package com.service;

import static org.junit.jupiter.api.Assertions.*;

import com.entity.SeatCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowTest {

    private Show show;

    @BeforeEach
    public void setUp() {
        // Initialize the seats map with a few seats and categories
        Map<String, SeatCategory> seats = new HashMap<>();
        seats.put("A1", SeatCategory.PLATINUM);
        seats.put("A3", SeatCategory.PLATINUM);
        seats.put("B2", SeatCategory.GOLD);
        seats.put("C3", SeatCategory.SILVER);
        seats.put("B1", SeatCategory.GOLD);

        show = new Show(seats);
    }

    @Test
    public void testBookSeats_validAndInvalidSeats() {
        // Book some valid and invalid seats
        String[] seatsToBook = {"A1", "C1"}; // C1 is an invalid seat
        List<String> unbookedSeats = show.bookSeats(seatsToBook);

        // Check that the unbooked seat is C1
        assertEquals(1, unbookedSeats.size());
        assertTrue(unbookedSeats.contains("C1"));
    }

    @Test
    public void testBookSeats_allValidSeats() {
        // Book all valid seats
        String[] seatsToBook = {"A1", "A3", "B2", "B1"};
        List<String> unbookedSeats = show.bookSeats(seatsToBook);

        // All seats should be valid, so unbookedSeats should be empty
        assertTrue(unbookedSeats.isEmpty());
    }

    @Test
    public void testBookSeats_allInvalidSeats() {
        // Attempt to book invalid seats
        String[] seatsToBook = {"C1", "C2", "C4"};
        List<String> unbookedSeats = show.bookSeats(seatsToBook);

        // All seats should be invalid, so unbookedSeats should contain all of them
        assertEquals(3, unbookedSeats.size());
        assertTrue(unbookedSeats.contains("C1"));
        assertTrue(unbookedSeats.contains("C2"));
        assertTrue(unbookedSeats.contains("C4"));
    }

    @Test
    public void testCalculateCost_validSeats() {
        // Calculate the cost for valid seats
        String[] seatsToBook = {"A1", "A3", "B1"};
        int totalCost = show.calculateCost(seatsToBook);

        // A1 (PLATINUM), A3 (PLATINUM), B1 (GOLD) => 320 + 320 + 280 = 920
        assertEquals(920, totalCost);
    }

    @Test
    public void testCalculateCost_invalidSeat() {
        // Calculate the cost where one seat is invalid
        String[] seatsToBook = {"A1", "C1"}; // C1 is invalid
        int totalCost = show.calculateCost(seatsToBook);

        // Only A1 (PLATINUM) should be counted => 320
        assertEquals(320, totalCost);
    }

    @Test
    public void testCalculateCost_afterBookingSeats() {
        // First calculate the cost for some seats
        String[] seatsToBook = {"A1", "A3"};
        int totalCost = show.calculateCost(seatsToBook);

        // A1 (PLATINUM), A3 (PLATINUM) => 320 + 320 = 560
        assertEquals(640, totalCost);

        // Attempt to book the same seats again should yield zero cost as they are removed
        totalCost = show.calculateCost(seatsToBook);
        assertEquals(0, totalCost);
    }
}
