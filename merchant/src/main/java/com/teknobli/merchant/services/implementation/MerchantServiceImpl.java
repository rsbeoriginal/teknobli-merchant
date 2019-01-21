package com.teknobli.merchant.services.implementation;

import com.teknobli.merchant.dto.MerchantDTO;
import com.teknobli.merchant.entity.Merchant;
import com.teknobli.merchant.repository.MerchantRepository;
import com.teknobli.merchant.services.MerchantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public MerchantDTO add(MerchantDTO merchantDTO) {
        Merchant merchant = new Merchant();
        BeanUtils.copyProperties(merchantDTO,merchant);
        MerchantDTO merchantDTODb=new MerchantDTO();
        BeanUtils.copyProperties(merchantRepository.save(merchant),merchantDTODb);
        return merchantDTODb;
    }

    @Override
    public MerchantDTO select(String merchantId) {
        MerchantDTO merchantDTO = new MerchantDTO();
        System.out.println("MID: " + merchantId);
        BeanUtils.copyProperties(merchantRepository.findOne(merchantId),merchantDTO);
        return merchantDTO;
    }

    @Override
    public MerchantDTO update(MerchantDTO merchantDTO) {
        Merchant merchant = new Merchant();
        BeanUtils.copyProperties(merchantDTO,merchant);
        MerchantDTO merchantDTODb=new MerchantDTO();
        BeanUtils.copyProperties(merchantRepository.save(merchant),merchantDTODb);
        return merchantDTODb;
    }

    @Override
    public void delete(String merchantId) {
        merchantRepository.delete(merchantId);
    }

    @Override
    public void updateRating(String merchantId, Double newRating) {
        merchantRepository.updateRating(merchantId,newRating);
    }
}
