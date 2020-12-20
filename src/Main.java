public class Main {

    public static void main(String[] args) {

        String lispCode = "(defun fibonacci (N)\r\n" +
                "  \"Compute the N'th Fibonacci number.\"\r\n" +
                "  (if (or (zerop N) (= N 1))\r\n" +
                "      1\r\n" +
                "    (let\r\n" +
                "	((F1 (fibonacci (- N 1)))\r\n" +
                "	 (F2 (fibonacci (- N 2))))\r\n" +
                "      (+ F1 F2))))";


        LispValidator lv = new LispValidator();
        lv.validateLispCode(lispCode);

    }
}
