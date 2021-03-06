package tweetBasic;

import static tweetBasic.AWSResourceSetup.*;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "tweet-db")
public class Tweet {
	
	private String id;
	private String content;
	private String username;
	private String userLocation;
	private double userLat;
	private double userLng;
	private double geoLat;
	private double geoLng;
	private Date createdDate;
	private long createdLong;
	
	private String category;
	private String sentiment;
	
	public Tweet(){
		
	}

	public Tweet(String id, String username, String content, String userLocation, double geoLat,
			double geoLng, Date createdDate) {
		super();
		this.id = id;
		this.username = username;
		this.content = content;
		this.userLocation = userLocation;
		this.geoLat = geoLat;
		this.geoLng = geoLng;
		this.createdDate = createdDate;
		this.createdLong = createdDate.getTime();
	}


	public void saveTweetToDynamoDB(){
    	DYNAMODB_MAPPER.save(this);
    }
	
	@DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getUserLocation() {
		return userLocation;
	}


	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}


	public double getUserLat() {
		return userLat;
	}


	public void setUserLat(double userLat) {
		this.userLat = userLat;
	}


	public double getUserLng() {
		return userLng;
	}


	public void setUserLng(double userLng) {
		this.userLng = userLng;
	}


	public double getGeoLat() {
		return geoLat;
	}


	public void setGeoLat(double geoLat) {
		this.geoLat = geoLat;
	}


	public double getGeoLng() {
		return geoLng;
	}


	public void setGeoLng(double geoLng) {
		this.geoLng = geoLng;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getSentiment() {
		return sentiment;
	}


	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}
	
	
	public long getCreatedLong() {
		return createdLong;
	}


	public void setCreatedTime(long createdLong) {
		this.createdLong = createdLong;
	}
	
	public void setCreatedLong(long createdLong) {
		this.createdLong = createdLong;
	}

	
	public static void main(String[] args) {
		 Tweet t = new Tweet("1", "hehe", "Hello Twitter World!", "New York", 40.0, 74.0, new Date());
		 t.category = "test";
		 t.sentiment = "positive";
		 t.saveTweetToDynamoDB();
	}
	
}
