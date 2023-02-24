package com.example.shiftlab.repository;

import com.example.shiftlab.entity.PropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PropertyValueRepository extends JpaRepository<PropertyValue, UUID> {
    List<PropertyValue> findAllByPropertyId(UUID id);
}
