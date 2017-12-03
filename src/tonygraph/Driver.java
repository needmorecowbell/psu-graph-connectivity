/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tonygraph;
import java.util.Scanner;
/**
 *
 * @author atm5343
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter Number of Nodes in Graph: ");
        int nodes = in.nextInt();
        in.nextLine(); //clear register
        
        
        System.out.println("Number of Nodes: "+nodes);
        
        int [][] adjacencyMatrix = new int [nodes][nodes];
        System.out.println("[INFO] Enter Adjacencies in the form of: 0,1,0,1,1"); //clarify this, not sure how right now
        System.out.println("[INFO] 0 = No Connection");
        System.out.println("[INFO] 1 = Connection");
        
        System.out.println("************************");
        
        String adjacencyLine= "";
        for(int x =0; x<nodes; x++){
            System.out.println("Enter the Adjacency for node ("+x+"): ");
            
            adjacencyLine= in.nextLine();
            
            System.out.println("Line: "+adjacencyLine);
            
            String [] adjacenciesOfNode= adjacencyLine.split(","); //use comma as delimiter
            
            for(int y=0;y<nodes;y++){
                adjacencyMatrix[x][y]= Integer.parseInt(adjacenciesOfNode[y]);
                //fill each line of the adjacency matrix using split adjacenciesOfNode array
                System.out.println("[INFO] Converted adjacency matrix line number ["+x+","+y+"]");
            }
           
            
            
        }
        
        
        //now lets display the current adjacency matrix
        System.out.println("Adjacency Matrix: ");
                
        for(int x=0;x<nodes;x++){
            System.out.print("Node ["+x+"]: ");
            for(int y=0;y<nodes;y++){
                System.out.print(""+adjacencyMatrix[x][y]+", ");
            }
            System.out.println();
        }
        
        System.out.println("Checking for connectivity...");
        boolean isConnected = false;
        //now that it's loaded into the array, lets analyze for connectivity
        for(int x=0;x<nodes;x++){
            System.out.println("[INFO] Checking Node["+x+"] for connectivity");
            isConnected=false;
            for(int y=0;y<nodes;y++){
                if(x == y && adjacencyMatrix[x][y] == 1){  
                    System.out.println("[INFO] Node ["+x+"] is connected to itself");    
                }else{
                    
                    if(adjacencyMatrix[x][y] ==1){ //there is a connection
                        System.out.println("[INFO] Node["+x+"] is connected to the graph");
                        isConnected = true;
                        break; //moving on to the next node to check for connectivity
                    }
                    
                    if(y == nodes-1 &&  isConnected == false){ //if we have reached the end and this node is still not connected... 
                        System.out.println("[INFO] Node["+x+"] is NOT Connected");
                        System.out.println("Graph is not Connected.");
                        System.exit(0); //remove this to continue program, this shows that graph is not connected so the loop can be broken out of.
                    }
                    
                    
                }
                
                
                
            }
        }
        //if the loop isn't broken out of, it must be connected...
        System.out.println("Graph is connected.");
    }
    
    
    
    
}
