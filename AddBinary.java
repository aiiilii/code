public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1; // starting from the right most index, which represent the 1th digit
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry; // after the previous loop, the next loop(next digit addition) need to also add the carry to the sum
            if (i >= 0) {
                sum = sum + (a.charAt(i) - '0'); // changing the string into number(using ASCII, every char is represented by a number) and add it to the sum
                i--;
            }
            if (j >= 0) {
                sum = sum + (b.charAt(j) - '0');
                j--;
            }
            sb.append(sum % 2); // 1 % 2 == 1; 2 % 2 == 0; 0 % 2 == 0 // getting the 1th digit
            carry = sum / 2; // int 1 / 2 == 0; 2 / 2 == 1; 0 / 2 == 0 // deleting the 1th digit, which in this case is getting the 10th digit
        }
        if (carry != 0) {
            sb.append(carry); // if there is still a carry after the while loop, meaning need one more space to created this extra digit, so append after the loop
        }
        return sb.reverse().toString(); // appending from left to right, so need to reverse
    }
}