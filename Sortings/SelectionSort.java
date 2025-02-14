import java.util.*;
public class SelectionSort{
	public static void SelectionSort(int[] arr){
		int n = arr.length;
		

		for(int i=0;i<n-1;i++){
			int minIndex = i;
			for(int j=i+1;j<n;j++){
				if(arr[j] < arr[minIndex]){
					minIndex = j;
				}
			}
		swap(arr,i,minIndex);
		}
	}
	public static void swap(int arr[],int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String args[]){
		int[] examScores = {85, 72, 90, 65, 80, 75};
		
		System.out.println("Before Sorting : " + Arrays.toString(examScores));

		SelectionSort(examScores);

		System.out.println("After Sorting : " + Arrays.toString(examScores));
	}
}
