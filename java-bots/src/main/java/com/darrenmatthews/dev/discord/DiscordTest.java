package com.darrenmatthews.dev.discord;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageBuilder;

public class DiscordTest {

	public static void main(String[] args) {
		String token = System.getenv("DISCORD_TOKEN");

		DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

		api.addMessageCreateListener(event -> {
			String message = event.getMessageContent();
			String userDisplayName = event.getMessage().getAuthor().getDisplayName();
			TextChannel channel = event.getChannel();

			if (message.startsWith("!starwars")) {
				String[] starwarsArg = message.split(" ");

				try {
					MessageBuilder starWarsResponse = StarWarsAPI.getFilmInformation(starwarsArg[1]);
					starWarsResponse.send(channel);

				} catch (BitchException e) {
					MessageBuilder error = e.getDiscordMessage(userDisplayName);
					error.send(channel);
				}

			}
		});
	}

}
