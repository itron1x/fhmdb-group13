package at.ac.fhcampuswien.fhmdb.api;

import at.ac.fhcampuswien.fhmdb.models.Genre;

public class MovieAPIRequestBuilder {
    public static final String DELIMITER = "&";
    private String query;
    private Genre genre;
    private String year;
    private String rating;
    private String base;

    StringBuilder url = new StringBuilder();

    public MovieAPIRequestBuilder(String base){
        this.base = base;
        url.append(base).append("?");
    }

    public MovieAPIRequestBuilder query(String query) {
        if (query != null) {
            this.query = query;
            url.append("query=").append(query).append(DELIMITER);
        }
        return this;
    }

    public MovieAPIRequestBuilder genre(Genre genre) {
        if (genre != null) {
            this.genre = genre;
            url.append("genre=").append(genre).append(DELIMITER);
        }
        return this;
    }

    public MovieAPIRequestBuilder releaseYear(String year) {
        if (year != null) {
            this.year = year;
            url.append("releaseYear=").append(year).append(DELIMITER);
        }
        return this;
    }

    public MovieAPIRequestBuilder ratingFrom(String rating) {
        if (rating != null) {
            this.rating = rating;
            url.append("ratingFrom=").append(rating).append(DELIMITER);
        }
        return this;
    }

    public String build() {
        return url.toString();
    }
}
