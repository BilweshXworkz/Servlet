package com.xworkz.hotelapp.dto;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data

public class RoomOrderDto {
    private Integer id;
    private String firstName;
    private Long phoneNumber;
    private String hotel;
    private String stayTime;
    private String numberRoom;
}
