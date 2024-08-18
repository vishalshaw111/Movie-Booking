package com.entity;

public enum SeatCategory {
    PLATINUM(320), GOLD(280), SILVER(240);

    private final int cost;

    SeatCategory(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}

