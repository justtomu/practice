package dijkstra;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;


public class Algorithm {

    public Graph graph = new Graph();
    public ArrayList<Node> nodes = new ArrayList<Node>();



    public ArrayList<StepResults> getResult(){
        return this.graph.step_res;
    }

    public String run_alg (Node start) {
        StringBuilder result = new StringBuilder();

        System.out.println(start);
        if(start == null) {
            System.out.println("The error of start");
            return null;
        }
        Graph new_graph = Dijkstra.calculateShortestPathFromSource(this.graph, start);

        graph = null;
        graph = new_graph;
        for (Node node : graph.getNodes()) {
            result.append(node.getName()).append(' ');
            result.append(node.getDistance());
            var dist = node.getShortestPath();
            if (dist.size() > 0) {
                result.append(": ");
            }
            for (int i = 0; i < dist.size(); i++) {
                result.append(dist.get(i).getName());
                if (i != dist.size() - 1) {
                    result.append("->");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }

    public void read_graph_from_nodes(ArrayList<Node> nodes_list) {
        this.graph = new Graph();
        this.nodes = nodes_list;
        for (Node node : nodes_list) {
            this.graph.addNode(node);
        }
    }

    public void read_graph_from_file(String filename) throws Exception {
        String data = Read(filename).strip();
        ArrayList<Character> letters = new ArrayList<Character>();
        int counter = 0;
        while (counter < data.length()) {
            char letter = data.charAt(counter);
            if (Character.isAlphabetic(letter) && !letters.contains(letter)) {
                letters.add(data.charAt(counter));
            }
            counter += 1;
        }

        for (Character letter : letters) {
            nodes.add(new Node(letter.toString()));
        }

        for (String line : data.split("[\\r\\n]+")) {
            String[] edge = line.split(" ");
            String name1 = edge[0];
            Node node1 = null;
            for (Node el : nodes) {
                if (el.getName().equals(name1)) {
                    node1 = el;
                }
            }
            if (node1 == null) {
                throw new Exception("[ERROR] Can't read file. Check rules u v weight");
            }
            String name2 = edge[1];
            Node node2 = null;

            for (Node el : nodes) {
                if (el.getName().equals(name2)) {
                    node2 = el;
                }
            }

            if (node2 == null) {
                throw new Exception("[ERROR] Can't read file. Check rules u v weight");
            }

            node1.addDestination(node2, Integer.parseInt(edge[2]));

        }

        for (Node node : nodes) {
            this.graph.addNode(node);
        }

    }


    public String Read(String filename){
        StringBuilder content = new StringBuilder();
        try (FileReader reader = new FileReader(filename)){
            int i;
            while ((i=reader.read()) != -1)
                content.append((char) i);
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void clear() {
        this.graph = null;
        this.nodes = null;
        this.graph = new Graph();
        this.nodes = new ArrayList<Node>();
    }
}