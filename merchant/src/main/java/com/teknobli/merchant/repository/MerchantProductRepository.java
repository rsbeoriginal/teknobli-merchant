package com.teknobli.merchant.repository;

import com.teknobli.merchant.entity.Merchant;
import com.teknobli.merchant.entity.MerchantProduct;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MerchantProductRepository extends CrudRepository<MerchantProduct,String> {


    @Query("FROM MerchantProduct WHERE (merchant_id = ?1 AND productId = ?2)")
    MerchantProduct findMerchantProductOne(String merchantId, String productId);

    @Query(value = "SELECT MIN(price) FROM MerchantProduct WHERE productId = ?1 AND stock > 0 ")
    Double getMinPrice(String productId);

    @Modifying
    @Query("UPDATE MerchantProduct SET stock = ?3 WHERE (merchant_id = ?1 AND productId = ?2) ")
    void updateStock(String merchantId, String productId, int newStock);

    @Modifying
    @Query("UPDATE MerchantProduct SET price = ?3 WHERE (merchant_id = ?1 AND productId = ?2) ")
    void updatePrice(String merchantId, String productId, int newPrice);

    @Query(value = "FROM MerchantProduct WHERE productId = ?1 ")
    List<MerchantProduct> selectAllMerchants(String productId);

    @Modifying
    @Query("DELETE FROM MerchantProduct WHERE (merchant_id = ?1 AND productId = ?2) ")
    void delete(String merchantId, String productId);
}
