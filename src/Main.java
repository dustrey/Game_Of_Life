import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException
    {
        String input_file = "testgrid.txt";
        Grid initial_grid = new Grid();


        //check if file is opened
        try
        {
          initial_grid.readInFile(input_file);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.out.println("Could not open file..... closing program");
            return;
        }
        //call Neighbor and Count

        initial_grid.countNeighbors = new Count();
        initial_grid.neighbors = new Neighbor();
        System.out.println("Initial Grid: ");
        initial_grid.displayGrid();

        //print each gen

        for(int i =0; i < initial_grid.gen_count; i++)
        {
            initial_grid.updateGrid();
            System.out.println("Generation " + (i +1) + ": ");
            initial_grid.displayGrid();
        }
    }
}