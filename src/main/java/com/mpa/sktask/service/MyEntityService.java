package com.mpa.sktask.service;

import com.mpa.sktask.domain.dto.ModifyRequestDTO;
import com.mpa.sktask.domain.model.MyEntity;
import com.mpa.sktask.domain.pojo.MyJsonb;
import com.mpa.sktask.exception.EntityNotFoundException;
import com.mpa.sktask.exception.ResponseTimeOutException;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyEntityService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public MyEntity updateEntity(ModifyRequestDTO requestDTO) {
        Long id = requestDTO.getId();
        int increaseBy = requestDTO.getAdd();
        try {
            MyEntity entity = entityManager.find(MyEntity.class, id, LockModeType.PESSIMISTIC_WRITE);
            if (entity == null) {
                throw new EntityNotFoundException("Entity not found id: " + id);
            }
            MyJsonb jsonb = entity.getJsonb();
            int currentValue = jsonb.getCurrent();
            jsonb.setCurrent(currentValue + increaseBy);
            entity.setJsonb(jsonb);
            return entity;
        } catch (LockTimeoutException ex) {
            throw new ResponseTimeOutException(ex.getMessage());
        }
    }
}
