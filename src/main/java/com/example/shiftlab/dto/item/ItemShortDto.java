package com.example.shiftlab.dto.item;

import com.example.shiftlab.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemShortDto {
    private ItemIdDto id;
    private String name;
    private Float cost;

    public ItemShortDto(Item item){
        id = new ItemIdDto(item.getId());
        name = item.getName();
        cost = item.getCost();
    }
}
