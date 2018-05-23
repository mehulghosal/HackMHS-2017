import java.util.*;
import java.io.*;

public class NMain{

	static Scanner sc;

	public static void main(String[] args) {
		createMap();
	}

	public static ArrayList<Hallway> read(){
		String inp = "";
		ArrayList<Hallway> output = new ArrayList<Hallway>();
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

		String[] arr = inp.split("Hallway");
		for(int i = 0; i < arr.length; i++){
			String[] hold = arr[i].split(" ");
			Hallway h = new Hallway(i, 1);
			output.add(h);
			for(String s2: hold){
				if(!s2.equals("")){
					ClassRoom c = new ClassRoom(s2, 1, i);
					h.add(c);
				}
			}
		}

		return output;

	}

	public static void createMap(){
		Floor first  = new Floor(1);
		ArrayList firstFloorHalls = read();
		first.setFloor(firstFloorHalls);
		System.out.println(first);
		Floor second = new Floor(2);
		Floor third  = new Floor(3);
	}

}