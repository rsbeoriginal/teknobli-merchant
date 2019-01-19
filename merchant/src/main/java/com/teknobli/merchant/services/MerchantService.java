package com.teknobli.merchant.services;

import com.teknobli.merchant.dto.MerchantDTO;

public interface MerchantService {

    MerchantDTO add(MerchantDTO merchantDTO);

    MerchantDTO select(String merchantId);

    MerchantDTO update(MerchantDTO merchantDTO);

    void delete(String merchantId);
}
