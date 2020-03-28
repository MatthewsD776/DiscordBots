package dev.darrenmatthews.starwars.pojo;

import java.awt.Color;
import java.util.List;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import dev.darrenmatthews.starwars.api.StarWarsResources;

public class StarWarsFilms {
	@SerializedName("results")
	@Expose
	public List<StarWarsFilm> films = null;

	public MessageBuilder getDiscordRender() {
		MessageBuilder builder = new MessageBuilder();
		
		EmbedBuilder emBuilder = new EmbedBuilder();
		emBuilder.setColor(Color.GREEN);
		emBuilder.setThumbnail(StarWarsResources.getC3PO());
		
		for(StarWarsFilm film : films) {
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append(film.title);
			strBuilder.append("\r\n");
			strBuilder.append("Directed By : ").append(film.director);
			strBuilder.append("\r\n");
			strBuilder.append("Released : ").append(film.releaseDate);
			strBuilder.append("\r\n");
			
			emBuilder.addField("Episode " + film.episodeId, strBuilder.toString());
		}
		
		return builder.setEmbed(emBuilder);
	}
}
