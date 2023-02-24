package com.example.shiftlab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table
@Getter
@Setter
public class PropertyValue {
    @Id
    @Column(name = "property_value_id")
    private UUID id;
    @Column(name = "\"value\"")
    private String value;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "property_id")
    private Property property;
}
