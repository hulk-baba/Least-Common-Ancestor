import java.io.StringReader;
import java.util.Set;
import java.io.*;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedPseudograph;
import org.jgrapht.io.DOTImporter;
import org.jgrapht.io.EdgeProvider;
import org.jgrapht.io.GraphImporter;
import org.jgrapht.io.VertexProvider;



public class CommonParent {
	private static final String NL = "\n";
	
	
	public static String readFile(String fileName) throws IOException {
		
		
//		InputStream is = new FileInputStream(fileName); 
//		BufferedReader buf = new BufferedReader(new InputStreamReader(is)); 
//		String line = buf.readLine(); 
//		StringBuilder sb = new StringBuilder();
//		while(line != null){ 
//			sb.append(line).append("\n");
//			line = buf.readLine();
//		} 
//		String fileAsString = sb.toString();
//		System.out.println("Contents (before Java 7) : " + fileAsString);


	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
//	        System.out.println("Line" + line);
	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } catch(Exception e){
	    	e.getMessage();
	    }
	    finally {
	        br.close();
	    }
		return "";
	    
	}
	
	
//	@SuppressWarnings("unused")
//	private static GraphImporter<String, DefaultEdge> buildImporter()
//    {
//        return new DOTImporter<String, DefaultEdge>(
//            (label, attributes) -> label, (from, to, label, attributes) -> new DefaultEdge());
//    }
	
	public static void main(String args[]){
		Graph<String, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);
		g.addVertex("a");
	    g.addVertex("b");
	    g.addVertex("c");
	    g.addVertex("d");
	    
	    g.addEdge("a","c");
	    g.addEdge("b", "c");
	    g.addEdge("a", "d");
	    g.addEdge("b", "d");
	    System.out.println(g.toString());
