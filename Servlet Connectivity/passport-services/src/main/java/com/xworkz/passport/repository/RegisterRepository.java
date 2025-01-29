package com.xworkz.passport.repository;

import com.xworkz.passport.entity.RegisterEntity;

public interface RegisterRepository {
    Boolean save(RegisterEntity registerEntity);
}
