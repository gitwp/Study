package org.beans;

import oracle.sql.BLOB;

public class TbImage {

	private Integer id;
	private String name;
	private byte[] images;
	private BLOB image;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getImages() {
		return images;
	}
	public void setImages(byte[] images) {
		this.images = images;
	}
	public BLOB getImage() {
		return image;
	}
	public void setImage(BLOB image) {
		this.image = image;
	}
	
	
}
