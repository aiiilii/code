public class IntegerToString {

    public static String intToString(int val) {
        if (val == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        boolean isNeg = false;

        if (val < 0) {
            val = -val;
            isNeg = true;
        }

        while(val > 0) {
            int digitVal = val % 10;
            sb.append(digitVal);
            val = val / 10;
        }
        
        if (isNeg) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String temp = intToString(123084849);
        System.out.println(intToString(123084849));
        System.out.println(intToString(-123084849));
        System.out.println(intToString(0));
        System.out.println(intToString(1));
        System.out.println(intToString(-8));
        System.out.println(temp.getClass());
    }
}