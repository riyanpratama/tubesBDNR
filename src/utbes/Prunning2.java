/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utbes;

import java.util.ArrayList;

/**
 * cek banyak
 *
 * @author dion
 */
public class Prunning2 {
    ArrayList<Node> n=new ArrayList<>();
   
    public void run(FeasibilityMates M) {
        boolean cek = false;
        for (Mapping m : M.getMapping()) {
            for (Node s : m.getlistmap()) {
                for (Edge p2 : s.getArrayEdge()) {
                    for (Edge p1 : m.getPatern().getArrayEdge()) {
                        if(p2.getNode().getInfo().contains(p1.getNode().getInfo())){
                            p1.getNode().setStatus(true);
                        }
                    }
                }
                if(!cekStatus(m)){
                  n.add(s);
                }              
            resetStatus(M); 
            }
            for(Node e:n){
                m.deleteListMap(e);
            }
            n.clear();  
        }
    
    }
   
    public boolean cekStatus(Mapping m){
        boolean state=true;
        for(Edge e:m.getPatern().getArrayEdge()){
            state=state&&e.getNode().getStatus();
        }
        return state;
    }
  
    
    public void resetStatus(FeasibilityMates M){
        for (Mapping m: M.getMapping()){
            m.getPatern().setStatus(false);
        }
    }
    
  

}
