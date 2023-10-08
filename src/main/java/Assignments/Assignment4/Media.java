package Assignments.Assignment4;

public abstract class Media {
    private String fileName;
    private int id;
    private static int nextID=0;

    public String getFileName() {
        return fileName;
    }

    public int getId() {
        return id;
    }

    public Media() {
        this.id= nextID++;
    }

    public Media(String fileName) {
        this.fileName = fileName;
        this.id = nextID++;
    }
}
