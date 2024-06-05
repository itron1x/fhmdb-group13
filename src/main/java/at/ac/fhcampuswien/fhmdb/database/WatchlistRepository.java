package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.observer.Observable;
import at.ac.fhcampuswien.fhmdb.observer.Observer;
import com.j256.ormlite.dao.Dao;

import java.util.LinkedList;
import java.util.List;

public class WatchlistRepository implements Observable {

    Dao<WatchlistMovieEntity, Long> dao;
    private List<Observer> observers = new LinkedList<>();

    private static WatchlistRepository watchlistRepository = null;

    public static WatchlistRepository getInstance() throws DataBaseException {
        if(watchlistRepository == null) watchlistRepository = new WatchlistRepository();
        return watchlistRepository;
    }

    private WatchlistRepository() throws DataBaseException {
        try {
            this.dao = DatabaseManager.getInstance().getWatchlistDao();
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    @Override
    public void addSubscriber(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyControllers(String message) {
        observers.forEach(o -> o.update(message));
    }

    public List<WatchlistMovieEntity> getWatchlist() throws DataBaseException {
        try {
            return dao.queryForAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("Error while reading watchlist");
        }
    }
    public int addToWatchlist(WatchlistMovieEntity movie) throws DataBaseException {
        try {
            // only add movie if it does not exist yet
            long count = dao.queryBuilder().where().eq("apiId", movie.getApiId()).countOf();
            if (count == 0) {
                notifyControllers("Movie successfully added to the watchlist");
                return dao.create(movie);
            } else {
                notifyControllers("Movie already on watchlist");
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("Error while adding to watchlist");
        }
    }

    public int removeFromWatchlist(String apiId) throws DataBaseException {
        try {
            notifyControllers("Movie removed from watchlist");
            return dao.delete(dao.queryBuilder().where().eq("apiId", apiId).query());
        } catch (Exception e) {
            throw new DataBaseException("Error while removing from watchlist");
        }
    }
}
