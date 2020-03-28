package dev.darrenmatthews.restapi;

import java.awt.Color;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.json.JSONObject;

import dev.darrenmatthews.discord.exceptions.RestAPIException;
import dev.darrenmatthews.libs.RestAPI;

public class StarWarsAPI {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String STAR_WARS_API_ROOT = "https://swapi.co/api/";

	private StarWarsAPI() {
	}

	public static MessageBuilder getFilmInformation(String filmId) throws RestAPIException {
		LOGGER.info("Obtaining Star Wars Information for {}", filmId);
		String filmUrl = STAR_WARS_API_ROOT + "films/" + filmId;

		String jsonString = RestAPI.getRequest(filmUrl);

		JSONObject obj = new JSONObject(jsonString);

		String filmName = obj.getString("title");
		String openingCrawl = obj.getString("opening_crawl");
		String director = obj.getString("director");
		String releaseDate = obj.getString("release_date");

		EmbedBuilder builder = new EmbedBuilder();
		builder.setTitle(filmName);
		builder.setColor(Color.GREEN);
		builder.setFooter("Bot by Dazza");
		builder.addField("Director : ", director);
		builder.addField("Release Date : ", releaseDate);
		builder.addField("Opening Crawl : ", openingCrawl);

		MessageBuilder mBuilder = new MessageBuilder();
		mBuilder.append("Here is that Star Wars Film you were after you lil Biatch:");
		mBuilder.setEmbed(builder);
		mBuilder.setTts(true);

		return mBuilder;

	}

}
