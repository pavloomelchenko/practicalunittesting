package com.mycompany.put.other;

public class OperatingSystem {
	protected int nbOfBits;
	protected String name;
	protected String version;
	protected int releaseYear;

	// getters and setters omitted
	public int getNbOfBits() {
		return nbOfBits;
	}

	public void setNbOfBits(int nbOfBits) {
		this.nbOfBits = nbOfBits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

}