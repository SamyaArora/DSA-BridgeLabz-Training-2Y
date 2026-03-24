package com.linkedlist;

import java.util.Scanner;

class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    public Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskScheduler {
    private Task head;

    // Add task at end
    public void addTask(Task t) {
        if (head == null) {
            head = t;
            t.next = head;
            return;
        }
        Task temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = t;
        t.next = head;
    }

    // Remove task by ID
    public void removeTask(int id) {
        if (head == null) return;

        Task curr = head, prev = null;
        do {
            if (curr.id == id) {
                if (prev != null) prev.next = curr.next;
                else { // removing head
                    Task last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                }
                System.out.println("Removed task " + id);
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Task not found.");
    }

    // Display all tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks.");
            return;
        }
        Task temp = head;
        do {
            System.out.println(temp.id + " | " + temp.name + " | Priority: " + temp.priority + " | Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    public void searchByPriority(int priority) {
        if (head == null) { System.out.println("No tasks."); return; }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println(temp.id + " | " + temp.name + " | Priority: " + temp.priority + " | Due: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tasks with priority " + priority);
    }

    // Main
    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add Task 2.Remove Task 3.Display Tasks 4.Search Priority 5.Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Task ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Task Name: "); String name = sc.nextLine();
                    System.out.print("Priority: "); int p = sc.nextInt(); sc.nextLine();
                    System.out.print("Due Date: "); String d = sc.nextLine();
                    ts.addTask(new Task(id, name, p, d));
                }
                case 2 -> {
                    System.out.print("Enter Task ID to remove: "); int id = sc.nextInt();
                    ts.removeTask(id);
                }
                case 3 -> ts.displayTasks();
                case 4 -> {
                    System.out.print("Enter priority to search: "); int p = sc.nextInt();
                    ts.searchByPriority(p);
                }
                case 5 -> { sc.close(); return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}