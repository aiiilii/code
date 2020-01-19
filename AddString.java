public class AddString {

    public String addString(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }
        if (num1 == "0" || num2 == "0") {
            return "0";
        }

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0) {
            int d1 = 0;
            int d2 = 0;
            if (i >= 0) {
                d1 = num1.charAt(i) - '0';
            }
            if (j >= 0) {
                d2 = num2.charAt(j) - '0';
            }
            int sum = d1 + d2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            
            i --;
            j --;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}