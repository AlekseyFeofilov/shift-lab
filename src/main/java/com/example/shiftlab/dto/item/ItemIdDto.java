package com.example.shiftlab.dto.item;

import com.example.shiftlab.exception.ItemNotFoundException;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ItemIdDto {
    @JsonValue
    private UUID id;

    public ItemIdDto(String id) {
        try {
            this.id = UUID.fromString(id);
        } catch (Exception ex){
            throw new ItemNotFoundException();
        }
    }

    public ItemIdDto(UUID id) {
        this.id = id;
    }
}
