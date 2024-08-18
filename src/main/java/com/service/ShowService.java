package com.service;

import com.dao.ShowRepository;
import com.entity.SeatCategory;
import com.exception.SeatAlreadyBookedException;

import java.util.*;
import java.util.stream.Collectors;

public class ShowService {
    private final ShowRepository showRepository;
    private final Booking booking;

    public ShowService(ShowRepository showRepository, Booking booking) {
        this.showRepository = showRepository;
        this.booking = booking;
    }

    public void displaySeats(int showNumber) {
        Map<String, SeatCategory> seats = showRepository.getSeatsForShow(showNumber);

        // Group seats by their row identifier (A, B, C, etc.)
        Map<Character, String> seatRows = seats.keySet().stream()
                .collect(Collectors.groupingBy(
                        seat -> seat.charAt(0),
                        TreeMap::new, // Keeps rows sorted alphabetically
                        Collectors.joining(" ") // Concatenate seat names with space
                ));

        // Print seats row by row
        for (Map.Entry<Character, String> entry : seatRows.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void bookSeats(int showNumber, String[] seatsToBook) throws SeatAlreadyBookedException {
        Map<String, SeatCategory> seats = showRepository.getSeatsForShow(showNumber);
        Show show = new Show(seats);
        List<String> booked = show.bookSeats(seatsToBook);
        if (booked.isEmpty()) {
            int cost = show.calculateCost(seatsToBook);
            booking.addRevenue(cost);
            showRepository.updateSeats(showNumber, seats);
            System.out.println("Successfully Booked - Show "+showNumber);
            System.out.printf("Subtotal: Rs. %d%n",cost);
            System.out.printf("Total: Rs. %.2f%n", booking.processBooking(cost));
        } else {
            throw new SeatAlreadyBookedException(booked + " seats are not available, Please select different seats");
        }
    }

    public void printSummary() {
        booking.printSummary();
    }
}

