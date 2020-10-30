package ua.lviv.iot.calendar_task;

public class CalendarSortManager {
    
    public static final int START_END_MEETING_COUNT = 2;
    
    public static void mergeByIncreaseValueOfStartTime(int[][] meetings, int firstElementIndex, int middleElementeIndex, int lastElementIndex) {
        
        int countElementsInLeftPart = middleElementeIndex - firstElementIndex + 1;
        int countElementsInRightPart = lastElementIndex - middleElementeIndex;
        
        int[][] arrayOfLeftElements = new int[countElementsInLeftPart][START_END_MEETING_COUNT];
        int[][] arrayOfRightElements = new int[countElementsInRightPart][START_END_MEETING_COUNT];
        
        for(int indexOfElementInLeftPart = 0; indexOfElementInLeftPart < countElementsInLeftPart; ++indexOfElementInLeftPart) {
            arrayOfLeftElements[indexOfElementInLeftPart][0] = meetings[firstElementIndex + indexOfElementInLeftPart][0];
            arrayOfLeftElements[indexOfElementInLeftPart][1] = meetings[firstElementIndex + indexOfElementInLeftPart][1];
        }
        
        for(int indexOfElementInRightPart = 0; indexOfElementInRightPart < countElementsInRightPart; ++indexOfElementInRightPart) {
            arrayOfRightElements[indexOfElementInRightPart][0] = meetings[middleElementeIndex + 1 + indexOfElementInRightPart][0];
            arrayOfRightElements[indexOfElementInRightPart][1] = meetings[middleElementeIndex + 1 + indexOfElementInRightPart][1];
        }
        
        int indexOfElementInLeftPart = 0;
        int indexOfElementInRightPart = 0;
        int indexOfElementInSortedList = firstElementIndex;
        
        while(indexOfElementInLeftPart < countElementsInLeftPart && indexOfElementInRightPart < countElementsInRightPart) {
            
            
            if(arrayOfLeftElements[indexOfElementInLeftPart][0] < arrayOfRightElements[indexOfElementInRightPart][0]) {

                meetings[indexOfElementInSortedList][0] = arrayOfLeftElements[indexOfElementInLeftPart][0];
                meetings[indexOfElementInSortedList][1] = arrayOfLeftElements[indexOfElementInLeftPart][1];
                indexOfElementInLeftPart++;
                
            } else {
                
                meetings[indexOfElementInSortedList][0] = arrayOfRightElements[indexOfElementInRightPart][0];
                meetings[indexOfElementInSortedList][1] = arrayOfRightElements[indexOfElementInRightPart][1];
                indexOfElementInRightPart++;
            
            }
            
            indexOfElementInSortedList++;
            
        }
        
        while(indexOfElementInLeftPart < countElementsInLeftPart) {
            
            meetings[indexOfElementInSortedList][0] = arrayOfLeftElements[indexOfElementInLeftPart][0];
            meetings[indexOfElementInSortedList][1] = arrayOfLeftElements[indexOfElementInLeftPart][1];
            indexOfElementInLeftPart++;
            indexOfElementInSortedList++;

        }
        
        while(indexOfElementInRightPart < countElementsInRightPart) {
            
            meetings[indexOfElementInSortedList][0] = arrayOfRightElements[indexOfElementInRightPart][0];
            meetings[indexOfElementInSortedList][1] = arrayOfRightElements[indexOfElementInRightPart][1];
            indexOfElementInRightPart++;
            indexOfElementInSortedList++;

        }
    }
    
    public static void mergeSortByIncreaseValueOfStartTime(int[][] meetings, int firstElementIndex, int lastElementIndex) {
        
        if( firstElementIndex < lastElementIndex) {
            
            int middleElementeIndex = (firstElementIndex + lastElementIndex)/2;
            mergeSortByIncreaseValueOfStartTime(meetings, firstElementIndex, middleElementeIndex);
            mergeSortByIncreaseValueOfStartTime(meetings, middleElementeIndex + 1, lastElementIndex);
            mergeByIncreaseValueOfStartTime(meetings, firstElementIndex, middleElementeIndex, lastElementIndex);
        }
                
    }

}
