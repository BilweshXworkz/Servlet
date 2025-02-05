package com.xworkz.passport.repository;

import com.xworkz.passport.entity.RegisterEntity;

import java.util.List;

public interface RegisterRepository {
    Boolean save(RegisterEntity registerEntity);
    List<RegisterEntity> getRegisterDetails();
    void deleteById(int id);
    RegisterEntity getProfileById(Integer id);
    void updateProfile(RegisterEntity entity);
}
