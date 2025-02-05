package com.xworkz.tablebook.services;

import com.xworkz.tablebook.dto.BookTableDto;

import java.util.List;

public interface BookTableServices {
    Boolean validAndSave(BookTableDto dto);
    List<BookTableDto> getBook();
    void deleteById(int id);
    BookTableDto getTableById(int id);
    void updateTable(BookTableDto dto);
}
