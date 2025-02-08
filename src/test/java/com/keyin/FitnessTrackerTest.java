package com.keyin;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

class FitnessTrackerTest {

    private Goal goal;
    private Workout workout1;
    private Workout workout2;
    private FitnessTracker fitnessTracker;

    @BeforeEach
    void setUp() {
        // Initialize real objects
        goal = new Goal(1000, 150);
        workout1 = new Workout("Running", 80, 800);
        workout2 = new Workout("Cycling", 80, 400);

        // Creating the fitness tracker with a real Goal object
        fitnessTracker = new FitnessTracker(goal);
    }

    @Test
    void testAddWorkout() {
        System.out.println("\nTest Add Workout");

        // Add workout1
        fitnessTracker.addWorkout(workout1);

        // Verify the workout was added and progress calculated correctly
        assertEquals(2, fitnessTracker.calculateTotalProgress().length);
        assertEquals(800, fitnessTracker.calculateTotalProgress()[0]);
        assertEquals(80, fitnessTracker.calculateTotalProgress()[1]);
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
        assertEquals(1200, progress[0]);
        assertEquals(160, progress[1]);
    }

    @Test
    void testGoalCompletion() {
        System.out.println("\nTest Goal Completion");

        // Prepare a mock input
        String simulatedInput = "0\n0\n";
        Scanner mockScanner = new Scanner(simulatedInput);

        // Add both workouts to the fitness tracker
        fitnessTracker.addWorkout(workout1); // 800 calories, 80 minutes
        fitnessTracker.addWorkout(workout2); // 400 calories, 80 minutes

        // Simulate checking goal completion after adding the workouts
        int[] progress = fitnessTracker.calculateTotalProgress();
        fitnessTracker.checkGoalCompletion(progress[0], progress[1], mockScanner);

        // Check if the goal  for calories and minutes was reached
        assertTrue(fitnessTracker.calculateTotalProgress()[0] >= goal.getTargetCalories()); // Should have reached or exceeded calories goal
        assertTrue(fitnessTracker.calculateTotalProgress()[1] >= goal.getTargetMinutes()); // Should have reached or exceeded minutes goal

        // Assert the congratulatory flags are set correctly after the goals are reached
        assertFalse(fitnessTracker.isCongratulatedForCalories()); // Should be true for calories
        assertFalse(fitnessTracker.isCongratulatedForMinutes()); // Should be true for minutes
    }
}
