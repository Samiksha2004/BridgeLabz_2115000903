public class FibonacciComparison{
	public static void main(String args[]){
		int n = 50;

		long startRecursive = System.nanoTime();
		System.out.println("Recursive Fibonacci: " + fibonacciRecursive(n));
		long endRecursive = System.nanoTime();
		System.out.println("Time taken (Recursive) : " + (endRecursive - startRecursive) / 1e6 + "ms");
		

		long startIterative = System.nanoTime();
		System.out.println("Iterative Fibonacci: " + fibonacciIterative(n));
		long endIterative = System.nanoTime();
		System.out.println("Time taken (Iterative): " + (endIterative - startIterative)/1e6 + "ms");
	}


		//RECURSIVE
		public static int fibonacciRecursive(int n){
			if(n <= 1){
				return n;
			}
			return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
		} 

		//ITERATIVE
		public static int fibonacciIterative(int n){
			if(n <= 1) {
				return n;
			}
			int a=0,b=1,sum=0;
			for(int i=2;i<=n;i++){
				sum = a + b;
				a = b ;
				b = sum;
			}
			return b;
		}
	
}
