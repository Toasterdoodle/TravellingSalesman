import java.util.ArrayList;

public class Path {

    //instance fields

    private ArrayList<City> cityBank = new ArrayList<>();
    //a bank of available cities

    private ArrayList<City> cityList = new ArrayList<>();
    //list of cities in the path

    private double totDistance;

    //constructor

    public Path(){

        //initializing the cityBank
        cityBank.add(new City(273, 225, 1));
        cityBank.add(new City(643, 437, 2));
        cityBank.add(new City(235, 630, 3));
        cityBank.add(new City(541, 737, 4));
        cityBank.add(new City(248, 587, 5));
        cityBank.add(new City(129, 185, 6));
        cityBank.add(new City(369, 503, 7));
        cityBank.add(new City(300, 797, 8));
        cityBank.add(new City(555, 406, 9));
        cityBank.add(new City(404, 214, 10));
        cityBank.add(new City(302, 657, 11));
        cityBank.add(new City(775, 438, 12));
        cityBank.add(new City(315, 359, 13));
        cityBank.add(new City(773, 75, 14));
        cityBank.add(new City(129, 69, 15));
        cityBank.add(new City(238, 13, 16));
        cityBank.add(new City(520, 23, 17));
        cityBank.add(new City(295, 299, 18));
        cityBank.add(new City(794, 346, 19));
        cityBank.add(new City(18, 457, 20));
        cityBank.add(new City(348, 631, 21));
        cityBank.add(new City(638, 157, 22));
        cityBank.add(new City(189, 513, 23));
        cityBank.add(new City(750, 587, 24));

        initializePath();
        //cityBank should be empty at this point

        calcTotDistance();

    }

    //methods

    public double calcTotDistance(){

        City previousCity = new City(0, 0, 0);

        double distance = 0;

        for (int i = 0; i < cityList.size(); i++) {

            distance += previousCity.distanceTo(cityList.get(i));

            previousCity = cityList.get(i);

        }

        totDistance = distance;

        return distance;

    }

    public void initializePath(){
        //initialize the path to contain random cities

        int rand;

        while(cityBank.size() > 0) {

            rand = (int) (Math.random() * cityBank.size());

            cityList.add(cityBank.remove(rand));

        }

    }

    public void soutCities(ArrayList<City> cities, boolean shortHand){

        if(!shortHand) {

            if (cities.size() == 0) {

                System.out.println("No Cities inside ArrayList");

            } else {

                for (int i = 0; i < cities.size(); i++) {

                    System.out.print(i + ": ");

                    System.out.print("Index: " + cities.get(i).getIndex() + " ");

                    System.out.println(cities.get(i).toString());

                }

                calcTotDistance();

                System.out.println("Total Distance: " + totDistance);

            }

        }
        else{

            calcTotDistance();

            System.out.println("Total Distance: " + totDistance);

        }

    }

    //TODO: implement scaled mutation, smaller mutation the lower the distance, higher mutation for larger distance
    //Start off at like 5-10% then scale to around 1-2%

    public void mutate(){
        //city bank should be empty right now

        int rand;

//        System.out.println("commence mutation");

        for (int i = 0; i < cityList.size(); i++) {
            //removes cities randomly and adds them to the city bank

            rand = (int)(Math.random() * 100);

//            System.out.println(rand);

            if(rand < 5){

                cityBank.add(cityList.remove(i));

//                System.out.println("removed");

//                cityList.add(cityList.remove(i));

                i--;

            }

        }

        while(cityBank.size() > 0) {
            //adds cities back into the cityList from the cityBank at random positions

            cityList.add((int)(Math.random() * cityList.size()), cityBank.remove(0));

        }

    }

    public ArrayList<City> getCityList() {

        return cityList;

    }

    public void setCityList(ArrayList<City> list) {

        while(cityList.size() > 0){

            cityList.remove(0);

        }
        for (int i = 0; i < list.size(); i++) {

            cityList.add(list.get(i));

        }

    }

    public double getTotDistance() {
        return totDistance;
    }

    public void setTotDistance(double totDistance) {
        this.totDistance = totDistance;
    }

}
