public class ShortestWordDistance {

    public int shortestDistace(String[] words, String word1, String word2) {
        int minDist = Integer.MAX_VALUE;
        int pos1 = -1;
        int pos2 = -1;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                pos1 = i;
            }
            if (words[i].equals(word2)) {
                pos2 = i;
            }
            if (pos1 != -1 && pos2 != -1) {
                minDist = Math.min(minDist, Math.abs(pos1 - pos2));
            }
        }
        return minDist;
    }
}