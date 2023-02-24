package com.example.shiftlab.dto.property;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PropertyIdDto {
    @JsonValue
    private UUID id;

    public PropertyIdDto(String id){
        this.id = UUID.fromString(id);
    }

    public PropertyIdDto(UUID id){
        this.id = id;
    }
}
