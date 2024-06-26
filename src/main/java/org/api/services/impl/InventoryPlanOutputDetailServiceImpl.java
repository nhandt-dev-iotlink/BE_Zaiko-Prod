package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.bean.jpa.*;
import org.api.dto.InventoryPlanOutputDetailDto;
import org.api.mapper.InventoryPlanOutputDetailMapper;
import org.api.repository.inventoryPlanOutputDetail.InventoryPlanOutputDetailRepository;
import org.api.services.*;
import org.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    @Autowired
    private CustomerService customerService;


    @Override
    public Page<InventoryPlanOutputDetailDto> getAllInventoryPlanOutputDetailByInventoryOutputId(Pageable pageable, Integer inventoryOutputId) throws Exception {
        Page<InventoryPlanOutputDetailDto> response = inventoryPlanOutputDetailRepository.getAllInventoryPlanOutputDetailByInventoryOutputId(pageable, inventoryOutputId);
        return new PageImpl<>(response.getContent(), response.getPageable(), response.getTotalElements());
    }

    @Override
    public ResultBean addNewDetailByInventoryOutputId(List<InventoryPlanOutputDetailDto> listDto) throws Exception {
        InventoryPlanOutputDetailEntity detailEntityToSave = new InventoryPlanOutputDetailEntity();
        List<InventoryPlanOutputDetailEntity> detailEntityToSaveList = new ArrayList<>();
        for (InventoryPlanOutputDetailDto dto : listDto) {
//            detailEntityToSave = mapper.toEntity(dto);
            inventoryPlanOutputDetailRepository.save(detailEntityToSave);

            detailEntityToSaveList.add(detailEntityToSave);
        }
        return new ResultBean(detailEntityToSaveList, Constants.STATUS_201, Constants.MESSAGE_OK);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ResultBean deletePlanOutputDetailByOutputId(Integer id) throws Exception {
        List<InventoryPlanOutputDetailEntity> detailEntityToSaveList = inventoryPlanOutputDetailRepository.getAllByOutputId(id);
        if (detailEntityToSaveList.isEmpty()) {
            return new ResultBean(Constants.FLG_ZERO, Constants.STATUS_SYSTEM_ERROR);
        }
        for (InventoryPlanOutputDetailEntity detailEntityToSave : detailEntityToSaveList) {
            if (detailEntityToSave.getDelFlg().equals("0")) {
                detailEntityToSave.setDelFlg("1");
                inventoryPlanOutputDetailRepository.save(detailEntityToSave);
            }
        }
        return new ResultBean(Constants.FLG_ONE, Constants.MESSAGE_OK);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ResultBean savePlanOutputDetail(InventoryPlanOutputDetailDto dto, InventoryOutputEntity outputEntity) throws Exception {
        InventoryPlanOutputDetailEntity detailEntityToSave = new InventoryPlanOutputDetailEntity();
//        Check create or update
        if(dto.getPlanDetailId() != null){
            Optional<InventoryPlanOutputDetailEntity> optional = inventoryPlanOutputDetailRepository.findById(dto.getPlanDetailId());
            detailEntityToSave = optional.get();
            mapper.update(detailEntityToSave, dto);
        }else {
            detailEntityToSave = mapper.toEntity(dto);
            detailEntityToSave.setCompanyId(outputEntity.getCompanyId());
            detailEntityToSave.setInventoryOutputId(outputEntity.getInventoryOutputId());
            detailEntityToSave.setIsBatchInprogress(Constants.ZERO_IN);
            detailEntityToSave.setBatchStatus(Constants.BATCH_STATUS_0);
            detailEntityToSave.setDelFlg(Constants.DEL_FLG_0);
            detailEntityToSave.setBatchNo(outputEntity.getSlipNo());
        }
//        End

        CustomerEntity customerEntity = customerService.findOneCustomerByCode(dto.getCustomerCode());
        detailEntityToSave.setProductOwnerId(customerEntity.getCustomerId());

        ProductEntity productEntity = productService.findOneByCodeReturnEntity(dto.getProductCode());
        detailEntityToSave.setProductId(productEntity.getProductId());
        detailEntityToSave.setSupplierId(productEntity.getSupplierId());

//      Start Set Amount Total
        SalePriceEntity salePrice = salePriceService.findOneByProductId(productEntity.getProductId());
        detailEntityToSave.setPlanCsPrice(salePrice.getPackCsPrice());
        detailEntityToSave.setPlanBlPrice(salePrice.getPackBlPrice());
        detailEntityToSave.setPlanPiecePrice(salePrice.getPiecePrice());
        if(detailEntityToSave.getPlanPiecePrice() > 0) {
            detailEntityToSave.setAmountTotal(detailEntityToSave.getTotalPlanQuantity() * detailEntityToSave.getPlanPiecePrice());
        }else if(detailEntityToSave.getPlanBlPrice() > 0){
            detailEntityToSave.setAmountTotal((detailEntityToSave.getTotalPlanQuantity() / productEntity.getPackBlAmount()) * detailEntityToSave.getPlanBlPrice());
        }else if(detailEntityToSave.getPlanCsPrice() > 0){
            detailEntityToSave.setAmountTotal(((detailEntityToSave.getTotalPlanQuantity()/ productEntity.getPackBlAmount()) / productEntity.getPackCsAmount()) * detailEntityToSave.getPlanCsPrice());
        }
//      End

        InventoryPlanOutputDetailEntity detailEntityReturn = inventoryPlanOutputDetailRepository.save(detailEntityToSave);

        return new ResultBean(detailEntityReturn, Constants.STATUS_201, Constants.MESSAGE_OK);
    }
}
