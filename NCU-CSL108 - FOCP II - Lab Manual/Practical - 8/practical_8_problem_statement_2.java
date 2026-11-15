







public class practical_8_problem_statement_2 {
    public static void main(String[] args) {

        try {
            String argument = "Practical 8 Problem Statement 2";
            throw new Exception(argument);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Final Block");
        }
    }
}