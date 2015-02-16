package org.vaadin.artur.whatsnewinvaadin74.data;

import java.util.Random;

public class Address {

	private String streetAddress, city;
	private Country country;

	public Address(Random r) {
		streetAddress = streetNames[r.nextInt(streetNames.length)] + " "
				+ (r.nextInt(80) + 1);
		city = cities[r.nextInt(cities.length)];
		country = Country.values()[r.nextInt(Country.values().length)];
	}

	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * @param streetAddress
	 *            the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	private static String[] streetNames = new String[] { "Fairway Drive",
		"Mulberry Lane", "Mill Street", "Route 44", "Ivy Lane",
		"Maple Avenue", "Lexington Court", "Market Street",
		"Mulberry Street", "River Road", "Summer Street", "Church Road",
		"Willow Lane", "Valley View Road", "Manor Drive",
		"Jefferson Avenue", "Main Street East", "Hillside Avenue",
		"Green Street", "Walnut Avenue", "Route 29", "Shady Lane",
		"Pearl Street", "Canterbury Drive", "11th Street", "Orchard Lane",
		"Cypress Court", "Route 7", "Route 202", "Overlook Circle",
		"Hartford Road", "Crescent Street", "Valley Road", "Elm Street",
		"Ann Street", "Ridge Avenue", "Franklin Avenue",
		"6th Street North", "9th Street", "Cross Street", "Redwood Drive",
		"Hawthorne Lane", "8th Street West", "Park Place",
		"Hillcrest Avenue", "Route 30", "Windsor Court", "Heather Court",
		"Woodland Drive", "Route 41" };
	private static String[] cities = new String[] { "Abidjan", "Addis Ababa",
		"Ahmedabad", "Ankara", "Baghdad", "Bangalore", "Beijing", "Berlin",
		"Bogota", "Busan", "Cairo", "Cape Town", "Chennai", "Dhaka",
		"Dongguan", "Durban", "Guangzhou", "Ho Chi Minh City", "Hong Kong",
		"Hyderabad", "Istanbul", "Jaipur", "Jakarta", "Jeddah", "Kinshasa",
		"Kolkata", "Lagos", "Lahore", "London", "Los Angeles", "Madrid",
		"Mexico City", "Moscow", "Mumbai", "Nairobi", "New Taipei City",
		"New York City", "Pyongyang", "Rio de Janeiro", "Saint Petersburg",
		"Sao Paulo", "Seoul", "Shanghai", "Shenyang", "Shenzhen",
		"Singapore", "Tehran", "Tokyo", "Yangon", "Yokohama" };

}
