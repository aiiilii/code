public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum = sum + (a.charAt(i) - '0'); // changing the string into number and add it to the sum
                i--;
            }
            if (j >= 0) {
                sum = sum + (b.charAt(j) - '0');
                j--;
            }
            sb.append(sum % 2); // 1 % 2 == 1; 2 % 2 == 0; 0 % 2 == 0
            carry = sum / 2; // int 1 / 2 == 0; 2 / 2 == 1; 0 / 2 == 0
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}