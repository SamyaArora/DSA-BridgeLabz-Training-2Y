package com.recursion;

import java.util.Scanner;

public class NQueens {

    static int N;

    public static boolean isSafe(int[][] board, int row, int col) {
        // Check left side of row
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1) return false;

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;

        // Check lower diagonal on left side
        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1) return false;

        return true;
    }

    public static boolean solveNQueens(int[][] board, int col) {
        if (col >= N) return true; // all queens placed

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQueens(board, col + 1)) return true;

                board[i][col] = 0; // backtrack
            }
        }
        return false;
    }

    public static void printBoard(int[][] board) {
        System.out.println("N-Queens solution:");
        for (int[] row : board) {
            for (int val : row) System.out.print((val == 1 ? "Q " : ". "));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of N for N-Queens: ");
        N = sc.nextInt();

        int[][] board = new int[N][N];

        if (solveNQueens(board, 0))
            printBoard(board);
        else
            System.out.println("No solution exists for N = " + N);

        sc.close();
    }
}