import java.io.*;

public class EfficientFileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        long startTime, endTime;

        // Unbuffered File Copy
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            startTime = System.nanoTime();

            int byteData;
            long totalBytes = 0;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
                totalBytes++;
                if (totalBytes % (1024 * 1024) == 0) {
                    System.out.println("Unbuffered Copy Progress: " + (totalBytes / (1024 * 1024)) + " MB");
                }
            }

            endTime = System.nanoTime();
            System.out.println("Unbuffered copy completed in: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourceFile);
        } catch (IOException e) {
            System.out.println("Error occurred while copying the file: " + e.getMessage());
        }

        // Buffered File Copy
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {

            startTime = System.nanoTime();

            byte[] buffer = new byte[4096];
            int bytesRead;
            long totalBytes = 0;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;

                // Display progress every 1 MB
                if (totalBytes % (1024 * 1024) == 0) {
                    System.out.println("Buffered Copy Progress: " + (totalBytes / (1024 * 1024)) + " MB");
                }
            }

            bos.flush(); // Ensure all remaining data is written

            endTime = System.nanoTime();
            System.out.println("Buffered copy completed in: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourceFile);
        } catch (IOException e) {
            System.out.println("Error occurred while copying the file: " + e.getMessage());
        }
    }
}

