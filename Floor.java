import java.util.*;
import java.io  .*;

public class Floor{

	private ArrayList<Hallway> floor;

	public Floor(ArrayList<Hallway> f){
		this.floor = f;
	}
	public Floor(){}

	public ArrayList<Hallway> getFloor(){return floor;}
	public void setFloor(ArrayList<Hallway> f){
		this.floor = f;
	}
	public void addHall(Hallway h){
		floor.add(h);
	}

}