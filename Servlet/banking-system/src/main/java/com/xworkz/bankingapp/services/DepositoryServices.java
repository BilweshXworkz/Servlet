package com.xworkz.bankingapp.services;

import com.xworkz.bankingapp.dto.DepositoryDto;

import java.util.List;

public interface DepositoryServices {
    boolean validAndSave(DepositoryDto dto);
    List<DepositoryDto> GetDepository();
    void deleteById(int id);
    DepositoryDto getDepositoryById(int id);
    void updateDepository(DepositoryDto dto);
}
