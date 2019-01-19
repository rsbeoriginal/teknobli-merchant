package com.teknobli.merchant.repository;

import com.teknobli.merchant.entity.MerchantProduct;
import org.springframework.data.repository.CrudRepository;

public interface MerchantProductRepository extends CrudRepository<MerchantProduct,String> {
}
