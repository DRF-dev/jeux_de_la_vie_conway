package gof;

public class AliveCell implements Cell {
	
	@Override
	public Cell newGeneration(int nbNeighbours) {
		
		if (nbNeighbours == 3 || nbNeighbours == 2) {
			return new AliveCell();
		}
		return new DeadCell();
		
 	}
	
	@Override
	public boolean isAlive() {
		return true;
	}

	@Override
	public String getAsString() {
		return "0";
	}

}
