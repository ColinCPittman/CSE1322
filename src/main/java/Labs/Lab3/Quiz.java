package Labs.Lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    ArrayList<Question> questions = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void add_question(){
        System.out.println("What is the question text?");
        String question = scanner.nextLine();
        System.out.println("What is the answer?");
        String answer = scanner.nextLine();
        System.out.println("How difficult (1-3)?");
        int difficulty = scanner.nextInt();
    }
}