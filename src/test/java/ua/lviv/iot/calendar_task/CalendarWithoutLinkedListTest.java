package ua.lviv.iot.calendar_task;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalendarWithoutLinkedListTest {
    
    public static final int START_END_MEETING_COUNT = 2;
    
    int[][] meetingsOfFirstTeam = {{5, 6}, {45, 97}, {12, 13}, {13, 29}, {1, 8}, {89, 100}, {66, 97}};
    int[][] meetingsOfSecondTeam = {{6, 9}, {45, 90}, {1, 13}, {985, 993}, {19, 89}, {34, 88}, {11, 50}, {990, 994}};
    int[][] meetingsOfThirdTeam = {{17, 34}, {56, 97}, {3, 6}, {34, 35}, {1, 2}, {66, 70}, {87, 102}, {876, 987}, {765, 999}, {777, 947}};
    
    int countOfMeetingsOfFirstTeam = meetingsOfFirstTeam.length;
    int countOfMeetingsOfSecondTeam = meetingsOfSecondTeam.length;
    int countOfMeetingsOfThirdTeam = meetingsOfThirdTeam.length;

    @Test
    public void testFirstTeam() { 
        int[][] combinedMeetingsOfFirstTeam = {{1, 8}, {12, 29}, {45, 100}};
        
        CalendarSortManager.mergeSortByIncreaseValueOfStartTime(meetingsOfFirstTeam, 0, countOfMeetingsOfFirstTeam - 1);
        
        int[][] combinedMeetingsOfFirstTeamWithEmptySubarrays = new int[countOfMeetingsOfFirstTeam][START_END_MEETING_COUNT];
        CalendarWithoutLinkedList.combineMeetings(meetingsOfFirstTeam, combinedMeetingsOfFirstTeamWithEmptySubarrays);
        int numberOfNotEmptySubarrays = CalendarWithoutLinkedList.countNotEmptySubarrays(combinedMeetingsOfFirstTeamWithEmptySubarrays, countOfMeetingsOfFirstTeam);
        int[][] combinedMeetingsOfFirstTeamWithoutEmptySubarrays = new int[numberOfNotEmptySubarrays][START_END_MEETING_COUNT];
        CalendarWithoutLinkedList.copyDesiredPartsOfArray(combinedMeetingsOfFirstTeamWithEmptySubarrays, combinedMeetingsOfFirstTeamWithoutEmptySubarrays);
        
        for(int iteratorInCombinedMeetingsOfFirstTeam=0, iteratotInCombinedMeetingsOfFirstTeamWithoutEmptySubarrays=0; 
                iteratorInCombinedMeetingsOfFirstTeam < combinedMeetingsOfFirstTeam.length && iteratotInCombinedMeetingsOfFirstTeamWithoutEmptySubarrays<combinedMeetingsOfFirstTeamWithoutEmptySubarrays.length;
                iteratorInCombinedMeetingsOfFirstTeam++, iteratotInCombinedMeetingsOfFirstTeamWithoutEmptySubarrays++) {
            assertEquals(combinedMeetingsOfFirstTeam[iteratorInCombinedMeetingsOfFirstTeam][0], combinedMeetingsOfFirstTeamWithoutEmptySubarrays[iteratotInCombinedMeetingsOfFirstTeamWithoutEmptySubarrays][0]);
            assertEquals(combinedMeetingsOfFirstTeam[iteratorInCombinedMeetingsOfFirstTeam][1], combinedMeetingsOfFirstTeamWithoutEmptySubarrays[iteratotInCombinedMeetingsOfFirstTeamWithoutEmptySubarrays][1]);
        }
    }
       
    @Test
    public void testSecondTeam() { 
        int[][] combinedMeetingsOfSecondTeam = {{1, 90}, {985, 994}};
        
        CalendarSortManager.mergeSortByIncreaseValueOfStartTime(meetingsOfSecondTeam, 0, countOfMeetingsOfSecondTeam - 1);
        
        int[][] combinedMeetingsOfSecondTeamWithEmptySubarrays = new int[countOfMeetingsOfSecondTeam][START_END_MEETING_COUNT];
        CalendarWithoutLinkedList.combineMeetings(meetingsOfSecondTeam, combinedMeetingsOfSecondTeamWithEmptySubarrays);
        int numberOfNotEmptySubarrays = CalendarWithoutLinkedList.countNotEmptySubarrays(combinedMeetingsOfSecondTeamWithEmptySubarrays, countOfMeetingsOfSecondTeam);
        int[][] combinedMeetingsOfSecondTeamWithoutEmptySubarrays = new int[numberOfNotEmptySubarrays][START_END_MEETING_COUNT];
        CalendarWithoutLinkedList.copyDesiredPartsOfArray(combinedMeetingsOfSecondTeamWithEmptySubarrays, combinedMeetingsOfSecondTeamWithoutEmptySubarrays);
        
        for(int iteratorInCombinedMeetingsOfSecondTeam=0, iteratotInCombinedMeetingsOfSecondTeamWithoutEmptySubarrays=0; 
                iteratorInCombinedMeetingsOfSecondTeam < combinedMeetingsOfSecondTeam.length && iteratotInCombinedMeetingsOfSecondTeamWithoutEmptySubarrays<combinedMeetingsOfSecondTeamWithoutEmptySubarrays.length; 
                iteratorInCombinedMeetingsOfSecondTeam++, iteratotInCombinedMeetingsOfSecondTeamWithoutEmptySubarrays++) {
            assertEquals(combinedMeetingsOfSecondTeam[iteratorInCombinedMeetingsOfSecondTeam][0], combinedMeetingsOfSecondTeamWithoutEmptySubarrays[iteratotInCombinedMeetingsOfSecondTeamWithoutEmptySubarrays][0]);
            assertEquals(combinedMeetingsOfSecondTeam[iteratorInCombinedMeetingsOfSecondTeam][1], combinedMeetingsOfSecondTeamWithoutEmptySubarrays[iteratotInCombinedMeetingsOfSecondTeamWithoutEmptySubarrays][1]);
        }
    }
    
    @Test
    public void testThirdTeam() { 
        int[][] combinedMeetingsOfThirdTeam = {{1, 2}, {3, 6}, {17, 35}, {56, 102}, {765, 999}};
        
        CalendarSortManager.mergeSortByIncreaseValueOfStartTime(meetingsOfThirdTeam, 0, countOfMeetingsOfThirdTeam - 1);
        
        int[][] combinedMeetingsOfThirdTeamWithEmptySubarrays = new int[countOfMeetingsOfThirdTeam][START_END_MEETING_COUNT];
        CalendarWithoutLinkedList.combineMeetings(meetingsOfThirdTeam, combinedMeetingsOfThirdTeamWithEmptySubarrays);
        int numberOfNotEmptySubarrays = CalendarWithoutLinkedList.countNotEmptySubarrays(combinedMeetingsOfThirdTeamWithEmptySubarrays, countOfMeetingsOfThirdTeam);
        int[][] combinedMeetingsOfThirdTeamWithoutEmptySubarrays = new int[numberOfNotEmptySubarrays][START_END_MEETING_COUNT];
        CalendarWithoutLinkedList.copyDesiredPartsOfArray(combinedMeetingsOfThirdTeamWithEmptySubarrays, combinedMeetingsOfThirdTeamWithoutEmptySubarrays);
        
        for(int iteratorInCombinedMeetingsOfThirdTeam=0, iteratotInCombinedMeetingsOfThirdTeamWithoutEmptySubarrays=0; 
                iteratorInCombinedMeetingsOfThirdTeam < combinedMeetingsOfThirdTeam.length && iteratotInCombinedMeetingsOfThirdTeamWithoutEmptySubarrays<combinedMeetingsOfThirdTeamWithoutEmptySubarrays.length; 
                iteratorInCombinedMeetingsOfThirdTeam++, iteratotInCombinedMeetingsOfThirdTeamWithoutEmptySubarrays++) {
            assertEquals(combinedMeetingsOfThirdTeam[iteratorInCombinedMeetingsOfThirdTeam][0], combinedMeetingsOfThirdTeamWithoutEmptySubarrays[iteratotInCombinedMeetingsOfThirdTeamWithoutEmptySubarrays][0]);
            assertEquals(combinedMeetingsOfThirdTeam[iteratorInCombinedMeetingsOfThirdTeam][1], combinedMeetingsOfThirdTeamWithoutEmptySubarrays[iteratotInCombinedMeetingsOfThirdTeamWithoutEmptySubarrays][1]);
        }
    }
}
