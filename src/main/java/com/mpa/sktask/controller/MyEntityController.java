package com.mpa.sktask.controller;

import com.mpa.sktask.domain.dto.ModifyRequestDTO;
import com.mpa.sktask.domain.dto.MyEntityDTO;
import com.mpa.sktask.domain.mapper.MyEntityMapper;
import com.mpa.sktask.domain.model.MyEntity;
import com.mpa.sktask.service.MyEntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyEntityController {

    private final MyEntityService myEntityService;
    private final MyEntityMapper myEntityMapper;

    @Autowired
    public MyEntityController(MyEntityService myEntityService,
                              MyEntityMapper myEntityMapper) {
        this.myEntityService = myEntityService;
        this.myEntityMapper = myEntityMapper;
    }

    @PutMapping("/modify")
    public MyEntityDTO modifyMyEntity(@Valid @RequestBody ModifyRequestDTO requestDTO) {
        MyEntity entity = myEntityService.updateEntity(requestDTO);
        return myEntityMapper.toMyEntityDto(entity);
    }
}
