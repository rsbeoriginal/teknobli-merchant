package com.teknobli.merchant.services.implementation;

import com.teknobli.merchant.dto.MerchantProductDTO;
import com.teknobli.merchant.entity.MerchantProduct;
import com.teknobli.merchant.repository.MerchantOrderRepository;
import com.teknobli.merchant.repository.MerchantProductRepository;
import com.teknobli.merchant.services.MerchantProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public class MerchantProductServiceImpl implements MerchantProductService {

    @Autowired
    MerchantProductRepository merchantProductRepository;

    @Autowired
    MerchantOrderRepository merchantOrderRepository;


    @Override
    public MerchantProductDTO add(MerchantProductDTO merchantProductDTO) {
        MerchantProduct merchantProduct = new MerchantProduct();
        BeanUtils.copyProperties(merchantProductDTO, merchantProduct);
        MerchantProductDTO merchantProductDTODb = new MerchantProductDTO();
        BeanUtils.copyProperties(merchantProductRepository.save(merchantProduct), merchantProductDTODb);
        return merchantProductDTODb;
    }

    @Transactional(readOnly = true)
    @Override
    public MerchantProductDTO select(String merchantId, String productId) {
        MerchantProductDTO merchantProductDTO = new MerchantProductDTO();
        BeanUtils.copyProperties(merchantProductRepository.findMerchantProductOne(merchantId, productId), merchantProductDTO);
        return merchantProductDTO;
    }

    @Override
    public MerchantProductDTO update(MerchantProductDTO merchantProductDTO) {
        MerchantProduct merchantProduct = new MerchantProduct();
        BeanUtils.copyProperties(merchantProductDTO, merchantProduct);
        MerchantProductDTO merchantProductDTODb = new MerchantProductDTO();
        BeanUtils.copyProperties(merchantProductRepository.save(merchantProduct), merchantProductDTODb);
        return merchantProductDTODb;
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(String merchantId, String productId) {
        merchantProductRepository.delete(merchantId, productId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<MerchantProduct> selectAllMerchants(String productId) {

        List<MerchantProduct> merchantProducts = merchantProductRepository.selectAllMerchants(productId);

        List<MerchantProduct> merchantProductListRatingSorted = new ArrayList<>();
        for (int i = 0; i < merchantProducts.size(); i++) {
            MerchantProduct merchantProduct = merchantProducts.get(i);
            String merchantId = merchantProduct.getMerchant().getMerchantId();

            Double userRating = merchantProduct.getMerchant().getRating();
            Double productVarietyRating = merchantProductRepository.getTypesOfProduct(merchantId);
            Double orderCreatedRating = Double.valueOf(merchantOrderRepository.getCount(merchantId));
            Double stockRating = Double.valueOf(merchantProduct.getStock());
            Double priceRating = Double.valueOf(i + 1);

            Double params = 5d;
            Double combinedRating = ((userRating * (100 / params))
                    + (productVarietyRating * (100 / params))
                    + (orderCreatedRating * (100 / params))
                    + (stockRating * (100 / params))
                    + (priceRating * (100 / params))) / 100;

            merchantProduct.getMerchant().setRating(combinedRating);

//            System.out.println(merchantId +" : " +userRating +" : " +productVarietyRating +" : "
//                    + orderCreatedRating +" : "+stockRating+" : " + priceRating +" : "+ combinedRating) ;

            merchantProductListRatingSorted.add(merchantProduct);
        }

        Collections.sort(merchantProductListRatingSorted,new MerchantComparator());

        return merchantProductListRatingSorted;
    }


    @Transactional(readOnly = true)
    @Override
    public Double getMinPrice(String productId) {
        return merchantProductRepository.getMinPrice(productId);
    }

    @Transactional
    @Override
    public void updateStock(String merchantId, String productId, int newStock) {
        merchantProductRepository.updateStock(merchantId, productId, newStock);
    }

    @Transactional
    @Override
    public void updatePrice(String merchantId, String productId, int newPrice) {
        merchantProductRepository.updatePrice(merchantId, productId, newPrice);
    }

    @Override
    public Integer getTotalStock(String productId) {
        Integer stock = merchantProductRepository.getTotalStock(productId);
        if(stock!=null){
            return stock;
        }
        return 0;
    }


    private class MerchantComparator implements Comparator<MerchantProduct> {
        @Override
        public int compare(MerchantProduct m1, MerchantProduct m2) {
            if (m1.getMerchant().getRating() < m2.getMerchant().getRating()) return 1;
            else if (m1.getMerchant().getRating() > m2.getMerchant().getRating()) return -1;
            return 0;
        }
    }
}
