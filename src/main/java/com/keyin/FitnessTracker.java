package com.keyin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FitnessTracker {
    private List<Workout> workouts;
    private Goal goal;
    private boolean congratulatedForCalories = false;
    private boolean congratulatedForMinutes = false;

    public FitnessTracker(Goal goal) {
        this.workouts = new ArrayList<>();
        this.goal = goal;
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
        System.out.println("Workout added: " + workout);
    }

    public void showWorkouts() {
        if (workouts.isEmpty()) {
            System.out.println("No workouts to show.");
        } else {
            for (int i = 0; i < workouts.size(); i++) {
                System.out.println(i + ": " + workouts.get(i));
            }
        }
    }

    public int[] calculateTotalProgress() {
        int totalCaloriesBurned = 0;
        int totalWorkoutTime = 0;

        // Sum the total calories burned and total workout time
        for (Workout workout : workouts) {
            totalCaloriesBurned += workout.getCaloriesBurned();
            totalWorkoutTime += workout.getDurationInMinutes();
        }

        // Return as an array: [totalCaloriesBurned, totalWorkoutTime]
        return new int[]{totalCaloriesBurned, totalWorkoutTime};
    }

    // Method to check and display goal completion
    public void checkGoalCompletion(int totalCaloriesBurned, int totalWorkoutTime, Scanner scanner) {
        // Check if calories goal is reached
        if (totalCaloriesBurned >= goal.getTargetCalories() && !congratulatedForCalories) {
            System.out.println("\nGoal for " + goal.getTargetCalories() + " calories reached. Congratulations!");
            congratulatedForCalories = true; // Set the flag when goal is reached

            // Prompt the user to set a new calorie goal
            System.out.println("Would you like to set a new calorie goal?");
            System.out.print("Enter new calorie goal: ");
            int newCaloriesGoal = scanner.nextInt() + goal.getTargetCalories();
            goal.setTargetCalories(newCaloriesGoal);

             congratulatedForCalories = false;
        }

        // Check if minutes goal is reached
        if (totalWorkoutTime >= goal.getTargetMinutes() && !congratulatedForMinutes) {
            System.out.println("\nGoal for " + goal.getTargetMinutes() + " minutes reached. Congratulations!");
            congratulatedForMinutes = true; // Set the flag when goal is reached

            // Prompt the user to set a new time goal
            System.out.println("Would you like to set a new time goal?");
            System.out.print("Enter new time goal in minutes: ");
            int newTimeGoal = scanner.nextInt() + goal.getTargetMinutes();
            goal.setTargetMinutes(newTimeGoal);

             congratulatedForMinutes = false;
        }
    }

    // Getter methods for the congratulation flags
    public boolean isCongratulatedForCalories() {
        return congratulatedForCalories;
    }

    public boolean isCongratulatedForMinutes() {
        return congratulatedForMinutes;
    }

    public void trackProgress() {
        int[] progress = calculateTotalProgress();
        goal.showProgress(progress[0], progress[1]); // Show goal progress
    }
}
