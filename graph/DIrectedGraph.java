package graph;  // folder untuk menyimpan class

import java.util.*;  

class DirectedGraph {  // class untuk  graf berarah
    private Map<String, List<String>> adjacencyList;  // Daftar ketetanggaan untuk menyimpan graf

    public DirectedGraph() {  // Konstruktor untuk menginisialisasi graf
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan simpul (node) ke graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());  // Tambahkan simpul jika belum ada
    }

    // Metode untuk menambahkan sisi (edge) ke graf (hanya satu arah untuk graf berarah)
    public void addEdge(String source, String destination) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge dari sumber ke tujuan
        adjacencyList.get(source).add(destination);
    }

    // Metode untuk mendapatkan daftar tetangga dari node
    public List<String> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());  // Kembalikan daftar tetangga, atau daftar kosong jika tidak ada
    }

    // Metode untuk mencetak graf
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Metode utama untuk menjalnkan program
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");  // Buat edge dari A ke B
        graph.addEdge("A", "C");  // Buat edge dari A ke C
        graph.addEdge("B", "C");  // Buat edge dari B ke C
        graph.addEdge("C", "A");  // Buat edge dari C ke A
        graph.addEdge("C", "D");  // Buat edge dari C ke D

        graph.printGraph();  // Cetak graf untuk melihat hubungan antar node
    }
}
