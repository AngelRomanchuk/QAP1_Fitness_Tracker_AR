package com.keyin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FitnessTracker {
    private List<Workout> workouts;
    private Goal goal;

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

    public void trackProgress() {
        int totalCaloriesBurned = 0;
        int totalWorkoutTime = 0;

        for (Workout workout : workouts) {
            totalCaloriesBurned += workout.getCaloriesBurned();
            totalWorkoutTime += workout.getDurationInMinutes();
        }

        goal.showProgress(totalCaloriesBurned, totalWorkoutTime);
    }
}

