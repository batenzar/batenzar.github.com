import java.util.List;


public class GenericClassTest {

	public static class A <R>{
		public List<String> list;
	}

	public static void main(String args[]){
		// this compile
		A<?> a =new A<Object>();
		String[] array01 = a.list.toArray(new String[0]);
		
		// this won't compile
//		A b =new A<Object>();
//		String[] array02 = b.list.toArray(new String[0]);
	}
	
}