package com.teknobli.merchant.repository;

import com.teknobli.merchant.entity.Merchant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant,String> {

    @Modifying
    @Query("UPDATE Merchant SET rating = ?2 WHERE merchantId = ?1")
    void updateRating(String merchantId, Double newRating);
}
