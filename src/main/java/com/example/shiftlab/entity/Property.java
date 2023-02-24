package com.example.shiftlab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table
@Getter
@Setter
public class Property {
    @Id
    @Column(name = "property_id")
    private UUID id;
    @Column
    private String name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "type_id")
    private Type type;
}
