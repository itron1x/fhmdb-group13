package at.ac.fhcampuswien.fhmdb.controllers;

import javafx.util.Callback;

public class ControllerFactory implements Callback<Class<?>, Object> {

    @Override
    public Object call(Class<?> aClass) {
        try{
            if(aClass.equals(MainController.class)){
                System.out.println("Getting MainController");
                return MainController.getInstance();
            }
            if(aClass.equals(MovieListController.class)){
                System.out.println("Getting MovieListController");
                return MovieListController.getInstance();
            }
            if(aClass.equals(WatchlistController.class)){
                System.out.println("Getting WatchlistController");
                return WatchlistController.getInstance();
            }
            else return aClass.getDeclaredConstructor().newInstance(); //will probably never happen?

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("How did we even get to this point");
        return null;
    }
}
