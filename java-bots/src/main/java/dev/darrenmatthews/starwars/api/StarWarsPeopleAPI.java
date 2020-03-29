package dev.darrenmatthews.starwars.api;

import dev.darrenmatthews.exceptions.RestAPIException;
import dev.darrenmatthews.libs.RestAPI;
import dev.darrenmatthews.starwars.pojo.StarWarsPerson;

public class StarWarsPeopleAPI extends StarWarsAPI {

	public static StarWarsPerson getPersonById(String id) throws RestAPIException {
		String jsonString = RestAPI.getRequest(STAR_WARS_API_PEOPLE_ROOT + id);
		return gson.fromJson(jsonString, StarWarsPerson.class);
	}

}
