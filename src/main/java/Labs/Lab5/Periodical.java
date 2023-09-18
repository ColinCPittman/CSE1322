package Labs.Lab5;

public class Periodical extends Item{
    private int issueNum;

    public Periodical() {
        super();
        issueNum = -1;
    }

    public Periodical(String title, int issueNum) {
        super(title);
        this.issueNum = issueNum;
    }
    public String getListing() {
        return "Pediodical Title - " + getTitle() +
                "\nIssue # - " + getIssueNum();
    }
    public int getIssueNum() {
        return issueNum;
    }

    public void setIssueNum(int issueNum) {
        this.issueNum = issueNum;
    }
}
