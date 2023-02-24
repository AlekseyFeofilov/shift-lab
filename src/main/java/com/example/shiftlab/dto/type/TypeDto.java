package com.example.shiftlab.dto.type;

import com.example.shiftlab.entity.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TypeDto {
    @JsonProperty("id")
    private TypeIdDto typeIdDto;
    private String name;

    public TypeDto(Type type){
        typeIdDto = new TypeIdDto(type.getId());
        name = type.getName();
    }
}
