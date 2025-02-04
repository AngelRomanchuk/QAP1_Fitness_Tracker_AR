package com.keyin;

import java.util.ArrayList;
import java.util.List;

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
            return new int[] { totalCaloriesBurned, totalWorkoutTime };
        }

    // Method to check and display goal completion
        public void checkGoalCompletion(int totalCaloriesBurned, int totalWorkoutTime) {
            if (totalCaloriesBurned >= goal.getTargetCalories() && !congratulatedForCalories) {
                System.out.println("\nGoal for " + goal.getTargetCalories() + " calories reached. Congratulations!");
                congratulatedForCalories = true; // Ensure the message only shows once
            }

            if (totalWorkoutTime >= goal.getTargetMinutes() && !congratulatedForMinutes) {
                System.out.println("\nGoal for " + goal.getTargetMinutes() + " minutes reached. Congratulations!");
                congratulatedForMinutes = true; // Ensure the message only shows once
            }
        }

    public void trackProgress() {
        int[] progress = calculateTotalProgress();
        goal.showProgress(progress[0], progress[1]); // Show goal progress
    }
}

