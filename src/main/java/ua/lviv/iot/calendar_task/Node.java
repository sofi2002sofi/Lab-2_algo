package ua.lviv.iot.calendar_task;

public class Node {
       
    private Node nextNode;
    
    private int[] value;

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public int[] getValue() {
        return value;
    }

    public void setValue(int[] value) {
        this.value = value;
    }

    public Node(int[] value) {
        super();
        this.nextNode = null;
        this.value = value;
    }   
    
}
