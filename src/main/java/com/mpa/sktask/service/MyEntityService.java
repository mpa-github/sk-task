package com.mpa.sktask.service;

import com.mpa.sktask.domain.dto.ModifyRequestDTO;
import com.mpa.sktask.domain.model.MyEntity;
import com.mpa.sktask.domain.pojo.MyJsonb;
import com.mpa.sktask.exception.EntityNotFoundException;
import com.mpa.sktask.repository.MyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyEntityService {

    private final MyEntityRepository myEntityRepository;

    @Autowired
    public MyEntityService(MyEntityRepository myEntityRepository) {
        this.myEntityRepository = myEntityRepository;
    }

    public MyEntity getEntity(Long id) {
        MyEntity entity = myEntityRepository.findMyEntityById(id);
        if (entity == null) {
            throw new EntityNotFoundException("Entity not found id: "  + id);
        }
        return entity;
    }

    @Transactional
    public MyEntity updateEntity(ModifyRequestDTO requestDTO) {
        Long id = requestDTO.getId();
        int increaseBy = requestDTO.getAdd();
        MyEntity entity = myEntityRepository.findMyEntityById(id);
        if (entity == null) {
            throw new EntityNotFoundException("Entity not found id: "  + id);
        }
        MyJsonb jsonb = entity.getJsonb();
        int currentValue = jsonb.getCurrent();
        jsonb.setCurrent(currentValue + increaseBy);
        entity.setJsonb(jsonb);
        return entity;
    }
}
