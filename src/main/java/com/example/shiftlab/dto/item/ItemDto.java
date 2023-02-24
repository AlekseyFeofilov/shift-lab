package com.example.shiftlab.dto.item;

import com.example.shiftlab.dto.type.TypeDto;
import com.example.shiftlab.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ItemDto {
    private ItemIdDto itemIdDto;
    private String name;
    private String serialNumber;
    private String producer;
    private Float cost;
    private Long quantity;
    private TypeDto type;
    private Map<String, String> additionalProperties;

    public ItemDto(Item item, Map<String, String> additionalProperties){
        itemIdDto = new ItemIdDto(item.getId());
        name = item.getName();
        serialNumber = item.getSerialNumber();
        producer = item.getProducer();
        cost = item.getCost();
        quantity = item.getQuantity();
        type = new TypeDto(item.getType());
        this.additionalProperties = additionalProperties;
    }
}
