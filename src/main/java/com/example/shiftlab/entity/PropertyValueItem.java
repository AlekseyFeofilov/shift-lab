package com.example.shiftlab.entity;

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
public class PropertyValueItem {
    @Id
    @Column(name = "property_value_item_id")
    private UUID id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "property_value_id")
    private PropertyValue propertyValue;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "item_id")
    private Item item;

    public PropertyValueItem(PropertyValue propertyValue, Item item){
        id = UUID.randomUUID();
        this.propertyValue = propertyValue;
        this.item = item;
    }
}
