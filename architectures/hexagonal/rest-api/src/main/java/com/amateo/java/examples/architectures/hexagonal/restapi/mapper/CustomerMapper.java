package com.amateo.java.examples.architectures.hexagonal.restapi.mapper;

import com.amateo.java.examples.architectures.hexagonal.domain.model.Customer;
import com.amateo.java.examples.architectures.hexagonal.restapi.dto.CustomerDTO;
import com.amateo.java.examples.architectures.hexagonal.restapi.dto.CustomerIdDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerDTOFrom(Customer customer);

    CustomerIdDTO customerIdDTOFrom(Customer customer);

    Customer customerFrom(CustomerDTO customerDTO);
}
