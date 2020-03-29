package dev.darrenmatthews.starwars.pojo;

import java.awt.Color;
import java.util.List;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import dev.darrenmatthews.starwars.api.StarWarsResources;

public class StarWarsPerson {

	@SerializedName("name")
	@Expose
	public String name;
	
	@SerializedName("height")
	@Expose
	public String height;
	
	@SerializedName("mass")
	@Expose
	public String mass;
	
	@SerializedName("hair_color")
	@Expose
	public String hairColor;
	
	@SerializedName("skin_color")
	@Expose
	public String skinColor;
	
	@SerializedName("eye_color")
	@Expose
	public String eyeColor;
	
	@SerializedName("birth_year")
	@Expose
	public String birthYear;
	
	@SerializedName("gender")
	@Expose
	public String gender;
	
	@SerializedName("homeworld")
	@Expose
	public String homeworld;
	
	@SerializedName("films")
	@Expose
	public List<String> films = null;
	
	@SerializedName("species")
	@Expose
	public List<String> species = null;
	
	@SerializedName("vehicles")
	@Expose
	public List<String> vehicles = null;
	
	@SerializedName("starships")
	@Expose
	public List<String> starships = null;
	
	@SerializedName("created")
	@Expose
	public String created;
	
	@SerializedName("edited")
	@Expose
	public String edited;
	
	@SerializedName("url")
	@Expose
	public String url;
	
	public MessageBuilder renderDiscord() {
		MessageBuilder builder = new MessageBuilder();
		
		EmbedBuilder emBuilder = new EmbedBuilder();
		emBuilder.setTitle(this.name);
		emBuilder.addField("Eye Colour :", this.eyeColor);
		emBuilder.addField("Skin Colour :", this.skinColor);
		emBuilder.addField("Hair Colour :", this.hairColor);
		emBuilder.addField("Birth Year :", this.birthYear);
		emBuilder.addField("Mass :", this.mass);
		emBuilder.addField("Height :", this.height);
		emBuilder.setColor(Color.GREEN);
		emBuilder.setThumbnail(StarWarsResources.getC3PO());
		
		builder.setEmbed(emBuilder);
		
		return builder;
	}

}
