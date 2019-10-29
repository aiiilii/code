import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    /**
     * Pascal's Triangle: numRows = total number of output arrays; first number and last number of each array is 1;
     * the number at [i][j] is equal to the sum of two numbers above it, which can be represented by ([i-1][j-1] + [i-1][j]) 
     * @param numRows
     * @return a list of a list of integers that make up the triangle
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        if (numRows == 1) {
            return triangle;
        }

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currRow = new ArrayList<>();

            currRow.add(1);

            for (int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            currRow.add(1);
            triangle.add(currRow);
        }
        return triangle;
    }
}