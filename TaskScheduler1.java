package com.linkedlist;

import java.util.Scanner;

public class TaskScheduler1 {

    // Inner static class for Task
    static class Task {
        int id, priority;
        String name, dueDate;
        Task next;

        Task(int id, String name, int priority, String dueDate) {
            this.id = id;
            this.name = name;
            this.priority = priority;
            this.dueDate = dueDate;
        }
    }

    private Task head;
    Scanner sc = new Scanner(System.in);

    // Add task to circular linked list
    void addTask(Task t) {
        if (head == null) {
            head = t;
            t.next = t; // circular link
        } else {
            Task cur = head;
            while (cur.next != head)
                cur = cur.next;
            cur.next = t;
            t.next = head;
        }
        System.out.println("Task added successfully.");
    }

    // Remove task by ID
    void removeTask(int id) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task cur = head, prev = null;
        do {
            if (cur.id == id) {
                if (prev != null) {
                    prev.next = cur.next;
                } else { // removing head
                    Task last = head;
                    while (last.next != head)
                        last = last.next;
                    head = cur.next;
                    last.next = head;
                }
                System.out.println("Task with ID " + id + " removed.");
                return;
            }
            prev = cur;
            cur = cur.next;
        } while (cur != head);

        System.out.println("Task not found with ID " + id);
    }

    // Display all tasks
    void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Task cur = head;
        do {
            System.out.println(
                cur.id + " | " + cur.name + " | Priority: " + cur.priority + " | Due: " + cur.dueDate
            );
            cur = cur.next;
        } while (cur != head);
    }

    // Menu-driven interface
    public void menu() {
        while (true) {
            System.out.println("\n1. Add Task  2. Remove Task  3. Display Tasks  4. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (ch) {
                case 1 -> {
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int priority = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Due Date: ");
                    String dueDate = sc.nextLine();
                    addTask(new Task(id, name, priority, dueDate));
                }
                case 2 -> {
                    System.out.print("Enter Task ID to remove: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    removeTask(id);
                }
                case 3 -> displayTasks();
                case 4 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }

    public static void main(String[] args) {
        new TaskScheduler1().menu();
    }
}