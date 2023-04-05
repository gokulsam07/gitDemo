package learn.automation.online.complex.pojo;
import lombok.Data;
import java.util.List;

@Data public class SuperHeroMoviesNTvSeries {
private String category;
private List<String> acceptedFranchises;
private List<String> genre;
private List<Movies> movies;
private List<TvSeries> tvseries;
private OtherDetails otherdetails;

//lot of code to do getters and setters -- verbose code or boiler plate code -- how do we reduce verbose code?
// Use lombok dependency / library
}