//	    System.out.println(new TarjanLowestCommonAncestor<>(g).calculate("a", "c", "d"));
	    System.out.println(g.toString());
	    NaiveLcaFinder<String, DefaultEdge> gFinder = new NaiveLcaFinder<>(g);  
	    String c="c";
	    String d="d";
	    Set<String> gAns = gFinder.findLcaS(c,d);
	    for (String s : gAns) {
	        System.out.println("LCA with Graph G are "+s);
	    }

        try {
        	 System.out.println("In try part");
        	 System.out.println(g.toString());

        	/*String input = "digraph G {" + NL +
                    "  subgraph cluster0 {" + NL +
                    "    node [style=filled,color=white];" + NL+
                    "    style=filled;" + NL+
                    "    color=lightgrey;" + NL+
                    "    a0->a1->a2->a3;" + NL+
                    "    label=\"process #1\";" + NL+
                    "  }"+NL+
                    "  subgraph cluster1 {" + NL+
                    "    node [style=filled];"+NL+
                    "    b0->b1->b2->b3;" + NL+
                    "    label=\"process #2\";" + NL+
                    "    color=blue"+NL+
                    "  }"+NL+
                    "  start -> a0;"+NL+
                    "  start -> b0;"+NL+
                    "  a1 -> b3;"+NL+
                    "  b2 -> a3;"+NL+
                    "  a3 -> end;"+NL+
                    "  b3 -> end;"+NL+
                    "  start [shape=Mdiamond];"+NL+
                    "  end [shape=Msquare];" + NL+ 
                    "}";*/
        	/* String input = "digraph GOT {"+NL+
        				"graph [ bgcolor = whitesmoke ]"+NL+
        				"subgraph cluster_stark {"+NL+
        					"style = filled ;"+NL+
        					"color = lightblue ;"+NL+
        					"label = \" House Stark \" ;"+NL+
        					"node [ style = filled , color = white ];"+NL+
        					"Rickard ;"+NL+
        					"Brandon ; Eddard ; Benjen ; Lyanna ;"+NL+
        					"Robb ; Sansa ; Arya ; Brandon ; Rickon ;"+NL+
        					"node [ shape = doublecircle , style = filled , color = white ];"+NL+
        					"Jon ;"+NL+
        					"Rickard -> Brandon ;"+NL+
        					"Rickard -> Eddard ;"+NL+
        					"Rickard -> Benjen ;"+NL+
        					"Rickard -> Lyanna ;"+NL+
        					"Eddard -> Robb ;"+NL+
        					"Eddard -> Sansa ;"+NL+
        					"Eddard -> Arya ;"+NL+
        					"Eddard -> Brandon ;"+NL+
        					"Eddard -> Rickon ;"+NL+
        					"Eddard -> Jon [ label = \" bastard \" , color = azure4 ];"+NL+
        				"}"+NL+
        				"subgraph cluster_baratheon {"+NL+
        					"style = filled ;" +NL+
        					"color = chocolate3 ;" +NL+
        					"label = \" House Baratheon \" ;" +NL+
        					"node [ style = filled , color = white ];" +NL+
        					"Ormund ; Steffon ; Robert ; Stannis ; Renly ; Shireen ; Joffrey ; Myrcellar ; Tommen ;" +NL+
        					"Ormund -> Steffon ;" +NL+
        					"Rhaelle -> Steffon ;" +NL+
        					"Ormund -> Rhaelle ;" +NL+
        					"Rhaelle -> Ormund ;" +NL+
        					"Steffon -> Robert ;" +NL+
        					"Steffon -> Stannis ;" +NL+
        					"Steffon -> Renly ;" +NL+
        					"Stannis -> Shireen ;" +NL+
        					"Robert -> Joffrey ;" +NL+
        					"Robert -> Myrcellar ;" +NL+
        					"Robert -> Tommen ;" +NL+
        				"}" +NL+
        				"subgraph cluster_lannister {"+NL+
        					"style = filled ;"+NL+
        					"color = cornsilk3 ;"+NL+
        					"label = \" House Lannister \" ;"+NL+
        					"node [ style = filled , color = white ];"+NL+
        					"Tywin ; Joanna ; Jaime ; Cersei ; Tyrion ;"+NL+
        					"Tywin -> Joanna ;"+NL+
        					"Joanna -> Tywin ;"+NL+
        					"Joanna -> Jaime ;"+NL+
        					"Joanna -> Cersei ;"+NL+
        					"Joanna -> Tyrion ;"+NL+
        					"Tywin -> Jaime ;"+NL+
        					"Tywin -> Cersei ;"+NL+
        					"Tywin -> Tyrion ;"+NL+
        					"Jaime -> Cersei ;"+NL+
        					"Cersei -> Jaime ;"+NL+
        					"Robert -> Cersei ;"+NL+
        					"Cersei -> Robert ;"+NL+
        					"Cersei -> Joffrey ;"+NL+
        					"Cersei -> Myrcellar ;"+NL+
        					"Cersei -> Tommen ;"+NL+
        					"Jaime -> Joffrey [ style = dashed ];"+NL+
        					"Jaime -> Myrcellar [ style = dashed ];"+NL+
        					"Jaime -> Tommen [ style = dashed ];"+NL+
        				"}"+NL+
        				"Lyanna -> Rhaegar [ style = dashed , label = \" ? \" ];"+NL+
        				"Rhaegar -> Lyanna [ style = dashed , label = \" ? \" ];"+NL+
        				"Lyanna -> Jon [ style = dashed , label = \" ? \" ];"+NL+
        				"Rhaegar -> Jon [ style = dashed , label = \" ? \" ];"+NL+
        				"labelloc = \" t \" ;"+NL+
        				"fontsize =50;"+NL+
        				"fontcolor = lightslategrey ;"+NL+
        				"fontname = \" Bookman Old Style Bold Italic \" ;"+NL+
        				"label = \" Game of Thrones Family Tree \""+NL+
        				"}" ;*/
        	 	
        	 String input = "digraph GOT {"+NL+
     				"graph [ bgcolor = whitesmoke ]"+NL+
     				"subgraph cluster_baratheon {"+NL+
     					"style = filled ;" +NL+
     					"color = chocolate3 ;" +NL+
     					"label = \" House Baratheon \" ;" +NL+
     					"node [ style = filled , color = white ];" +NL+
     					"Ormund ; Steffon ; Robert ; Stannis ; Renly ; Shireen ; Joffrey ; Myrcellar ; Tommen ;" +NL+
     					"Ormund -> Steffon ;" +NL+
     					"Rhaelle -> Steffon ;" +NL+
     					"Ormund -> Rhaelle ;" +NL+
     					"Steffon -> Robert ;" +NL+
     					"Steffon -> Stannis ;" +NL+
     					"Steffon -> Renly ;" +NL+
     					"Stannis -> Shireen ;" +NL+
     					"Robert -> Joffrey ;" +NL+
     					"Robert -> Myrcellar ;" +NL+
     					"Robert -> Tommen ;" +NL+
     				"}" +NL+
     				"subgraph cluster_lannister {"+NL+
     					"style = filled ;"+NL+
     					"color = cornsilk3 ;"+NL+
     					"label = \" House Lannister \" ;"+NL+
     					"node [ style = filled , color = white ];"+NL+
     					"Tywin ; Joanna ; Jaime ; Cersei ; Tyrion ;"+NL+
     					"Joanna -> Jaime ;"+NL+
     					"Joanna -> Cersei ;"+NL+
     					"Joanna -> Tyrion ;"+NL+
     					"Tywin -> Jaime ;"+NL+
     					"Tywin -> Cersei ;"+NL+
     					"Tywin -> Tyrion ;"+NL+
     					"Cersei -> Joffrey ;"+NL+
     					"Cersei -> Myrcellar ;"+NL+
     					"Cersei -> Tommen ;"+NL+
     					"Jaime -> Joffrey [ style = dashed ];"+NL+
     					"Jaime -> Myrcellar [ style = dashed ];"+NL+
     					"Jaime -> Tommen [ style = dashed ];"+NL+
     				"}"+NL+
     				"labelloc = \" t \" ;"+NL+
     				"fontsize =50;"+NL+
     				"fontcolor = lightslategrey ;"+NL+
     				"fontname = \" Bookman Old Style Bold Italic \" ;"+NL+
     				"label = \" Game of Thrones Family Tree \""+NL+
     				"}" ;
        	 	
//        	 	System.out.println("String as read from file ") ;
//        	 	String input = readFile("/home/atul/JGRAPHT/demo2.dot");
//        	 	System.out.print("input "+input) ;
	        	VertexProvider<String> vp = (a, b) -> a;
                EdgeProvider<String, DefaultEdge> ep = (f, t, l, a) -> new DefaultEdge();
                GraphImporter<String, DefaultEdge> importer = new DOTImporter<String, DefaultEdge>(vp, ep);
                DirectedPseudograph<String, DefaultEdge> graph = new DirectedPseudograph<String, DefaultEdge>(DefaultEdge.class);
                importer.importGraph(graph, new StringReader(input));
                System.out.println("Graph \"graph \" as parsed ");
                System.out.println(graph.toString());
//              System.out.println(new TarjanLowestCommonAncestor<>(graph).calculate("start", "a0", "b0"));
                NaiveLcaFinder<String, DefaultEdge> graphFinder = new NaiveLcaFinder<>(graph);
                
                //experimenting with a pair of vertices for all LCAs
                Set<String> graphAns = graphFinder.findLcaS( "Joffrey" , "Tommen");
                if(graphAns.isEmpty()){
                	System.out.println("We have got an empty set ");
                }
                for (String s : graphAns) {
        	        System.out.println("LCAs of graph \"graph\" "+s);
        	    }
                //experimenting with a pair of vertices for first encounter LCA
                String lca = graphFinder.findLca("Joffrey", "Tommen");
                System.out.println("Graph \"graph \" as parsed ");
                System.out.println(graph.toString());
                System.out.println("LCA of graph \"graph\" "+lca );
                
                
                
        } catch (Exception e) {
                e.getMessage();
        }
   
	}
	
}
