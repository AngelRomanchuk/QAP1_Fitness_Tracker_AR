package com.keyin;

public class Workout {
    private String type;           // Running, Cycling, etc.
    private int durationInMinutes; // Workout duration in minutes
    private int caloriesBurned;    // Calories burned during workout

    public Workout(String type, int durationInMinutes, int caloriesBurned) {
        this.type = type;
        this.durationInMinutes = durationInMinutes;
        this.caloriesBurned = caloriesBurned;
    }

    public String getType() {
        return type;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    @Override
    public String toString() {
        return String.format("Workout Type: %s, Duration: %d mins, Calories Burned: %d",
                type, durationInMinutes, caloriesBurned);
    }
}

