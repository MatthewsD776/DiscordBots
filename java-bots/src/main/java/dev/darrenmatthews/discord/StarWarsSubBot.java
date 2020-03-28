package dev.darrenmatthews.discord;

import java.util.Arrays;
import java.util.List;

import org.javacord.api.entity.message.MessageBuilder;

import dev.darrenmatthews.exceptions.BasicBitchException;
import dev.darrenmatthews.exceptions.RestAPIException;
import dev.darrenmatthews.starwars.api.StarWarsFilmAPI;
import dev.darrenmatthews.starwars.pojo.StarWarsFilm;
import dev.darrenmatthews.starwars.pojo.StarWarsFilms;

public class StarWarsSubBot {

	private StarWarsSubBot() {
	}

	public static MessageBuilder analyse(String command) {
		MessageBuilder response = null;
		List<String> params = Arrays.asList(command.split(" "));
		
		if(params.size() <= 1) {
			return commandError();
		}		
		
		String topic = params.get(1);
		
		if(topic.equalsIgnoreCase("film")) {
			return filmCommand(params);
		} else if (topic.equalsIgnoreCase("films")) {
			return filmsCommand();
		}

		return response;
	}
	
	private static MessageBuilder filmsCommand() {
		try {
			StarWarsFilms films = StarWarsFilmAPI.getAllFilms();
			return films.getDiscordRender();
			
		} catch (RestAPIException e) {
			return BasicBitchException.getDiscordException(e.getMessage());
		}
	}

	private static MessageBuilder filmCommand(List<String> args) {
		if(args.size() <= 2) {
			return commandError();
		}
		
		String filmId = args.get(2);
		return getFilm(filmId);
	}

	private static MessageBuilder getFilm(String filmId) {
		try {
			StarWarsFilm film = StarWarsFilmAPI.getFilmById(filmId);
			return film.getDiscordRender();
		} catch (RestAPIException e) {
			return BasicBitchException.getDiscordException(e.getMessage());
		}
	}
	
	private static MessageBuilder commandError() {
		return new MessageBuilder().append("Unrecoginized Commands");
	}
}
