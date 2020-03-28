package dev.darrenmatthews.starwars.pojo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StarWarsFilms {
	@SerializedName("results")
	@Expose
	public List<StarWarsFilm> films = null;
}
