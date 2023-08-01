import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Grid {


    //create a grid
    char[][]cell_grid;
    Count countNeighbors;
    Neighbor neighbors;
    int gen_count;


    public void displayGrid()
    {
        for (int i = 0; i < cell_grid.length; i++)
        {
            for(int j = 0; j < cell_grid[i].length; j++ )
            {
                System.out.print(cell_grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    //update based on Neighbor rules
    public void updateGrid()
    {
        char [][] updated_grid = new char [cell_grid.length][cell_grid[0].length];

        for (int i =0; i < cell_grid.length; i++)
        {
            for(int j = 0; j < cell_grid[i].length; j++)
            {
                int neighborCount = countNeighbors.neighborCount(cell_grid,i,j);
                char nextGen = neighbors.getNextGen(cell_grid[i][j], neighborCount);
                updated_grid[i][j] = nextGen;
            }
        }

        cell_grid = updated_grid;
    }
//read through input file for grid
    public void readInFile(String inputFile) throws IOException
    {
        try(BufferedReader gridScan = new BufferedReader(new FileReader(inputFile)))
        {
            List<String> arrayLines = new ArrayList<>();
            String read_line;
            while((read_line = gridScan.readLine()) != null)
            {
                arrayLines.add(read_line);
            }

            int rows = arrayLines.size() - 1;
            int cols = arrayLines.get(0).length();
            gen_count = Integer.parseInt(arrayLines.get(arrayLines.size() - 1));

            cell_grid = new char[rows][cols];
            for(int i = 0; i < rows; i++)
            {
                for(int j = 0; j < cols; j++)
                {
                    cell_grid[i][j] = arrayLines.get(i).charAt(j);
                }
            }
        }
    }

}
