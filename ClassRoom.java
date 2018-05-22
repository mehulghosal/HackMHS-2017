import java.util.*;

public class ClassRoom{
	
	private String name;
	//dont need floor bc it exits in the hallway
	//private int floor;
	private int hallway;

	public ClassRoom(String n, int h){
		this.name = n;
		//this.floor = f; 
		this.hallway = h;
	}

	public String getName(){return name;}
	//public int getFloor(){return floor;}
	public int getHall(){return hallway;}

	/*
	private int distanceToStart;
	private ClassRoom fromNode;
	private boolean didCheck;
	private HashMap<ClassRoom, Integer> nextTo;
	private ArrayList<ClassRoom> nextToList;
	

	
	public ClassRoom(String name){
		this.name = name;
		distanceToStart = 0;
	}

	public ClassRoom(){
		
	}

	public void resetAlgorithm(){
		distanceToStart = Integer.MAX_VALUE;
		fromNode = null;
	}

	
	public void setNextTo(HashMap<ClassRoom, Integer> arr){ nextTo = arr; }
	public void setNextToList(ArrayList<ClassRoom> list){ this.nextToList = list; }
	public void setDistanceToStart(int dist){ this.distanceToStart = dist;}
	public void setFromNode(ClassRoom from){ this.fromNode = from; }
	public void setDidCheck(boolean check){ this.didCheck = check; }

	public boolean getDidCheck(){ return this.didCheck; }
	public String getFromName(){ return fromNode.getName(); }
	public ClassRoom getFrom(){ return fromNode; }
	public int getDistanceFromStart(){ return distanceToStart; }

	public ArrayList<ClassRoom> getNextToList(){ return this.nextToList; }
	public HashMap<ClassRoom, Integer> getNextTo(){ return nextTo; }
	public String getName(){ return name; }
	*/
	
	
}
