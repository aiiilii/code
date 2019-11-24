import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllNumbersDisappearedInArray {

    public List<Integer> findAllNumbersDisappearedInArray(int [] nums) {
        List<Integer> result = new ArrayList<Integer>();
        HashSet<Integer> numbers = new HashSet<Integer>();
        for (int i : nums) {
            numbers.add(i);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!numbers.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}