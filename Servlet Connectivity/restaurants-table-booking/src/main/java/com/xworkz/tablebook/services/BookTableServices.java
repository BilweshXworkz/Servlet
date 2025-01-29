package com.xworkz.tablebook.services;

import com.xworkz.tablebook.dto.BookTableDto;

public interface BookTableServices {
    Boolean validAndSave(BookTableDto dto);
}
