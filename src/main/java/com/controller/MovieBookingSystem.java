package com.controller;

import com.exception.InvalidInputException;
import com.exception.SeatAlreadyBookedException;
import com.service.ShowService;

import java.util.Scanner;

public class MovieBookingSystem {
    private final ShowService showService;

    public MovieBookingSystem(ShowService showService) {
        this.showService = showService;
    }

    public void startBooking() {
        Scanner scanner = new Scanner(System.in);
        int showNumber;
        while (true) {
            System.out.println("Enter the show number (1, 2, 3) or 0 to exit:");
            try {
                showNumber = scanner.nextInt();
                if(showNumber > 3 || showNumber<0){
                    throw new InvalidInputException("Invalid input. Show number must be 1, 2 or 3");
                }
            } catch (InvalidInputException e){
                System.out.println(e.getMessage());
                continue;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
                continue;
            }
            scanner.nextLine(); // Consume newline
            if (showNumber == 0) {
                break;
            }
            System.out.println("Available seats:");
            showService.displaySeats(showNumber);
            System.out.println("Enter seats to book (comma separated):");
            String input = scanner.nextLine();
            String[] seatsToBook = input.split("\\s*,\\s*");
            try {
                showService.bookSeats(showNumber, seatsToBook);
            }catch (SeatAlreadyBookedException e){
                System.out.println(e.getMessage());
            }
            System.out.println("Would you like to continue (Yes/No):");
            String proceed = scanner.nextLine();
            if("Yes".equalsIgnoreCase(proceed)){
                continue;
            }else{
                break;
            }
        }
        showService.printSummary();
    }
}
