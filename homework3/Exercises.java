import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercises{
	
	public static List<Integer> change(int cents){
		if(cents<0) {
			throw new IllegalArgumentException("Amount cannot be negative");
		}
		List<Integer> list = new ArrayList<Integer>();
		int[] coins= {25,10,5,1};
		for(int i=0; i<4; i++) {
			int currentCoin=cents/coins[i];
			cents-=currentCoin*coins[i];
			list.add(currentCoin);
		}
		return Collections.unmodifiableList(list);
	}
	
	public static String stretched(String toBeStretched) {
		
		
	}
	
	
}