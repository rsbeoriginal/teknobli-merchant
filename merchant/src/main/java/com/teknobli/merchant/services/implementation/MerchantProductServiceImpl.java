package com.teknobli.merchant.services.implementation;

import com.teknobli.merchant.dto.MerchantProductDTO;
import com.teknobli.merchant.entity.MerchantProduct;
import com.teknobli.merchant.repository.MerchantProductRepository;
import com.teknobli.merchant.services.MerchantProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
public class MerchantProductServiceImpl implements MerchantProductService {

    @Autowired
    MerchantProductRepository merchantProductRepository;


    @Override
    public MerchantProductDTO add(MerchantProductDTO merchantProductDTO) {
        MerchantProduct merchantProduct = new MerchantProduct();
        BeanUtils.copyProperties(merchantProductDTO,merchantProduct);
        MerchantProductDTO merchantProductDTODb = new MerchantProductDTO();
        BeanUtils.copyProperties(merchantProductRepository.save(merchantProduct),merchantProductDTODb);
        return merchantProductDTODb;
    }

    @Transactional(readOnly = true)
    @Override
    public MerchantProductDTO select(String merchantId, String productId) {
        MerchantProductDTO merchantProductDTO = new MerchantProductDTO();
        BeanUtils.copyProperties(merchantProductRepository.findMerchantProductOne(merchantId,productId),merchantProductDTO);
        return merchantProductDTO;
    }

    @Override
    public MerchantProductDTO update(MerchantProductDTO merchantProductDTO) {
        MerchantProduct merchantProduct = new MerchantProduct();
        BeanUtils.copyProperties(merchantProductDTO,merchantProduct);
        MerchantProductDTO merchantProductDTODb = new MerchantProductDTO();
        BeanUtils.copyProperties(merchantProductRepository.save(merchantProduct),merchantProductDTODb);
        return merchantProductDTODb;
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(String merchantId, String productId) {
        merchantProductRepository.delete(merchantId,productId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<MerchantProduct> selectAllMerchants(String productId) {
        return merchantProductRepository.selectAllMerchants(productId);
    }

    @Transactional(readOnly = true)
    @Override
    public Integer getMinPrice(String productId) {
        return merchantProductRepository.getMinPrice(productId);
    }

    @Transactional
    @Override
    public void updateStock(String merchantId, String productId,int newStock) {
        merchantProductRepository.updateStock(merchantId,productId,newStock);
    }

    @Transactional
    @Override
    public void updatePrice(String merchantId, String productId, int newPrice) {
        merchantProductRepository.updatePrice(merchantId,productId,newPrice);
    }


}
