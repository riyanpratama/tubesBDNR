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
 */
public class Edge {

    private String info;
    private ArrayList<String>  Attribut;
    
    //buat menyimpan info node
    private Node node;

    //construktor edge untuk menginisiasi variabel info dan node;
    public Edge(String attribut, Node n) {
        this.info = attribut;
        this.node = n;
        Attribut=new ArrayList<>();
        setAttribut(attribut);
    }

    public Edge(Node n) {
        this.node = n;
    }
    
    public void setNode(Node n){
        node=n;
    }

    //mengambil info edge
    public String getInfo() {
        return this.info;
    }

    //mengambil info node
    public Node getNode() {
        return this.node;
    }

    //agar equals/kesamaan objek edge berdassarkan atribut info
    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof Edge) {
            Edge n = (Edge) object;
            return this.node.equals(n.node) || this.info.equals(n.info);
        }
        return false;
    }

     public void setAttribut(String attribut){
        int temp=0;
        for(int i=0;i<attribut.length();i++){
            if(attribut.charAt(i)==','||(i+1)==attribut.length()){
                Attribut.add(attribut.substring(temp,i));
                temp=i;
            }
        }
    }

}
