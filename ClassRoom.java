import java.util.*;
import java.io.*;
import java.lang.*;

public class ClassRoom{
	
	private String name;
	private int id;
	private int floor;
	private int hallway;
	private boolean hallend;

	public ClassRoom(String n, int f, int h, int id){
		this.name = n;
		this.floor = f; 
		this.hallway = h;
		this.id = id;
		this.hallend = false;
	}
	public ClassRoom(int f){
		this.floor = f;
		this.hallend = false;
	}

	//copies the info from toCopy --> c
	//also, modifies the name to fit the floor
	public static ClassRoom copy(ClassRoom c, ClassRoom toCopy){
		String n = toCopy.getName();
		try{
			int nameAsInt = Integer.parseInt(n);
			if (c.getFloor() == 3){
				c.name = (nameAsInt + (c.floor-1)*100) + "";
			}
			
		}
		catch(java.lang.NumberFormatException e){
			if(n.indexOf("Bathroom")!=-1){//its a bathroom
				c.name = n;
			}
			else if(n.indexOf("Stairs")!=-1){//its a staircase
				c.name = n;
			}
		}
		c.hallway = toCopy.getHall();
		c.id = toCopy.getID();
		return c;
	}

	public String	getName (){return name;}
	public int 		getID	(){return id;}
	public int 		getFloor(){return floor;}
	public int 		getHall (){return hallway;}	
	public boolean 	getEnd	(){return hallend;}
	public String 	toString(){return name + " " + id+ " ";}

	public void 	setEnd	(boolean b){this.hallend = b;}
	
}