package com.example.shiftlab.service.property;

import com.example.shiftlab.dto.property.PropertyDto;
import com.example.shiftlab.dto.property.PropertyIdDto;
import com.example.shiftlab.dto.property.PropertyValueDto;
import com.example.shiftlab.dto.type.TypeIdDto;
import com.example.shiftlab.repository.PropertyRepository;
import com.example.shiftlab.repository.PropertyValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;
    private final PropertyValueRepository propertyValueRepository;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository, PropertyValueRepository propertyValueRepository) {
        this.propertyRepository = propertyRepository;
        this.propertyValueRepository = propertyValueRepository;
    }

    @Override
    public List<PropertyDto> fetchItemProperties(TypeIdDto typeIdDto) {
        return propertyRepository
                .findAllByTypeId(typeIdDto.getId())
                .stream()
                .map(PropertyDto::new)
                .toList();
    }

    @Override
    public List<PropertyValueDto> fetchItemPropertyValues(TypeIdDto typeIdDto, PropertyIdDto propertyIdDto) {
        return propertyValueRepository
                .findAllByPropertyId(propertyIdDto.getId())
                .stream()
                .map(PropertyValueDto::new)
                .toList();
    }
}
