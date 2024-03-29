import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
	
	public static <T,U> Set<U> mapThenUnique(List<T> items, Function<T,U> lambda) {
		return items.stream().map(lambda).collect(Collectors.toSet());
	}
	
	public static void powers(int base, int limit, Consumer<Integer> lambda) {
		int power = 0;
		while(Math.pow(base, power)<=limit) {
			lambda.accept((int) Math.pow(base, power));
			power++;
		}
	}
	
	public static IntStream powers(int base){
		return IntStream.iterate(1, i -> i*base);
	}
	
	static class MyString{
		String totalString="";
		public MyString and(String str) {
			totalString+=" "+str;
			return this;
		}
		public String ok() {
			return totalString.substring(1);
		}
		public String toString() {
			return totalString.substring(1);
		}
	}
	
	public static String say() {
		return "";
	}
	
	public static MyString say(String word) {
		MyString myStr = new MyString();
		myStr.and(word);
		return myStr;
	}
	
	public static <T> T twice(Function<T,T> function, T variable) {
		return function.andThen(function).apply(variable);
	}
	
	public static Optional<String> firstLongStringUppercased(int length, List<String> strings){
		try {
			String firstLong = strings.stream().filter(s->s.length()>length).findFirst().get();
			if(!firstLong.equalsIgnoreCase("empty")) {
				return Optional.of(firstLong.toUpperCase());
			}
			else {
				return Optional.empty();
			}
		} catch(Exception e) {
			return Optional.empty();
		}
	}
	
	public static List<String> topTenScorers(Map<String, List<String>> teamStatistics){
		if(teamStatistics.isEmpty()) {
			return List.of();
		}
		List<String> playersOver15 = new ArrayList<String>();
		for(String team : teamStatistics.keySet()) {
			List<String> players = teamStatistics.get(team);
			String currentPlayer="";
			for(String player : players) {
				String[] p=player.split(",");
				if(Integer.parseInt(p[1])>=15) {
					currentPlayer=p[0]+"|"+String.format("%.2f",Double.parseDouble(p[2])/Double.parseDouble(p[1]))+"|"+team;
					playersOver15.add(currentPlayer);
				}
			}
		}
		playersOver15.sort(new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				String[] firstPlayer=arg0.split("\\|");
				String[] secondPlayer=arg1.split("\\|");
				Double ppg1=Double.parseDouble(firstPlayer[1]);
				Double ppg2=Double.parseDouble(secondPlayer[1]);
				return ppg2.compareTo(ppg1);
			}
			
		});
	/*	
		teamStatistics.keySet().stream().flatMap((String team)
				->{List<String> players=teamStatistics.get(team);return players.stream().map((String player) 
				-> player+","+team);}).collect(Collectors.toList());
	*/
		return playersOver15.subList(0, 10);
	}
}