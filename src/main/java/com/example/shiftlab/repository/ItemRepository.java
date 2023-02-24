package com.example.shiftlab.repository;

import com.example.shiftlab.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
    List<Item> findByTypeId(UUID id);
    Boolean existsBySerialNumber(String serialNumber);
}
