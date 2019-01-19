package com.teknobli.merchant.services;

import com.teknobli.merchant.dto.MerchantProductDTO;
import com.teknobli.merchant.entity.Merchant;

import java.util.List;

public interface MerchantProductService {
    MerchantProductDTO add(MerchantProductDTO merchantProductDTO);

    MerchantProductDTO select(String productId);

    MerchantProductDTO update(MerchantProductDTO merchantProductDTO);

    void delete(String productId);

    List<Merchant> selectAllMerchants(String productId);

    Integer getMinPrice(String productId);

    void updateStock(String productId);


    void updatePrice(String productId);
}
