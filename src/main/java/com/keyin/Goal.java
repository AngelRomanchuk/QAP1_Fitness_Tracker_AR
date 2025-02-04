package com.keyin;

public class Goal {
    private int targetCalories;
    private int targetMinutes;

    public Goal(int targetCalories, int targetMinutes) {
        this.targetCalories = targetCalories;
        this.targetMinutes = targetMinutes;
    }

    public int getTargetCalories() {
        return targetCalories;
    }

    public int getTargetMinutes() {
        return targetMinutes;
    }

    public void setTargetCalories(int targetCalories) {
        this.targetCalories = targetCalories;
    }

    public void setTargetMinutes(int targetMinutes) {
        this.targetMinutes = targetMinutes;
    }

    public void showProgress(int totalCaloriesBurned, int totalWorkoutTime) {
        System.out.println("Goal Progress:");
        System.out.println("Target Calories: " + targetCalories + " | Calories Burned: " + totalCaloriesBurned);
        System.out.println("Target Time: " + targetMinutes + " mins | Total Time: " + totalWorkoutTime + " mins");
    }
}

