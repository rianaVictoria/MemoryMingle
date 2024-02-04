/**
 * 
 */
package memory.mingle.profile;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

import memory.mingle.feed.Feed;
import memory.mingle.video.Video;

/**
 * 
 */
public class Profile {
	
	String name; 
	
	String email; 
	
	String password;
	 
	Feed profileFeed;
	
	String phoneNumber;
	
	boolean hasDementia;
	
	boolean hasPosted;
	
	LocalDate dateToday;
	
	public ArrayList<Profile> requests;
	
	public ArrayList<Profile> profiles;
	

	/**
	 * 
	 */
	public Profile(String name, String email, String password, boolean hasDementia) {
		profileFeed = new Feed();
		setName(name);
		setEmail(email);
		setPassword(password);
		setDementia(hasDementia);
		this.requests = new ArrayList<Profile>();
		this.profiles = new ArrayList<Profile>();
		//this.hasPosted = postedToday();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the profileFeed
	 */
	public Feed getProfileFeed() {
		return profileFeed;
	}

	/**
	 * @param profileFeed the profileFeed to set
	 */
	public void setProfileFeed(Feed profileFeed) {
		this.profileFeed = profileFeed;
	}
	
	
	public boolean getHasPosted() {
		return hasPosted;
	}
	
	public LocalDate getTodayDate() {
		dateToday = java.time.LocalDate.now();
		return dateToday;
	}
	
	public boolean getDementia() {
		return hasDementia;
	}
	
	public void setDementia(boolean hasDementia) {
		this.hasDementia = hasDementia;
	}
	
	public boolean postedToday() {
		if (profileFeed.getLatestVideo().getDate() == getTodayDate()) {
			return true;
		} else { 
			return false;
		}
	}

	public String notification() {
		String s = "";
		if(!postedToday()) {
			s = ("Hey " + name + ", be sure to post your Mingle for today!");
		}
		return s;
	}
	
	public Video reply(String fileName) {
		return new Video(fileName);
	}
	
	public ArrayList<Profile> getRequests(){
		return requests;
	}
	

}

