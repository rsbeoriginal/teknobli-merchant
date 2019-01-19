package com.teknobli.merchant.repository;

import com.teknobli.merchant.entity.Merchant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant,String> {
}
