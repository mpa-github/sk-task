package com.mpa.sktask.repository;

import com.mpa.sktask.domain.model.MyEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntityRepository extends CrudRepository<MyEntity, Long> {

    MyEntity findMyEntityById(Long id);

    // Test way to update json attribute value in entity
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE sk_example_table " +
                   "SET obj = jsonb_set(obj, '{current}', to_jsonb(:newValue), false) WHERE id = :id",
           nativeQuery = true)
    void updateJsonCurrentAttr(@Param("id") Long id,
                               @Param(value = "newValue") int newValue);
}
