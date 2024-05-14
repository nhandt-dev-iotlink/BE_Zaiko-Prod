package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.dto.supplier.response.SupplierDialogDTO;
import org.api.repository.supplier.SupplierRepository;
import org.api.services.SupplierService;
import org.api.utils.Constants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public ResultBean getAllSupplierForDialog() {
        List<SupplierDialogDTO> supplierDialogDTOS = supplierRepository.findAllSupplier();
//        if(!supplierDialogDTOS.isEmpty()){
//            return new ResultBean(supplierDialogDTOS, Constants.STATUS_OK, Constants.MESSAGE_OK);
//        }
        return (!supplierDialogDTOS.isEmpty()) ? new ResultBean(supplierDialogDTOS, Constants.STATUS_OK, Constants.MESSAGE_OK) :
                new ResultBean(supplierDialogDTOS, Constants.STATUS_NOT_FOUND, "Empty Result");
    }

    @Override
    public ResultBean searchSupplier(String keyWord) {
        List<SupplierDialogDTO> supplierDialogDTOS = supplierRepository.findSupplierByCodeOrName(keyWord, keyWord);
//        if(!supplierDialogDTOS.isEmpty()){
//            return new ResultBean(supplierDialogDTOS, Constants.STATUS_OK, Constants.MESSAGE_OK);
//        }
        return (!supplierDialogDTOS.isEmpty()) ? new ResultBean(supplierDialogDTOS, Constants.STATUS_OK, Constants.MESSAGE_OK) :
                new ResultBean(supplierDialogDTOS, Constants.STATUS_NOT_FOUND, "Empty Result");
    }
}
