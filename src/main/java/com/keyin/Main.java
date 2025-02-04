package com.keyin;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define the user's fitness goal (e.g., burn 1000 calories and exercise for 200 minutes)
        Goal userGoal = new Goal(100, 20);
        FitnessTracker fitnessTracker = new FitnessTracker(userGoal);

        boolean running = true;

        while (running) {
            int[] progress = fitnessTracker.calculateTotalProgress();
            int totalCaloriesBurned = progress[0];
            int totalWorkoutTime = progress[1];

            // Check if the goal is reached and display the message if it is
            fitnessTracker.checkGoalCompletion(totalCaloriesBurned, totalWorkoutTime);

            System.out.println("\n\n--- Fitness Tracker ---");
            System.out.println("1. Add a Workout");
            System.out.println("2. View Workouts");
            System.out.println("3. Track Progress");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a workout
                    System.out.print("Enter workout type (e.g., Running, Cycling): ");
                    String type = scanner.next();

                    System.out.print("Enter duration in minutes: ");
                    int duration = scanner.nextInt();

                    System.out.print("Enter calories burned: ");
                    int calories = scanner.nextInt();

                    Workout newWorkout = new Workout(type, duration, calories);
                    fitnessTracker.addWorkout(newWorkout);
                    break;

                case 2:
                    // View all workouts
                    fitnessTracker.showWorkouts();
                    break;

                case 3:
                    // Track progress towards goal
                    fitnessTracker.trackProgress();
                    break;

                case 4:
                    // Exit
                    running = false;
                    System.out.println("Exiting Fitness Tracker...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }
}
