package com.example.shiftlab.dto.property;

import com.example.shiftlab.entity.Property;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PropertyDto {
    @JsonProperty("id")
    private PropertyIdDto propertyIdDto;
    private String name;

    public PropertyDto(Property property){
        propertyIdDto = new PropertyIdDto(property.getId());
        name = property.getName();
    }
}
