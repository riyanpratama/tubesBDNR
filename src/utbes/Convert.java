/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utbes;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import org.graphstream.algorithm.APSP;
import org.graphstream.algorithm.APSP.APSPInfo;
import org.graphstream.algorithm.BetweennessCentrality;

import org.graphstream.algorithm.Centroid;
import org.graphstream.algorithm.Eccentricity;
import org.graphstream.algorithm.Toolkit;
import org.graphstream.algorithm.measure.ClosenessCentrality;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.file.FileSourceDGS;
import org.graphstream.stream.file.FileSourceDGS;

/**
 *
 * @author dion
 */
public class Convert {

     Graph Gstream = null;
    Graphs G;
    private String styleSheet = "node { fill-color : black;}node.marked {fill-color:red;}";
    private String betweness;
    private String Closeness;
    private String ecentricity;

    public Convert(Graphs p) {
        this.G = p;
        this.Gstream = new SingleGraph("Graph");
    }

    public void run() {
        int temp = 0;
        for (Node i : G.getNode()) {
            Gstream.addNode(i.getInfo());
        }
        addEdges();
    }

    public void Run() {
        int temp = 0;
        for (Node i : G.getNode()) {
            Gstream.addNode(i.getInfo());
        }
    }

    //tambahkan edge
    public void addEdges() {
        int temp = 0;
        for (int i = 0; i < G.getSizeNode(); i++) {
            Node f = G.cariNode(G.getNode().get(i).getInfo());
            //iterasi tiap edge untuk mendapatkan hubungan antar node 
            for (Edge j : f.getArrayEdge()) {
                //jika status node1 dan node2 false maka hubungkan node tersebut
                if (!f.getStatus() && !j.getNode().getStatus()) {
                    Gstream.addEdge(j.getInfo() + "-" + temp, Gstream.getNode(f.getInfo()), Gstream.getNode(j.getNode().getInfo()));
                    temp++;
                }
            }
            f.setStatus(true);
        }
        resetStatus();
    }

    //reset status tiap node ke awal
    public void resetStatus() {
        for (Node f : G.getNode()) {
            f.setStatus(false);
        }
    }

    public void D_Aktor() {
        for (org.graphstream.graph.Node n : Gstream.getEachNode()) {
            n.addAttribute("ui.hide");
            for (org.graphstream.graph.Edge e : n.getEachEdge()) {
                e.addAttribute("ui.hide");
            }
            for (Node i : G.getNode()) {
                if (i.getLabel().contains("aktor")) {
                    if (i.getInfo().contains(n.getId())) {
                        n.removeAttribute("ui.hide");
                        n.addAttribute("ui.style", "fill-color:rgb(0,188,200);");
                    }
                }
            }
            n.addAttribute("ui.label", n.getId());
        }
    }

    public void D_Movie() {
        for (org.graphstream.graph.Node n : Gstream.getEachNode()) {
            n.addAttribute("ui.hide");
            for (org.graphstream.graph.Edge e : n.getEachEdge()) {
                e.addAttribute("ui.hide");
            }
            for (Node i : G.getNode()) {
                if (i.getLabel().contains("movie")) {
                    if (i.getInfo().contains(n.getId())) {
                        n.removeAttribute("ui.hide");
                        n.addAttribute("ui.style", "fill-color:rgb(255,188,200);");
                    }
                }
            }
            n.addAttribute("ui.label", n.getId());
        }

    }

    public void D_Highlight(String ceklis) {
        for (org.graphstream.graph.Node n : Gstream.getEachNode()) {
            for (Node i : G.getNode()) {
                if (i.getLabel().contains("aktor")) {
                    if (i.getInfo().contains(n.getId())) {
                        n.addAttribute("ui.style", "fill-color:rgb(0,188,200);");
                    }
                }
                if (i.getInfo().contains(ceklis.substring(10))) {
                    if (i.getInfo().contains(n.getId())) {
                        n.addAttribute("ui.style", "fill-color:rgb(250,0,0);");
                    }
                }
            }
            n.addAttribute("ui.label", n.getId());
        }
    }

