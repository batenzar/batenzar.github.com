import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class TestGenericCasting<T extends Serializable> {
	public void test(Object a){
		List<List<String>> opresults = new ArrayList<List<String>>();
		List<T> dataIterator = new ArrayList<T>((List<T>) opresults);
	}
}
