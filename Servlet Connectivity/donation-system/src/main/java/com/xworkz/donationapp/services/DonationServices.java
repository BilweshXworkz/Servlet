package com.xworkz.donationapp.services;

import com.xworkz.donationapp.dto.DonationDto;;import java.util.List;

public interface DonationServices {
    Boolean ValidAndSave(DonationDto dto);
    List<DonationDto> getDonation();
    void deleteById(int id);
}
