import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class ConcurrentAddToList {

	private static List<Integer> a;
	
	private static int count = 0;
	private static class AddWorker implements Runnable{

		@Override
		public void run() {
			for (int i=0; i<= 10000 ; i++){
				a.add(Integer.valueOf(count));
				count ++;
			}
		}
		
	}
	
	public static void main(String[] args){
		// this line cause race condition
		// and cause array index out of bound
		a = new ArrayList<Integer>();
		
		// to prevent problem, try this
		// a = new Vector<Integer>();
		
		Thread t1 = new Thread(new AddWorker());
		t1.setName("t1");
		Thread t2 = new Thread(new AddWorker());
		t2.setName("t2");
		Thread t3 = new Thread(new AddWorker());
		t3.setName("t3");
		Thread t4 = new Thread(new AddWorker());
		t4.setName("t4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		for (int c = 0; c < a.size() ; c++){
			if (a.get(c) == null){
				// print null index
				System.out.println(c);
			}
		}
	}
}
