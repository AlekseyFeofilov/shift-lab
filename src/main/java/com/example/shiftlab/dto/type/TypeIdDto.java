package com.example.shiftlab.dto.type;

import com.example.shiftlab.exception.TypeNotFoundException;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class TypeIdDto {
    @JsonValue
    private UUID id;

    public TypeIdDto(String id) {
        try {
            this.id = UUID.fromString(id);
        } catch (Exception ex){
            throw new TypeNotFoundException();
        }
    }

    public TypeIdDto(UUID id){
        this.id = id;
    }
}
