package com.example.shiftlab.repository;

import com.example.shiftlab.entity.PropertyValueItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PropertyValueItemRepository extends JpaRepository<PropertyValueItem, UUID> {
    List<PropertyValueItem> findAllByItemId(UUID id);
}
