package com.teknobli.merchant.repository;

import com.teknobli.merchant.entity.MerchantProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MerchantProductRepository extends CrudRepository<MerchantProduct,String> {

//    @Query("UPDATE MerchantProduct SET stock = ?2 WHERE productId = ?0 ")
//    void updateStock(String productId,String newStock);

}
