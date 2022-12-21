package com.mpa.sktask.domain.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

public class ModifyRequestDTO {

    @NotNull(message = "JSON attribute 'id': should not be empty!")
    @Min(value = 1, message = "JSON attribute 'id': should be positive integer number!")
    private Long id;

    @NotNull(message = "JSON attribute 'add': should not be empty!")
    @Range(min = 1, max = 999, message = "JSON attribute 'add': should be in range from 1 to 999!")
    private Integer add;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAdd() {
        return add;
    }

    public void setAdd(Integer add) {
        this.add = add;
    }
}
