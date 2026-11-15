import java.util.*;
















public class problem_statement_experiment_8 {

    public static String reverseSentence(String str) {
        Stack<String> stack = new Stack<String>();
        String[] strArray = str.split(" ");
        String result = "";

        for (int i = 0; i < strArray.length; i++) {
            stack.push(strArray[i]);
        }

        while (!stack.isEmpty()) {
            result += stack.pop() + " ";
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "data structures and algorithms";
        System.out.println(reverseSentence(str));

    }
}