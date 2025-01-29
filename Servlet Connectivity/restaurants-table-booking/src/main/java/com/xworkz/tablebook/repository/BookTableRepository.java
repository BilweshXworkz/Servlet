package com.xworkz.tablebook.repository;

import com.xworkz.tablebook.entity.BookTableEntity;

public interface BookTableRepository {
    Boolean save(BookTableEntity bookTableEntity);
}
