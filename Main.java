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

		
		List<ClassRoom> route = findPath(classRooms.get("109"), classRooms.get("139")).getRoute();
		for(int i = 0; i < route.size(); i++){
			System.out.println(route.get(i).getName());
		}

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
			ArrayList<ClassRoom> classrooms = new ArrayList<ClassRoom>();

			while(true){
				String nextLine = newSc.nextLine();
				if (nextLine.equals("new")){
					break;
				}else if (nextLine.equals("end")){
					breakOuter = true;
					break;
				}else{
					String[] line = nextLine.split(" ");
					// System.out.println(line[0]);
					distances.put(classRooms.get(line[0]), Integer.parseInt(line[1]));
					classrooms.add(classRooms.get(line[0]));
					if (classRooms.get(line[0]) == null){
						//System.out.println(line[0]);
					}
				}
			}

			classRooms.get(title).setNextToList(classrooms);
			classRooms.get(title).setNextTo(distances);
			if(breakOuter) break;

		}
		
	}

	public static Path findPath(ClassRoom start, ClassRoom finish){
		resetNodes(start);

		start.setDidCheck(true);
		
		ArrayList<ClassRoom> pending = new ArrayList<ClassRoom>();
		ArrayList<ClassRoom> nextToArrStart = start.getNextToList();

		for (ClassRoom i : nextToArrStart){
			i.setDistanceToStart(start.getNextTo().get(i));
			i.setFromNode(start);
			//System.out.println("thisRoom: " + start.getName() + "\tTo Room: " + i.getName()); // + "\tFrom Room: " + room.getFromName());
			pending.add(i);
		}

		while(true){
			ClassRoom thisRoom = new ClassRoom();
			int smallestDist = Integer.MAX_VALUE;
			for(ClassRoom i : pending){
				if (i.getDistanceFromStart() < smallestDist){
					// System.out.println("worked");
					thisRoom = i;
					smallestDist = i.getDistanceFromStart();
				}
			}

			int index = pending.indexOf(thisRoom);
			pending.remove(index);

			thisRoom.setDidCheck(true);



			ArrayList<ClassRoom> children = thisRoom.getNextToList();
			HashMap<ClassRoom, Integer> nextToDist = thisRoom.getNextTo();
			boolean shouldEnd = true;

			//System.out.println("node: " + thisRoom.getName());
			for (ClassRoom ugh : children){
			//	System.out.println(ugh.getName());
			shouldEnd = false;
			//System.out.println("\n");
			}

			for(ClassRoom room : children){
				// System.out.println("room status " + room.getName() + "\tStsus " + room.getDidCheck());
				// System.out.println()

				// if (!room.getDidCheck()){

				shouldEnd = true;

					if(pending.indexOf(room) == -1){
						pending.add(room);
					}

					if (nextToDist.get(room) + thisRoom.getDistanceFromStart() < room.getDistanceFromStart()){
						room.setFromNode(thisRoom);
						// System.out.println("thisRoom: " + thisRoom.getName() + "\tTo Room: " + room.getName()); // + "\tFrom Room: " + room.getFromName());
						room.setDistanceToStart(nextToDist.get(room) + thisRoom.getDistanceFromStart());
					}

				// }
			}

			if (shouldEnd){
		//		System.out.println(finish.getFrom().getName());
				break;
			}
		//	System.out.println("\n");
		}
// 		TO BE CHANGED (just herefor compiling erros and stuff)
		return findPath2(start, finish);

	}


	public static Path findPath2(ClassRoom start, ClassRoom finish){
		ArrayList<ClassRoom> route = new ArrayList<ClassRoom>();
		ClassRoom current = finish;

		while(true){
			route.add(current);
		//	// System.out.println(current.getName());
			ClassRoom prev = current.getFrom();
			if (prev == null){
				break;
			}
			current = prev;
		}

		Path finalPath = new Path(route, start, finish);

		return finalPath;
	}


	public static void resetNodes(ClassRoom startNode){
		Object[] classRoomsList = classRooms.values().toArray();
		for(Object i : classRoomsList){
			ClassRoom l = (ClassRoom) i;
			if (l != startNode){
				l.setDistanceToStart(Integer.MAX_VALUE);
				l.setFromNode(startNode);
				l.setDidCheck(false);
			}else{
				l.setDistanceToStart(0);
				l.setFromNode(null);
				l.setDidCheck(false);
			}
		}
	}


}

class Path{

	private ArrayList<ClassRoom> route = new ArrayList<ClassRoom>();
	// private int distace;
	private ClassRoom startClass, endClass;

	public Path(ArrayList<ClassRoom> route, ClassRoom startClass, ClassRoom endClass){
		this.route = route;
		this.startClass = startClass;
		this.endClass = endClass;
	}

	public ArrayList<ClassRoom> getRoute(){ return this.route; }
	public ClassRoom getStart(){ return startClass; }
	public ClassRoom getEnd(){ return endClass; }

}