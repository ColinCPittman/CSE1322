package Labs.Lab6;

public class FibIteration implements FindFib{

    @Override
    public  int calculate_fib(int num) {
        if(num <= 2) return 1;
        return(calculate_fib(num -1) + calculate_fib(num - 2));
    }
}
