package com.teknobli.merchant.services;

import com.teknobli.merchant.dto.MerchantProductDTO;
import com.teknobli.merchant.entity.MerchantProduct;

import java.util.List;

public interface MerchantProductService {
    MerchantProductDTO add(MerchantProductDTO merchantProductDTO);

    MerchantProductDTO select(String merchantId, String productId);

    MerchantProductDTO update(MerchantProductDTO merchantProductDTO);

    void delete(String merchantId, String productId);

    List<MerchantProduct> selectAllMerchants(String productId);

    Double getMinPrice(String productId);

    void updateStock(String merchantId, String productId, int newStock);


    void updatePrice(String merchantId, String productId, int newPrice);

    Integer getTotalStock(String productId);
}
