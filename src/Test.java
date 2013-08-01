import java.awt.Point;
import java.util.ArrayList;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<Cell> bacteria = new ArrayList<Cell>();
		bacteria.add(new Cell(new Point(0,0)));
		bacteria.add(new Cell(new Point(2,0)));
		bacteria.add(new Cell(new Point(2,1)));
		bacteria.add(new Cell(new Point(2,2)));
		Grid obj = new Grid(bacteria);
		
		bacteria = obj.populateNextGen(obj.countRepeatedCell(obj.neighbourOfAliveCells()));
		System.out.println(bacteria);
	}
}
