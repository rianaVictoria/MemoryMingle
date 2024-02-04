/**
 * 
 */
package memory.mingle.video;
import java.nio.file.Path;

//import java.io.File;
import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;


/**
 * 
 */
public class Video {
	
	String caption;
	 
	boolean reply;
	
	Path path;
	
	LocalDate date;
	
	

	/**
	 * 
	 */
	public Video(String fileName, String caption) {
		setCaption(caption);
		this.path = Path.of(fileName);	
		this.reply = false;
		setDate();
	
	}
	
	public Video(String fileName) {
		this.caption = "";
		this.path = Path.of(fileName);
		this.reply = false;
		setDate();
	}

	/**
	 * @return the caption
	 */
	public String getCaption() {
		return caption;
	}

	/**
	 * @param caption the caption to set
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}

	/**
	 * @return the reply
	 */
	public boolean isReply() {
		return reply;
	}

	/**
	 * @param reply the reply to set
	 */
	public void setReply(boolean reply) {
		this.reply = reply;
	}

	/**
	 * @return the path
	 */
	public Path getPath() {
		return path;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate() {
		date = java.time.LocalDate.now();
	}
	
	public String getFileName() {
		return this.getFileName();
	}

	
	
	
	

}

