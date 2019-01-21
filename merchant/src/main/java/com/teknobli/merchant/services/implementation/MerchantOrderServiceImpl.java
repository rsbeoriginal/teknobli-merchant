package com.teknobli.merchant.services.implementation;

import com.teknobli.merchant.dto.MerchantOrderDTO;
import com.teknobli.merchant.entity.MerchantOrder;
import com.teknobli.merchant.ordermicroservices.dto.RecieptDTO;
import com.teknobli.merchant.ordermicroservices.dto.RecieptProductDTO;
import com.teknobli.merchant.repository.MerchantOrderRepository;
import com.teknobli.merchant.repository.MerchantProductRepository;
import com.teknobli.merchant.services.MerchantOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
public class MerchantOrderServiceImpl implements MerchantOrderService {

    @Autowired
    MerchantOrderRepository merchantOrderRepository;

    @Autowired
    MerchantProductRepository merchantProductRepository;

    @Override
    public MerchantOrderDTO add(MerchantOrderDTO merchantOrderDTO) {
        MerchantOrder merchantOrder = new MerchantOrder();
        BeanUtils.copyProperties(merchantOrderDTO,merchantOrder);
        MerchantOrderDTO merchantOrderDTODb = new MerchantOrderDTO();
        BeanUtils.copyProperties(merchantOrderRepository.save(merchantOrder),merchantOrderDTODb);
        return merchantOrderDTODb;
    }

    @Transactional(readOnly = true)
    @Override
    public int getCount(String merchantId) {
        return merchantOrderRepository.getCount(merchantId);
    }

    @Override
    public Boolean validateOrder(RecieptDTO recieptDTO) {

        for(RecieptProductDTO recieptProductDTO: recieptDTO.getRecieptProductDTOList()){
            if(!checkStock(recieptProductDTO)){
                return false;
            }
        }
        //accept order
        for(RecieptProductDTO recieptProductDTO: recieptDTO.getRecieptProductDTOList()){
            acceptOrder(recieptProductDTO);
        }
        return true;
    }

    private void acceptOrder(RecieptProductDTO recieptProductDTO) {
        int currentStock = merchantProductRepository.getStock(recieptProductDTO.getMerchantId(),recieptProductDTO.getProductId());
        int newStock = currentStock - recieptProductDTO.getQuantity();
        System.out.println(currentStock + " : " + newStock);
        merchantProductRepository.updateStock(recieptProductDTO.getMerchantId(),recieptProductDTO.getProductId(),newStock);
    }

    private boolean checkStock(RecieptProductDTO recieptProductDTO) {

        int currentStock = merchantProductRepository.getStock(recieptProductDTO.getMerchantId(),recieptProductDTO.getProductId());
        System.out.println("Current Stock :" + currentStock + " required :" + recieptProductDTO.getQuantity());
        if(recieptProductDTO.getQuantity()>currentStock){
            return false;
        }
        return true;
    }


}
