package com.teknobli.merchant.controller;

import com.teknobli.merchant.dto.MerchantDTO;
import com.teknobli.merchant.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @PostMapping("/add")
    public MerchantDTO add(@RequestBody MerchantDTO merchantDTO){
        return merchantService.add(merchantDTO);
    }

    @GetMapping("/select/{merchantId}")
    public MerchantDTO select(@PathVariable("merchantId") String merchantId){
        return merchantService.select(merchantId);
    }

    @PutMapping("/update")
    public MerchantDTO update(@RequestBody MerchantDTO merchantDTO){
        return merchantService.update(merchantDTO);
    }

    @DeleteMapping("/delete/{merchantId}")
    public void delete(@PathVariable("merchantId") String merchantId){
        merchantService.delete(merchantId);
    }

    @PutMapping("/updateRating/{merchantId}/{newRating:.+}")
    public void updateRating(@PathVariable("merchantId") String merchantId,@PathVariable("newRating") String newRating){
        merchantService.updateRating(merchantId,Double.parseDouble(newRating));
    }

}
