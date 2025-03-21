import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    private static ArrayList<String> tasks = new ArrayList<>();

    private static void displayMenu() {
        System.out.println("\nTo-Do List Application");
        System.out.println("1. Add a Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Remove a Task");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask(Scanner sc) {
        System.out.print("Enter the task to add: ");
        String task = sc.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nYour To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void removeTask(Scanner sc) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove.");
        } else {
            viewTasks();
            System.out.print("Enter the task number to remove: ");
            int taskNumber;
            try {
                taskNumber = Integer.parseInt(sc.nextLine());
                if (taskNumber > 0 && taskNumber <= tasks.size()) {
                    tasks.remove(taskNumber - 1);
                    System.out.println("Task removed successfully.");
                } else {
                    System.out.println("Invalid task number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addTask(sc);
                    break;
                case "2":
                    viewTasks();
                    break;
                case "3":
                    removeTask(sc);
                    break;
                case "4":
                    exit = true;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}

