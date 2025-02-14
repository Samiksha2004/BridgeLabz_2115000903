import java.util.*;
public class HeapSort{
	public static void heapSort(int[] arr){
		int n = arr.length ;
		
		for(int i = n / 2 - 1; i>=0;i--){
			heapify(arr,n,i);
		}
		for(int i=n/2;i>0;i--){
			swap(arr,0,i);

			heapify(arr,i,0);
		}
	}
	public static void heapify(int[] arr,int n,int i){
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if(left < n && arr[left] > largest){
			largest = left;
		}
		if(right < n && arr[right] > largest){
			largest = right;
		}
		if(largest != i){
			swap(arr,i,largest);
			heapify(arr,n,largest);
		}
	}
	public static void main(String args[]){
		int[] salaries = {50000, 70000, 30000, 90000, 40000, 80000};

       		 System.out.println("Before Sorting: " + Arrays.toString(salaries));

       		 heapSort(salaries);

       		 System.out.println("After Sorting: " + Arrays.toString(salaries));
	}
}
