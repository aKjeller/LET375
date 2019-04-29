package del1;

public class StressTest implements Runnable{
	int alg = 0;
	private Thread t;
	private long result = 0;
	private long average = 0;
	
	public StressTest(int alg) {
		this.alg = alg;
	}
	public void printRes() {
		System.out.println("Alg: " + alg + " has finished 10 500x500 matrixes in: " + result + "ms with an average of: " + average + "ms");
	}
	
	@Override
	public void run() {
		System.out.println("Starting alg: " + alg);
		long time = System.currentTimeMillis();
		for ( int n = 1; n <= 1000; n++ ) {
			int[][] m = MaxSumTwoDimensions.randMatrix(100,100);
			if(alg == 1) {
				MaxSumTwoDimensions.maxSubMatrixSumEvenBetter(m);
					System.out.println("alg: " + alg + " has finished: " + n + " matrixes");
			}
			else {
				MaxSumTwoDimensions.maxSubMatrixSumLegendary(m);
				if(n % 100 == 0)
					System.out.println("alg: " + alg + " has finished: " + n + " matrixes");
			}
		}
		result = System.currentTimeMillis() - time;
		average = result / 20;
		printRes();
	}
	public void start() {
		if (t == null) {
			t = new Thread (this);
			t.start ();
		}
	}
}
