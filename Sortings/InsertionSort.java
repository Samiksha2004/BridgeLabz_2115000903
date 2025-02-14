import java.util.*;
public class InsertionSort{
	public static int[] sortEmployeeIDs(int empIDs[]){
		int n = empIDs.length;
		
		for(int i=1;i<n;i++){
			int key = empIDs[i];
			int j = i-1;
			
		        while(j>=0 && empIDs[j]>key){
			        empIDs[j+1] = empIDs[j];
		        	j--;	
			}
		empIDs[j+1] = key;
		}
	return empIDs;
	}
	public static void main(String args[]){
		int[] employeeIDs = {105, 102, 110, 101, 108, 103};

		System.out.println("Before Sorting : " + Arrays.toString(employeeIDs));

		int[] sorted = sortEmployeeIDs(employeeIDs);

		System.out.println("After Sorting : " + Arrays.toString(sorted));
	}
}
