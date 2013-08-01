import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

public class Grid {

	private ArrayList<Cell> livingCells;
	
	public Grid(ArrayList<Cell> bacs) {
		livingCells = new ArrayList<Cell>();
		for (int i = 0; i < bacs.size(); i++)
			livingCells.add(bacs.get(i));
	}

	public ArrayList<Cell> neighbourOfAliveCells() {
		ArrayList<Cell> neighbourCells = new ArrayList<Cell>();
		for (int i = 0; i < livingCells.size(); i++) {
			Cell currentCell = livingCells.get(i);
			
			neighbourCells.add(new Cell(new Point(currentCell.getPosition().x - 1, currentCell.getPosition().y - 1)));
			neighbourCells.add(new Cell(new Point(currentCell.getPosition().x - 1, currentCell.getPosition().y    )));
			neighbourCells.add(new Cell(new Point(currentCell.getPosition().x - 1, currentCell.getPosition().y + 1)));
			neighbourCells.add(new Cell(new Point(currentCell.getPosition().x    , currentCell.getPosition().y - 1)));
			neighbourCells.add(new Cell(new Point(currentCell.getPosition().x    , currentCell.getPosition().y + 1)));
			neighbourCells.add(new Cell(new Point(currentCell.getPosition().x + 1, currentCell.getPosition().y - 1)));
			neighbourCells.add(new Cell(new Point(currentCell.getPosition().x + 1, currentCell.getPosition().y    )));
			neighbourCells.add(new Cell(new Point(currentCell.getPosition().x + 1, currentCell.getPosition().y + 1)));
		}
		Collections.sort(neighbourCells);
		System.out.println(neighbourCells);
		return neighbourCells;
	}
	
	public ArrayList<Cell> countRepeatedCell(ArrayList<Cell> neighbourCells) {
		ArrayList<Cell> neighbourCount = new ArrayList<Cell>();
		for(int i = 0; i < neighbourCells.size();) {
			Cell currentCell = neighbourCells.get(i);
			Cell newCell = currentCell;
			int count = 0;
			while(i < neighbourCells.size() && 
					currentCell.compareTo(neighbourCells.get(i)) == 0) {
				count++;
				i++;
			}
			newCell.setNeighbourCount(count);
			neighbourCount.add(newCell);
		}
		System.out.println(neighbourCount);
		return neighbourCount;
	}
	
	public ArrayList<Cell> populateNextGen(ArrayList<Cell> countcell) {

		ArrayList<Cell> nextlist = new ArrayList<Cell>();
		for (int i = 0; i < countcell.size(); i++) {
			Cell c = countcell.get(i);
			int val = c.getNeighbourCount();
			
			if (isAlive(c)) {
				if((val < 2) || (val > 3)) 
					livingCells.remove(c);
				else
					nextlist.add(c);
			} else {
				if(val == 3)
					nextlist.add(c);
			}
		}
		
		return nextlist;
	}
	
	public boolean isAlive(Cell c) {
		for (int i = 0; i < livingCells.size() ; i++) {
			if (c.compareTo(livingCells.get(i)) == 0)
				return true;
		}
		return false;
	}
	
	public String toString() {
		
		String bacteriaListToString = "";
		for (int i = 0; i < livingCells.size(); i++)
			bacteriaListToString += livingCells.get(i).getPosition();
		return bacteriaListToString;
	}
	
}
