package com.amateo.java.examples.dbfw.jpa.jpaexample.repository;

import com.amateo.java.examples.dbfw.jpa.jpaexample.repository.entity.ConsumerAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerAccountRepository extends JpaRepository<ConsumerAccountEntity, Long> {

}
