package com.teknobli.merchant.controller;

import com.teknobli.merchant.dto.MerchantOrderDTO;
import com.teknobli.merchant.services.MerchantOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("merchant/order")
public class MerchantOrderController {

    @Autowired
    MerchantOrderService merchantOrderService;

    @PostMapping("/add")
    public MerchantOrderDTO add(@RequestBody MerchantOrderDTO merchantOrderDTO){
        return merchantOrderService.add(merchantOrderDTO);
    }

    @GetMapping("/getCount/{merchantId}")
    public int getCount(@PathVariable("merchantId") String merchantId){
        return merchantOrderService.getCount(merchantId);
    }

}
