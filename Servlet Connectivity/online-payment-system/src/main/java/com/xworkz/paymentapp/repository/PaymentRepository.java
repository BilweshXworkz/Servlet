package com.xworkz.paymentapp.repository;

import com.xworkz.paymentapp.dto.PaymentDto;
import com.xworkz.paymentapp.entity.PaymetEntity;

public interface PaymentRepository {
    Boolean save(PaymetEntity paymetEntity);
}
