package com.mpa.sktask.domain.model;

import com.mpa.sktask.domain.pojo.MyJsonb;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Objects;

@Entity @Table(name = "sk_example_table")
public class MyEntity {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false)
    private Long id;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "obj", nullable = false)
    private MyJsonb jsonb;

    public MyEntity() {
    }

    public MyEntity(Long id, MyJsonb jsonb) {
        this.id = id;
        this.jsonb = jsonb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MyJsonb getJsonb() {
        return jsonb;
    }

    public void setJsonb(MyJsonb jsonb) {
        this.jsonb = jsonb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyEntity entity = (MyEntity) o;
        return id.equals(entity.id) && jsonb.equals(entity.jsonb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jsonb);
    }
}
