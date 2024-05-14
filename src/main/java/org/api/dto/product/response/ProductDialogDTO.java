package org.api.dto.product.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDialogDTO {
    private Integer productId;
    private String productCode;
    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private String name5;
}
