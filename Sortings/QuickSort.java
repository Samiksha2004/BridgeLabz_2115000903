import java.util.*;
public class QuickSort{
	public static void quickSort(double[] arr,int low,int high){
		if(low < high){
			int partitionIndex = partition(arr,low,high);

			quickSort(arr,low,partitionIndex - 1);
			quickSort(arr,partitionIndex+ 1,high); 
		}
	}
	public static int partition(double[] arr,int low,int high){
		double pivot = arr[high];
		int i = low - 1;
		
		for(int j=low;j<high;j++){
			if(arr[j] <= pivot){
			 i++;
		         swap(arr,i,j);		
			}
		}
		swap(arr,i+1,high);
		return i + 1;
	}
	public static void swap(double[] arr,int i,int j){
		double temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
	public static void main(String args[]){
		double[] productPrices = {199.99, 499.50, 150.75, 299.99, 99.99, 350.25};
		
		System.out.println("Before Sorting : " + Arrays.toString(productPrices));

		quickSort(productPrices , 0 , productPrices.length-1);

		System.out.println("After Sorting : " + Arrays.toString(productPrices));
	}
}
