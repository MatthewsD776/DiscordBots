package dev.darrenmatthews.starwars.pojo;

import java.awt.Color;
import java.util.List;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import dev.darrenmatthews.starwars.api.StarWarsResources;

public class StarWarsFilm extends StarWarsInformation {

	@SerializedName("title")
	@Expose
	public String title;
	
	@SerializedName("episode_id")
	@Expose
	public Integer episodeId;
	
	@SerializedName("opening_crawl")
	@Expose
	public String openingCrawl;
	
	@SerializedName("director")
	@Expose
	public String director;
	
	@SerializedName("producer")
	@Expose
	public String producer;
	
	@SerializedName("release_date")
	@Expose
	public String releaseDate;
	
	@SerializedName("characters")
	@Expose
	public List<String> characters = null;
	
	@SerializedName("planets")
	@Expose
	public List<String> planets = null;
	
	@SerializedName("starships")
	@Expose
	public List<String> starships = null;
	
	@SerializedName("vehicles")
	@Expose
	public List<String> vehicles = null;
	
	@SerializedName("species")
	@Expose
	public List<String> species = null;
	
	@SerializedName("created")
	@Expose
	public String created;
	
	@SerializedName("edited")
	@Expose
	public String edited;
	
	@SerializedName("url")
	@Expose
	public String url;

	public MessageBuilder getDiscordRender() {
		EmbedBuilder builder = new EmbedBuilder();
		builder.setTitle(this.title);
		builder.setColor(Color.GREEN);
		builder.setFooter("Bot by Dazza");
		builder.addField("Director : ", this.director);
		builder.addField("Release Date : ", this.releaseDate);
		String crawl = this.openingCrawl.replaceAll("\\r\\n", " ");
		builder.addField("Opening Crawl : ", crawl);
		builder.setThumbnail(StarWarsResources.getC3PO());
		
		MessageBuilder mBuilder = new MessageBuilder();
		mBuilder.append("Here is that Star Wars Film you were after you lil Biatch:");
		mBuilder.setEmbed(builder);
		mBuilder.setTts(true);

		return mBuilder;
	}

}
