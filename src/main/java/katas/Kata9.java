package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists
                .stream()
                .flatMap(c -> c.getVideos().stream())
                .map(element -> {
                    List<BoxArt> boxArts = element.getBoxarts();
                    Integer index = boxArts.indexOf(element);
                    return Map.of("id", element.getId(), "title", element.getTitle(), "time", new Date(), "url", element.getBoxarts().stream().min(Comparator.comparing(box -> box.getWidth())));
                }).
                collect(Collectors.toList());

        //return ImmutableList.of(ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl"));
    }
}
