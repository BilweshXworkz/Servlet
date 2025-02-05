package com.xworkz.tablebook.repository;

import com.xworkz.tablebook.entity.BookTableEntity;

import java.util.List;

public interface BookTableRepository {
    Boolean save(BookTableEntity bookTableEntity);
    List<BookTableEntity> getBookDetails();
    void deleteById(int id);
    BookTableEntity getTableById(int id);
    void updateTable(BookTableEntity entity);
}
