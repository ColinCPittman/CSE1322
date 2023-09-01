package Labs.Lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    ArrayList<Question> questions = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void add_question() {
        questions.add(initializeQuestionFromUser());
    }

    public void remove_question() {
        System.out.println("Choose the question to remove:");
        print_questions();
        int removeChoice = scanner.nextInt();
        scanner.nextLine();
        questions.remove(removeChoice - 1);
    }

    public void modify_question() {
        System.out.println("Choose question to modify:");
        print_questions();
        int modifyChoice = scanner.nextInt();
        scanner.nextLine();
        questions.set(modifyChoice - 1, initializeQuestionFromUser());
    }

    public void give_quiz() {
        int correctCount = 0;
        int questionCount = 0;
        for (Question question :
                questions) {
            System.out.println(question.getQuestion());
            if (scanner.nextLine().equalsIgnoreCase(question.getAnswer())) {
                System.out.println("Correct");
                correctCount++;
                questionCount++;
                continue;
            }
            System.out.println("Incorrect");
            questionCount++;
        }
        System.out.println("You got " + correctCount + " out of " + questionCount + ".");
    }

    private void print_questions() {
        for (int i = 0; i < questions.size(); i++) {
            System.out.println((i + 1) + ". " + questions.get(i).getQuestion());
        }
    }

    private Question initializeQuestionFromUser() {
        System.out.println("What is the question text?");
        String question = scanner.nextLine();
        System.out.println("What is the answer?");
        String answer = scanner.nextLine();
        System.out.println("How difficult (1-3)?");
        int difficulty = scanner.nextInt();
        scanner.nextLine();
        return new Question(question, answer, difficulty);
    }
}