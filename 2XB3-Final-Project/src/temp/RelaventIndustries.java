package temp;
import java.io.File;
import java.util.ArrayList;

/**
 *  A class that provide recommendation services
 *  @author Lizhiyuan Lin
 */
public class RelaventIndustries {
	private SymbolGraph graph;
	/**
    	 * Initializes an empty RelaventIndustries ooject
    	 */
	public RelaventIndustries(){
		String path = new File("").getAbsolutePath();
		graph = new SymbolGraph(path + "//Data//graph.txt", ";");
	}
	/**
    	 * Generates recommendations based on given industry names
    	 * param V the number of vertices
    	 *
    	 * @param  s The list of industry names that needs recommendations.
    	 * @return the list of recommendations of industry names.
    	 */
	public ArrayList<String> giveRecommendations(String[] s) {
		//initialize a list for recommendations
		ArrayList<String> list = new ArrayList<String>();
		//loop to search for relevant industry names
		for(int i = 0;i<s.length;i++){
			java.util.Iterator<Integer> adjacents = graph.graph().adj(graph.indexOf(s[i])).iterator();
			while(adjacents.hasNext()){
				//keep looking for industry names if the size of the list is less than 10
				if(list.size()<10)	list.add(graph.nameOf(adjacents.next()));
				//break the loop and return the result when it hits the maximum size of 10
				else{
					i = s.length+1;
					break;
				}
			}
		}
		
		return list;
    }
	/**
    	 * Returns the underlying graph of the object
    	 * @return the underlying graph
    	 */
	public SymbolGraph getGraph(){
		return graph;
	}
}
