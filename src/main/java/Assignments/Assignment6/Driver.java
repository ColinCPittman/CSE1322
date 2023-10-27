package Assignments.Assignment6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Driver{
    public static void main(String[] args) throws IOException,StateComplaintException{
        System.out.print("Please enter the file name: ");
        Scanner sc = new Scanner(System.in);
        String[] complaintDetails = null;
        Complaint complaint = null;
        String line = "";
        String fileName = sc.nextLine();
        Scanner scComplaints = null;
        PrintWriter pwAccepted = null;
        PrintWriter pwRemanded = null;
        int acceptedCounter = 0;
        int remandedCounter = 0;

        try {
        scComplaints = new Scanner(new File(fileName));
        pwAccepted = new PrintWriter("accepted.txt");
        pwRemanded = new PrintWriter("remanded.txt");

        }catch(IOException e) {
            System.out.println("No file with name \"" + fileName + "\" in " + System.getProperty("user.dir"));
            if(scComplaints != null) scComplaints.close();
            if(pwRemanded != null) pwRemanded.close();
            if(pwAccepted != null) pwAccepted.close();
        }
        if(scComplaints != null && pwRemanded != null && pwAccepted != null) {
            while(scComplaints.hasNextLine()){
                line = scComplaints.nextLine();
                complaintDetails = line.split(",",5);
                complaint = new Complaint(complaintDetails[0],Integer.parseInt(complaintDetails[1]),complaintDetails[2],complaintDetails[3],complaintDetails[4]);
                try {
                    processComplaint(complaint);
                    pwAccepted.println(complaint + "\n==============================");
                    acceptedCounter++;
                }catch(StateComplaintException e) {
                    pwRemanded.println(complaint + "\n\nReason for remand: " + e.getMessage() + "\n==============================");
                    remandedCounter++;
                }
            }
        }

        if(acceptedCounter == 0 && remandedCounter == 0) {
            System.out.println("Shutting down...");
        } else {
            System.out.println("Number of remanded cases: " + remandedCounter + "\n" +
                    "Number of accepted cases: " + acceptedCounter + "\n" +
                    "Shutting down...");
        }
        if(scComplaints != null) scComplaints.close();
        if(pwRemanded != null) pwRemanded.close();
        if(pwAccepted != null) pwAccepted.close();
    }
    private static List<String> validCauses = Arrays.asList("Equal Protection Challenge", "Title IX Workplace Discrimination", "Prisoner Civil Rights Claim", "Fair Labor Standard Act Claim");
    private static void processComplaint(Complaint c) throws StateComplaintException{
        if(validCauses.contains(c.getCauseOfAction())) return;
        if(!c.getDefendantCitizenship().equals(c.getPlaintiffCitizenship())) throw new StateComplaintException("Lack of diversity");
        if(c.getAmountInControversy() <= 75000.00d) throw new StateComplaintException("Amount in controversy less than or equal to $75000");
        if(c.getOriginalStateOfFiling().equals(c.getPlaintiffCitizenship())) throw new StateComplaintException("No prejudice through diversity");
    }
}
