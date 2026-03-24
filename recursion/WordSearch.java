package com.recursion;

import java.util.Scanner;

public class WordSearch {

    static int[] rowDir = {-1,-1,-1,0,0,1,1,1};
    static int[] colDir = {-1,0,1,-1,1,-1,0,1};

    public static boolean dfs(char[][] grid, String word,
                              int row, int col, int index) {

        if (index == word.length()) return true;

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
                || grid[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = grid[row][col];
        grid[row][col] = '*';

        for (int d = 0; d < 8; d++) {
            if (dfs(grid, word, row + rowDir[d], col + colDir[d], index + 1)) {
                return true;
            }
        }

        grid[row][col] = temp;
        return false;
    }

    public static boolean search(char[][] grid, String word) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (dfs(grid, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] grid = {
            {'C','A','T','S'},
            {'O','R','E','A'},
            {'D','E','A','M'},
            {'E','L','L','S'}
        };

        System.out.print("Enter word to search: ");
        String word = sc.nextLine();

        if (search(grid, word)) {
            System.out.println("Word Found");
        } else {
            System.out.println("Word Not Found");
        }

        sc.close();
    }
}