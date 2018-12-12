public class Map {

    //instance field

    private Path[] paths = new Path[50];

    private int gen = 1;

    private int maxGen  = 1000;

    private double bestScore = 20000;

    //constructor

    public Map(){

        for (int i = 0; i < paths.length; i++) {

            paths[i] = new Path();

        }

//        sort();
//
//        soutPaths(true);
//
//        killAndReplace();
//
//        soutPaths(true);
//
//        for (int i = 0; i < paths.length; i++) {
//
//            paths[i].mutate();
//
//        }
//
//        soutPaths(true);

        circleOfLife(maxGen);

    }

    //method

    public void soutPaths(boolean shortHand){

        System.out.println("Generation Number: " + gen);

        for (int i = 0; i < paths.length; i++) {

            System.out.println("Path: " + (i + 1));

            paths[i].soutCities(paths[i].getCityList(), shortHand);

        }

    }

    public void sort(){

        Path temp = new Path();

        for (int i = 0; i < paths.length; i++) {

            for (int j = i; j < paths.length; j++) {

                if(paths[i].getTotDistance() < paths[j].getTotDistance()){

                    temp.setCityList(paths[i].getCityList());

                    paths[i].setCityList(paths[j].getCityList());

                    paths[j].setCityList(temp.getCityList());

                    paths[i].calcTotDistance();

                    paths[j].calcTotDistance();

                }

            }

        }

    }

    public void killAndReplace(){

        for (int i = 0; i < paths.length / 2; i++) {

            paths[i].setCityList(paths[i + (paths.length / 2)].getCityList());

            paths[i].calcTotDistance();

        }

    }

    public void circleOfLife(int genLimit){

        for (int i = 0; i < genLimit; i++) {

            System.out.println("============= Generation: " + gen + " =============");

            sort();

//            System.out.println("=====Sort=====");
//            soutPaths(true);

            killAndReplace();

//            System.out.println("=====Kill and Replace=====");
//            soutPaths(true);

            for (int j = 0; j < paths.length; j++) {

                paths[j].mutate();

            }

//            System.out.println("=====mutate=====");
//            soutPaths(true);

            bestDistance();

            System.out.println("Best Score: " + bestScore);

            gen++;

        }

    }

    public void bestDistance(){

        for (int i = 0; i < paths.length; i++) {

            if(paths[i].getTotDistance() < bestScore){

                bestScore = paths[i].getTotDistance();

            }

        }

    }

}
