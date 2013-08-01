import java.awt.Point;
import java.util.ArrayList;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<Cell> colony = new ArrayList<Cell>();
		colony.add(new Cell(new Point(0,0)));
		colony.add(new Cell(new Point(2,0)));
		colony.add(new Cell(new Point(2,1)));
		colony.add(new Cell(new Point(2,2)));
		
        Grid grid = new Grid(colony);
		
		colony = grid.populateNextGen(grid.countRepeatedCell(grid.neighboursOfAliveCells()));
		
        System.out.println(colony);
	}
}
