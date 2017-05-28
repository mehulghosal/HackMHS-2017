import java.util.*;

public class Main{
	
	public static void main(String[] args){
		
		createMap();
		System.out.println(map[0][0].getX());
		
	}

	private static Tile[][] map = new Tile[47][39];
	
	public static void createMap(){
		
		for(int i = 0; i < 47; i++){
			for(int j =0; j < 39; j++){
				
				map[i][j] = new Tile(i, j);
				
			}
		}
		
		//every index is multiplied by 2
		
		map[18][10] = new ClassRoom(18,10, "Gym");
		map[20][10] = new ClassRoom(20,10, "Nurse");
		map[21][10] = new Staircase(21,10);
		map[21][6] = new ClassRoom(21, 6, "Main Office");
		map[26][6] = new Staircase(26, 6);
		map[27][6] = new ClassRoom(27, 6, "113");
		map[29][6] = new ClassRoom(29, 6, "111");
		map[31][6] = new ClassRoom(31, 6, "109");
		map[33][6] = new ClassRoom(33, 6, "107");
		
		map[26][10] = new ClassRoom(26, 10, "Bathroom");
		map[28][10] = new ClassRoom(28, 10, "112");
		map[30][10] = new ClassRoom(30, 10, "110");
		map[32][10] = new ClassRoom(32, 10, "108");
		map[34][10] = new ClassRoom(34, 10, "106");
		map[36][10] = new Staircase(36, 10);
		
		map[38][10] = new ClassRoom(38, 10, "Cafeteria");
		map[46][8] = new ClassRoom(46, 8, "103");
		map[46][6] = new ClassRoom(46,6, "102");
		map[46][4] = new Staircase(46, 4);
		map[44][2] = new ClassRoom(46,6, "101");
		map[46][0] = new ClassRoom(46,6, "100");
		
		map[24][12] = new ClassRoom(24,12, "Athletic Office");
		map[24][13] = new ClassRoom(24,13, "117");
		map[24][16] = new ClassRoom(24,16, "119");
		map[24][19] = new ClassRoom(24,19, "121");
		map[24][21] = new ClassRoom(24,21, "123");
		map[24][24] = new ClassRoom(24,24, "125");
		map[24][26] = new ClassRoom(24,26, "Bathroom");
		map[23][26] = new ClassRoom(24,26, "128");
		map[22][28] = new Staircase(21,28);
		map[23][30] = new ClassRoom(23,30, "127");
		map[27][30] = new ClassRoom(27,30, "129");
		map[30][30] = new ClassRoom(30,30, "131");
		map[32][30] = new ClassRoom(32,30, "133");
		map[34][30] = new ClassRoom(34,30, "135");
		map[36][30] = new ClassRoom(36,30, "137");
		map[38][30] = new Staircase(38,30);
		map[40][30] = new ClassRoom(40,30, "Bathroom");
		
		map[28][26] = new ClassRoom(28,26, "130");
		map[30][26] = new ClassRoom(30,26, "132");
		map[32][26] = new ClassRoom(32,26, "134");
		map[34][26] = new ClassRoom(34,26, "136");
		map[36][26] = new ClassRoom(36,26, "138");

		map[40][31] = new ClassRoom(40,31, "173");
		map[40][35] = new ClassRoom(40,35, "173A");
		map[40][36] = new ClassRoom(40,36, "175");

		map[44][30] = new ClassRoom(44,30, "171");
		map[44][32] = new ClassRoom(44,32, "172");
		map[44][34] = new ClassRoom(44,34, "174");
		map[44][36] = new ClassRoom(44,36, "175");
		map[44][38] = new Staircase(44,38);
		
		map[40][22] = new ClassRoom(40,22, "139");
		map[44][22] = new ClassRoom(44,22, "141");
		map[46][22] = new ClassRoom(46,22, "143");
		
		map[40][19] = new ClassRoom(40,19, "Bathroom");
		map[42][18] = new ClassRoom(42,19, "140");
		map[44][18] = new ClassRoom(40,19, "142");
		
		
		
	}
}