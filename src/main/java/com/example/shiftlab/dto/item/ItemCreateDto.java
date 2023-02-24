package com.example.shiftlab.dto.item;

import com.example.shiftlab.dto.property.PropertyValueIdDto;
import com.example.shiftlab.dto.type.TypeIdDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemCreateDto {
    @NotEmpty(message = "name is required")
    private String name;
    @NotEmpty(message = "serialNumber is required")
    private String serialNumber;
    private String producer;
    @NotNull(message = "cost is required")
    @Positive(message = "cost must be positive")
    private Float cost;
    @Positive(message = "quantity must be positive")
    private Long quantity;
    @NotNull(message = "type id is required")
    @JsonProperty("typeId")
    private TypeIdDto typeIdDto;
    @JsonProperty("valuesId")
    private List<PropertyValueIdDto> propertyValuesIdDto;
}
