import java.io.*;

public class ImageByteArrayConverter {
    public static void main(String[] args) {
        String sourceImagePath = "source_image.jpg";
        String outputImagePath = "output_image.jpg";

        try {
            // Read image into byte array
            byte[] imageBytes = readImageToByteArray(sourceImagePath);

            // Write byte array to new image
            writeByteArrayToImage(imageBytes, outputImagePath);

            System.out.println("Image successfully converted to byte array and written back to: " + outputImagePath);

        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }

    // Method to read an image file into a byte array
    public static byte[] readImageToByteArray(String imagePath) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(imagePath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            return baos.toByteArray();
        }
    }

    // Method to write a byte array to an image file
    public static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}

