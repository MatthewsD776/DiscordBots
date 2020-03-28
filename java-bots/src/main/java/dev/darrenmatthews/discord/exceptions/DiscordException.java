package dev.darrenmatthews.discord.exceptions;

import org.javacord.api.entity.message.MessageBuilder;

public abstract class DiscordException extends Exception {
	private static final long serialVersionUID = 1L;

	public DiscordException(String message) {
		super(message);
	}

	public abstract MessageBuilder getDiscordException();

}
