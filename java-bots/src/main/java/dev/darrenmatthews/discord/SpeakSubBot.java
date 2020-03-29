package dev.darrenmatthews.discord;

import java.util.Arrays;
import java.util.List;

import org.javacord.api.entity.message.MessageBuilder;

public class SpeakSubBot extends SubBot {
	
	public static MessageBuilder analyse(String command) {
		List<String> words = Arrays.asList(command.split(" "));
		String speech;
		
		if(words.size() <= 1) {
			speech = "You didnt say anything you mute bitch";
		} else {
			List<String> toSay = words.subList(1, words.size());
			speech = String.join(" ", toSay);
		}
		
		MessageBuilder builder = new MessageBuilder();
		builder.append(speech);
		builder.setTts(true);
		
		return builder;
	}
}
