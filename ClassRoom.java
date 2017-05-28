import java.util.*;

public class ClassRoom{
	
	private String name;
	private HashMap<ClassRoom, Integer> nextTo;
	
	
	public ClassRoom(String name){
		this.name = name;
	}
	
	public void setNextTo(HashMap<ClassRoom, Integer> arr){
		nextTo = arr;
	}
	
	public HashMap<ClassRoom, Integer> getNextTo(){ return nextTo; }
	
	public String getName(){
		return name;
	}
	
	
}
