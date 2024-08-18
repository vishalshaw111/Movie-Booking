package com.dao;

import com.entity.SeatCategory;

import java.util.HashMap;
import java.util.Map;

public class ShowRepositoryImpl implements ShowRepository {
    private final Map<Integer, Map<String, SeatCategory>> shows;

    public ShowRepositoryImpl() {
        shows = new HashMap<>();
        initializeShows();
    }

    private void initializeShows() {
        Map<String, SeatCategory> show1Seats = new HashMap<>();
        show1Seats.put("A1", SeatCategory.PLATINUM);
        show1Seats.put("A2", SeatCategory.PLATINUM);
        show1Seats.put("A3", SeatCategory.PLATINUM);
        show1Seats.put("A4", SeatCategory.PLATINUM);
        show1Seats.put("A5", SeatCategory.PLATINUM);
        show1Seats.put("A6", SeatCategory.PLATINUM);
        show1Seats.put("A7", SeatCategory.PLATINUM);
        show1Seats.put("A8", SeatCategory.PLATINUM);
        show1Seats.put("A9", SeatCategory.PLATINUM);
        show1Seats.put("B1", SeatCategory.GOLD);
        show1Seats.put("B2", SeatCategory.GOLD);
        show1Seats.put("B3", SeatCategory.GOLD);
        show1Seats.put("B4", SeatCategory.GOLD);
        show1Seats.put("B5", SeatCategory.GOLD);
        show1Seats.put("B6", SeatCategory.GOLD);
        show1Seats.put("C2", SeatCategory.SILVER);
        show1Seats.put("C3", SeatCategory.SILVER);
        show1Seats.put("C4", SeatCategory.SILVER);
        show1Seats.put("C5", SeatCategory.SILVER);
        show1Seats.put("C6", SeatCategory.SILVER);
        show1Seats.put("C7", SeatCategory.SILVER);
        shows.put(1, show1Seats);

        Map<String, SeatCategory> show2Seats = new HashMap<>();
        show2Seats.put("A1", SeatCategory.PLATINUM);
        show2Seats.put("A2", SeatCategory.PLATINUM);
        show2Seats.put("A3", SeatCategory.PLATINUM);
        show2Seats.put("A4", SeatCategory.PLATINUM);
        show2Seats.put("A5", SeatCategory.PLATINUM);
        show2Seats.put("A6", SeatCategory.PLATINUM);
        show2Seats.put("A7", SeatCategory.PLATINUM);
        show2Seats.put("B2", SeatCategory.GOLD);
        show2Seats.put("B3", SeatCategory.GOLD);
        show2Seats.put("B4", SeatCategory.GOLD);
        show2Seats.put("B5", SeatCategory.GOLD);
        show2Seats.put("B6", SeatCategory.GOLD);
        show2Seats.put("C1", SeatCategory.SILVER);
        show2Seats.put("C2", SeatCategory.SILVER);
        show2Seats.put("C3", SeatCategory.SILVER);
        show2Seats.put("C4", SeatCategory.SILVER);
        show2Seats.put("C5", SeatCategory.SILVER);
        show2Seats.put("C6", SeatCategory.SILVER);
        show2Seats.put("C7", SeatCategory.SILVER);
        shows.put(2, show2Seats);

        Map<String, SeatCategory> show3Seats = new HashMap<>();
        show3Seats.put("A1", SeatCategory.PLATINUM);
        show3Seats.put("A2", SeatCategory.PLATINUM);
        show3Seats.put("A3", SeatCategory.PLATINUM);
        show3Seats.put("A4", SeatCategory.PLATINUM);
        show3Seats.put("A5", SeatCategory.PLATINUM);
        show3Seats.put("A6", SeatCategory.PLATINUM);
        show3Seats.put("A7", SeatCategory.PLATINUM);
        show3Seats.put("B1", SeatCategory.GOLD);
        show3Seats.put("B2", SeatCategory.GOLD);
        show3Seats.put("B3", SeatCategory.GOLD);
        show3Seats.put("B4", SeatCategory.GOLD);
        show3Seats.put("B5", SeatCategory.GOLD);
        show3Seats.put("B6", SeatCategory.GOLD);
        show3Seats.put("B7", SeatCategory.GOLD);
        show3Seats.put("B8", SeatCategory.GOLD);
        show3Seats.put("C1", SeatCategory.SILVER);
        show3Seats.put("C2", SeatCategory.SILVER);
        show3Seats.put("C3", SeatCategory.SILVER);
        show3Seats.put("C4", SeatCategory.SILVER);
        show3Seats.put("C5", SeatCategory.SILVER);
        show3Seats.put("C6", SeatCategory.SILVER);
        show3Seats.put("C7", SeatCategory.SILVER);
        show3Seats.put("C8", SeatCategory.SILVER);
        show3Seats.put("C9", SeatCategory.SILVER);
        shows.put(3, show3Seats);
    }

    @Override
    public Map<String, SeatCategory> getSeatsForShow(int showNumber) {
        return new HashMap<>(shows.getOrDefault(showNumber, new HashMap<>()));
    }

    @Override
    public void updateSeats(int showNumber, Map<String, SeatCategory> seats) {
        shows.put(showNumber, new HashMap<>(seats));
    }
}
