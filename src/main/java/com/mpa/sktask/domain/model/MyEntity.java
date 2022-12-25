package com.mpa.sktask.domain.model;

import com.mpa.sktask.domain.pojo.MyJsonb;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity @Table(name = "sk_example_table")
public class MyEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "obj", nullable = false)
    private MyJsonb jsonb;

    public MyEntity() {
    }

    public MyEntity(MyJsonb jsonb) {
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
}
