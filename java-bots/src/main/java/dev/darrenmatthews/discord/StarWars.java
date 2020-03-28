package dev.darrenmatthews.discord;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import dev.darrenmatthews.discord.exceptions.BitchException;
import dev.darrenmatthews.restapi.StarWarsAPI;

public class StarWars {

	public static MessageBuilder analyse(String message, MessageCreateEvent event) {		
		MessageBuilder response;

		try {
			String[] starwarsArg = message.split(" ");
			response = StarWarsAPI.getFilmInformation(starwarsArg[1]);

		} catch (BitchException e) {
			response = e.getDiscordException();
		}
		
		return response;
	}

}
