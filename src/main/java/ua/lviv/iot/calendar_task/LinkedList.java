package ua.lviv.iot.calendar_task;

public class LinkedList {
    
    protected Node head = null;
    
    protected Node lastNode = null;
    
    public void addNewNode(int[] value) {
        
            Node newNode = new Node(value);
            
            if (head == null) {
                
                head = newNode;
                lastNode = newNode;
                
            } else {
                
                lastNode.setNextNode(newNode);
                lastNode = newNode;
                
            }
    }
    
    public void printLinkedList() {
        
        Node currentNode = head;
        
        while(currentNode != null) {
            
            System.out.print("[");
            for(int element : currentNode.getValue()) {
                System.out.print(" " + Integer.toString(element) + " ");
            }
            System.out.println("]");
            
            currentNode = currentNode.getNextNode();
        }
    }
    
}
