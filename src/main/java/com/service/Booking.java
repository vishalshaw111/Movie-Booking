package com.service;

public class Booking {
    private static final double SERVICE_TAX_RATE = 0.14;
    private static final double SWACHH_BHARAT_CESS_RATE = 0.005;
    private static final double KRISHI_KALYAN_CESS_RATE = 0.005;

    private int revenue;

    public double processBooking(int cost) {
        double serviceTax = cost * SERVICE_TAX_RATE;
        double swachhBharatCess = cost * SWACHH_BHARAT_CESS_RATE;
        double krishiKalyanCess = cost * KRISHI_KALYAN_CESS_RATE;
        System.out.printf("Service Tax @14%%: Rs. %.2f%n",serviceTax);
        System.out.printf("Swachh Bharat Cess @0.5%%: Rs. %.2f%n",swachhBharatCess);
        System.out.printf("Krishi Kalyan Cess @0.5%%: Rs. %.2f%n",krishiKalyanCess);
        return cost + serviceTax + swachhBharatCess + krishiKalyanCess;
    }

    public void addRevenue(int amount) {
        revenue += amount;
    }

    public void printSummary() {
        System.out.printf("Revenue: Rs. %d%n", revenue);
        processBooking(revenue);
    }
}
