import java.util.*;
import java.io.*;

public class Main{
	
	static Scanner sc;
	
	
	public static void main(String[] args){
		
		try{
			sc = new Scanner(new File("data.txt"));
			createMap();
		}catch(Exception e){
			System.out.println("I Failed");
		}
		
		createMap();
	}
	
	public static HashMap<String, ClassRoom> classRooms = new HashMap<String, ClassRoom>();
	
	public static void createMap(){
		while(true){
			String title = sc.nextLine();
			ClassRoom thisClassRoom = new ClassRoom(title);
			classRooms.put(title, thisClassRoom);
			while (true){
				if (sc.nextLine().equals("new")){
					break;
				}
			}			
		}
		
		
		
	}
}