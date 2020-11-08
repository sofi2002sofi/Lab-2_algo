package ua.lviv.iot.calendar_task;

import java.io.InputStream;
import java.util.Scanner;

public class CalendarWithoutLinkedList {
    
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
    
    public static int inizialisationOfMeetingsBeggining (int[][] primaryArray, int[][] combinedArray, int iteratorInPrimaryArray, int iteratorInCombinedArray, int possibleValueMeetingsEnding) {
        
        combinedArray[iteratorInCombinedArray][0] = primaryArray[iteratorInPrimaryArray][0];
        possibleValueMeetingsEnding = primaryArray[iteratorInPrimaryArray][1];
        return possibleValueMeetingsEnding;
        
    }
    
    public static void combineMeetings(int[][] primaryArray, int[][] combinedArray) {
        
        int countOfElementsInPrimaryArray = primaryArray.length;
        int iteratorInPrimaryArray = 0;
        int iteratorInCombinedArray = 0;
        int possibleValueMeetingsEnding = 0;
        
        possibleValueMeetingsEnding = inizialisationOfMeetingsBeggining(primaryArray, combinedArray, iteratorInPrimaryArray, iteratorInCombinedArray, possibleValueMeetingsEnding);
        
        for(iteratorInPrimaryArray = 1; iteratorInPrimaryArray < countOfElementsInPrimaryArray; iteratorInPrimaryArray++) {
            
            if((primaryArray[iteratorInPrimaryArray][0] <= possibleValueMeetingsEnding) && (possibleValueMeetingsEnding <= primaryArray[iteratorInPrimaryArray][1] )) {
                possibleValueMeetingsEnding = primaryArray[iteratorInPrimaryArray][1];
            } 
            else if(possibleValueMeetingsEnding < primaryArray[iteratorInPrimaryArray][0]){
                combinedArray[iteratorInCombinedArray][1] = possibleValueMeetingsEnding;
                iteratorInCombinedArray++;
                possibleValueMeetingsEnding = inizialisationOfMeetingsBeggining(primaryArray, combinedArray, iteratorInPrimaryArray, iteratorInCombinedArray, possibleValueMeetingsEnding);
                
            }
        }
        if(combinedArray[iteratorInCombinedArray][1] == 0) {
            combinedArray[iteratorInCombinedArray][1] = possibleValueMeetingsEnding;
        }
    }
    
    public static int countNotEmptySubarrays(int[][] combinedArray, int count) {
        
        int numberOfNotEmptySubarrays=0;
        int iteratorInCombinedArray=0;
        
        while ( iteratorInCombinedArray < count && (combinedArray[iteratorInCombinedArray][0] != combinedArray[iteratorInCombinedArray][1]) && (combinedArray[iteratorInCombinedArray][1] != 0)) {
            numberOfNotEmptySubarrays++;
            iteratorInCombinedArray++;
        }
        
        return numberOfNotEmptySubarrays;
        
    }
    
    public static void copyDesiredPartsOfArray(int[][] primaryArray, int[][] desiredSizeArray) {
        
        int desiredSize = desiredSizeArray.length;
        
        for (int iteratorInDesiredSizeArray=0; iteratorInDesiredSizeArray<desiredSize; iteratorInDesiredSizeArray++) {
            desiredSizeArray[iteratorInDesiredSizeArray][0]=primaryArray[iteratorInDesiredSizeArray][0];
            desiredSizeArray[iteratorInDesiredSizeArray][1]=primaryArray[iteratorInDesiredSizeArray][1];
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter count of the meetings: ");
        Scanner scanner = new Scanner(System.in);
        int countOfMeetings = scanner.nextInt();
        
        int[][] meetings = getArrayOfArrays(System.in, countOfMeetings);
        printArrayOfArrays(meetings);
                
        CalendarSortManager.mergeSortByIncreaseValueOfStartTime(meetings, 0, countOfMeetings - 1);
        
        int[][] combinedMeetings = new int[countOfMeetings][START_END_MEETING_COUNT];

        combineMeetings(meetings, combinedMeetings);
        
        int numberOfNotEmptySubarrays = countNotEmptySubarrays(combinedMeetings, countOfMeetings);
        int[][] combinedMeetingsWithoutEmptySubarrays = new int[numberOfNotEmptySubarrays][START_END_MEETING_COUNT];
        copyDesiredPartsOfArray(combinedMeetings, combinedMeetingsWithoutEmptySubarrays);
        
        System.out.println("=====Combined meetings=====");
        printArrayOfArrays(combinedMeetingsWithoutEmptySubarrays);

    }

}
