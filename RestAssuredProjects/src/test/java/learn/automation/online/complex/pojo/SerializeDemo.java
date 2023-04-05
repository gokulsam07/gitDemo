package learn.automation.online.complex.pojo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeDemo {

	@Test(enabled=true)
	void setDetails() throws StreamWriteException, DatabindException, IOException {
		SuperHeroMoviesNTvSeries obj = new SuperHeroMoviesNTvSeries();
		obj.setCategory("Super hero movies & TV Series"); 
	
		List<String> af = new ArrayList<String>();
		af.add("DC");
		af.add("Marvel");
		obj.setAcceptedFranchises(af);

		List<String> gnr = new ArrayList<String>();
		gnr.add("Action");
		gnr.add("Adventure");
		gnr.add("Heroic");
		gnr.add("Dark");
		gnr.add("Funny");
		obj.setGenre(gnr);

		Movies batman = new Movies();
		batman.setTitle("Batman");
		batman.setYear(2008);

		List<String> cast = new ArrayList<String>();
		cast.add("Christian Bale");
		cast.add("Heath ledger");
		batman.setCast(cast);

		Movies jl = new Movies();
		jl.setTitle("Justice League");
		jl.setYear(2007);

		List<String> castjl = new ArrayList<String>();
		castjl.add("Henry Cavill");
		castjl.add("Gal Gadot");
		jl.setCast(castjl);

		Movies av = new Movies();
		av.setTitle("Avengers");
		av.setYear(2009);

		List<String> castav = new ArrayList<String>();
		castav.add("Robert Downey Jr");
		castav.add("Chris Evans");
		av.setCast(castav);

		List<Movies> mvs = new ArrayList<Movies>();
		mvs.add(av);
		mvs.add(batman);
		mvs.add(jl);

		obj.setMovies(mvs);


		//TVSeries

		TvSeries flash = new TvSeries();
		flash.setTitle("Falsh");
		flash.setYear(2014);
		TvSeries gotham = new TvSeries();
		gotham.setTitle("Gotham");
		gotham.setYear(2014);
		TvSeries supergirl = new TvSeries();
		supergirl.setTitle("Super Girl");
		supergirl.setYear(2018);

		List<TvSeries> tvs = new ArrayList<TvSeries>();
		tvs.add(supergirl);
		tvs.add(gotham);
		tvs.add(flash);

		obj.setTvseries(tvs);	

		OtherDetails othr = new OtherDetails();
		othr.setCountry("USA");
		othr.setLanguage("English");
		obj.setOtherdetails(othr);
		
		
		File jsonWrite = new File("C:\\Users\\v-gokulsam\\Downloads\\complex.json");
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(jsonWrite, obj);

	}
	
}
