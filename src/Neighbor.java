public class Neighbor
{
    public char getNextGen(char currentCell, int neighborCount)
    {
        if(currentCell == 'X' && neighborCount < 2)
        {
            return '.';
        }
        else if(currentCell == 'X' && (neighborCount == 2 || neighborCount == 3))
        {
            return 'X';
        }
        else if(currentCell == 'X' && neighborCount > 3)
        {
            return '.';
        }
        else if(currentCell == '.' && neighborCount == 3)
        {
            return 'X';
        }
        else
            return '.';
    }
}
