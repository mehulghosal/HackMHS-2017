import java.util.*;
import java.io.*;

public class NMain{

	static Scanner sc;

	public static void main(String[] args) {
		ArrayList<Floor> map = createMap();
		Floor f1 = map.get(0);
		Hallway h1 = f1.getFloor().get(0);
		Hallway h2 = f1.getFloor().get(1);
		ClassRoom c1 = h1.getClass(0);
		System.out.println(c1);
		ClassRoom c2 = h2.getClass(0);
		System.out.println(c2);
		//System.out.println(f1);
		System.out.println(findRoute(map, c2, c1));
	}

	public static ArrayList<Floor> createMap(){
		String inp = "";
		ArrayList<Floor> output = new ArrayList<Floor>();
		try{
			sc = new Scanner(new File("data.txt"));
		}
		catch(FileNotFoundException e){
			System.out.println("file error");
		}

		String str;
		while(true){
			str = sc.nextLine();
			if(str.equals("end")){break;}//break statement
			else{
				inp += str + " ";
			}
		}

		String[] hold;
		String[] hold2;
		String[] splitByFloor = inp.split("Floor");//array of two strings

		for(int j = 0; j < 2; j++){
			Floor f = new Floor(j);
			output.add(f);
			hold = splitByFloor[j].split("Hallway");
			int len = hold.length;
			for(int i = 0; i < len; i++){
				Hallway h = new Hallway(i, j+1);
				f.add(h);
				hold2 = hold[i].split(" ");
				for(int k = 0; k < hold2.length; k++){
					String s2 = hold2[k];
					if(!s2.equals("")){
						ClassRoom c = new ClassRoom(s2, j+1, i, k-1);
						if(k==0 || k==hold2.length-1){c.setEnd(true);}
						h.add(c);
					}
				}

			}
		}

		Floor third  = new Floor(3);
		Hallway thirdFloorHall = new Hallway(11,3);
		third.add(thirdFloorHall);
		output.add(third);
		ArrayList<ClassRoom> toCopy = output.get(0).getFloor().get(11).getHall();
		for(ClassRoom c: toCopy){
			thirdFloorHall.add(ClassRoom.copy(new ClassRoom(3), c));
		}

		output.get(0).getFloor().remove(0);
		output.get(1).getFloor().remove(0);
		return output;

	}

	public static ArrayList<ClassRoom> findRoute(ArrayList<Floor> map, 
		ClassRoom from, ClassRoom to){

		ArrayList<ClassRoom> route = new ArrayList<ClassRoom>();
		int ff = from.getFloor(), fh = from.getHall(), fromID = from.getID();
		int tf = to.getFloor()  , th = to.getHall()	 , toID   = to.getID();
		
		Floor   fromFloor= map.get(ff-1)		, toFloor = map.get(tf-1);
		Hallway fromHall = fromFloor.getHall(fh), toHall  = toFloor.getHall(th);
		//System.out.println(ff); System.out.println(tf);
		//System.out.println(fromHall); System.out.println(toHall);
		
		if(from.equals(to)){return route;}

		//same floor
		if(ff==tf){
			//same halllway
			if(fh==th){
				route.addAll(new ArrayList<ClassRoom>(subList(fromHall.getHall(), fromID, toID)));
			}
			//different halls
			else{
				ArrayList<Hallway> halls = subList(fromFloor.getFloor(), fh, th);
				System.out.println(halls);
				Hallway current = fromHall;

				while(true){
					if(true){break;}
				}
			}
		}
		//different floors
		else {
						
		}
		
		return route;

	}

	//rewrote arraylsit method subList so works if start
	public static <T> ArrayList<T> subList(ArrayList<T> list, int start, int to){
		ArrayList<T> output = new ArrayList<T>();
		if(start<to){
			for(int i = start; i<=to; i++){output.add(list.get(i));}
		}
		else{
			for(int i = start; i>=to; i--){output.add(list.get(i));}
		}
		return output;
	}

}