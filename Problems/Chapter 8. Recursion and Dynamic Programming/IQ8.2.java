import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException{
        // write your code here

        int [][] A = new int[6][4];


        A[1][3] = -1;
        A[3][2] = -1;
        A[4][0] = -1;
        A[2][1] = -1;

        A[5][3] = 1;


        ArrayList<Point> path = getPath(A, 0, 0);

        for (Point p : path){
            System.out.println("row: " + p.row + " col : " + p.col);
        }




    }
    public static class Point {

        int row;
        int col;

        Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }


    public static ArrayList<Point> getPath(int [][] grid, int row, int col){

        ArrayList<Point> path = new ArrayList<>();

        if (isPath(grid, row, col, path)){
            return path;
        }
        else
            return null;

    }


    public static boolean isPath(int [][] grid, int row, int col, ArrayList<Point> path){



        // Indexes out of bounds
        if (row >= grid.length)
            return false;
        else if (col >= grid[0].length)
            return false;

        // Obstacle
        else if(grid[row][col] == -1)
            return false;

       

        boolean isGoal =  (grid[row][col] == 1);

        if (isGoal || isPath(grid, row + 1, col, path) || isPath(grid, row, col +1, path)){
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;


    }


}