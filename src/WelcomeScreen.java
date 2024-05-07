import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeScreen extends JFrame {

    private JComboBox InitialBox;
    private JComboBox DestinationBox;
    private JButton createRouteButton;
    private JPanel Panel2;
    private JButton exitButton;
    private JLabel ValueLabel;
    private JLabel PathLabel;
    private JLabel MapLabel;

    public WelcomeScreen() {
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
                Vertex Tokyo = CityBindings.addVertex("Tokyo");
                Vertex Suva = CityBindings.addVertex("Suva");
                Vertex Seul = CityBindings.addVertex("Seul");
                Vertex Sydney = CityBindings.addVertex("Sydney");
                Vertex PortMoresby = CityBindings.addVertex("Port Moresby");
                Vertex Manila = CityBindings.addVertex("Manila");
                Vertex NewDelhi = CityBindings.addVertex("New Delhi");
                Vertex Taskent = CityBindings.addVertex("Taskent");
                Vertex Ankara = CityBindings.addVertex("Ankara");
                Vertex Makassar = CityBindings.addVertex("Makassar");
                Vertex Nairobi = CityBindings.addVertex("Nairobi");
                Vertex Cairo = CityBindings.addVertex("Cairo");
                Vertex Belgrad = CityBindings.addVertex("Belgrad");
                Vertex Berlin = CityBindings.addVertex("Berlin");
                Vertex Roma = CityBindings.addVertex("Roma");
                Vertex Tunus = CityBindings.addVertex("Tunus");
                Vertex Paris = CityBindings.addVertex("Paris");
                Vertex Madrid = CityBindings.addVertex("Madrid");
                Vertex Launda = CityBindings.addVertex("Launda");
                Vertex Marakesh = CityBindings.addVertex("Marakesh");
                Vertex BuenosAires = CityBindings.addVertex("Buenos Aires");
                Vertex Brasil = CityBindings.addVertex("Brasil");
                Vertex Bogota = CityBindings.addVertex("Bogota");
                Vertex Havana = CityBindings.addVertex("Havana");
                Vertex Washington = CityBindings.addVertex("Washington DC");
                Vertex Ottowa = CityBindings.addVertex("Ottowa");
                Vertex MexicoCity = CityBindings.addVertex("Mexico City");
                Vertex Santiago = CityBindings.addVertex("Santiago");
                Vertex Lima = CityBindings.addVertex("Lima");
                Vertex SanFransisco = CityBindings.addVertex("San Fransisco");
                CityBindings.addEdge(Suva,Tokyo,1600);
                CityBindings.addEdge(PortMoresby,Suva,500);
                CityBindings.addEdge(Sydney,Suva,500);
                CityBindings.addEdge(Makassar,Sydney,600);
                CityBindings.addEdge(Nairobi,Sydney,3400);
                CityBindings.addEdge(Nairobi,Makassar,2800);
                CityBindings.addEdge(Makassar,PortMoresby,350);
                CityBindings.addEdge(PortMoresby,Manila,500);
                CityBindings.addEdge(NewDelhi,Manila,1500);
                CityBindings.addEdge(NewDelhi,Tokyo,800);
                CityBindings.addEdge(Taskent,Tokyo,900);
                CityBindings.addEdge(Seul,Tokyo,300);
                CityBindings.addEdge(Ankara,Seul,1000);
                CityBindings.addEdge(NewDelhi,Seul,650);
                CityBindings.addEdge(Ankara,Taskent,500);
                CityBindings.addEdge(Belgrad,Taskent,1600);
                CityBindings.addEdge(Belgrad,Ankara,500);
                CityBindings.addEdge(Belgrad,Cairo,720);
                CityBindings.addEdge(Ankara,Cairo,1200);
                CityBindings.addEdge(NewDelhi,Cairo,1500);
                CityBindings.addEdge(NewDelhi,Makassar,1700);
                CityBindings.addEdge(Cairo,Nairobi,700);
                CityBindings.addEdge(Tunus,Nairobi,850);
                CityBindings.addEdge(Roma,Cairo,700);
                CityBindings.addEdge(Roma,Belgrad,800);
                CityBindings.addEdge(Berlin,Belgrad,1243);
                CityBindings.addEdge(Paris,Berlin,1056);
                CityBindings.addEdge(Madrid,Roma,1200);
                CityBindings.addEdge(Tunus,Roma,200);
                CityBindings.addEdge(Paris,Madrid,1210);
                CityBindings.addEdge(Madrid,Marakesh,400);
                CityBindings.addEdge(Marakesh,Tunus,200);
                CityBindings.addEdge(Tunus,Launda,900);
                CityBindings.addEdge(Nairobi,Launda,250);
                CityBindings.addEdge(BuenosAires,Launda,3700);
                CityBindings.addEdge(Marakesh,Launda,750);
                CityBindings.addEdge(BuenosAires,Marakesh,3800);
                CityBindings.addEdge(Brasil,Marakesh,1500);
                CityBindings.addEdge(Brasil,BuenosAires,410);
                CityBindings.addEdge(Madrid,Brasil,1950);
                CityBindings.addEdge(Madrid,Bogota,2000);
                CityBindings.addEdge(Madrid,Havana,3950);
                CityBindings.addEdge(Madrid,Washington,3800);
                CityBindings.addEdge(Washington,Paris,4000);
                CityBindings.addEdge(Ottowa,Paris,4100);
                CityBindings.addEdge(Ottowa,Washington,915);
                CityBindings.addEdge(SanFransisco,Ottowa,4623);
                CityBindings.addEdge(SanFransisco,Washington,4525);
                CityBindings.addEdge(Washington,MexicoCity,4625);
                CityBindings.addEdge(SanFransisco,MexicoCity,3566);
                CityBindings.addEdge(Havana,Bogota,1500);
                CityBindings.addEdge(Bogota,Brasil,600);
                CityBindings.addEdge(Bogota,BuenosAires,800);
                CityBindings.addEdge(Lima,BuenosAires,500);
                CityBindings.addEdge(Santiago,BuenosAires,200);
                CityBindings.addEdge(Santiago,Lima,400);
                CityBindings.addEdge(Bogota,Lima,300);
                CityBindings.addEdge(MexicoCity,Lima,600);
                CityBindings.addEdge(SanFransisco,Lima,3800);
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