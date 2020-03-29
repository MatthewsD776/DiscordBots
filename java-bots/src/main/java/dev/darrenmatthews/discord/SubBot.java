package dev.darrenmatthews.discord;

import org.javacord.api.entity.message.MessageBuilder;

public class SubBot {
	
	protected SubBot() {
	}
	
	protected static MessageBuilder commandError() {
		return new MessageBuilder().append("Unrecoginized Commands");
	}
}
