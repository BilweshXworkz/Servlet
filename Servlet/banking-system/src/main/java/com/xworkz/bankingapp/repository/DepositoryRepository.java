package com.xworkz.bankingapp.repository;

import com.xworkz.bankingapp.entity.DepositoryEntity;

import java.util.List;

public interface DepositoryRepository {
    Boolean save(DepositoryEntity depositoryEntity);
    List<DepositoryEntity> getDepositoryDetails();
    void deleteById(int id);
    DepositoryEntity getDepositoryById(int id);
    void updateDepository(DepositoryEntity entity);
}
