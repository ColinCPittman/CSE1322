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
                String f1,f2;
                int counter = 1;
                try{
                        File file1 = new File("src/main/resources/Labs/Lab9/" + file1Name);
                        File file2 = new File("src/main/resources/Labs/Lab9/" + file2Name);
                        Scanner scFile1 = new Scanner(file1);
                        Scanner scFile2 = new Scanner(file2);
                        while(scFile1.hasNext() && scFile2.hasNext()) {
                        f1 = scFile1.nextLine();
                        f2 = scFile2.nextLine();
                        if(!f1.equals(f2)){
                                System.out.println("Line " + counter + "\n< " + f1 + "\n> " + f2);
                        }
                        counter++;
                        }
                        if(scFile1.hasNext() || scFile2.hasNext()) System.out.println("Files have different number of lines");
                } catch (IOException e) {
                        System.out.println(e.getMessage());
                }
        }
}
