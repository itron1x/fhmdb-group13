package at.ac.fhcampuswien.fhmdb.controllers;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.ObservableList;

public abstract class State {
    public abstract void sortMovies(ObservableList<Movie> movies);
}
