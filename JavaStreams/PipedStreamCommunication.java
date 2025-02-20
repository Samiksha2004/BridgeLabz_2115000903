import java.io.*;

class PipedStreamCommunication {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            Thread writerThread = new Thread(() -> {
                try (DataOutputStream dos = new DataOutputStream(pos)) {
                    dos.writeUTF("Hello from Writer Thread!");
                    dos.writeUTF("Data transfer using Piped Streams");
                    System.out.println("Writer: Data sent.");
                } catch (IOException e) {
                    System.out.println("Writer error: " + e.getMessage());
                }
            });

            Thread readerThread = new Thread(() -> {
                try (DataInputStream dis = new DataInputStream(pis)) {
                    while (true) {
                        String message = dis.readUTF();
                        System.out.println("Reader received: " + message);
                    }
                } catch (EOFException e) {
                    System.out.println("Reader: End of data.");
                } catch (IOException e) {
                    System.out.println("Reader error: " + e.getMessage());
                }
            });

            writerThread.start();
            readerThread.start();

            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

