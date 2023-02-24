package com.example.shiftlab.repository;

import com.example.shiftlab.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PropertyRepository extends JpaRepository<Property, UUID> {
    List<Property> findAllByTypeId(UUID id);
}
