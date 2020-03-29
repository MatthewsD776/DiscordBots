package dev.darrenmatthews.starwars.api;

import java.io.File;

public class StarWarsResources {
	private StarWarsResources() {
	}

	public static File getC3PO() {
		return new File(StarWarsResources.class.getClassLoader().getResource("c3po.png").getFile());
	}
}
