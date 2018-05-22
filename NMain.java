import java.util.*;
import java.io.*;

public class NMain{

	static Scanner s;

	public static void read(){
		ArrayList<String> input =  new ArrayList<String>();
		try{
			s = new Scanner(new File("data.txt"));
		}
		catch(FileNotFoundException e){
			System.out.println("file error");
		}

		String str;
		while(true){
			str = s.nextLine();
			if(str.equals("end")){break;}//break statement
			else{
				input.add(str);
			}
		}

	}

	public static void createMap(){
		Floor first  = new Floor();
		first.

		Floor second = new Floor();
		Floor third  = new Floor();
	}


}