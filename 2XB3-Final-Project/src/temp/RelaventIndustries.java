import java.io.File;
import java.util.ArrayList;

public class RelaventIndustries {
	private SymbolGraph graph;
	public RelaventIndustries(){
		String path = new File("").getAbsolutePath();
		graph = new SymbolGraph(path + "\\data\\graph.txt", ";");
	}
	public ArrayList<String> giveRecommendations(String[] s) {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0;i<s.length;i++){
			java.util.Iterator<Integer> adjacents = graph.graph().adj(graph.indexOf(s[i])).iterator();
			while(adjacents.hasNext()){
				if(list.size()<10)	list.add(graph.nameOf(adjacents.next()));
				else{
					i = s.length+1;
					break;
				}
			}
		}
		
		return list;
    }
	public SymbolGraph getGraph(){
		return graph;
	}
}
