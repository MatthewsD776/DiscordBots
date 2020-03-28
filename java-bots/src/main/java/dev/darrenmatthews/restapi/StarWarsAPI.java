package dev.darrenmatthews.restapi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.message.MessageBuilder;
import com.google.gson.Gson;

import dev.darrenmatthews.discord.exceptions.RestAPIException;
import dev.darrenmatthews.libs.RestAPI;
import dev.darrenmatthews.pojo.StarWarsFilm;

public class StarWarsAPI {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String STAR_WARS_API_ROOT = "https://swapi.co/api/";

	private StarWarsAPI() {
	}

	public static MessageBuilder getFilmInformation(String filmId) throws RestAPIException {
		LOGGER.info("Obtaining Star Wars Information for {}", filmId);
		String filmUrl = STAR_WARS_API_ROOT + "films/" + filmId;

		String jsonString = RestAPI.getRequest(filmUrl);
		Gson gson = new Gson();
		StarWarsFilm film = gson.fromJson(jsonString, StarWarsFilm.class);
		
		return film.getDiscordRender();
	}

}
