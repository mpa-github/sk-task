package com.mpa.sktask.domain.mapper;

import com.mpa.sktask.domain.dto.MyEntityDTO;
import com.mpa.sktask.domain.model.MyEntity;
import org.springframework.stereotype.Service;

@Service
public class MyEntityMapper {

    public MyEntityDTO toMyEntityDto(MyEntity entity) {
        MyEntityDTO dto = new MyEntityDTO();
        dto.setCurrent(entity.getJsonb().getCurrent());
        return dto;
    }
}
