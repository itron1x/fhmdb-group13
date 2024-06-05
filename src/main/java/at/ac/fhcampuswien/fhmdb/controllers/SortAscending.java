package at.ac.fhcampuswien.fhmdb.controllers;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.ObservableList;

import java.util.Comparator;

public class SortAscending extends State {
    @Override
    public void sortMovies(ObservableList<Movie> movies) {
        movies.sort(Comparator.comparing(Movie::getTitle));
    }
}
