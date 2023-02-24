package com.example.shiftlab.service.property;

import com.example.shiftlab.dto.property.PropertyDto;
import com.example.shiftlab.dto.property.PropertyIdDto;
import com.example.shiftlab.dto.property.PropertyValueDto;
import com.example.shiftlab.dto.type.TypeIdDto;

import java.util.List;

public interface PropertyService {

    List<PropertyDto> fetchItemProperties(TypeIdDto typeIdDto);

    List<PropertyValueDto> fetchItemPropertyValues(TypeIdDto typeIdDto, PropertyIdDto propertyIdDto);
}
