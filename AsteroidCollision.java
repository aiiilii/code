import java.util.LinkedList;

public class AsteroidCollision {

    /**
     * Overall, there are totally 4 scenarios will happen: 1. + +  2. - -  3. + -  4. - +
     * when collision happens: only 3, which is + -;
     * Time - O(n), pushes and pops each asteroid at most once;
     * Space - O(n)
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length <= 1) {
            return asteroids;
        }
        LinkedList<Integer> list = new LinkedList<Integer>(); // use linkedlist to simulate stack;
        for (int ast : asteroids) {
            if (ast > 0) { // previous one does not matter, no collision forever;
                list.add(ast);
            } else { // ast < 0
                while (!list.isEmpty() && list.getLast() > 0 && list.getLast() < -ast) { // while list is not empty, the last in the list > 0, and last < -ast,
                    list.pollLast(); // pop the last out;
                }
                if (!list.isEmpty() && list.getLast() == -ast) { // if list is not empty, the last == -ast,
                    list.pollLast(); // pop it out as both disappears;
                } else if (list.isEmpty() || list.getLast() < 0) { // if list is empty, or last < 0 meaning both last and ast are < 0,
                    list.add(ast); // then add the negative ast into the list;
                }
            }
        }
        return list.stream().mapToInt(ast -> ast).toArray();
    }
}