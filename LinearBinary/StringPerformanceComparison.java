public class StringPerformanceComparison {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";
        long startTimeBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long endTimeBuffer = System.nanoTime();
        long bufferTime = endTimeBuffer - startTimeBuffer;

 
        long startTimeBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long endTimeBuilder = System.nanoTime();
        long builderTime = endTimeBuilder - startTimeBuilder;

   
        System.out.println("Time taken by StringBuffer: " + bufferTime / 1_000_000.0 + " ms");
        System.out.println("Time taken by StringBuilder: " + builderTime / 1_000_000.0 + " ms");
    }
}

