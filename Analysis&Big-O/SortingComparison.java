import java.util.*;

public class SortingComparison{

	//BUBBLE SORT
	public static void bubbleSort(int[] arr){
		int n = arr.length;
		for(int i=0;i<n-1;i++){
			for(int j=0;j<n-1;j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

	//MERGE SORT
	public static void mergeSort(int[] arr,int left,int right){
		if(left < right){
			int mid = left + (right - left) / 2;
			mergeSort(arr,left,mid);
			mergeSort(arr,mid+1,right);
			merge(arr,left,mid,right);
		}
	}
	private static void merge(int[] arr,int left,int mid,int right){
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] leftArr = new int[n1];
		int[] rightArr = new int[n2];


		for(int i = 0 ; i < n1 ; i++){
			leftArr[i] = arr[left+1];
		}
		for(int j = 0 ; j < n2 ; j++){
			rightArr[j] = arr[mid+1+j];
		}

		int i=0 , j=0 , k=left;
		while(i < n1 && j < n2){
			if(leftArr[i] <= rightArr[j]){
				arr[k++] = leftArr[i++];
			}
			else{
				arr[k++] = rightArr[j++];
			}
		}
		while(i < n1){
			arr[k++] = leftArr[i++];
		}
		while(j < n2){
			arr[k++] = rightArr[j++];
		
		}
	}
		
		public static void quickSort(int[] arr,int low, int high){
			if(low < high){
				int pi = partition(arr,low,high);
				quickSort(arr,low,pi-1);
				quickSort(arr,pi+1,high);
			}
		}
		private static int partition(int[] arr,int low,int high){
			int pivot = arr[high];
			int i = low - 1;
			for(int j=low;j<high;j++){
				if(arr[j] <= pivot){
					i++;
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			int temp = arr[i+1];
			arr[i+1] = arr[high];
			arr[high] = temp;
			return i+1;

		}
		

		//INSERTION SORT
		public static void insertionSort(int[] arr){
			int n = arr.length;
			for(int i = 1; i < n; i++){
				int key = arr[i];
				int j = i - 1;

				while(j >= 0 && arr[j] > key){
					arr[j+1] = arr[j];
					j--;
				}
				arr[j+1] = key;
			}
		}
		public static void main(String[] args){
			int N = 10_000;
			int[] data1 = new int[N];
			int[] data2 = new int[N];
			int[] data3 = new int[N];
			int[] data4 = new int[N];

			Random random = new Random();

			for(int i=0;i<N;i++){
				int value = random.nextInt(N);
				data1[i] = value;
				data2[i] = value;
				data3[i] = value;
				data4[i] = value;
			}
			long startBubble = System.nanoTime();
			bubbleSort(data1);
			long endBubble = System.nanoTime();

			long startMerge = System.nanoTime();
			mergeSort(data2,0,N-1);
			long endMerge = System.nanoTime();

			long startQuick = System.nanoTime();
			quickSort(data3,0,N-1);
			long endQuick = System.nanoTime();

			long startInsertion = System.nanoTime();
			insertionSort(data4);
			long endInsertion = System.nanoTime();


			  System.out.println("Dataset Size: " + N);

       			 System.out.println("Bubble Sort:");
       			 System.out.println("Time: " + (endBubble - startBubble) / 1_000_000 + " ms");

        		System.out.println("Merge Sort:");
       			 System.out.println("Time: " + (endMerge - startMerge) / 1_000_000 + " ms");

       			 System.out.println("Quick Sort:");
       			 System.out.println("Time: " + (endQuick - startQuick) / 1_000_000 + " ms");

        		System.out.println("Insertion Sort:");
        		System.out.println("Time: " + (endInsertion - startInsertion) / 1_000_000 + " ms");
		}
	
}
