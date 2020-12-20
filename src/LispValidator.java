import java.util.*;

public class LispValidator {

    public boolean validateLispCode(String code) {

        // using ArrayDeque is faster than using Stack
        Deque<Character> parenthesesStack = new ArrayDeque<Character>();

        for (int i = 0; i < code.length(); i++) {
            char x = code.charAt(i);

            // support multiple Lisp variants, such as Clojure
            if (x == '(' || x == '[' || x == '{') {
                parenthesesStack.push(x);
                continue;
            }

            if (parenthesesStack.isEmpty())
                return false;

            char check;
            switch (x) {
                case ')':
                    check = parenthesesStack.pop();

                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = parenthesesStack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = parenthesesStack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        // check for stray parentheses
        if (parenthesesStack.isEmpty()) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }
}

