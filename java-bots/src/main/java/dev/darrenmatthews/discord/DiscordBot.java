package dev.darrenmatthews.discord;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageBuilder;

public class DiscordBot {

	public static void main(String[] args) {
		String token = System.getenv("DISCORD_TOKEN");

		DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

		api.addMessageCreateListener(event -> {
			String message = event.getMessageContent();
			TextChannel channel = event.getChannel();

			if (message.startsWith("!starwars")) {
				MessageBuilder response = StarWars.analyse(message);
				response.send(channel);
			}
		});
	}

}
