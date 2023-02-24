package com.example.shiftlab.service.item;

import com.example.shiftlab.dto.item.ItemCreateDto;
import com.example.shiftlab.dto.item.ItemDto;
import com.example.shiftlab.dto.item.ItemIdDto;
import com.example.shiftlab.dto.item.ItemShortDto;
import com.example.shiftlab.dto.type.TypeIdDto;

import java.util.List;

public interface ItemService {
    ItemIdDto createItem(ItemCreateDto itemCreateDto);

    void updateItem(ItemDto itemDto);

    void deleteItem(ItemIdDto itemIdDto);

    List<ItemShortDto> fetchItemsByType(TypeIdDto typeIdDto);

    ItemDto fetchItem(ItemIdDto itemIdDto);
}
