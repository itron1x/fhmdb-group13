package at.ac.fhcampuswien.fhmdb.controllers;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.ObservableList;

public interface State {
    void changeState();
    void sortMovies(ObservableList<Movie> movies);
}
