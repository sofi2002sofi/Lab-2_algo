package ua.lviv.iot.calendar_task;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalendarTest {

    LinkedList linkListFirstTeam = new LinkedList();
    LinkedList linkListSecondTeam = new LinkedList();
    LinkedList linkListThirdTeam = new LinkedList();
    int[][] meetingsOfFirstTeam = {{5, 6}, {45, 97}, {12, 13}, {13, 29}, {1, 8}, {89, 100}, {66, 97}};
    int[][] meetingsOfSecondTeam = {{6, 9}, {45, 90}, {1, 13}, {985, 993}, {19, 89}, {34, 88}, {11, 50}, {990, 994}};
    int[][] meetingsOfThirdTeam = {{17, 34}, {56, 97}, {3, 6}, {34, 35}, {1, 2}, {66, 70}, {87, 102}, {876, 987}, {765, 999}, {777, 947}};

    @Test
    public void testFirstTeam() { 
        LinkedList combinedLinkListFirstTeam = new LinkedList();
        int[][] combinedMeetingsOfFirstTeam = {{1, 8}, {12, 29}, {45, 100}};
        for (int[] node : combinedMeetingsOfFirstTeam) {
            combinedLinkListFirstTeam.addNewNode(node);
        }
        
        CalendarSortManager.mergeSortByIncreaseValueOfStartTime(meetingsOfFirstTeam, 0, meetingsOfFirstTeam.length - 1);
        for (int[] node : meetingsOfFirstTeam) {
            linkListFirstTeam.addNewNode(node);
        }
        Calendar.combineMeetings(linkListFirstTeam);
        
        linkListFirstTeam.lastNode = linkListFirstTeam.head;
        combinedLinkListFirstTeam.lastNode = combinedLinkListFirstTeam.head;
        while(linkListFirstTeam.lastNode != null && combinedLinkListFirstTeam.lastNode!= null) {
            assertEquals(combinedLinkListFirstTeam.lastNode.getValue()[0], linkListFirstTeam.lastNode.getValue()[0]);
            assertEquals(combinedLinkListFirstTeam.lastNode.getValue()[1], linkListFirstTeam.lastNode.getValue()[1]);
            linkListFirstTeam.lastNode = linkListFirstTeam.lastNode.getNextNode();
            combinedLinkListFirstTeam.lastNode = combinedLinkListFirstTeam.lastNode.getNextNode();
        }
    }
    
    @Test
    public void testSecondTeam() { 
        LinkedList combinedLinkListSecondTeam = new LinkedList();
        int[][] combinedMeetingsOfSecondTeam = {{1, 90}, {985, 994}};
        for (int[] node : combinedMeetingsOfSecondTeam) {
            combinedLinkListSecondTeam.addNewNode(node);
        }
        
        CalendarSortManager.mergeSortByIncreaseValueOfStartTime(meetingsOfSecondTeam, 0, meetingsOfSecondTeam.length - 1);
        for (int[] node : meetingsOfSecondTeam) {
            linkListSecondTeam.addNewNode(node);
        }
        Calendar.combineMeetings(linkListSecondTeam);
        
        linkListSecondTeam.lastNode = linkListSecondTeam.head;
        combinedLinkListSecondTeam.lastNode = combinedLinkListSecondTeam.head;
        while(linkListSecondTeam.lastNode != null && combinedLinkListSecondTeam.lastNode!= null) {
            assertEquals(combinedLinkListSecondTeam.lastNode.getValue()[0], linkListSecondTeam.lastNode.getValue()[0]);
            assertEquals(combinedLinkListSecondTeam.lastNode.getValue()[1], linkListSecondTeam.lastNode.getValue()[1]);
            linkListSecondTeam.lastNode = linkListSecondTeam.lastNode.getNextNode();
            combinedLinkListSecondTeam.lastNode = combinedLinkListSecondTeam.lastNode.getNextNode();
        }
    }
    
    @Test
    public void testThirdTeam() { 
        LinkedList combinedLinkListThirdTeam = new LinkedList();
        int[][] combinedMeetingsOfThirdTeam = {{1, 2}, {3, 6}, {17, 35}, {56, 102}, {765, 999}};
        for (int[] node : combinedMeetingsOfThirdTeam) {
            combinedLinkListThirdTeam.addNewNode(node);
        }
        
        CalendarSortManager.mergeSortByIncreaseValueOfStartTime(meetingsOfThirdTeam, 0, meetingsOfThirdTeam.length - 1);
        for (int[] node : meetingsOfThirdTeam) {
            linkListThirdTeam.addNewNode(node);
        }
        Calendar.combineMeetings(linkListThirdTeam);
        
        linkListThirdTeam.lastNode = linkListThirdTeam.head;
        combinedLinkListThirdTeam.lastNode = combinedLinkListThirdTeam.head;
        while(linkListThirdTeam.lastNode != null && combinedLinkListThirdTeam.lastNode!= null) {
            assertEquals(combinedLinkListThirdTeam.lastNode.getValue()[0], linkListThirdTeam.lastNode.getValue()[0]);
            assertEquals(combinedLinkListThirdTeam.lastNode.getValue()[1], linkListThirdTeam.lastNode.getValue()[1]);
            linkListThirdTeam.lastNode = linkListThirdTeam.lastNode.getNextNode();
            combinedLinkListThirdTeam.lastNode = combinedLinkListThirdTeam.lastNode.getNextNode();
        }
    }
}
