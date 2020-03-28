package dev.darrenmatthews.restapi;

import java.awt.Color;
import java.io.IOException;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.json.JSONObject;

import dev.darrenmatthews.discord.exceptions.BitchException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StarWarsAPI {
	
	public static MessageBuilder getFilmInformation(String filmId) throws BitchException {		
		OkHttpClient client = new OkHttpClient();
		
		String url = "https://swapi.co/api/films/" + filmId;
		
		Request request = new Request.Builder().url(url).build();
		
		try {
			System.out.println("going for " + url);
			Response response = client.newCall(request).execute();
			
			if(!response.isSuccessful()) {
				throw new BitchException("Film Not Found by API");
			}
			
			String json = response.body().string();
			JSONObject obj = new JSONObject(json);
			
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
			
		} catch (IOException e) {
			System.out.println("Error getting the API");
		}
		
		return null;
	}

}
