import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;

public class WelcomeScreen extends JFrame {

    private JComboBox<String> InitialBox;
    private JComboBox<String> DestinationBox;
    private JButton createRouteButton;
    private JPanel Panel2;
    private JButton exitButton;
    private JLabel ValueLabel;
    private JLabel PathLabel;
    private JLabel MapLabel;
    private JComboBox<String> Continent1;
    private JComboBox<String> Continent2;
    private ContinentTree continentTree;

    public WelcomeScreen() {
        this.continentTree = new ContinentTree();

        Continent1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedContinent = (String) Continent1.getSelectedItem();
                if (!selectedContinent.equals("Select Continent")) {
                    InitialCities(selectedContinent);
                }
            }

            private void InitialCities(String continentName) {
                InitialBox.removeAllItems();
                Set<String> cities = continentTree.getCitiesByContinentSorted(continentName);
                for (String city : cities) {
                    InitialBox.addItem(city);
                }
            }
        });

        Continent2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedContinent = (String) Continent2.getSelectedItem();
                if (!selectedContinent.equals("Select Continent")) {
                    DestinationCities(selectedContinent);
                }
            }

            private void DestinationCities(String continentName) {
                DestinationBox.removeAllItems();
                Set<String> cities = continentTree.getCitiesByContinentSorted(continentName);
                for (String city : cities) {
                    DestinationBox.addItem(city);
                }
            }
        });

        setContentPane(Panel2);
        Panel2.setLocation(0,0);
        ImageIcon background = new ImageIcon("images/background.jpg");
        Image ScaledBg = background.getImage().getScaledInstance(650,400,Image.SCALE_AREA_AVERAGING);
        ImageIcon nc = new ImageIcon(ScaledBg);
        MapLabel.setIcon(nc);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == exitButton) {
                    System.exit(0);
                }
            }
        });

        createRouteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graph CityBindings = new Graph(true, false);
                Vertex Istanbul = CityBindings.addVertex("Istanbul");
                Vertex London = CityBindings.addVertex("London");
                Vertex Jerusalem = CityBindings.addVertex("Jerusalem");
                Vertex Amsterdam = CityBindings.addVertex("Amsterdam");
                Vertex NewYork = CityBindings.addVertex("New York");
                Vertex Tokyo = CityBindings.addVertex("Tokyo");
                Vertex Wuhan = CityBindings.addVertex("Wuhan");
                Vertex Mumbai = CityBindings.addVertex("Mumbai");
                Vertex Sofia = CityBindings.addVertex("Sofia");
                Vertex Budepeste = CityBindings.addVertex("Budepeste");
                Vertex Rio = CityBindings.addVertex("Rio De Jenario");
                CityBindings.addEdge(Tokyo, Wuhan, 4000);
                CityBindings.addEdge(Mumbai, Wuhan, 1000);
                CityBindings.addEdge(Sofia, Budepeste, 800);
                CityBindings.addEdge(Mumbai, Budepeste, 10000);
                CityBindings.addEdge(Tokyo, Rio, 9000);
                CityBindings.addEdge(Istanbul, Budepeste, 1000);
                CityBindings.addEdge(Amsterdam, Budepeste, 1150);
                CityBindings.addEdge(Amsterdam, NewYork, 5730);
                CityBindings.addEdge(NewYork, Rio, 8000);
                CityBindings.addEdge(Rio, Jerusalem, 10000);
                CityBindings.addEdge(Jerusalem, Istanbul, 1130);
                CityBindings.addEdge(Budepeste, London, 1394);
                String initialCity = (String) InitialBox.getSelectedItem();
                String destinationCity = (String) DestinationBox.getSelectedItem();
                Vertex initialVertex = findVertexByCityName(CityBindings, initialCity);
                Vertex destinationVertex = findVertexByCityName(CityBindings, destinationCity);
                Dijkstra dijkstra = new Dijkstra();
                String shortestPath = dijkstra.shortestPathBetween(CityBindings, initialVertex, destinationVertex);
                String[] result = shortestPath.split("\n");
                ValueLabel.setText(result[0]);
                PathLabel.setText(result[1]);


            }
            private Vertex findVertexByCityName(Graph graph, String cityName) {
                for (Vertex vertex : graph.getVertices()) {
                    if (vertex.getData().equals(cityName)) {
                        return vertex;
                    }
                }
                return null;
            }


        });
    }
}
