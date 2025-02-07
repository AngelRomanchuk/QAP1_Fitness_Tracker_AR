package com.keyin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FitnessTrackerTest {

    private Goal goal;
    private Workout workout1;
    private Workout workout2;
    private FitnessTracker fitnessTracker;

    @BeforeEach
    void setUp() {
        // Initialize real objects
        goal = new Goal(1000, 150);  // Goal: 1000 calories and 150 minutes
        workout1 = new Workout("Running", 30, 400);  // 30 minutes, 400 calories
        workout2 = new Workout("Cycling", 40, 300); // 40 minutes, 300 calories

        // Creating the fitness tracker with a real Goal object
        fitnessTracker = new FitnessTracker(goal);
    }

    @Test
    void testAddWorkout() {
        System.out.println("\nTest Add Workout");

        // Add workout1
        fitnessTracker.addWorkout(workout1);

        // Verify the workout was added and progress calculated correctly
        assertEquals(2, fitnessTracker.calculateTotalProgress().length);  // Length should be 2, for calories and minutes
        assertEquals(400, fitnessTracker.calculateTotalProgress()[0]);    // Calories check
        assertEquals(30, fitnessTracker.calculateTotalProgress()[1]);     // Minutes check
    }

    @Test
    void testCalculateTotalProgress() {
        System.out.println("\nTest Calculated Total Progress");

        // Add both workouts
        fitnessTracker.addWorkout(workout1);
        fitnessTracker.addWorkout(workout2);

        // Calculate total progress
        int[] progress = fitnessTracker.calculateTotalProgress();

        System.out.println("Total Calories: " + progress[0]);
        System.out.println("Total Minutes: " + progress[1]);

        // Verify total progress
        assertEquals(700, progress[0]); // Total Calories (400 + 300)
        assertEquals(70, progress[1]);  // Total Minutes (30 + 40)
    }
}
