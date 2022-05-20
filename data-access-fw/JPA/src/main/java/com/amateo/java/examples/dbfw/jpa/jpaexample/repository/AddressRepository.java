package com.amateo.java.examples.dbfw.jpa.jpaexample.repository;

import com.amateo.java.examples.dbfw.jpa.jpaexample.repository.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long> {

}
