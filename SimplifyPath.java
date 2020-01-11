import java.util.Stack;

public class SimplifyPath {

    public static String simplifyPath(String path) {
        if (path == null || path.length() <= 1) {
            return path;
        }
        String[] splitStr = path.split("/");
        Stack<String> stack = new Stack<String>();

        for (String curr : splitStr) {
            if (curr.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!curr.equals(".") && !curr.isEmpty()) {
                stack.push(curr);
            } 
            // the case where curr equals("."), nothing happens because it means current directory
        }

        String res = "";
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            String newPop = stack.pop();
            res = "/" + newPop + res;
        }
        return res;
    }

    public static void main(String[] args) {
        String path = "/home/";
        System.out.println(simplifyPath(path));
    }
}