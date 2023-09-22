package Labs.Lab6;

public class FibFormula implements FindFib{
    @Override
    public int calculate_fib(int num) {
        return (int) ((Math.pow(((1+Math.sqrt(5.0d))/2),num) - Math.pow(((1-Math.sqrt(5.0d))/2),num))/ Math.sqrt(5.0d));
    }
}
