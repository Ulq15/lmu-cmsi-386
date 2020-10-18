import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		toBeStretched= toBeStretched.replaceAll("\\s+", "");
		List<String> characters = Pattern.compile("\\P{M}\\p{M}*+").matcher(toBeStretched).results()
				.map(MatchResult::group).collect(Collectors.toList());
		String stretched = "";
		for(int i=0; i<characters.size(); i++) {
			for(int j=0; j<i+1; j++) {
				stretched+=characters.get(i);
			}
		}
		return stretched;
	}
	
	public static <T> Set<T> mapThenUnique(List<T> items, Function<T,T> lambda) {
		return items.stream().map(lambda).collect(Collectors.toSet());
	}
	
	public static void powers(int base, int limit, Consumer<Integer> lambda) {
		int power = 0;
		while(Math.pow(base, power)<=limit) {
			lambda.accept((int) Math.pow(base, power));
			power++;
		}
	}
	
	public static Stream<Integer> powers(int base){
		return Stream.iterate(1, i -> i*base);
	}
	
	
	
}