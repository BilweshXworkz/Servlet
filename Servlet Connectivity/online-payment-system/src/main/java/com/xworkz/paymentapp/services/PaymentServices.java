package com.xworkz.paymentapp.services;

import com.xworkz.paymentapp.dto.PaymentDto;
import com.xworkz.paymentapp.repository.PaymentRepository;

public interface PaymentServices {
    Boolean validAndSave(PaymentDto paymentDto);
}
