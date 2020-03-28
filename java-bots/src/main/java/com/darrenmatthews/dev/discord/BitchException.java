package com.darrenmatthews.dev.discord;

import java.awt.Color;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;

public class BitchException extends Exception {
	private static final long serialVersionUID = 1L;

	
	public MessageBuilder getDiscordMessage(String culprit) {
		EmbedBuilder builder = new EmbedBuilder();
		builder.setTitle(":rotating_light: Bitch Alert! :rotating_light:");
		builder.setColor(Color.RED);
		builder.setFooter("Bot by Dazza");
		builder.addField("Who is a Bitch?", culprit);
		
		MessageBuilder mBuilder = new MessageBuilder();
		mBuilder.append("What are you even doing? :warning:");
		mBuilder.setEmbed(builder);
		
		return mBuilder;
	}
	
	public MessageBuilder getDiscordMessage() {
		return getDiscordMessage("You");
	}
}
