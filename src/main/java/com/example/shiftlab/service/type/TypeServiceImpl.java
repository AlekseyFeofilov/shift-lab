package com.example.shiftlab.service.type;

import com.example.shiftlab.dto.type.TypeDto;
import com.example.shiftlab.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeDto> fetchTypes() {
        return typeRepository
                .findAll()
                .stream()
                .map(TypeDto::new)
                .toList();
    }
}
