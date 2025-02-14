import java.util.*;
public class CountingSort{
	public static void countingSort(int[] ages){
		int minAge = 10 , maxAge = 18;
		int range = maxAge - minAge + 1 ;

		int[] count = new int[range];

		for(int age:ages){
			count[age - minAge]++;
		}
		for(int i=1;i<range;i++){
			count[i] += count[i-1];
		}
		int[] sortedAges = new int[ages.length];
		for(int i=ages.length-1;i>=0;i--){
			int age =  ages[i];
			 sortedAges[count[age - minAge] - 1] = age;
            		 count[age - minAge]--;
		}
		  System.arraycopy(sortedAges, 0, ages, 0, ages.length);
		
	}
		public static void main(String[] args) {
     		   int[] studentAges = {15, 12, 18, 10, 14, 13, 12, 17, 11, 16, 15};

        	System.out.println("Before Sorting: " + Arrays.toString(studentAges));

       		countingSort(studentAges);

       		System.out.println("After Sorting: " + Arrays.toString(studentAges));
    }
}
