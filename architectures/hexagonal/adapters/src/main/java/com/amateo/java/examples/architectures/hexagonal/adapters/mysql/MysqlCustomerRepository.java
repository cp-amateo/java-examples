package com.amateo.java.examples.architectures.hexagonal.adapters.mysql;

import com.amateo.java.examples.architectures.hexagonal.adapters.mysql.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MysqlCustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
