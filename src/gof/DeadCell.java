package gof;

public class DeadCell implements Cell {
	
	@Override
	public Cell newGeneration(int nbNeighbours) {
		
		if (nbNeighbours == 3) {
			return new AliveCell();
		}
		return new DeadCell();
		
	}
	
	@Override
	public boolean isAlive() {
		return false;
	}
	
	@Override
	public String getAsString() {
		return "-";
	}
	
}
