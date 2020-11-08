package ua.lviv.iot.calendar_task;

import java.io.InputStream;
import java.util.Scanner;

import ua.lviv.iot.calendar_task.CalendarSortManager;

public class Calendar {
    
    public static final int START_END_MEETING_COUNT = 2;
    
    public static int[][] getArrayOfArrays(InputStream input, int countOfMeetings) {
        
        int[][] meeting = new int[countOfMeetings][START_END_MEETING_COUNT];
        Scanner scanner = new Scanner(System.in);
        
        for (int rowIterator = 0; rowIterator < countOfMeetings; rowIterator++) {
            for (int columnIterator = 0; columnIterator < START_END_MEETING_COUNT; columnIterator++) {
                meeting[rowIterator][columnIterator] = scanner.nextInt(); 
            }
        }
        return meeting;
    }
    
    public static void printArrayOfArrays(int[][] array) {
        
        for (int[] line : array) {
            System.out.print("[");
            for(int element : line) {
                System.out.print(" " + element + " ");
            }
            System.out.println("]");
        }
    }
    
    public static void combineMeetings(LinkedList linkList) {
        
        linkList.lastNode = linkList.head;
        
        while(true) {
            
            if (linkList.lastNode == null || linkList.lastNode.getNextNode() == null) {
                break;
            }
            
            if ((linkList.lastNode.getValue()[0] <= linkList.lastNode.getNextNode().getValue()[0]) && (linkList.lastNode.getNextNode().getValue()[0] <= linkList.lastNode.getNextNode().getValue()[1]) &&
                    (linkList.lastNode.getNextNode().getValue()[1] <= linkList.lastNode.getValue()[1])) {
                
                linkList.lastNode.setNextNode(linkList.lastNode.getNextNode().getNextNode());
            
            } else if ((linkList.lastNode.getValue()[0] <= linkList.lastNode.getNextNode().getValue()[0]) && (linkList.lastNode.getNextNode().getValue()[0] <= linkList.lastNode.getValue()[1]) &&
                    (linkList.lastNode.getValue()[1] <= linkList.lastNode.getNextNode().getValue()[1])) {
                
                linkList.lastNode.setValue(new int []{linkList.lastNode.getValue()[0], linkList.lastNode.getNextNode().getValue()[1]});
                linkList.lastNode.setNextNode(linkList.lastNode.getNextNode().getNextNode());
                
            } else {
                
                linkList.lastNode = linkList.lastNode.getNextNode();
            
            }
        }
    }

    

    public static void main(String[] args) {
        
        System.out.print("Enter count of the meetings: ");
        Scanner scanner = new Scanner(System.in);
        int countOfMeetings = scanner.nextInt();
        
        int[][] meetings = getArrayOfArrays(System.in, countOfMeetings);
        printArrayOfArrays(meetings);
                
        CalendarSortManager.mergeSortByIncreaseValueOfStartTime(meetings, 0, countOfMeetings - 1);
        printArrayOfArrays(meetings);
        
        LinkedList linkList = new LinkedList();
        for (int[] node : meetings) {
            linkList.addNewNode(node);
        }
                
        combineMeetings(linkList);
        System.out.println("=====Combined meetings=====");
        linkList.printLinkedList();
    }

}
