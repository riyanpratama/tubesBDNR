/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utbes;

import java.util.ArrayList;

/**
 *
 * @author dion
 * melakukan pengecekan terhadap node-node yang memiliki kesamaan antara graph G dan pattern P
 */
public class FeasibilityMates {
    private ArrayList<Mapping> mapping;
   
    
    public FeasibilityMates(){
        mapping = new ArrayList<>();       
    }
    
    //menambahkan list mapping
    public void addMapping(Node n){
        Mapping m = new Mapping(n);
        mapping.add(m);
    }
    
    //mengambil data mapping
    public ArrayList<Mapping> getMapping(){
        return this.mapping;
    }
    
   
    //menambahkan ke list kemungkinan yang muncul
    public void run(Graphs G, Graphs P){
        for(int j=0;j<P.getSizeNode();j++){
            addMapping(P.getNode().get(j));
            for(int i=0;i<G.getSizeNode();i++){
                if(G.getNode().get(i).getInfo().contains(P.getNode().get(j).getInfo())){
                    mapping.get(j).addListMap(G.getNode().get(i));
                }
            }
         }
    }
   

    
  
    
    //view semua data
    public String View(){
       String hasil=null;
        if(!mapping.isEmpty()){
            hasil="";
            for(Mapping n : mapping){
                hasil+=n.view()+"\n";
            }
        }
        return hasil;
    }
}
