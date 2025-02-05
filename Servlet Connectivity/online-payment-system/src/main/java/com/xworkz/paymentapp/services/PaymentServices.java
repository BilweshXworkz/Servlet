package com.xworkz.paymentapp.services;

import com.xworkz.paymentapp.dto.PaymentDto;
import com.xworkz.paymentapp.repository.PaymentRepository;

import java.util.List;

public interface PaymentServices {
    Boolean validAndSave(PaymentDto paymentDto);
    List<PaymentDto> getPayment();
    void deleteById(int id);
    PaymentDto getPaymentById(int id);
    void updatePayment(PaymentDto paymentDto);
}
