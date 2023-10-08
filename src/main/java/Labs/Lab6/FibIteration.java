package Labs.Lab6;

public class FibIteration implements FindFib{

    @Override
    public  int calculate_fib(int num) {
    int fib1 = 1;
    int fib2 = 1;
    int fibResult = 1;
        for (int i = 3; i <= num; i++) {
            fibResult = fib1+fib2;
            fib1=fib2;
            fib2 = fibResult;
        }
    return fibResult;
    }
}
