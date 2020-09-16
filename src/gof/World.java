package gof;

import java.util.Random;

public class World {

	// Constructors
	private int nbrColumn;
	private int nbrLines;
	private int generation;
	private Cell[][] values;

	public World(int nbrColumn, int nbrLines) {
		this.nbrColumn = nbrColumn;
		this.nbrLines = nbrLines;
		this.generation = 0;
		this.values = new Cell[nbrLines][nbrColumn];
		this.initialize();
	}

	// Methods
	public void initialize() {
		for (int i = 0; i < nbrLines; i++) {
			for (int j = 0; j < nbrColumn; j++) {
				Random rand = new Random();
				int number = rand.nextInt(2);

				if (number == 0) {
					values[i][j] = new AliveCell();
				}

				if (number == 1) {
					values[i][j] = new DeadCell();
				}
			}
		}
	}

	public void newGeneration() {

		Cell[][] tempsNewValue = new Cell[nbrLines][nbrColumn];
		System.out.println("Generation :" + generation);

	
			for (int i = 0; i < this.values.length; i++) {
				for (int j = 0; j < this.values[i].length; j++) {
					//Ici on est dans une cellule
					//Pour chaque cellule, on verifie si elle a des voisin
					int nbNeighbours = 0;
					for (int x = i-1; x <= i + 1; x++) {
						for (int y = j-1; y <= j+1; y++) {
							//On ne prend pas la cellule donc x=0 et y=0
							if(x == i && y == j) {
								continue;
							} else if((x >= 0 && y >= 0)) {
								if(x < this.values.length && y < this.values[i].length){
									if (this.values[x][y].isAlive()) { 
										nbNeighbours++;
									}
								}
							}
						}
					}
					tempsNewValue[i][j] = this.values[i][j].newGeneration(nbNeighbours);
				}
			}

		
		this.values = tempsNewValue;
		this.generation += 1;

		for (Cell[] cells : this.values) {
			for (Cell cell : cells) {
				System.out.print(cell.getAsString() + " ");
			}
			System.out.println("");
		}
	}

	@Override
	public String toString() {
		return ("[nbrColumn:" + this.nbrColumn + " , nbrLines:" + this.nbrLines + "]");
	}

}
