import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {

    /**
     * Time - O(n log n), used sorting
     * Space - O(n), n is the length of the deck
     * @param deck
     * @return
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for (int i = 0; i < N; i++) {
            queue.offer(i);
        }

        int[] res = new int[N];
        Arrays.sort(deck);

        for (int card : deck) {
            res[queue.poll()] = card;
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }
        
        return res;
    }
}