package com.example.shiftlab.entity;

import com.example.shiftlab.dto.item.ItemCreateDto;
import com.example.shiftlab.dto.item.ItemDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Item {
    @Id
    @Column(name = "item_id")
    private UUID id;
    @Column
    private String name;
    @Column
    private String serialNumber;
    @Column
    private String producer;
    @Column
    private Float cost;
    @Column
    private Long quantity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private Type type;

    public Item(ItemCreateDto itemCreateDto, Type type) {
        id = UUID.randomUUID();
        name = itemCreateDto.getName();
        serialNumber = itemCreateDto.getSerialNumber();
        producer = itemCreateDto.getProducer();
        cost = itemCreateDto.getCost();
        quantity = itemCreateDto.getQuantity();
        this.type = type;
    }

    public Item(ItemDto itemDto, Type type){
        id = itemDto.getItemIdDto().getId();
        name = itemDto.getName();
        serialNumber = itemDto.getSerialNumber();
        producer = itemDto.getProducer();
        cost = itemDto.getCost();
        quantity = itemDto.getQuantity();
        this.type = type;
    }
}
