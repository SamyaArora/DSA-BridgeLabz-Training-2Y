package com.recursion;
import java.util.Scanner;
public class WordSearch1 {
	
	    static int ROW, COL;

	    // Directions to move in the grid (8 directions)
	    static int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
	    static int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};

	    // Check if word exists starting at (row, col)
	    public static boolean searchWord(char[][] board, String word, int row, int col, int index) {
	        if (index == word.length()) return true;

	        if (row < 0 || row >= ROW || col < 0 || col >= COL || board[row][col] != word.charAt(index))
	            return false;

	        char temp = board[row][col];
	        board[row][col] = '#'; // mark visited

	        for (int d = 0; d < 8; d++) {
	            int newRow = row + rowDir[d];
	            int newCol = col + colDir[d];

	            if (searchWord(board, word, newRow, newCol, index + 1)) {
	                board[row][col] = temp;
	                return true;
	            }
	        }

	        board[row][col] = temp; // backtrack
	        return false;
	    }

	    // Find if word exists anywhere in the board
	    public static boolean exist(char[][] board, String word) {
	        for (int i = 0; i < ROW; i++)
	            for (int j = 0; j < COL; j++)
	                if (searchWord(board, word, i, j, 0))
	                    return true;
	        return false;
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of rows in board: ");
	        ROW = sc.nextInt();
	        System.out.print("Enter number of columns in board: ");
	        COL = sc.nextInt();

	        char[][] board = new char[ROW][COL];
	        System.out.println("Enter the board letters row-wise (no spaces):");
	        for (int i = 0; i < ROW; i++) {
	            String row = sc.next();
	            board[i] = row.toCharArray();
	        }

	        System.out.print("Enter word to search: ");
	        String word = sc.next();

	        boolean found = exist(board, word);
	        if (found) System.out.println("Word found in board.");
	        else System.out.println("Word NOT found in board.");

	        sc.close();
	    }
	}

