import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        final Map<Integer, String> onesMap = new HashMap<Integer, String>();
        onesMap.put(1, "One");
        onesMap.put(2, "Two");
        onesMap.put(3, "Three");
        onesMap.put(4, "Four");
        onesMap.put(5, "Five");
        onesMap.put(6, "Six");
        onesMap.put(7, "Seven");
        onesMap.put(8, "Eight");
        onesMap.put(9, "Nine");

        final Map<Integer, String> teensMap= new HashMap<Integer, String>();
        teensMap.put(10, "Ten");
        teensMap.put(11, "Eleven");
        teensMap.put(12, "Twelve");
        teensMap.put(13, "Thirteen");
        teensMap.put(14, "Fourteen");
        teensMap.put(15, "Fifteen");
        teensMap.put(16, "Sixteen");
        teensMap.put(17, "Seventeen");
        teensMap.put(18, "Eighteen");
        teensMap.put(19, "Nineteen");

        final Map<Integer, String> tensMap = new HashMap<Integer, String>();
        tensMap.put(2, "Twenty");
        tensMap.put(3, "Thirty");
        tensMap.put(4, "Forty");
        tensMap.put(5, "Fifty");
        tensMap.put(6, "Sixty");
        tensMap.put(7, "Seventy");
        tensMap.put(8, "Eighty");
        tensMap.put(9, "Ninety");

        final String thousand = "Thousand";
        final String million = "Million";
        final String billion = "Billion";

        StringBuilder sb = new StringBuilder();

        if (num / 1000000000 > 0) {
            sb.append(onesMap.get(num / 1000000000)).append(" ").append(billion);
            if (num % 1000000000 > 0) {
                sb.append(" ");
            }
            num = num % 1000000000;
        }

        if (num / 1000000 > 0) {
            sb.append(parseThree(num / 1000000, teensMap, onesMap, tensMap)).append(" ").append(million);
            if (num % 1000000 > 0) {
                sb.append(" ");
            }
            num = num % 1000000;
        }

        if (num / 1000 > 0) {
            sb.append(parseThree(num / 1000, teensMap, onesMap, tensMap)).append(" ").append(thousand);
            if (num % 1000 > 0) {
                sb.append(" ");
            }
            num = num % 1000;
        }

        String str = parseThree(num, teensMap, onesMap, tensMap);
        sb.append(str);
        return sb.toString();
    }

    private String parseThree(int i, Map<Integer, String> teensMap, Map<Integer, String> onesMap, Map<Integer, String> tensMap) {
        StringBuilder sb = new StringBuilder();

        if (i >= 100) {
            sb.append(onesMap.get(i / 100)).append(" ").append("Hundred");
            if (i % 100 > 0) {
                return sb.append(" ").append(parseTwo(i % 100, teensMap, onesMap, tensMap)).toString();
            }
        }
        if (i % 100 > 0) {
            return sb.append(parseTwo(i % 100, teensMap, onesMap, tensMap)).toString();
        }
        return sb.toString();
    }

    private String parseTwo(int i, Map<Integer, String> teensMap, Map<Integer, String> onesMap, Map<Integer, String> tensMap) {
        StringBuilder sb = new StringBuilder();

        if (i < 10) {
            return sb.append(onesMap.get(i)).toString();
        }
        if (i <= 19) {
            return sb.append(teensMap.get(i)).toString();
        }
        sb.append(tensMap.get(i / 10));

        if (i % 10 > 0) {
            sb.append(" ").append(onesMap.get(i % 10));
        }
        return sb.toString();
    }
}