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
        continentMap.get("Europe").addCity("London");
        continentMap.get("Europe").addCity("Amsterdam");
        continentMap.get("Europe").addCity("Budapest");
        continentMap.get("Europe").addCity("Sofia");

        // North America
        continentMap.get("North America").addCity("New York");

        // Asia
        continentMap.get("Asia").addCity("Tokyo");
        continentMap.get("Asia").addCity("Wuhan");
        continentMap.get("Asia").addCity("Mumbai");
        continentMap.get("Asia").addCity("Istanbul");
        continentMap.get("Asia").addCity("Jerusalem");

        // South America
        continentMap.get("South America").addCity("Rio de Janeiro");

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
