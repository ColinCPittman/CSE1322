package Labs.Lab6;

public class Driver {
    public static void main(String[] args) {
        FibFormula goofy = new FibFormula();
        FibIteration goober = new FibIteration();
        System.out.println(goofy.calculate_fib(5));
        System.out.println(goober.calculate_fib(5));
    }
}
