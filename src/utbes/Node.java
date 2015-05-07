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
public class Node {

    private String info;
    private String label;
    private ArrayList<String> Attribut;
    private ArrayList<Edge> edge;
    private boolean status = false;

    //construktor node menginisiasi variabel info dan instansiasi list edge
    public Node(String attribut) {
        Attribut = new ArrayList<>();
        edge = new ArrayList<Edge>();
        setAttribut(attribut);
    }

    //menambahkan info edge kedalam list edge yang dimiliki node
    public void addEdge(Edge e) {
        edge.add(e);
    }

    //delete semua edge pada node utama
    public void deleteEdge() {
        edge.clear();
    }

    //delete edge pada node lain yang berhubungan 
    public void deleteEdge(Node n) {
        edge.remove(edge.indexOf(getEdge(n)));
    }

    //set status
    public void setStatus(boolean t) {
        status = t;
    }

    //ambil status
    public boolean getStatus() {
        return status;
    }

    //mengambil arraylistEdge
    public ArrayList<Edge> getArrayEdge() {
        return edge;
    }

    //mengambil edge berdasarkan pencarian
    public Edge getEdge(Node info) {
        Edge n = new Edge(info);
        Edge e;
        e = edge.get(edge.indexOf(n));
        return e;
    }

    //mengambil info node
    public String getInfo() {
        return this.info;
    }

    //mengambil info label
    public String getLabel() {
        return this.label;
    }

    //mengambil semua info edge
    public String getEdge() {
        String lihat = "";
        if (!edge.isEmpty()) {
            for (Edge i : edge) {
                lihat += i.getInfo() + " - " + i.getNode().getInfo() + ", ";
            }
        } else {
            return null;
        }
        return lihat;
    }

    //mengambil info node dan edge-edgenya
    public String toString() {
        String Aktor = getInfo() + " [-] " + getEdge();
        return Aktor;
    }

    @Override
    //agar equals/kesamaan objek node berdassarkan atribut info
    public boolean equals(Object object) {
        if (object != null && object instanceof Node) {
            Node n = (Node) object;
            return this.info.equals(n.info);
        }
        return false;
    }

    public void setAttribut(String attribut) {
        int temp1 = 0, temp2 = 0;
        int cek = 0;
        for (int i = 0; i < attribut.length(); i++) {
            if (cek == 0) {
                if (attribut.charAt(i) == ':') {
                    temp2 = i + 1;
                } else if (attribut.charAt(i) == ',')  {
                    this.info = attribut.substring(temp2, i);
                    cek=1;
                }else if((i + 1) == attribut.length()){
                    this.info = attribut.substring(temp2, i+1);
                    cek=1;
                }
            }
            if (attribut.charAt(i) == ',' || (i + 1) == attribut.length()) {
                if (attribut.contains("judul")) {
                    this.label = "movie";
                } else if (attribut.contains("nama")) {
                    this.label = "aktor";
                } else {
                    this.label = "unkown";
                }
                Attribut.add(attribut.substring(temp1, i));
                temp1 = i;
            }
        }
    }

}
