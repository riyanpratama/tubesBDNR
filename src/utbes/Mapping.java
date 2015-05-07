/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utbes;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import java.util.ArrayList;

/**
 *
 * @author dion
 * digunakan untuk menyimpan mapping dari feasibility mates
 */
public class Mapping {
    private Node patern;
    private ArrayList<Node> listMap;
    
    public Mapping(Node node){
        this.patern=node;
        listMap = new ArrayList<>();       
    }
    
    public Node getPatern(){
        return patern;
    }
    
    //menambahkan daftar list
    public void addListMap(Node n){
        listMap.add(n);
    }
    
    //mengambil info
    public String getInfo(){
        return patern.getInfo();
    }
    
     //mengambil info
    public Node getPattertn(){
        return patern;
    }
    
    //mengambil array mapping
    public ArrayList<Node> getlistmap(){
        return listMap;
    }
    
    //mendapatkan semua data list
    public String getListmap(){
        String hasil=null;
        if(!listMap.isEmpty()){
            hasil="";
            for(Node n:listMap){
                hasil+=n.getLabel()+" ";
            }
        }
        return hasil;
    }
    
    //menghapus element 
    public void deleteListMap(Node info){
        listMap.remove(listMap.indexOf(info));
       
    }
    
    //view info dan list map
    public String view(){
        return getInfo()+": "+getListmap();
    }
     @Override
    //agar equals/kesamaan objek node berdassarkan atribut info
    public boolean equals(Object object) {
        boolean t=false;
        if (object != null && object instanceof Mapping) {
            Mapping n = (Mapping) object;
            t=this.patern.equals(n.patern);
        }

        return t;
    }
    
}
