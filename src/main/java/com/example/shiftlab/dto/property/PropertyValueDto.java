package com.example.shiftlab.dto.property;

import com.example.shiftlab.entity.PropertyValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PropertyValueDto {
    @JsonProperty("id")
    private PropertyValueIdDto id;
    private String value;

    public PropertyValueDto(PropertyValue propertyValue) {
        id = new PropertyValueIdDto(propertyValue.getId());
        value = propertyValue.getValue();
    }
}
