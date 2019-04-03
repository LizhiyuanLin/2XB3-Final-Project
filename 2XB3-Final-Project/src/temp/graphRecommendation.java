import java.io.IOException;
import java.util.ArrayList;

public class graphRecommendation {

	public static void main(String[] args) throws IOException {
		RelaventIndustries industries = new RelaventIndustries();
		String[] s = {"General merchandise stores",
				"Personal and household goods repair and maintenance",
				"Lime and gypsum product manufacturing",
				"Gambling industries",
				"Support activities for road transportation",
				"Industrial machinery manufacturing",
				"Forestry and logging",
				"Support activities for transportation"};
		ArrayList<String> listOfRecommendations = industries.giveRecommendations(s);
		for(int i = 0;i<listOfRecommendations.size();i++){
			System.out.println(listOfRecommendations.get(i));
		}
		System.out.println(listOfRecommendations.size());
	}
}
