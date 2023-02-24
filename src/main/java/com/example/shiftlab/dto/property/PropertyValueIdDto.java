package com.example.shiftlab.dto.property;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class PropertyValueIdDto {
    @JsonValue
    private UUID id;

    public PropertyValueIdDto(UUID id) {
        this.id = id;
    }
}
