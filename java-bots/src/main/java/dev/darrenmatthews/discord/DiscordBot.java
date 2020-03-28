package dev.darrenmatthews.discord;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageBuilder;

public class DiscordBot {
	private static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args) {
		String token = System.getenv("DISCORD_TOKEN");

		DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

		api.addMessageCreateListener(event -> {
			String message = event.getMessageContent();
			TextChannel channel = event.getChannel();
			String author = event.getMessageAuthor().getDisplayName();

			if (message.startsWith("!starwars")) {
				LOGGER.info("Received Star Wars event from {} on {}", author, channel);
				MessageBuilder response = StarWarsSubBot.analyse(message);
				response.send(channel);
				LOGGER.info("Star Wars event from {} on {} complete", author, channel);
			}
		});
	}

}
