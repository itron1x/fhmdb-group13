package at.ac.fhcampuswien.fhmdb.controllers;

import javafx.util.Callback;

public class ControllerFactory implements Callback<Class<?>, Object> {

    private static MainController singletonMain = null;
    private static MovieListController singletonMovieList = null;
    private static WatchlistController singletonWatchlist = null;
    private static Object mutex = new Object();

    private static volatile ControllerFactory controllerFactory = null;

    private ControllerFactory(){};

    public static ControllerFactory getFactory(){
        synchronized (mutex){
            if (controllerFactory == null) controllerFactory = new ControllerFactory();
        }
        return controllerFactory;
    }

    @Override
    public Object call(Class<?> aClass) {
        try{
            if(aClass.equals(MainController.class)){
                System.out.println("Getting MainController");
                if(singletonMain == null) singletonMain = new MainController();
                return singletonMain;
            }
            if(aClass.equals(MovieListController.class)){
                System.out.println("Getting MovieListController");
                if(singletonMovieList == null) singletonMovieList = new MovieListController();
                return singletonMovieList;
            }
            if(aClass.equals(WatchlistController.class)){
                System.out.println("Getting WatchlistController");
                if(singletonWatchlist == null) singletonWatchlist = new WatchlistController();
                return singletonWatchlist;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("How did we even get to this point");
        return null;
    }
}
