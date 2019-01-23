package com.teknobli.merchant.services;

import com.teknobli.merchant.dto.MerchantOrderDTO;
import com.teknobli.merchant.ordermicroservices.dto.RecieptDTO;

public interface MerchantOrderService {
    MerchantOrderDTO add(MerchantOrderDTO merchantOrderDTO);

    int getCount(String merchantId);

    Boolean validateOrder(RecieptDTO recieptDTO);
}
