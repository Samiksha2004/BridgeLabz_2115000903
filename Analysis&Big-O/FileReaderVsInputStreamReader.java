import java.io.*;
public class FileReaderVsInputStreamReader{
	public static void main(String args[]){
		
		String filePath = "largefile.txt" ;

		long startTime = System.nanoTime();
		try(FileReader fileReader = new FileReader(filePath)){
			char[] buffer = new char[1024];
			while(fileReader.read(buffer) != -1){
				
			}
	
		}catch (IOException e){
			e.printStackTrace();
		}
		long endTime = System.nanoTime();
		long fileReaderTime = endTime - startTime;

		startTime = System.nanoTime();
		try(InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))){
			char[] buffer = new char[1024];
			while(inputStreamReader.read(buffer) != -1){
				
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		endTime = System.nanoTime();
		long inputStreamReaderTime = endTime - startTime;

		System.out.println("FileReader Time: " + fileReaderTime/1000000.0 + "ms");
		System.out.println("InputStreamReader Time: " + inputStreamReaderTime/1000000.0+"ms");
	}

}
