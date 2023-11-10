package Labs.Lab11;

public class BlueRayCollection {
    class Node {
        BlueRayDisk disk;
        Node nextNode;

        public Node(BlueRayDisk disk, Node nextNode) {
            this.disk = disk;
            this.nextNode = nextNode;
        }

        public Node() {
        }

        public Node(BlueRayDisk disk) {
            this.disk = disk;
            nextNode = null;
        }
    }

    private Node head;

    public BlueRayCollection() {
        head = null;
    }

    public void add(String title, String director, int releaseYear, double cost) {
        if (head == null) head = new Node(new BlueRayDisk(title, director, releaseYear, cost));
        else {
            Node current = head;
            while (current.nextNode != null) {
                current = current.nextNode;
            }
            current.nextNode = new Node(new BlueRayDisk(title, director, releaseYear, cost));
        }
    }

    public void show_all() {
        if (head == null) return;
        Node current = head;
        System.out.println(current.disk);
        while (current.nextNode != null) {
            current = current.nextNode;
            System.out.println(current.disk);
        }
    }
}
