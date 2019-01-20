package com.teknobli.merchant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MerchantApplication{

	public static void main(String[] args) {
		SpringApplication.run(MerchantApplication.class, args);
	}

//	@Override
//	public void run(String... strings) throws Exception {
//
////		String uri = "https://www.blibli.com/backend/mobile/home.json";
//		@Autowired
//		RestTemplate restTemplate;
//
//		String uri = "http://172.16.20.78:8000/product/add";
//
//		ProductDTO sendProduct = new ProductDTO();
//		sendProduct.setProductName("LOL");
//		ProductDTO productDTO = restTemplate.postForObject(uri,sendProduct,ProductDTO.class);
//
//		System.out.println(productDTO);
//
//	}
}