    public void D_All() {
        for (org.graphstream.graph.Node n : Gstream.getEachNode()) {
            for (Node i : G.getNode()) {
                if (i.getLabel().contains("aktor")) {
                    if (i.getInfo().contains(n.getId())) {
                        n.addAttribute("ui.style", "fill-color:rgb(0,188,200);");
                    }
                }
            }
            n.addAttribute("ui.label", n.getId());
        }
    }

    public void D_Relasi(String info){
          for (org.graphstream.graph.Node n : Gstream.getEachNode()) {
            for (Node i : G.getNode()) {
                if (i.getLabel().contains("aktor")) {
                    if (i.getInfo().contains(n.getId())) {
                        n.addAttribute("ui.style", "fill-color:rgb(0,188,200);");
                    }
                }
                if (i.getInfo().contains(info.substring(10))) {
                    if (i.getInfo().contains(n.getId())) {
                        n.addAttribute("ui.style", "fill-color:rgb(250,0,0);");
                    }
                }
            }
            n.addAttribute("ui.label", n.getId());
        }
    }
    
    public View displayG(String ceklis) {
        if (ceklis.contains("aktor")) {
            D_Aktor();
        } else if (ceklis.contains("movie")) {
            D_Movie();
        } else if (ceklis.contains("highlight")) {
            D_Highlight(ceklis);
        } else if (ceklis.contains("-")) {
            D_Relasi(ceklis.substring(1));
        } else {
            D_All();
        }

        Viewer viewer = new Viewer(Gstream, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.enableAutoLayout();
        View view = viewer.addDefaultView(false);
        return view;
    }

    public String getBetweness() {
        return this.betweness;
    }

    public String getCloseness() {
        return this.Closeness;
    }

    public String getEcentricity() {
        return this.ecentricity;
    }

    public void addNOde(String s) {
        Gstream.addNode(s);
    }

    public ArrayList<String> Ecentricity() {
        ArrayList<String> sss = new ArrayList<>();
        APSP apsp = new APSP();
        apsp.init(Gstream);
        apsp.compute();
        Eccentricity eccentricity = new Eccentricity();
        eccentricity.init(Gstream);
        eccentricity.compute();
        for (org.graphstream.graph.Node n : Gstream.getEachNode()) {
            Boolean in = n.getAttribute("eccentricity");
            if (in) {
                sss.add(n.getId() + ": is ");
                ecentricity = n.getId();
            } else {
                sss.add(n.getId() + ": not");
            }
        }
        return sss;
    }

    public ArrayList<String> BEtweness() {
        ArrayList<String> sss = new ArrayList<>();
        double max = 0.0;
        String ss = null;
        BetweennessCentrality bcb = new BetweennessCentrality();
        bcb.init(Gstream);
        bcb.compute();
        for (org.graphstream.graph.Node n : Gstream.getEachNode()) {
            sss.add(n.getId() + " : " + n.getAttribute("Cb"));
            double s = n.getAttribute("Cb");
            if (max < s) {
                max = s;
                ss = n.getId();
            }

        }
        this.betweness = ss;
        return sss;
    }

    public ArrayList<String> Closenesss() {
        ArrayList<String> sss = new ArrayList<>();
        double max = 0.0;
        ClosenessCentrality cc = new ClosenessCentrality();
        cc.init(Gstream);
        cc.compute();
        for (org.graphstream.graph.Node n : Gstream.getEachNode()) {
            sss.add(n.getId() + " : " + n.getAttribute("closeness"));
            double s = n.getAttribute("closeness");
            if (max < s) {
                max = s;
                this.Closeness = n.getId();
            }

        }
        return sss;
    }

    public double getDIameter() {
        return Toolkit.diameter(Gstream);
    }


}
