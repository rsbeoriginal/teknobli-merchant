package com.teknobli.merchant.repository;

import com.teknobli.merchant.entity.MerchantOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MerchantOrderRepository extends CrudRepository<MerchantOrder,String> {

    @Query(value = "SELECT COUNT(*) FROM MerchantOrder WHERE merchantId = ?1")
    int getCount(String merchantId);

}
