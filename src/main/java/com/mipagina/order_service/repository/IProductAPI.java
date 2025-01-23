package com.mipagina.order_service.repository;

import com.mipagina.order_service.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bring-product-service")
public interface IProductAPI {
    @GetMapping("/products/bring-product/{id_product}")
    public ProductDTO getProductById(@PathVariable("id_product") Long id_product);
}
