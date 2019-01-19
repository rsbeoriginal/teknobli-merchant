package com.teknobli.merchant.controller;

import com.teknobli.merchant.dto.MerchantProductDTO;
import com.teknobli.merchant.entity.Merchant;
import com.teknobli.merchant.services.MerchantProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merchant/product")
public class MerchantProductController {

    @Autowired
    MerchantProductService merchantProductService;

    @PostMapping("/add")
    public MerchantProductDTO add(@RequestBody MerchantProductDTO merchantProductDTO){
        return merchantProductService.add(merchantProductDTO);
    }

    @GetMapping("/select/{productId}")
    public MerchantProductDTO select(@PathVariable("productId") String productId){
        return merchantProductService.select(productId);
    }

    @PutMapping("/update")
    public MerchantProductDTO update(@RequestBody MerchantProductDTO merchantProductDTO){
        return merchantProductService.update(merchantProductDTO);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable("productId") String productId){
        merchantProductService.delete(productId);
    }

    @GetMapping("/selectAllMerchants/{productId}")
    public List<Merchant> selectAllMerchants(@PathVariable("productId") String productId){
        return merchantProductService.selectAllMerchants(productId);
    }

    @GetMapping("/getMinPrice/{productId}")
    public Integer getMinPrice(@PathVariable("productId") String productId){
        return merchantProductService.getMinPrice(productId);
    }

    @PutMapping("/updateStock/{productId}")
    public void updateStock(@PathVariable("productId") String productId){
        merchantProductService.updateStock(productId);
    }

    @PutMapping("/updateStock/{productId}")
    public void updatePrice(@PathVariable("productId") String productId){
        merchantProductService.updatePrice(productId);
    }

}
