package dev.darrenmatthews.discord.exceptions;

import org.javacord.api.entity.message.MessageBuilder;

public interface DiscordException {
	
	public MessageBuilder getDiscordException();

}
