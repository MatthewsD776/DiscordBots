package dev.darrenmatthews.starwars.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.gson.Gson;

public class StarWarsAPI {
	protected static final Logger LOGGER = LogManager.getLogger();
	protected static final String STAR_WARS_API_ROOT = "https://swapi.co/api/";
	protected static final String STAR_WARS_API_FILMS_ROOT = STAR_WARS_API_ROOT + "films/";
	protected static final String STAR_WARS_API_PEOPLE_ROOT = STAR_WARS_API_ROOT + "people/";

	protected static final Gson gson = new Gson();

	protected StarWarsAPI() {
	}
}
