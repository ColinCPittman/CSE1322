package Labs.Lab9;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Lab9 {
    public static void main(String[] args) throws IOException {
        System.out.print("Please enter name for file 1:");
        Scanner sc = new Scanner(System.in);
        String file1Name = sc.nextLine();
        System.out.print("Please enter name for file 2:");
        String file2Name = sc.nextLine();
        try {
            File file1 = new File(file1Name);
            File file2 = new File(file2Name);
            try (Scanner scFile1 = new Scanner(file1); Scanner scFile2 = new Scanner(file2)) {
                compareFiles(scFile1, scFile2);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void compareFiles(Scanner scFile1, Scanner scFile2) {
        int counter = 1;
        String f1;
        String f2;
        while (scFile1.hasNext() && scFile2.hasNext()) {
            f1 = scFile1.nextLine();
            f2 = scFile2.nextLine();
            if (!f1.equals(f2)) {
                System.out.println("Line " + counter +
                        "\n< " + f1 +
                        "\n> " + f2);
            }
            counter++;
        }
        if (scFile1.hasNext() || scFile2.hasNext()){
                System.out.println("Files have different number of lines");
        }
    }
}
