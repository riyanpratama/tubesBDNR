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
public class Graphs {

    //membuat list node yang dimiliki graph
    private ArrayList<Node> node = new ArrayList<Node>();

    //menambahkan node kedalam graph
    public void addNode(Node n) {
        node.add(n);
    }

    public void addEdge(String info, String node1, String node2) {
        //pengecekan node harus ada terlebih dahulu
        if (cekNode(node1) && cekNode(node2)) {
            //mencari posisi node yang akan dihubungkan ke node lain/n2
            Node n1 = cariNode(node1);
            Node n2 = cariNode(node2);
            n1.addEdge(new Edge(info, n2));
            n2.addEdge(new Edge(info, n1));
        }
    }

    public Node cariNode(String info) {
        for (Node e : node) {
            if (info.contains(e.getInfo())) {
                return e;
            }
        }
        return null;
    }

    //mengambil array node
    public ArrayList<Node> getNode() {
        return node;
    }

    //mengambil ukuran array node/jumlah node
    public int getSizeNode() {
        return node.size();
    }

    //mengambil jumlah edge
    public int getSizeedge() {
        int total = 0;
        for (Node i : node) {
            total += i.getArrayEdge().size();
        }
        return total;
    }

    //untuk menghapus node graph Undirected
    public void deleteNodeUndirected(String info) {
        Node n = cariNode(info);
        //hapus node yang memiliki hubungan, untuk kasus undirected
        for (Edge e : n.getArrayEdge()) {
            e.getNode().deleteEdge(n);
        }
        //hapus semua edge yang dimiliki
        n.deleteEdge();
        //hapus node
        node.remove(node.indexOf(n));
    }

    //untuk menghapus node graph Directed
    public void deleteNodeDirected(String info) {
        Node n = cariNode(info);

        if (node.contains(n)) {
            //hapus node yang memiliki hubungan, untuk kasus directed
            for (Node i : node) {
                for (Edge e : i.getArrayEdge()) {
                    if (e.getNode().equals(n)) {
                        i.deleteEdge(n);
                    }
                }

            }
            //hapus semua edge yang dimiliki
            n.deleteEdge();
            //hapus node
            node.remove(node.indexOf(n));
        }
    }

    //cek apakah terdapat node yang dicari
    public boolean cekNode(String info) {
        Node n = new Node(info);
        //agar constains bekerja, gunakan method equals di class node
        return node.contains(n);
    }

    //cek apakah terdapat edge yang dicari
    public boolean cekEdge(String info) {
        for (Node i : node) {
            for (Edge e : i.getArrayEdge()) {
                if (e.getInfo().contains(info)) {
                    return true;
                }
            }
        }
        return false;
    }

    //view all data
    public String view() {
        String lihat = "";
        if (!node.isEmpty()) {
            for (Node i : node) {
                lihat += i.toString() + "\n";
            }
        } else {
            return null;
        }
        return lihat;
    }

}
