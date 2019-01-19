package com.teknobli.merchant.repository;

import com.teknobli.merchant.entity.MerchantOrder;
import org.springframework.data.repository.CrudRepository;

public interface MerchantOrderRepository extends CrudRepository<MerchantOrder,String> {
}
