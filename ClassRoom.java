import java.util.*;
import java.io.*;

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
	
}

class HallEnd extends ClassRoom{

	private int hall2;
	public HallEnd(String n, int h, int h2){
		super(n, h);
		this.hall2 = h2;
	}

	public int gethall2(){return hall2;}

}
