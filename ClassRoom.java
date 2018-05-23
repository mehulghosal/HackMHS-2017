import java.util.*;
import java.io.*;
import java.lang.*;

public class ClassRoom{
	
	private String name;
	private int floor;
	private int hallway;

	public ClassRoom(String n, int f, int h){
		this.name = n;
		this.floor = f; 
		this.hallway = h;
	}
	public ClassRoom(int f){
		this.floor = f;
	}

	//copies the info from toCopy --> this
	//also, modifies the name to fit the floor
	public void copy(ClassRoom toCopy){
		try{
			this.name = (Integer.parseInt(toCopy.getName()) + this.floor*100) + "";
		}
		catch(java.lang.NumberFormatException e){}
		this.hallway = toCopy.getHall();
	}

	public String	getName (){return name;}
	public int 		getFloor(){return floor;}
	public int 		getHall (){return hallway;}	
	public String 	toString(){return name + " " + hallway + " ";}
	
}

class HallEnd extends ClassRoom{

	private int hall2;
	public HallEnd(String n, int f, int h, int h2){
		super(n, f, h);
		this.hall2 = h2;
	}

	public int gethall2(){return hall2;}

}
