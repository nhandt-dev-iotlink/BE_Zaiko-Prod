package org.api.bean.mapper;



import org.api.bean.jpa.CustomerDeliveryDestEntity;
import org.api.bean.reponse.dto.CustomerDeliveryDestDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CustomerDeliveryDestMapper {
    CustomerDeliveryDestDTO customerDeliveryDestToCustomerDeliveryDestDto(CustomerDeliveryDestEntity entity);


}
