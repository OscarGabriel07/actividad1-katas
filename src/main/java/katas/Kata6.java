package katas;

import model.Movie;
import org.w3c.dom.ls.LSOutput;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies
                .stream()
                .map(element -> element.getBoxarts())
                .flatMap(c -> c.stream())
                .reduce((x, y) -> (x.getUrl().length() > y.getUrl().length()) ? x : y)
                .get().getUrl();
    }
}
