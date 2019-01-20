package com.teknobli.merchant.services;

import com.teknobli.merchant.dto.MerchantOrderDTO;

public interface MerchantOrderService {
    MerchantOrderDTO add(MerchantOrderDTO merchantOrderDTO);

    int getCount(String merchantId);
}
