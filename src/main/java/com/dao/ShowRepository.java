package com.dao;

import com.entity.SeatCategory;

import java.util.Map;

public interface ShowRepository {
    Map<String, SeatCategory> getSeatsForShow(int showNumber);
    void updateSeats(int showNumber, Map<String, SeatCategory> seats);
}

