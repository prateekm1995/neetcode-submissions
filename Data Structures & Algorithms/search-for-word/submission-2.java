class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, boolean[][] visited){
        if(word.length() == 0){
            return true;
        }

        if(i==-1 || i== board.length || j==-1 || j == board[0].length) {
            return false;
        }

        if(board[i][j] != word.charAt(0)){
            return false;
        }

        if(visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        boolean ans = dfs(board, word.substring(1), i+1, j, visited) ||
            dfs(board, word.substring(1), i-1, j, visited) ||
            dfs(board, word.substring(1), i, j+1, visited) ||
            dfs(board, word.substring(1), i, j-1, visited);
        visited[i][j] = false;

        return ans;
    }
}