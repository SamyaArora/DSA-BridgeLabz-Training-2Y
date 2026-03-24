package com.linkedlist;

import java.util.Scanner;

class Item {
    int id;
    String name;
    int quantity;
    double price;
    Item next;

    public Item(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagement {
    private Item head;

    // Add at end
    public void addItem(Item item) {
        if (head == null) {
            head = item;
            return;
        }
        Item temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = item;
    }

    // Remove by ID
    public void removeItem(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            System.out.println("Removed item " + id);
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) temp = temp.next;
        if (temp.next == null) System.out.println("Item not found.");
        else {
            temp.next = temp.next.next;
            System.out.println("Removed item " + id);
        }
    }

    // Update quantity
    public void updateQuantity(int id, int qty) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = qty;
                System.out.println("Updated quantity for " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search
    public void searchByID(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                System.out.println(temp.id + " | " + temp.name + " | " + temp.quantity + " | " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchByName(String name) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println(temp.id + " | " + temp.name + " | " + temp.quantity + " | " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found.");
    }

    // Display all
    public void display() {
        if (head == null) { System.out.println("No items."); return; }
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.id + " | " + temp.name + " | " + temp.quantity + " | " + temp.price);
            temp = temp.next;
        }
    }

    // Total value
    public void totalValue() {
        double sum = 0;
        Item temp = head;
        while (temp != null) {
            sum += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total inventory value: " + sum);
    }

    // Main
    public static void main(String[] args) {
        InventoryManagement im = new InventoryManagement();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add 2.Remove 3.Update 4.Search ID 5.Search Name 6.Display 7.Total Value 8.Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Quantity: "); int qty = sc.nextInt();
                    System.out.print("Price: "); double price = sc.nextDouble(); sc.nextLine();
                    im.addItem(new Item(id, name, qty, price));
                }
                case 2 -> {
                    System.out.print("Enter ID to remove: "); int id = sc.nextInt();
                    im.removeItem(id);
                }
                case 3 -> {
                    System.out.print("Enter ID to update quantity: "); int id = sc.nextInt();
                    System.out.print("New quantity: "); int qty = sc.nextInt();
                    im.updateQuantity(id, qty);
                }
                case 4 -> {
                    System.out.print("Enter ID to search: "); int id = sc.nextInt();
                    im.searchByID(id);
                }
                case 5 -> {
                    System.out.print("Enter Name to search: "); String name = sc.nextLine();
                    im.searchByName(name);
                }
                case 6 -> im.display();
                case 7 -> im.totalValue();
                case 8 -> { sc.close(); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}