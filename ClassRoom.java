public class ClassRoom extends Tile
{
	
	protected String name;
	
	public ClassRoom()
	{
		//super();
	}
	
	public ClassRoom(int x, int y, String namex)
	{
		super(x, y);
		this.name = namex;
		isOccupied = true;
	}
	
	public String getName()
	{
		return name;
	}
	
	
}
