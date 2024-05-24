import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ContinentTree {

    private static class Continent {

        private String name;
        private Map<String, TreeSet<String>> cities; // Kıta adı ve şehirlerin ağacı

        public Continent(String name) {
            this.name = name;
            this.cities = new HashMap<>();
        }

        // Kıtaya yeni bir şehir ekler
        public void addCity(String city) {
            cities.computeIfAbsent(name, k -> new TreeSet<>()).add(city);
        }

        // Belirli bir kıtadaki tüm şehirleri getirir
        public Set<String> getCities() {
            return cities.getOrDefault(name, new TreeSet<>());
        }

        // Tüm kıtaları getirir
        public static Set<String> getAllContinents() {
            return Set.of("Europe", "Asia", "Africa", "North America", "South America", "Australia", "Antarctica");
        }

        // Belirli bir kıtanın adını getirir
        public String getName() {
            return name;
        }
    }


    private Map<String, Continent> continentMap; // Kıta adı ve kıtayı temsil eden ağaç

    public ContinentTree() {
        this.continentMap = new HashMap<>();
        // Kıtaları oluştur
        for (String continentName : Continent.getAllContinents()) {
            continentMap.put(continentName, new Continent(continentName));
        }
        // Şehirleri kıtalara ekle
        addCitiesToContinents();
    }

    // Kıtalara şehirleri ekler
    private void addCitiesToContinents() {
        // Europe
        continentMap.get("Europe").addCity("Berlin");
        continentMap.get("Europe").addCity("Paris");
        continentMap.get("Europe").addCity("Roma");
        continentMap.get("Europe").addCity("Madrid");

        // North America
        continentMap.get("North America").addCity("New York");
        continentMap.get("North America").addCity("San Francisco");
        continentMap.get("North America").addCity("Ottowa");
        continentMap.get("North America").addCity("Mexico City");
        continentMap.get("North America").addCity("Washington DC");

        //Africa
        continentMap.get("Africa").addCity("Tunus");
        continentMap.get("Africa").addCity("Launda");
        continentMap.get("Africa").addCity("Marakesh");
        continentMap.get("Africa").addCity("Washington DC");


        // Asia
        continentMap.get("Asia").addCity("Tokyo");
        continentMap.get("Asia").addCity("Suva");
        continentMap.get("Asia").addCity("Seul");
        continentMap.get("Asia").addCity("Sydney");
        continentMap.get("Asia").addCity("Manila");
        continentMap.get("Asia").addCity("Port Moresby");
        continentMap.get("Asia").addCity("Manila");
        continentMap.get("Asia").addCity("New Delhi");
        continentMap.get("Asia").addCity("Taskent");
        continentMap.get("Asia").addCity("Ankara");
        continentMap.get("Asia").addCity("Makassar");


        // South America
        continentMap.get("South America").addCity("Brasil");
        continentMap.get("South America").addCity("Buenos Aires");
        continentMap.get("South America").addCity("Santiago");
        continentMap.get("South America").addCity("Lima");
        continentMap.get("South America").addCity("Bogota");



    }


    // Belirli bir kıtanın tüm şehirlerini getirir
    public Set<String> getCitiesByContinent(String continentName) {
        if (continentMap.containsKey(continentName)) {
            return continentMap.get(continentName).getCities();
        } else {
            return new TreeSet<>(); // Eğer kıta bulunamazsa boş bir set döndür
        }
    }

    // Belirli bir kıtaya göre sıralı bir şekilde şehirleri döndürür
    public Set<String> getCitiesByContinentSorted(String continentName) {
        TreeSet<String> sortedCities = new TreeSet<>();
        Continent continent = continentMap.get(continentName);
        if (continent != null) {
            sortedCities.addAll(continent.getCities());
        }
        return sortedCities;
    }





}
