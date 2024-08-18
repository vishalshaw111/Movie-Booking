package com.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookingTest {

    private Booking booking;

    @BeforeEach
    public void setUp() {
        booking = new Booking();
    }

    @Test
    public void testProcessBooking() {
        int cost = 1000;
        double expectedTotalCost = cost
                + (cost * 0.14)  // Service Tax
                + (cost * 0.005) // Swachh Bharat Cess
                + (cost * 0.005);// Krishi Kalyan Cess
        double totalCost = booking.processBooking(cost);
        assertEquals(expectedTotalCost, totalCost, 0.01);
    }

    @Test
    public void testProcessBooking_zeroCost() {
        int cost = 0;
        double expectedTotalCost = 0.0;
        double totalCost = booking.processBooking(cost);
        assertEquals(expectedTotalCost, totalCost, 0.01);
    }
}
