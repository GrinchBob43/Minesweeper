public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        String[][] grid = generateGrid(m, n, k);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static String[][] generateGrid(int m, int n, int k)
    {
        String[][] grid = new String[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = "null";  
                 }
            }

        //pick spots for mines
        for (int i = 0; i < k; i++) {
            int mplace = (int)(Math.random() * m);
            int nplace = (int)(Math.random() * n);
            if (grid[mplace][nplace] == "null")
             {
                grid[mplace][nplace] = "*";
             } 
             else {i--;}
             //return grid; //Debug
        //count mines around each cell
        }
        for (int i = 0; i < m; i++) 
        {
          for (int j = 0; j < n; j++) 
           {
            if (grid[i][j].equals("*")) 
            {
                continue; // skip mine cells, learned this from ChatGPT
            }

            int count = 0;

            // Check all 8 possible directions with bounds checking
            // Top row
            if (i > 0 && grid[i-1][j].equals("*")) count++;
            if (i > 0 && j > 0 && grid[i-1][j-1].equals("*")) count++;
            if (i > 0 && j < n-1 && grid[i-1][j+1].equals("*")) count++;

            // Same row
            if (j > 0 && grid[i][j-1].equals("*")) count++;
            if (j < n-1 && grid[i][j+1].equals("*")) count++;

            // Bottom row
            if (i < m-1 && grid[i+1][j].equals("*")) count++;
            if (i < m-1 && j > 0 && grid[i+1][j-1].equals("*")) count++;
            if (i < m-1 && j < n-1 && grid[i+1][j+1].equals("*")) count++;

            // Assign the count as string
            grid[i][j] = String.valueOf(count); //learned how to convert int to string from ChatGPT
           }
        }
        return grid;
  }
}
