package memory.mingle.gui;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import memory.mingle.profile.Profile;
import memory.mingle.video.Video;


public class MemoryMingleGUI{
	

	public static ArrayList<Profile> profiles;
	
	public static String name;
	
	public static String email;
	
	public static String password;
	
	public static boolean hasDementia;
	
	public static String hasDementiaString;
	
	public static Profile userProfile;
	
	
	
	public static void main(String[] args) {
		//post("C:\\Users\\nasee\\git\\MemoryMingle\\MemoryMingle\\test-file");
		//post("test-video.mp4");
		//post("///C:/Users/nasee/git/MemoryMingle/MemoryMingle/test-video.mp4");
		
		profiles = new ArrayList<Profile>();
		setUp();
		Scanner scan =  new Scanner(System.in);
		signUp(scan);
		
		Profile newProf = newProfile(name, email, password, hasDementia);
		addProfile(newProf);
		
		
		System.out.println();
		
		//lowk request method, make this a method and make sure to add profile to request array list of requested or inputed person
		System.out.println("Add a loved one!");
		System.out.print("Enter email: ");
		String reqEmail = scan.next();
		System.out.print("Enter your relationship to them: ");
		scan.next();
		System.out.print("Enter their relationship to you: ");
		String relationshipTheir = scan.next();
		
		request(reqEmail, relationshipTheir,newProf);
		
		//demo purposes!
		System.out.println("Since you have no connections, come back when we notify that you do!");
		
		//logging in dementia patient
		int loggedIdx = logIn(scan);
		Profile loggedIn = null;
		if(loggedIdx > -1) {
			loggedIn = profiles.get(loggedIdx);
		} else {
			System.out.println("log in unsuccessful!");
		}
		
		System.out.println();
		System.out.println("Welcome, " + loggedIn.getName());
		
		//accept request from grandD for demo
		System.out.println("You have one request from " + loggedIn.getRequests().get(0).getName());
		System.out.println("Type 'a' to accept or 'r' to reject");
		String accept = scan.next();
		
		acceptRequest(loggedIn, loggedIn.requests.get(0));
		
		System.out.println("You may now start making memories with " + loggedIn.profiles.get(0).getName());
		String choice = displayMenu(scan);
		while(!scan.next().equalsIgnoreCase("Q")) {
			choice = displayMenu(scan);
			if (choice.equalsIgnoreCase("p")) {
				System.out.print("Enter your file path:");
				String fileName = scan.next();
				post(fileName);
				displayMenu(scan);
			} else if (choice.equalsIgnoreCase("q")) {
				System.exit(1);
			} else if(choice.equalsIgnoreCase("L")){
				int loggedOut = logOut(loggedIn);
				if (loggedOut == -1) {
					System.out.print("Logout successful!");
					logIn(scan);
				}
			}
		}
		
	}
	
	public static String displayMenu(Scanner scan) {
		System.out.print("Here are your options!: \n"
				+ "P: post your videos \n"
				+ "Q: quit the program \n"
				+ "A: send a request to someone \n"
				+ "R: see your current requests \n"
				+ "L: Logout \n"
				);
		String choice = scan.next();
		return choice;
	}
	
	public static void setUp() {
		Profile prof1 = newProfile("Jenny Han", "jenhan@gmail.com", "p123", false);
		Profile dementiaProf = newProfile("Kelly Clarkson", "kellyClarkson@gmail.com", "monkeyingAround", true);
		Profile prof2 = newProfile("Caleb Johnson", "cjohnson@gmail.com", "p444", false);
		Profile prof3 = newProfile("Lily Anne", "lilyAnne@gmail.com", "lilyAnne", false);
		
		//works!
		
		addProfile(dementiaProf);
		addProfile(prof1);
		addProfile(prof2);
		addProfile(prof3);
	}
	
	public static int logOut(Profile loggedIn) {
		loggedIn = null;
		return -1;
	}
	
	
	public static void signUp(Scanner scan) {
		
		System.out.println("Sign Up!");
		
		//asking for name
		System.out.print("Enter full name: ");
		name = scan.nextLine();
		
		//asking for email
		System.out.print("Enter email: ");
		email = scan.nextLine();
		
		//asking for password
		System.out.print("Password: ");
		password = scan.nextLine();
		
		//asking whether you have dementia
		System.out.print("Do you have dementia? y or n: ");
		hasDementiaString = scan.next();
		
		if(hasDementiaString.equals("y")) {
			hasDementia = true;
		} else {
			hasDementia = false;
		}
	}
	
	public static void post(String fileName) {
	        // Replace "your_video_file_path.mp4" with the actual path to your video file
	        
	        File fileVideo = new File(fileName);
	        String videoFilePath = fileVideo.getAbsolutePath();
	        //fix
	        System.out.println(videoFilePath);
	        //String videoFilePath = absolute;

	        // Use the appropriate command based on your operating system and media player
	        String os = System.getProperty("os.name").toLowerCase();
	        String command = "";

	        if (os.contains("win")) {
	            // Windows
	            command = "cmd /c start vlc " + videoFilePath;
	        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
	            // Linux or MacOS
	            command = "vlc " + videoFilePath;
	        } else {
	            System.out.println("Unsupported operating system");
	            System.exit(1);
	        }

	        try {
	            // Execute the command
	            ProcessBuilder processBuilder = new ProcessBuilder	(command.split(" "));
	            Process process = processBuilder.start();

	            // Wait for the process to finish (optional)
	            int exitCode = process.waitFor();
	            //System.out.println("Video player exited with code: " + exitCode);
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	        }
	    //Video videoPost = new Video(fileName);
	    //profile.getProfileFeed().addVideo(videoPost);
	}
	
	private static void request(String email, String relashTheir, Profile requester) {		
		boolean accountFound = false;
		for(Profile p : profiles) {
			if(p.getEmail().equals(email)) {
				System.out.println("Account found!");
				System.out.println("Sending request to " + p.getName() + ", your " + relashTheir);
				p.requests.add(requester);
				accountFound = true;
				break;
			}
		}
		
		if(!accountFound) {
			System.out.println("Account not found!");
		}
	}
	
	private static void acceptRequest(Profile requester, Profile requestee) {
		requester.requests.remove(requestee);
		requester.profiles.add(requestee);
	}
	
	private static Profile newProfile(String name, String email, String password, boolean hasDementia) {
		return new Profile(name, email, password, hasDementia);
	}
	
	private static void addProfile(Profile profile) {
		profiles.add(profile);
	}
	
	private static int logIn(Scanner scan) {
		System.out.println("Log In!"); 
		System.out.print("Enter email: ");
		email = scan.next();
		//asking for password
		System.out.print("Password: ");
		password = scan.next();
		
		int idx = -1;
		for(int i = 0; i < profiles.size(); i++) {
			if(profiles.get(i).getEmail().equals(email) && profiles.get(i).getPassword().equals(password)) {
				idx = i;
			}
		}

		return idx;
	}
	
	
	
}
