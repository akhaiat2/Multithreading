class WorkerThread implements Runnable
{
	int num;
	int numDivisors;
	int[] numDivisorsArray; 
	
	public WorkerThread (int num, int[] numDivisorsArray) {
		this.num = num;
		numDivisors = 0;
		this.numDivisorsArray = numDivisorsArray;
	}
	public void run() {
		int numberOfDivisors = 0; 
		for (int i = 1; i < 100000; i++) {
		    if (100000 % i == 0)
		    {
		    	numDivisors++;
		    }
		}
	 numDivisorsArray[num] = numDivisors;
	 if (num > numDivisorsArray[0])
	 {
		 numDivisorsArray[0] = num;
	 }
	}
}
public class Driver {
	
	static int intWithMaxDivisors = 0;
	static int maxDivisors = 0;
		
	public static int numberDivisors (int number) {
		int numberOfDivisors = 0; 
		for (int i = 1; i < number; i++) {
		    if (number % i == 0)
		    {
		    	numberOfDivisors++;
		    }
		}
		return numberOfDivisors;
	}
	
	public static void main (String [] args)
	{
		int intWithMaxDivisors = 0;
		int maxDivisors = 0;
		int [] numDivisorsArray = new int[100001];
		for (int i = 1; i <= 100000; i++)
		{
			Thread thrd = new Thread (new WorkerThread(i, numDivisorsArray));
			thrd.start();
		}
		
		for (int i = 1; i<= 100000; i++)
		{
			if (numDivisorsArray[i] > maxDivisors) {
				maxDivisors = numDivisorsArray[i];
				intWithMaxDivisors = 1;
			}
		}
		System.out.println(intWithMaxDivisors);
		System.out.println(maxDivisors);
	}	
}
