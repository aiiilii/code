public class ImplementStrStr {

    /**
     * Two pointer
     * Time - O((H - N) * N)
     * Space - O(1)
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int N = needle.length();
        int H = haystack.length();

        if (N == 0) {
            return 0;
        }

        int hayPos = 0;

        while (hayPos < H - N + 1) { // length of the hay minus length of needle +1 is for index at 0;
            while (hayPos < H - N + 1 && haystack.charAt(hayPos) != needle.charAt(0)) {
                hayPos ++;
            }

            int currLen = 0;
            int needlePos = 0;
            while (needlePos < N && hayPos < H && haystack.charAt(hayPos) == needle.charAt(needlePos)) {
                hayPos ++;
                needlePos ++;
                currLen ++;
            }

            // if the whole needle string is found,
            // return its start position;
            if (currLen == N) {
                return hayPos - N;
            }

            // otherwize, backtrack and start over by finding the next char that equals to the needle.charAt(0);
            hayPos = hayPos - currLen + 1;
        }
        return -1;
    }
}