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

			Boolean isEnd = false;

			while (true){
				if (sc.nextLine().equals("new")){
					break;
				}else if(sc.nextLine().equals("end")){
					isEnd = true;
				}
			}

			if (isEnd) break;
		}
		

		Scanner newSc;

		try{
			newSc = new Scanner(new File("data.txt"));
		}catch(Exception e){
			System.out.println("You dun goofed");
			return;
		}


		while(true){
			String title = newSc.nextLine();
			Boolean breakOuter = false;

			HashMap<ClassRoom, Integer> distances = new HashMap<ClassRoom, Integer>();

			while(true){
				String nextLine = newSc.nextLine();

				if (nextLine == "new"){
					break;
				}else if (nextLine == "end"){
					breakOuter = true;
				}else{
					distances.put(classRooms.get(nextLine.split(" ")[0]), Integer.parseInt(nextLine.split(" ")[1]));
				}
			}
			classRooms.get(title).setNextTo(distances);
			if(breakOuter) break;

		}
		
	}
}