package com.xworkz.donationapp.services;

import com.xworkz.donationapp.dto.DonationDto;;

public interface DonationServices {
    Boolean ValidAndSave(DonationDto dto);
}
