package at.ac.fhcampuswien.fhmdb.controllers;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.ObservableList;

import java.util.Comparator;

public class SortNone implements State{
    @Override
    public void changeState() {
        MovieListController.getInstance().setState(new SortAscending());
    }

    @Override
    public void sortMovies(ObservableList<Movie> movies) {
    }
}
