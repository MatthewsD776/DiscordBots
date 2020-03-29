package dev.darrenmatthews.starwars.pojo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StarWarsQuery {
	@SerializedName("count")
	@Expose
	public Integer count;
	
	@SerializedName("next")
	@Expose
	public Object next;
	
	@SerializedName("previous")
	@Expose
	public Object previous;
	
	@SerializedName("results")
	@Expose
	public List<StarWarsInformation> results = null;

}
