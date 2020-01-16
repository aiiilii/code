import java.util.Arrays;
import java.util.Comparator;;

public class ReorderDataInLogFiles {

    /**
     * Time - O(A log A); A is the total content of logs
     * Space - O(A)
     * 
     * Guaranteed 4:
     * 1. guaranteed to have a word following an identifier (allows me to use indexOf ' ' freely).
     * 2. letter logs need to be ordered lexicographically, so we can use built in compare function when we know we have two.
     * 3. number logs need to be sorted naturally, so we just say they're all "equal" to eachother and trust java's built in sort feature to be stable.
     * 4. number logs need to be after letter logs, so once we find out they're different, we return one of the other and short-circuit.
     * @param logs
     * @return
     */
    public String[] reorderLogFiles2(String[] logs) {
        Arrays.sort(logs, new SortArray());
        return logs;
    }

    public class SortArray implements Comparator<String> {
        public int compare(String s1, String s2) {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                // both letter-logs.
                int comp = split1[1].compareTo(split2[1]); // will return -1, 0, 1;
                if (comp == 0) { // if comp == 0, means they equal, then compare identifiers
                    return split1[0].compareTo(split2[0]);
                } else {
                    return comp; // if they don't equal, then return comp;
                }
            } else if (isDigit1 && isDigit2) {
                // both digit-logs. So keep them in orignal order
                return 0;
            } else if (isDigit1 && !isDigit2) {
                // first is digit, second is letter. Bring letter forward
                return 1;
            } else {
                // first is letter, second is digit. Keep them in this order
                return -1;
            }
        }
    }
        
    


    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2); // when reach the first " ", split into two strings
            String[] split2 = s2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                // both letter-logs.
                int comp = split1[1].compareTo(split2[1]); 
                if (comp == 0) { 
                    return split1[0].compareTo(split2[0]);
                } else {
                    return comp; 
                }
            } else if (isDigit1 && isDigit2) {
                // both digit-logs. So keep them in orignal order
                return 0;
            } else if (isDigit1 && !isDigit2) {
                // first is digit, second is letter. Bring letter forward
                return 1;
            } else {
                // first is letter, second is digit. Keep them in this order
                return -1;
            }
        });
        return logs;
    }
}