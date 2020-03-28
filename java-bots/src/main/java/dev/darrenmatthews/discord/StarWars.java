package dev.darrenmatthews.discord;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import dev.darrenmatthews.discord.exceptions.BasicBitchException;
import dev.darrenmatthews.discord.exceptions.RestAPIException;
import dev.darrenmatthews.restapi.StarWarsAPI;

public class StarWars {

	public static MessageBuilder analyse(String message, MessageCreateEvent event) {
		MessageBuilder response;

		String[] starwarsArg = message.split(" ");

		try {
			response = StarWarsAPI.getFilmInformation(starwarsArg[1]);
		} catch (RestAPIException e) {
			response = BasicBitchException.getDiscordException(e.getMessage());
		}

		return response;
	}

}
