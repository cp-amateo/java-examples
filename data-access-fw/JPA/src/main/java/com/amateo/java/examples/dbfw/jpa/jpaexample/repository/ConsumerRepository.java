package com.amateo.java.examples.dbfw.jpa.jpaexample.repository;

import com.amateo.java.examples.dbfw.jpa.jpaexample.repository.entity.ConsumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsumerRepository extends JpaRepository<ConsumerEntity, Long> {

    Optional<ConsumerEntity> findByName(String name);
}
