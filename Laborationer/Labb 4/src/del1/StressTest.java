package del1;

public class StressTest implements Runnable{
	int alg = 0;
	private Thread t;
	private long average = 0;
	private int testLength = 10000;
	private int size = 256;
	private int completed = 0;
	
	public StressTest(int alg) {
		this.alg = alg;
	}
	public void printRes() {
		System.out.println("n^" + alg + " has finished " + completed + " matrixes with the size " + size + " with an average of " + average + "ms");
	}
	
	@Override
	public void run() {		
		System.out.println("Starting alg n^" + alg);
		long time = System.currentTimeMillis();
		for ( int n = 1; n <= testLength; n++ ) {
			int[][] m = MaxSumTwoDimensions.randMatrix(size,size);
			if(alg == 4) {
				MaxSumTwoDimensions.maxSubMatrixSumEvenBetter(m);
			}
			else {
				MaxSumTwoDimensions.maxSubMatrixSumLegendary(m);
			}
			average = (System.currentTimeMillis() - time) / n;
			completed ++;
		}
	}
	public void start() {
		if (t == null) {
			t = new Thread (this);
			t.start ();
		}
	}
	public static void main(String args[]) {
    	StressTest a = new StressTest(3);
    	StressTest b = new StressTest(4);
        a.start();
        b.start();
        while(true) {
        	try {
				Thread.sleep(3000);
				a.printRes();
				b.printRes();
				System.out.println("");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	
        }
	}
}
