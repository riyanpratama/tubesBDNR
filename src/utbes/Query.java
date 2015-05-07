/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utbes;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.read.biff.BiffException;

/**
 *
 * @author Dion Tanjung
 */
public class Query {

    private Graphs G;

    public Node createNode(String query) {
        int temp = 0;
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) == '{') {
                temp = i + 1;
            } else if (query.charAt(i) == '}') {
                Node o = new Node(query.substring(temp, i));
                G.addNode(o);
                return o;
            }
        }
        return null;
    }

//    public void query(String query) {
//        Node n = null;
//        int temp = 0;
//        if (query != null || !query.contains("Enter")) {
//            if (query.contains("create node")) {
//                 
//            } else if (query.contains("match")) {
//                if (query.contains("where")) {
//                    if (query.contains("-")) {
//                        for (int i = 0; i < query.length(); i++) {
//                            if (query.charAt(i) == '{') {
//                                temp = i + 1;
//                            } else if (query.charAt(i) == '}') {
//                                if (G.cariNode(query.substring(temp, i)) != null) {
//                                    n = G.cariNode(query.substring(temp, i));
//                                    if (n != null) {
//                                        Graphs E = new Graphs();
//                                        E.addNode(n);
//                                        for (Edge e : n.getArrayEdge()) {
//                                            E.addNode(e.getNode());
//                                            e.getNode().deleteEdge();
//                                        }
//                                 
//
//                                    }
//                                } else {
//                                    jTextArea2.setText("not Found");
//                                }
//                            }
//                        }
//                    } else {
//                        for (int i = 0; i < query.length(); i++) {
//                            if (query.charAt(i) == '{') {
//                                temp = i + 1;
//                            } else if (query.charAt(i) == '}') {
//                                if (G.cariNode(query.substring(temp, i)) != null) {
//                                    n = G.cariNode(query.substring(temp, i));
//                                    if (n != null) {
//                                        Gstream = new Convert(G);
//                                        Gstream.run();
//                                        Gstream.displayG("highlight " + n.getInfo());
//                                        jTextArea2.setText(n.toString());
//
//                                    }
//                                } else {
//                                    jTextArea2.setText("not Found");
//                                }
//                            }
//                        }
//                    }
//                } else {
//                    if (query.contains("aktor")) {
//                        Gstream = new Convert(G);
//                        Gstream.run();
//                        Gstream.displayG("aktor");
//                    } else if (query.contains("movie")) {
//                        Gstream = new Convert(G);
//                        Gstream.run();
//                        Gstream.displayG("movie");
//                    }
//                }
//            } else if (query.contains("create edge")) {
//                String n1 = "", n2 = "", info = "";
//                int t = 0;
//                for (int i = 0; i < query.length(); i++) {
//                    if (query.charAt(i) == '{') {
//                        temp = i + 1;
//                    } else if (query.charAt(i) == '}') {
//                        if (t == 0) {
//                            n1 = query.substring(temp, i);
//                        } else {
//                            n2 = query.substring(temp, i);
//                        }
//                    } else if (query.charAt(i) == '[') {
//                        temp = i + 1;
//                    } else if (query.charAt(i) == ']') {
//                        info = query.substring(temp, i);
//                    }
//                }
//                Node a = G.cariNode(n1);
//                Node b = G.cariNode(n2);
//                if (a != null && b != null) {
//                    G.addEdge(info, n1, n2);
//                    jTextArea2.setText("insert node success");
//                    Gstream = new Convert(G);
//                    Gstream.run();
//                    Gstream.displayG("");
//
//                } else {
//                    jTextArea2.setText("Node yang dimaksud tidak ditemukan");
//                }
//            } else if (jTextArea1.getText().contains("Open")) {
//                try {
//                    // TODO add your handling code here:
//                    id = new ImportDataset(jTextArea1.getText().substring(5));
//                } catch (IOException ex) {
//                    Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (BiffException ex) {
//                    Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                id.Run(G);
//                jTextArea2.setText("Success");
//                jTextArea2.setText(G.view());
//                System.out.println(G.view());
//                Gstream = new Convert(G);
//                Gstream.run();
//                Gstream.displayG("");
//                //analisis();
//                //  setText();
//            } else if (jTextArea1.getText().contains("return all")) {
//                Gstream = new Convert(G);
//                Gstream.run();
//                Gstream.displayG("");
//                jTextArea2.setText(G.view());
//            }
//        }
//
//    }
}
