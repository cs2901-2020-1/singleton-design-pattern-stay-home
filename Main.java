public class Main {
	public static void main(String[] args){ 
        int n = 8; // define number of threads and call a for loop for parallel execution
        for (int i=0; i<8; i++){ 
            Thread singletonThreads = new Thread(new MultiThread()); 
            singletonThreads.start(); 
        } 
    } 
}
