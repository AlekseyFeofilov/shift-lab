package com.example.shiftlab.controller;

import com.example.shiftlab.dto.property.PropertyDto;
import com.example.shiftlab.dto.property.PropertyIdDto;
import com.example.shiftlab.dto.property.PropertyValueDto;
import com.example.shiftlab.dto.type.TypeDto;
import com.example.shiftlab.dto.type.TypeIdDto;
import com.example.shiftlab.service.property.PropertyService;
import com.example.shiftlab.service.type.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "type", produces = MediaType.APPLICATION_JSON_VALUE)
public class TypeController {
    private final TypeService typeService;
    private final PropertyService propertyService;

    @Autowired
    public TypeController(TypeService typeService, PropertyService propertyService) {
        this.typeService = typeService;
        this.propertyService = propertyService;
    }

    @GetMapping
    public ResponseEntity<List<TypeDto>> getItem(){
        List<TypeDto> types = typeService.fetchTypes();
        return ResponseEntity.ok(types);
    }


    @GetMapping(value = "{id}/property")
    public ResponseEntity<List<PropertyDto>> getItemProperties(@PathVariable String id){
        TypeIdDto typeIdDto = new TypeIdDto(id);
        List<PropertyDto> properties = propertyService.fetchItemProperties(typeIdDto);
        return ResponseEntity.ok().body(properties);
    }

    @GetMapping(value = "{typeId}/property/{propertyId}")
    public ResponseEntity<List<PropertyValueDto>> getItemPropertyValues(@PathVariable String typeId, @PathVariable String propertyId){
        TypeIdDto typeIdDto = new TypeIdDto(typeId);
        PropertyIdDto propertyIdDto = new PropertyIdDto(propertyId);

        List<PropertyValueDto> properties = propertyService.fetchItemPropertyValues(typeIdDto, propertyIdDto);
        return ResponseEntity.ok().body(properties);
    }
}
