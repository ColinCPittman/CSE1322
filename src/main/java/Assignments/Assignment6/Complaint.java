package Assignments.Assignment6;

public class Complaint {
    private String causeOfAction;
    private String plaintiffCitizenship;
    private String defendantCitizenship;
    private String originalStateOfFiling;
    private double amountInControversy;
    private int id;
    private static int nextID = 1;

    public Complaint(String causeOfAction,
                     double amountInControversy,
                     String plaintiffCitizenship,
                     String defendantCitizenship,
                     String originalStateOfFiling) {

        this.causeOfAction = causeOfAction;
        this.plaintiffCitizenship = plaintiffCitizenship;
        this.defendantCitizenship = defendantCitizenship;
        this.originalStateOfFiling = originalStateOfFiling;
        this.amountInControversy = amountInControversy;
        this.id = nextID++;
    }

    public String getCauseOfAction() {
        return causeOfAction;
    }

    public String getPlaintiffCitizenship() {
        return plaintiffCitizenship;
    }

    public String getDefendantCitizenship() {
        return defendantCitizenship;
    }

    public String getOriginalStateOfFiling() {
        return originalStateOfFiling;
    }

    public double getAmountInControversy() {
        return amountInControversy;
    }

    public int getId() {
        return id;
    }
    public String toString() {
        return "Case ID: " + getId() + "\n" +
                "Cause of action: "+ getCauseOfAction() +"\n" +
                "Amount in Controversy: $" + getAmountInControversy() + "\n" +
                "Plaintiff’s Citizenship: " + getPlaintiffCitizenship() + "\n" +
                "Defendant’s Citizenship: " + getDefendantCitizenship() + "\n" +
                "Originally filled in: " + getOriginalStateOfFiling();
    }
}
