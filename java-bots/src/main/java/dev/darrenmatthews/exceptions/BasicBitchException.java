package dev.darrenmatthews.exceptions;

import java.awt.Color;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;

public class BasicBitchException extends DiscordException {
	private static final long serialVersionUID = 1L;

	public BasicBitchException(String culprit) {
		super(culprit);
	}

	public static MessageBuilder getDiscordException(String user) {
		return new BasicBitchException(user).getDiscordException();
	}

	public MessageBuilder getDiscordException() {
		EmbedBuilder builder = new EmbedBuilder();
		builder.setTitle(":rotating_light: Bitch Alert! :rotating_light:");
		builder.setColor(Color.RED);
		builder.setFooter("Bot by Dazza");
		builder.addField("Who is a Bitch?", "You Is");
		builder.addField("Look at your mistake", this.getMessage());

		MessageBuilder mBuilder = new MessageBuilder();
		mBuilder.append("What are you even doing? :warning:");
		mBuilder.setEmbed(builder);
		mBuilder.setTts(true);

		return mBuilder;
	}
}
