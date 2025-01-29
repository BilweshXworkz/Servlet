package com.xworkz.donationapp.repository;

import com.xworkz.donationapp.entity.DonationEntity;

public interface DonationRepository {
    Boolean save (DonationEntity donationEntity);
}
