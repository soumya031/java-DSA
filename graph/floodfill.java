package graph;

// Flood Fill / Grid BFS-DFS Problem Suite in Java

import java.util.*;

public class floodfill{

    // ---------- 1. Number of Islands ----------
    public static int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfsIsland(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfsIsland(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ||
            grid[i][j] == '0' || visited[i][j]) return;

        visited[i][j] = true;
        dfsIsland(grid, visited, i + 1, j);
        dfsIsland(grid, visited, i - 1, j);
        dfsIsland(grid, visited, i, j + 1);
        dfsIsland(grid, visited, i, j - 1);
    }

    // ---------- 2. Max Area of Island ----------
    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfsArea(grid, i, j));
                }
            }
        }
        return max;
    }

    private static int dfsArea(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        return 1 + dfsArea(grid, i + 1, j) + dfsArea(grid, i - 1, j) + dfsArea(grid, i, j + 1) + dfsArea(grid, i, j - 1);
    }

    // ---------- 3. Rotting Oranges ----------
    public static int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0, time = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] d : dirs) {
                    int ni = cell[0] + d[0], nj = cell[1] + d[1];
                    if (ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] == 1) {
                        grid[ni][nj] = 2;
                        queue.offer(new int[]{ni, nj});
                        fresh--;
                    }
                }
            }
        }

        return fresh == 0 ? time : -1;
    }

    // ---------- 4. Word Search ----------
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfsWord(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private static boolean dfsWord(char[][] board, String word, int idx, int i, int j) {
        if (idx == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx)) return false;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfsWord(board, word, idx + 1, i + 1, j) ||
                        dfsWord(board, word, idx + 1, i - 1, j) ||
                        dfsWord(board, word, idx + 1, i, j + 1) ||
                        dfsWord(board, word, idx + 1, i, j - 1);

        board[i][j] = temp;
        return found;
    }

    // ---------- Main Method for Testing ----------
    public static void main(String[] args) {
        // 1. Number of Islands
        char[][] islandGrid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of Islands: " + numIslands(islandGrid));

        // 2. Max Area of Island
        int[][] areaGrid = {
            {0, 0, 1, 0, 0, 0, 1, 1},
            {0, 1, 1, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 1, 1, 1},
        };
        System.out.println("Max Area of Island: " + maxAreaOfIsland(areaGrid));

        // 3. Rotting Oranges
        int[][] orangeGrid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        System.out.println("Minutes to Rot All Oranges: " + orangesRotting(orangeGrid));

        // 4. Word Search
        char[][] wordGrid = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println("Word Search 'ABCCED' Exists: " + exist(wordGrid, word));
    }
}

