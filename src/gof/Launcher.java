package gof;

public class Launcher {
	public static void main(String[] args) {
		World newWorld = new World(80, 20);
		while (true) {
			newWorld.newGeneration();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
