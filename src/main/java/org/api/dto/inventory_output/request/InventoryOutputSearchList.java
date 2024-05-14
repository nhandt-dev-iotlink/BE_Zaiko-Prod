package org.api.dto.inventory_output.request;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryOutputSearchList {

    private String f_orderDate;
    private String t_orderDate;

    private String f_planOutputDate;
    private String t_planOutputDate;

    private String f_planWorkingDate;
    private String t_planWorkingDate;

    private String f_planDeliverDate;
    private String t_planDeliverDate;

    private String f_slipNo;
    private String t_slipNo;

    private String f_customerId;
    private String t_customerId;
    private String customerName;

    private String f_deliverDestId;
    private String t_deliverDestId;
    private String deliveryDestName;

    private String f_supplierId;
    private String t_supplierId;
    private String supplierName;

    private String f_productId;
    private String t_productId;
    private String productName;

    private String f_repositoryId;
    private String t_repositoryId;

    private String batchNo;

    //Radio Btn
    private String deliveryType;
    private String deliveryStatus;
    private String is_closed;
}
