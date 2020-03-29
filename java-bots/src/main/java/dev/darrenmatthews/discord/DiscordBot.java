package dev.darrenmatthews.discord;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.Channel;
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
			} else if(message.startsWith("!say")) {
				MessageBuilder response = SpeakSubBot.analyse(message);
				response.send(channel);
			} else if (message.startsWith("!")) {
				event.getChannel().sendMessage("Not Implemented this stuff yet");
			}
		});
		
		//TODO Refactor this to be cleaner and extensible
		api.addServerVoiceChannelMemberJoinListener(event -> {			
			Collection<Channel> channels = api.getChannelsByName("general");
			
			MessageBuilder msg = new MessageBuilder();
			msg.append("A little bitch has joined");
			msg.setTts(true);
			
			Iterator<Channel> itr = channels.iterator();
			while(itr.hasNext()) {
				Channel channel = itr.next();
				
				Optional<TextChannel> obj = channel.as(TextChannel.class);
				obj.ifPresent(chan -> {
					msg.send(chan);
				});
			}
		});
	}

}
