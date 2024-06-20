package org.api.bean.mapper;



import org.api.bean.jpa.CustomerEntity;
import org.api.bean.reponse.dto.CustomerDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO customerToCustomerDto(CustomerEntity entity);

}


