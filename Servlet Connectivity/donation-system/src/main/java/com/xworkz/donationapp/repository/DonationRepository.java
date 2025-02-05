package com.xworkz.donationapp.repository;

import com.xworkz.donationapp.entity.DonationEntity;

import java.util.List;

public interface DonationRepository {
    Boolean save (DonationEntity donationEntity);
    List<DonationEntity> getDonationDetails();
    void deleteById(int id);
    DonationEntity getDonationById(int id);
    void updateDonation(DonationEntity entity);
}
