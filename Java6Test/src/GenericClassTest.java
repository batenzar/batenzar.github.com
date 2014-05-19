import java.util.List;


public class GenericClassTest {

	public static class A <R>{
		public List<String> list;
	}

	public static void main(String args[]){
		A a =new A();
		String[] array = a.list.toArray(new String[0]);
	}
	
}
