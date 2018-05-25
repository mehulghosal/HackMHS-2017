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

	//copies the info from toCopy --> c
	//also, modifies the name to fit the floor
	public static ClassRoom copy(ClassRoom c, ClassRoom toCopy){
		String n = toCopy.getName();
		try{
			c.name = (Integer.parseInt(n) + c.floor*100) + "";
		}
		catch(java.lang.NumberFormatException e){
			if(n.equals("MainGym")){//maingym --> guidance
				c.name = "GuidanceOffice";
			}
			else if(n.indexOf("Bathroom")!=-1){//its a bathroom
				c.name = n;
			}
			else if(n.indexOf("Stairs")!=-1){//its a staircase
				c.name = n;
			}
		}
		c.hallway = toCopy.getHall();
		return c;
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
