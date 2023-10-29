package Labs.Lab10;

import javax.swing.plaf.TableHeaderUI;
import java.util.Random;

public class Baby implements Runnable{
    int time;

    public Baby(String name) {
        Random random = new Random();
        this.name = name;
        this.time = random.nextInt(5000);
    }

    String name;
    @Override
    public void run() {
        try {
            System.out.println("My name is " + name + " and I am going to sleep for " + time + "ms");
            Thread.sleep(time);
            System.out.println("My name is " + name + " and I'm awake, feed me!!!");
        } catch (InterruptedException e) {
            System.out.println(name + "'s sleep was interrupted.");
        }
    }
}
class Main {
    public static void main(String[] args) {
        Thread b1 = new Thread(new Baby("Noah"));
        Thread b2 = new Thread(new Baby("Olivia"));
        Thread b3 = new Thread(new Baby("Liam"));
        Thread b4 = new Thread(new Baby("Emma"));
        Thread b5 = new Thread(new Baby("Amelia"));
        b1.start();
        b2.start();
        b3.start();
        b4.start();
        b5.start();
    }
}