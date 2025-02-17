public class StringConcatPerformance{
	public static void main(String args[]){
		int n = 1_000_000;

		//String
		long startTime = System.nanoTime();
		String str = "";
		for(int i=0;i<n;i++){
			str += "a";
		}
		long endTime = System.nanoTime();
		System.out.println("String time: " + (endTime - startTime) / 1_000_000+ "ms");


		//String Builder
		startTime = System.nanoTime();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
			sb.append("a");
		}
		endTime = System.nanoTime();
		System.out.println("StringBuilder time:" + (endTime - startTime)/1_000_000 + "ms");


		//String Buffer
		startTime = System.nanoTime();
		StringBuffer sbf = new StringBuffer();
		for(int i=0;i<n;i++){
			sbf.append("a");
		}
		endTime = System.nanoTime();
		System.out.println("StringBuffer time: " + (endTime - startTime) / 1_000_000);

	}
}
