package com.xworkz.paymentapp.repository;

import com.xworkz.paymentapp.dto.PaymentDto;
import com.xworkz.paymentapp.entity.PaymetEntity;

import java.util.List;

public interface PaymentRepository {
    Boolean save(PaymetEntity paymetEntity);
    List<PaymetEntity> getPaymentDetails();
    public void deleteById(int id);
    PaymetEntity getpaymentById(int id);
    void updatePayment(PaymetEntity entity);
}
