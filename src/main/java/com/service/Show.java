package com.service;

import com.entity.SeatCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Show {
    private final Map<String, SeatCategory> seats;

    public Show(Map<String, SeatCategory> seats) {
        this.seats = seats;
    }

    public List<String> bookSeats(String[] seatsToBook) {
        List<String>  list = new ArrayList<>();
        for (String seat : seatsToBook) {
            if (!seats.containsKey(seat) || seats.get(seat) == null) {
                 list.add(seat);
            }
        }
        return list;
    }

    public int calculateCost(String[] seatsToBook) {
        int totalCost = 0;
        for (String seat : seatsToBook) {
            SeatCategory category = seats.get(seat);
            if (category != null) {
                totalCost += category.getCost();
            }
        }
        // Remove seats which are booked
        for (String seat : seatsToBook) {
            seats.remove(seat);
        }
        return totalCost;
    }
}

