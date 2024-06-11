package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.bean.jpa.InventoryOutputEntity;
import org.api.bean.jpa.InventoryPlanOutputDetailEntity;
import org.api.bean.jpa.ProductEntity;
import org.api.bean.jpa.SalePriceEntity;
import org.api.dto.InventoryOutputPlanDto;
import org.api.dto.InventoryPlanOutputDetailDto;
import org.api.dto.PlanFormDto;
import org.api.mapper.InventoryPlanOutputDetailMapper;
import org.api.repository.inventoryPlanOutputDetail.InventoryPlanOutputDetailRepository;
import org.api.repository.salePrice.SalePriceRepository;
import org.api.services.InventoryOutputService;
import org.api.services.InventoryPlanOutputDetailService;
import org.api.services.ProductService;
import org.api.services.SalePriceService;
import org.api.utils.Constants;
import org.api.utils.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryPlanOutputDetailServiceImpl implements InventoryPlanOutputDetailService {
    @Autowired
    private InventoryPlanOutputDetailRepository inventoryPlanOutputDetailRepository;
    @Autowired
    private InventoryPlanOutputDetailMapper mapper;
    @Autowired
    private ProductService productService;
    @Autowired
    private SalePriceService salePriceService;


    @Override
    public Page<InventoryPlanOutputDetailDto> getAllInventoryPlanOutputDetailByInventoryOutputId(Pageable pageable, Integer inventoryOutputId) throws Exception {
        Page<InventoryPlanOutputDetailDto> response = inventoryPlanOutputDetailRepository.getAllInventoryPlanOutputDetailByInventoryOutputId(pageable, inventoryOutputId);
        return new PageImpl<>(response.getContent(), response.getPageable(), response.getTotalElements());
    }

    @Override
    public ResultBean addNewDetailByInventoryOutputId(List<InventoryPlanOutputDetailDto> listDto) throws Exception {
        InventoryPlanOutputDetailEntity detailEntity = new InventoryPlanOutputDetailEntity();
        List<InventoryPlanOutputDetailEntity> detailEntityList = new ArrayList<>();
        for (InventoryPlanOutputDetailDto dto : listDto) {
            detailEntity = mapper.toEntity(dto);
            inventoryPlanOutputDetailRepository.save(detailEntity);

            detailEntityList.add(detailEntity);
        }
        return new ResultBean(detailEntityList, Constants.STATUS_201, Constants.MESSAGE_OK);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ResultBean deletePlanOutputDetailByOutputId(Integer id) throws Exception {
        List<InventoryPlanOutputDetailEntity> detailEntityList = inventoryPlanOutputDetailRepository.getAllByOutputId(id);
        if (detailEntityList.isEmpty()) {
            return new ResultBean(Constants.FLG_ZERO, Constants.STATUS_SYSTEM_ERROR);
        }
        for (InventoryPlanOutputDetailEntity detailEntity : detailEntityList) {
            if (detailEntity.getDelFlg().equals("0")) {
                detailEntity.setDelFlg("1");
                inventoryPlanOutputDetailRepository.save(detailEntity);
            }
        }
        return new ResultBean(Constants.FLG_ONE, Constants.MESSAGE_OK);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ResultBean savePlanOutputDetail(InventoryPlanOutputDetailDto dto, InventoryOutputEntity outputEntity) throws Exception {
        InventoryPlanOutputDetailEntity detailEntity = mapper.toEntity(dto);
        detailEntity.setCompanyId(outputEntity.getCompanyId());
        detailEntity.setInventoryOutputId(outputEntity.getInventoryOutputId());
        detailEntity.setIsBatchInprogress(Constants.ZERO_IN);
        detailEntity.setBatchStatus(Constants.BATCH_STATUS_0);
        detailEntity.setDelFlg(Constants.DEL_FLG_0);
        detailEntity.setBatchNo(outputEntity.getSlipNo());

        if(detailEntity.getDatetimeMngFrom() != null){
            detailEntity.setDatetimeMngFrom(formatDate(detailEntity.getDatetimeMngFrom()));
        }
        if(detailEntity.getDatetimeMngTo() != null){
            detailEntity.setDatetimeMngTo(formatDate(detailEntity.getDatetimeMngTo()));
        }

        ProductEntity productEntity = productService.findOneByCodeReturnEntity(dto.getProductCode());
        detailEntity.setProductId(productEntity.getProductId());
        detailEntity.setSupplierId(productEntity.getSupplierId());

        SalePriceEntity salePrice = salePriceService.findOneByProductId(productEntity.getProductId());
        detailEntity.setPlanCsPrice(salePrice.getPackCsPrice());
        detailEntity.setPlanBlPrice(salePrice.getPackBlPrice());
        detailEntity.setPlanPiecePrice(salePrice.getPiecePrice());

        if(detailEntity.getPlanPiecePrice() > 0) {
            detailEntity.setAmountTotal(detailEntity.getTotalPlanQuantity() * detailEntity.getPlanPiecePrice());
        }else if(detailEntity.getPlanBlPrice() > 0){
            detailEntity.setAmountTotal((detailEntity.getTotalPlanQuantity() / productEntity.getPackBlAmount()) * detailEntity.getPlanBlPrice());
        }else if(detailEntity.getPlanCsPrice() > 0){
            detailEntity.setAmountTotal(((detailEntity.getTotalPlanQuantity()/ productEntity.getPackBlAmount()) / productEntity.getPackCsAmount()) * detailEntity.getPlanCsPrice());
        }

        inventoryPlanOutputDetailRepository.save(detailEntity);

        return new ResultBean(detailEntity, Constants.STATUS_201, Constants.MESSAGE_OK);
    }

    public static String formatDate(String date) throws Exception {
        return date.replaceAll("-", "/");
    }
}
