package org.api.bean.dto;

public interface ProductSearchDto {
    String getProductCode();

    String getProductName();

    String getStandardInfo();

    String getDatetimeMngType();


    String getIsDatetimeMng();

    String getIsNumberMng();

    String getIsPackCsOutput();

    String getIsPackBlOutput();

    String getIsPieceOutput();

    Integer getPackCsAmount();

    Integer getPackBlAmount();

    Double getPackCsPrice();

    Double getPackBlPrice();

    Double getPiecePrice();
}
