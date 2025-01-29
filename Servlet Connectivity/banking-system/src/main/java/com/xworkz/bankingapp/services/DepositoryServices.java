package com.xworkz.bankingapp.services;

import com.xworkz.bankingapp.dto.DepositoryDto;

public interface DepositoryServices {
    boolean validAndSave(DepositoryDto dto);
}
