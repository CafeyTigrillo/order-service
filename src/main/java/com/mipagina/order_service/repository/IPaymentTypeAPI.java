package com.mipagina.order_service.repository;

import com.mipagina.order_service.dto.PaymentTypeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "payment-type-service")
public interface IPaymentTypeAPI {
    @GetMapping("/payment/bring/{paymentId}")
    public PaymentTypeDTO getPaymentType(@PathVariable("paymentId") Long id);
}
