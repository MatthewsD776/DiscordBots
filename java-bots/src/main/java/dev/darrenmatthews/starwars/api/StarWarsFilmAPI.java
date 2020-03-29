package dev.darrenmatthews.starwars.api;

import dev.darrenmatthews.exceptions.RestAPIException;
import dev.darrenmatthews.libs.RestAPI;
import dev.darrenmatthews.starwars.pojo.StarWarsFilm;
import dev.darrenmatthews.starwars.pojo.StarWarsFilms;

public class StarWarsFilmAPI extends StarWarsAPI {
	private StarWarsFilmAPI() {}
	
	/**
	 * Will Retrieve a list of all Star Wars films from the API.
	 * 
	 * @return StarWarsFilms object with all films
	 * 
	 * @throws RestAPIException Thrown when the API errors out
	 */
	public static StarWarsFilms getAllFilms() throws RestAPIException {
		LOGGER.info("Obtaining All Star Wars films");
		String jsonString = RestAPI.getRequest(STAR_WARS_API_FILMS_ROOT);
		return gson.fromJson(jsonString, StarWarsFilms.class);
	}

	/**
	 * Given a Film ID, will obtain the Film Information from the API.
	 * 
	 * @param filmId Id of the Film
	 * 
	 * @return StarWarsFilm object
	 * 
	 * @throws RestAPIException Thrown when the API errors out
	 */
	public static StarWarsFilm getFilmById(String filmId) throws RestAPIException {
		LOGGER.info("Obtaining Star Wars Information for {}", filmId);
		String filmUrl = STAR_WARS_API_FILMS_ROOT + filmId;

		String jsonString = RestAPI.getRequest(filmUrl);
		return gson.fromJson(jsonString, StarWarsFilm.class);
	}

}
