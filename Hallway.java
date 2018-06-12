import java.util.*;
import java.io.*;

public class Hallway{

	private ArrayList<ClassRoom> hall;
	private int identity;
	private int floor;
	//where halls end, it is expected to connect to another hallway
	private HallEnd start; //rightmost, closest to millburn ave classroom, start of list
	private HallEnd end;   //end of list, last class in hall, to the left

	public Hallway(ArrayList<ClassRoom> h, int i, int f){
		this.hall  = h;
		this.identity = i;
		this.floor = f;
		this.start = (HallEnd)hall.get(0);
		this.end   = (HallEnd)hall.get(hall.size()-1);
	}
	public Hallway(ClassRoom[] h, int i, int f){
		this.hall  = (ArrayList<ClassRoom>)Arrays.asList(h);
		this.identity = i;
		this.floor = f;
		this.start = (HallEnd)hall.get(0);
		this.end   = (HallEnd)hall.get(hall.size()-1);
	}
	public Hallway(int i, int f){
		this.hall = new ArrayList<ClassRoom>();
		this.identity = i;
		this.floor = f;
	}

	//gets the next classroom in the hall, to the right or further from millburn ave
	public ClassRoom getLeft (ClassRoom c){
		int ind = hall.indexOf(c);
		if(ind!=hall.size()){return hall.get(ind+1);}
		return null;//if last element, return null
	}
	public ClassRoom getRight(ClassRoom c){
		int ind = hall.indexOf(c);
		if(ind!=0){return hall.get(ind-1);}
		return null;
	}

	public ArrayList<ClassRoom> getHall (){return hall;}
	public int 					getID 	(){return identity;}
	public int 					getFloor(){return floor;}
	public HallEnd	 			getStart(){return start;}
	public HallEnd	 			getEnd  (){return end;}
	public ClassRoom 			getClass(int i){
		for(ClassRoom c: hall){
			if(c.getID() == i){return c;}
		}
		return null;
	}
	public int 					getLen	(){return hall.size();}
	public String 				toString(){
		String s = "";
		for(ClassRoom c: hall){s+=c.toString();}
		return s;
	}
	public boolean 				contains(ClassRoom c){return hall.contains(c);}

	public void 				add		(ClassRoom c){
		hall.add(c);
	}
	public void 				setClass(int i, ClassRoom c){
		hall.set(i, c);
	}
	public void 				setFloor(int f){
		this.floor = f;
	}

}