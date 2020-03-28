package dev.darrenmatthews.discord;

import org.javacord.api.entity.message.MessageBuilder;

import dev.darrenmatthews.exceptions.BasicBitchException;
import dev.darrenmatthews.exceptions.RestAPIException;
import dev.darrenmatthews.starwars.api.StarWarsFilmAPI;
import dev.darrenmatthews.starwars.pojo.StarWarsFilm;

public class StarWarsSubBot {

	private StarWarsSubBot() {
	}

	public static MessageBuilder analyse(String message) {
		MessageBuilder response;

		String[] starwarsArg = message.split(" ");

		try {
			StarWarsFilm film = StarWarsFilmAPI.getFilmById(starwarsArg[1]);
			return film.getDiscordRender();
		} catch (RestAPIException e) {
			response = BasicBitchException.getDiscordException(e.getMessage());
		}

		return response;
	}

}
