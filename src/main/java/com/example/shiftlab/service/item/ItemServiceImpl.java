package com.example.shiftlab.service.item;

import com.example.shiftlab.dto.item.ItemCreateDto;
import com.example.shiftlab.dto.item.ItemDto;
import com.example.shiftlab.dto.item.ItemIdDto;
import com.example.shiftlab.dto.item.ItemShortDto;
import com.example.shiftlab.dto.property.PropertyValueIdDto;
import com.example.shiftlab.dto.type.TypeIdDto;
import com.example.shiftlab.entity.*;
import com.example.shiftlab.exception.*;
import com.example.shiftlab.repository.ItemRepository;
import com.example.shiftlab.repository.PropertyValueItemRepository;
import com.example.shiftlab.repository.PropertyValueRepository;
import com.example.shiftlab.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final TypeRepository typeRepository;
    private final PropertyValueRepository propertyValueRepository;
    private final PropertyValueItemRepository propertyValueItemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, TypeRepository typeRepository, PropertyValueRepository propertyValueRepository, PropertyValueItemRepository propertyValueItemRepository) {
        this.itemRepository = itemRepository;
        this.typeRepository = typeRepository;
        this.propertyValueRepository = propertyValueRepository;
        this.propertyValueItemRepository = propertyValueItemRepository;
    }

    @Override
    @Transactional
    public ItemIdDto createItem(ItemCreateDto itemCreateDto) {
        if (itemRepository.existsBySerialNumber(itemCreateDto.getSerialNumber())) {
            throw new ItemWithSerialNumberAlreadyExistException();
        }

        Type type = fetchTypeById(itemCreateDto.getTypeIdDto());
        Item item = new Item(itemCreateDto, type);
        itemRepository.save(item);

        addAdditionalProperties(item, itemCreateDto.getPropertyValuesIdDto());
        return new ItemIdDto(item.getId());
    }

    @Override
    @Transactional
    public void updateItem(ItemDto itemDto) {
        if (!itemRepository.existsById(itemDto.getItemIdDto().getId())) {
            throw new ItemNotFoundException();
        }

        Type type = fetchTypeById(itemDto.getType().getTypeIdDto());
        itemRepository.save(new Item(itemDto, type));
    }

    @Override
    @Transactional
    public void deleteItem(ItemIdDto itemIdDto) {
        if (!itemRepository.existsById(itemIdDto.getId())) {
            throw new ItemNotFoundException();
        }

        itemRepository.deleteById(itemIdDto.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemShortDto> fetchItemsByType(TypeIdDto typeIdDto) {
        Type type = fetchTypeById(typeIdDto);
        return itemRepository
                .findByTypeId(type.getId())
                .stream()
                .map(ItemShortDto::new)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ItemDto fetchItem(ItemIdDto itemIdDto) {
        Item item = itemRepository
                .findById(itemIdDto.getId())
                .orElseThrow(ItemNotFoundException::new);

        Map<String, String> additionalProperties = fetchAdditionalProperties(itemIdDto);
        return new ItemDto(item, additionalProperties);
    }

    private void addAdditionalProperties(Item item, List<PropertyValueIdDto> propertyValueIdDtoList){
        List<Property> properties = new ArrayList<>();

        for (PropertyValueIdDto propertyValueIdDto : propertyValueIdDtoList) {
            PropertyValue propertyValue = propertyValueRepository
                    .findById(propertyValueIdDto.getId())
                    .orElseThrow(PropertyValueNotFoundException::new);

            if(properties.contains(propertyValue.getProperty())){
                throw new ItemAlreadyHavePropertyValueException();
            }

            properties.add(propertyValue.getProperty());
            PropertyValueItem propertyValueItem = new PropertyValueItem(propertyValue, item);
            propertyValueItemRepository.save(propertyValueItem);
        }
    }

    private Map<String, String> fetchAdditionalProperties(ItemIdDto itemIdDto){
        Map<String, String> additionalProperties = new HashMap<>();
        List<PropertyValueItem> itemValues = propertyValueItemRepository.findAllByItemId(itemIdDto.getId());

        for (PropertyValueItem itemValue : itemValues) {
            String propertyName = itemValue.getPropertyValue().getProperty().getName();
            String propertyValue = itemValue.getPropertyValue().getValue();

            additionalProperties.put(propertyName, propertyValue);
        }

        return additionalProperties;
    }

    private Type fetchTypeById(TypeIdDto typeIdDto) {
        return typeRepository
                .findById(typeIdDto.getId())
                .orElseThrow(TypeNotFoundException::new);
    }
}
