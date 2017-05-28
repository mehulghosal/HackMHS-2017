import java.util.*;
import java.io.*;

public class Main{
	
	static Scanner sc;
	
	
	public static void main(String[] args){
		
		try{
			sc = new Scanner(new File("data.txt"));
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
				String nextLine = sc.nextLine();
				if (nextLine.equals("new")){
					break;
				}else if(nextLine.equals("end")){
					isEnd = true;
					break;
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
				if (nextLine.equals("new")){
					break;
				}else if (nextLine.equals("end")){
					breakOuter = true;
					break;
				}else{
					String[] line = nextLine.split(" ");
					distances.put(classRooms.get(line[0]), Integer.parseInt(line[1]));
				}
			}
			classRooms.get(title).setNextTo(distances);
			if(breakOuter) break;

		}
		
	}

	public static Path findPath(ClassRoom start, ClassRoom finish){
		resetNodes(start);
		Set<ClassRoom> keys = start.getNextTo().keySet();
		ClassRoom[] array = keys.toArray(new ClassRoom[keys.size()]);
		
		for(int i = 0; i < array.length; i++){
			if (!array[i].getDidCheck()) {
				array[i].setDistanceToStart(start.getNextTo().get(array[i]));
				array[i].setdidCheck(true);
			}
		}

	}


	public static void resetNodes(ClassRoom startNode){
		Object[] classRoomsList = classRooms.values().toArray();
		for(Object i : classRoomsList){
			ClassRoom l = (ClassRoom) i;
			if (l != startNode){
				l.setDistanceToStart(Integer.MAX_VALUE);
				l.setFromNode(startNode);
			}else{
				l.setDistanceToStart(0);
				l.setFromNode(null);
			}
		}
	}


}

class Path{

	private ArrayList<ClassRoom> route = new ArrayList<ClassRoom>();
	private int distace;
	private ClassRoom startClass, endClass;

	public Path(){

	}

	public Path(ArrayList<ClassRoom> route, int distance, ClassRoom startClass, ClassRoom endClass){

	}



}