import java.awt.Point;

public class Cell implements Comparable<Cell> {

	private Point position;
	private Integer neighbourCount;

	public Cell(Point position) {
		this.position = position;
		neighbourCount = 0;
	} 

	public Point getPosition() {
		return position;
	}

	public String toString() {
		return position.x + " " + position.y + " " + neighbourCount;
	}

	public Integer getNeighbourCount() {
		return neighbourCount;
	}

	public void setNeighbourCount(Integer neighbourCount) {
		this.neighbourCount = neighbourCount;
	}
	@Override
	public int compareTo(Cell c) {
		if (this.position.x > c.position.x)
			return 1;
		else if (this.position.x < c.position.x)
			return -1;
		else {
			if (this.position.y > c.position.y)
				return 1;
			else if (this.position.y < c.position.y)
				return -1;
		}
		return 0;
	}
	
}
