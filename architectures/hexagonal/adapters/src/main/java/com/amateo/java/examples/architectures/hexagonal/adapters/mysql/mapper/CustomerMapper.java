package com.amateo.java.examples.architectures.hexagonal.adapters.mysql.mapper;

import com.amateo.java.examples.architectures.hexagonal.adapters.mysql.entity.CustomerEntity;
import com.amateo.java.examples.architectures.hexagonal.domain.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerEntity customerEntityFrom(Customer customer);

    Customer customerFrom(CustomerEntity customerEntity);

}
