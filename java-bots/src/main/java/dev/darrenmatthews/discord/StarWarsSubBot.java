package dev.darrenmatthews.discord;

import java.util.Arrays;
import java.util.List;

import org.javacord.api.entity.message.MessageBuilder;

import dev.darrenmatthews.exceptions.BasicBitchException;
import dev.darrenmatthews.exceptions.RestAPIException;
import dev.darrenmatthews.starwars.api.StarWarsFilmAPI;
import dev.darrenmatthews.starwars.api.StarWarsPeopleAPI;
import dev.darrenmatthews.starwars.pojo.StarWarsFilm;
import dev.darrenmatthews.starwars.pojo.StarWarsFilms;
import dev.darrenmatthews.starwars.pojo.StarWarsPerson;

public class StarWarsSubBot extends SubBot {

	private StarWarsSubBot() {
	}

	public static MessageBuilder analyse(String command) {
		List<String> params = Arrays.asList(command.split(" "));
		
		if(params.size() <= 1) {
			return commandError();
		}		
		
		String topic = params.get(1);
		
		if(topic.equalsIgnoreCase("film")) {
			return filmCommand(params);
		} else if (topic.equalsIgnoreCase("films")) {
			return filmsCommand();
		} else if (topic.equalsIgnoreCase("person")) {
			return personCommand(params);
		}

		return commandError();
	}
	
	private static MessageBuilder personCommand(List<String> params) {
		if(params.size() <= 2) {
			return commandError();
		}
		
		String id = params.get(2);
		
		try {
			StarWarsPerson person = StarWarsPeopleAPI.getPersonById(id);
			return person.renderDiscord();
		} catch (RestAPIException e) {
			return BasicBitchException.getDiscordException(e.getMessage());
		}
		
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
}
