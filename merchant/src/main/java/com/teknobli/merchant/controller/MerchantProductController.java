package com.teknobli.merchant.controller;

import com.teknobli.merchant.dto.MerchantProductDTO;
import com.teknobli.merchant.entity.Merchant;
import com.teknobli.merchant.entity.MerchantProduct;
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
    public MerchantProductDTO add(@RequestBody MerchantProductDTO merchantProductDTO) {
        return merchantProductService.add(merchantProductDTO);
    }

    @GetMapping("/select/{merchantId}/{productId}")
    public MerchantProductDTO select(@PathVariable("merchantId") String merchantId, @PathVariable("productId") String productId) {
        return merchantProductService.select(merchantId,productId);
    }

    @PutMapping("/update")
    public MerchantProductDTO update(@RequestBody MerchantProductDTO merchantProductDTO) {
        return merchantProductService.update(merchantProductDTO);
    }

    @DeleteMapping("/delete/{merchantId}/{productId}")
    public void delete(@PathVariable("merchantId") String merchantId, @PathVariable("productId") String productId) {
        merchantProductService.delete(merchantId,productId);
    }

    @GetMapping("/selectAllMerchants/{productId}")
    public List<MerchantProduct> selectAllMerchants(@PathVariable("productId") String productId) {
        return merchantProductService.selectAllMerchants(productId);
    }

    @GetMapping("/getMinPrice/{productId}")
    public Integer getMinPrice(@PathVariable("productId") String productId) {
        return merchantProductService.getMinPrice(productId);
    }

    @PutMapping("/updateStock/{merchantId}/{productId}/{newStock}")
    public void updateStock(@PathVariable("merchantId") String merchantId, @PathVariable("productId") String productId,@PathVariable("newStock") int newStock) {
        merchantProductService.updateStock(merchantId,productId,newStock);
    }

    @PutMapping("/updatePrice/{merchantId}/{productId}/{newPrice}")
    public void updatePrice(@PathVariable("merchantId") String merchantId, @PathVariable("productId") String productId, @PathVariable("newPrice") int newPrice) {
        merchantProductService.updatePrice(merchantId,productId,newPrice);
    }

}
