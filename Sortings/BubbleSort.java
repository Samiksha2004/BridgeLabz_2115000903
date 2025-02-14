import java.util.*;
public class BubbleSort{
	public static int[] sortStudentMarks(int[] marks){
		int n = marks.length;
		boolean swapped;

		for(int i=0;i<n-1;i++){
			swapped = false;
			for(int j=0;j<n-1-i;j++){
				if(marks[j] > marks[j+1]){
					int temp = marks[j];
					marks[j] = marks[j+1];
					marks[j+1] = temp;
					swapped = true;
				}
			}
			if(!swapped) break;
			}
		return marks;
		}
	public static void main(String args[]){
		   int[] studentMarks = {85, 78, 92, 65, 89, 70};
       		   System.out.println("Before Sorting: " + Arrays.toString(studentMarks));

                   int[] sortedMarks = sortStudentMarks(studentMarks);
                   System.out.println("After Sorting: " + Arrays.toString(sortedMarks));	
		
	}
}
