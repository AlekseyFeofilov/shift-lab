package com.example.shiftlab.controller;

import com.example.shiftlab.dto.item.ItemCreateDto;
import com.example.shiftlab.dto.item.ItemDto;
import com.example.shiftlab.dto.item.ItemIdDto;
import com.example.shiftlab.dto.item.ItemShortDto;
import com.example.shiftlab.dto.type.TypeIdDto;
import com.example.shiftlab.service.item.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "item", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemIdDto> createItem(@Valid @RequestBody ItemCreateDto itemCreateDto){
        ItemIdDto itemIdDto = itemService.createItem(itemCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemIdDto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateItem(@Valid @RequestBody ItemDto itemDto){
        itemService.updateItem(itemDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable String id){
        ItemIdDto itemIdDto = new ItemIdDto(id);
        itemService.deleteItem(itemIdDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "type/{id}")
    public ResponseEntity<List<ItemShortDto>> getItems(@PathVariable String id){
        TypeIdDto typeIdDto = new TypeIdDto(id);
        List<ItemShortDto> itemsByType = itemService.fetchItemsByType(typeIdDto);
        return ResponseEntity.ok().body(itemsByType);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ItemDto> getItem(@PathVariable String id){
        ItemIdDto itemIdDto = new ItemIdDto(id);
        ItemDto item = itemService.fetchItem(itemIdDto);
        return ResponseEntity.ok(item);
    }
}
