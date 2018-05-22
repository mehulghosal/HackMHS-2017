import java.util.*;
import java.io.*;

public class Hallway{

	private ArrayList<ClassRoom> hall;
	private int floor;
	private ClassRoom start; //leftmost, clossest to millburn ave classroom, start of list
	private ClassRoom end;   //end of list, last class in hall

	public Hallway(ArrayList<ClassRoom> h, int f){
		this.hall  = h;
		this.floor = f;
		this.start = hall.get(0);
		this.end   = hall.get(hall.size()-1);
	}

	//gets the next classroom in the hall, to the right or further from millburn ave
	public ClassRoom getRight(ClassRoom c){
		int ind = hall.indexOf(c);
		if(ind!=hall.size()){return hall.get(ind+1);}
		return null;//if last element, return null
	}
	public ClassRoom getLeft (ClassRoom c){
		int ind = hall.indexOf(c);
		if(ind!=0){return hall.get(ind-1);}
		return null;
	}


	public ArrayList<ClassRoom> getHall() {return hall ;}
	public int 					getFloor(){return floor;}
	public ClassRoom 			getStart(){return start;}
	public ClassRoom 			getEnd()  {return end  ;}
}