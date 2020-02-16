import java.util.LinkedList;

public class AsteroidCollision {

    /**
     * Time - O(n), pushes and pops each asteroid at most once;
     * Space - O(n)
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int ast : asteroids) {
            if (ast > 0) {
                list.add(ast);
            } else {
                while (!list.isEmpty() && list.getLast() > 0 && list.getLast() < -ast) {
                    list.pollLast();
                }
                if (!list.isEmpty() && list.getLast() == -ast) {
                    list.pollLast();
                } else if (list.isEmpty() || list.getLast() < 0) {
                    list.add(ast);
                }
            }
        }
        return list.stream().mapToInt(ast -> ast).toArray();
    }
}