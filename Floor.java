import java.util.*;
import java.io  .*;

public class Floor{

	private ArrayList<Hallway> floor;
	private int identity;

	public Floor(ArrayList<Hallway> f, int i){
		this.floor = f;
		this.identity = i;
	}
	public Floor(int i){
		this.floor = new ArrayList<Hallway>();
		this.identity = i;
	}

	public ArrayList<Hallway> 	getFloor(){return floor;}
	public int 					getID	(){return identity;}
	public String 				toString(){
		String s = "";
		for(Hallway h: floor){s+=h.toString() + "\n";}
		return s;
	}
	public Hallway				getHall(int i){
		for(Hallway h: floor){
			if(h.getID()==i){return h;}
		}
		return null;
	}

	public void 				setFloor(ArrayList<Hallway> f){
		this.floor = f;
	}
	public void 				add		(Hallway h){
		floor.add(h);
	}

	public boolean 				contains(ClassRoom cl){
		for(Hallway h: floor){
			for(ClassRoom c: h.getHall()){
				if(c.getName().equals(cl.getName())){return true;}
			}
		}
		return false;
	}

}