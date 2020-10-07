import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercises{
	
	public static List<Integer> change(int cents){
		if(cents<0) {
			throw new IllegalArgumentException("Amount cannot be negative");
		}
		List<Integer> list = new ArrayList<Integer>();
		Integer quarters = cents/25;
		cents=cents-quarters*25;
		Integer dimes = cents/10;
		cents=cents-dimes*10;
		Integer nickles = cents/5;
		cents=cents-nickles*5;
		list.add(quarters);
		list.add(dimes);
		list.add(nickles);
		list.add(cents);
		List<Integer> immutable = Collections.unmodifiableList(list);
		return immutable;
	}
	
	
}