package com.amateo.java.examples.architectures.hexagonal.adapters.mongo.mapper;

import com.amateo.java.examples.architectures.hexagonal.adapters.mongo.document.CustomerDocument;
import com.amateo.java.examples.architectures.hexagonal.domain.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDocument customerDocumentFrom(Customer customer);

    Customer customerFrom(CustomerDocument customerDocument);

}
