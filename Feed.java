/**
 * 
 */
package memory.mingle.feed;

import java.nio.file.Path;
import java.util.ArrayList;

import memory.mingle.video.Video;

/**
 * 
 */
public class Feed {
	ArrayList<Video> feedArray;
	

	/**
	 * 
	 */
	public Feed() {
		feedArray = new ArrayList<Video>();
	}
	
	public void addVideo(Video video) {
		feedArray.add(0, video);
	}
	
	public void removeVideo(Path path) {
		for(int i = 0; i < feedArray.size(); i++) {
			if(feedArray.get(i).getPath().equals(path)) {
				feedArray.remove(i);
			}
		}
	}
	
	public Video getLatestVideo() {
			return feedArray.get(0);
		
	}

}
