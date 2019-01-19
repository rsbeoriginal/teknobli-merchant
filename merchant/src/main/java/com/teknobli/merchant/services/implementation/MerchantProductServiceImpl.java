package com.teknobli.merchant.services.implementation;

import com.teknobli.merchant.dto.MerchantProductDTO;
import com.teknobli.merchant.entity.Merchant;
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
@Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)
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

    @Override
    public MerchantProductDTO select(String productId) {
        MerchantProductDTO merchantProductDTO = new MerchantProductDTO();
        BeanUtils.copyProperties(merchantProductRepository.findOne(productId),merchantProductDTO);
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

    @Override
    public void delete(String productId) {
        merchantProductRepository.delete(productId);
    }

    @Override
    public List<Merchant> selectAllMerchants(String productId) {
        return null;
    }

    @Override
    public Integer getMinPrice(String productId) {
        return null;
    }

    @Override
    public void updateStock(String productId) {

    }

    @Override
    public void updatePrice(String productId) {

    }
}
