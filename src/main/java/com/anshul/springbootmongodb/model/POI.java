/**
 * 
 */
package com.anshul.springbootmongodb.model;

import java.io.Serializable;

/**
 * @author anshul
 *
 */
public class POI implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = -4545841727054824573L;
	private String nameOfPoint;
	private double lat;
	private double lon;

	/**
	 * 
	 */
	public POI() {
		super();
	}

	/**
	 * @param nameOfPoint
	 * @param lat
	 * @param lon
	 */
	public POI(String nameOfPoint, double lat, double lon) {
		this();
		this.nameOfPoint = nameOfPoint;
		this.lat = lat;
		this.lon = lon;
	}

	public String getNameOfPoint() {
		return nameOfPoint;
	}

	public void setNameOfPoint(String nameOfPoint) {
		this.nameOfPoint = nameOfPoint;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lon);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		POI other = (POI) obj;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lon) != Double.doubleToLongBits(other.lon))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "POI [nameOfPoint=" + nameOfPoint + ", lat=" + lat + ", lon=" + lon + "]";
	}

}
