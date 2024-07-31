package com.website.pojo;

public class ProductDetails {
	private int id;
	private String name;
	private String description;
	private double price;
	private String image;
	private String category;
	private int rating;
	private String stars;
	private String status;
	private int uId;
	private String date;
	private String address;
	private int quantity;
	
	
	
	public ProductDetails(String name, String description, double price, String image, String category, int rating,
			String stars, String status, int uId, String date, String address, int quantity) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.category = category;
		this.rating = rating;
		this.stars = stars;
		this.status = status;
		this.uId = uId;
		this.date = date;
		this.address = address;
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ProductDetails() {
        this.stars = ""; // initialize stars to an empty string
    }
	
	public String getStars() {
		return stars;
	}
	public void setStars(String stars) {
		this.stars = stars;
	}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
	    this.rating = rating;
	    for (int i = 1; i <= rating; i++) {
	        this.stars = this.stars.concat(" <i class=\"fa fa-star checked\"></i>");
	    }
	}
	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", image=" + image + ", rating=" + rating+", status=" + status  + ", category=" + category +", uId=" + uId +", address=" + address +",quantity=" + quantity+" , date=" + date + "]";
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
