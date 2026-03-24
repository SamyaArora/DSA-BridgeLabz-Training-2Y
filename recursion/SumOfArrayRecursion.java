package com.recursion;

import java.util.Scanner;

public class SumOfArrayRecursion {

    public static int sum(int arr[], int n) {

        if (n == 0) {
            return 0;
        }

        return arr[n - 1] + sum(arr, n - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = sum(arr, n);

        System.out.println("Sum of array = " + result);

        sc.close();
    }
}