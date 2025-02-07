import java.util.*;
public class VolumeCylinder(String args[]){
	public static void main{
		Scanner sc = new Scanner(System.in)
		double radius = sc.nextDouble();
		double height = sc.nextDouble();
		
		double voc = Math.PI * radius * radius * height;
		
		System.out.println("Volume f cylinder is : "+ voc);
	}
}
