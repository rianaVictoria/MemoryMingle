package memory.mingle.gui;

import java.util.ArrayList;

import memory.mingle.profile.Profile;

public class MemoryMingleGUI{
	

	public static ArrayList<Profile> profiles;
	
	
	private static String nameText;
	
	private static String emailText;
	
	private static String passwordText;
	
	public static String name;
	
	public static String email;
	
	public static String password;
	
	public static boolean hasDementia;
	
	public static String hasDementiaString;
	
	public static Profile userProfile;
	
	
	
	public static void main(String[] args) {
		
		collectSignUp();
		
	}
	
	private static void collectSignUp() {
//		nameText = JOptionPane.showInputDialog("Name");
//		emailText = JOptionPane.showInputDialog("Email");
//		passwordText = JOptionPane.showInputDialog("Password");
//		hasDementiaString = JOptionPane.showInputDialog("Do you have Dementia? (Please put in y or n)");
		hasDementia();
	}
	
	private static void hasDementia() {
		if(hasDementiaString.equalsIgnoreCase("y")) {
			hasDementia = true;
		} else if (hasDementiaString.equalsIgnoreCase("n")) {
			hasDementia = false;
		}
	}
	
	private static Profile newProfile() {
		return createProfile(nameText, emailText, passwordText, hasDementia);
	}
	
	private static Profile createProfile(String name, String email, String password, boolean hasDementia) {
		Profile profile = new Profile(name, email, password, hasDementia);
		profiles.add(profile);
		return profile;
	}
	
//	private static 
	
}


///**
// * GameGUI.java
// *
// * This class is used to provide a visual interface for a player
// * in the CSC116 "Connect 4" Game
// * @author Rosalie Rutten
// * @author Varsha Karuturi
// * @author Lilly Galietta
// * @author Naseerah Ali
// */
//public class MemoryMingleGUI extends JFrame implements ActionListener {
//
//
//    /** width of frame */
//    public static final int WIDTH = 800;
//   
//    /** height of frame */
//    public static final int HEIGHT = 600;
//   
//    /** x location of upper-left corner of frame */
//    public static final int X_LOCATION = 100;
//
//    /** y location of upper-left corner of frame */
//    public static final int Y_LOCATION = 100;
//
//    /** constant for value of rows */
//    public static final int VALUE_ROWS = 13;
//
//    /** constant for value of columns */
//    public static final int VALUE_COLS = 2;
//
//
//    /** buttons player will use to indicate a box they want to select */
//    private JButton[][] boxBtns;
//
//    /** Label that shows the current status of the game */
//    private JLabel statusLbl;
//
//    /** Container for all of the box buttons */
//    private JPanel boxPanel;
//
//    /** Container for the labels that show */
//    private JPanel winPanel;
//
//
//
//    /**
//     * Starts the GUI depending on the testing
//     * boolean, stores initial sizes
//     */
//    public GameGUI(){
//        numRows = SIZE; // default number of rows
//        numColumns = SIZE; //default number of columns
//        gridSize = GRIDSIZE; // default grid size
//       
//        setSize(WIDTH,HEIGHT);
//        setLocation(X_LOCATION,Y_LOCATION);
//        String instructions = "Welcome to Connect Four! This version of Connect Four allows you \n"
//            + " to pick the number of pieces you want to connect to win. The goal is \n"
//            + " to connect your pieces faster than your opponent can. Enjoy your game!!";
//        JOptionPane.showMessageDialog(this, instructions, "Information", 
//            JOptionPane.INFORMATION_MESSAGE);
//
//        initializeGUI();
//   
//    }
//
//    /**
//     * Initializes the GUI and displays
//     * it for user to interact with
//     */
//    private void initializeGUI() {
//        setTitle("Connect Four");
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//       
//        promptForConnectionNumber();
//
//
//        Container c = getContentPane();
//        c.setBackground(Color.PINK);
//       
//        statusLbl = new JLabel("Select a box in the column you want to" +
//            "place your token by clicking on it");
//        boxPanel = new JPanel();
//        boxPanel.setLayout(new GridLayout(numRows, numColumns));
//
//
//        winPanel = new JPanel();
//        winPanel.setLayout(new GridLayout(VALUE_ROWS, VALUE_COLS));
//        Border b = BorderFactory.createLineBorder(Color.black);
//        winPanel.setBorder(new TitledBorder(b, "# of Wins", TitledBorder.CENTER,
//            TitledBorder.ABOVE_TOP));
//
//
//        boxBtns = new JButton[numRows][numColumns];    
//       
//       
//       
//        for(int i = 0; i < numRows; i++){
//            for (int j = 0; j < numColumns; j++){
//                boxBtns[i][j] = new JButton("");
//                boxBtns[i][j].setBackground(Color.PINK);
//                boxBtns[i][j].setOpaque(true);
//                boxBtns[i][j].addActionListener(this);
//                boxPanel.add(boxBtns[i][j]);
//            }
//        }
//
//
//        p1GameWins = 0;
//        String initialWinsStringp1 = "Player 1 # of Wins - " + p1GameWins;
//        JLabel p1Wins = new JLabel (initialWinsStringp1);
//        winPanel.add(p1Wins);
//
//
//        JLabel space = new JLabel (" ");
//        winPanel.add(space);
//
//
//        p2GameWins = 0;
//        String initialWinsStringp2 = "Player 2 # of Wins - " + p2GameWins;
//        JLabel p2Wins = new JLabel (initialWinsStringp2);
//        winPanel.add(p2Wins);
//       
//        winPanel.add(Box.createHorizontalStrut(100));
//
//
//        c.add(boxPanel, BorderLayout.CENTER);
//        c.add(statusLbl, BorderLayout.NORTH);
//        c.add(winPanel, BorderLayout.WEST);
//
//
//        setVisible(true);
//
//
//    }
//
//    /**
//     * prompts user for the amount of pieces that they would 
//     *  like to connect in order to win the game
//     */
//    private void promptForConnectionNumber(){
//        String inputText = JOptionPane.showInputDialog(this, 
//            "Input the number of pieces to connect.", 
//            "Connect Amount", JOptionPane.QUESTION_MESSAGE);
//        try {
//            int input = Integer.parseInt(inputText);
//            if (input < INPUT) {
//                JOptionPane.showMessageDialog(null, "Invalid integer.");
//                System.exit(1);
//            }
//            numRows = input * 2;
//            numColumns = input * 2;
//            gridSize = numRows * numColumns;
//
//            grid = new Grid(input);
//
//
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "Invalid input.", 
//                "Error", JOptionPane.ERROR_MESSAGE);
//            System.exit(1);
//        }
//    }
//
//    /**
//     * actionPerformed method that manages the game play
//     * manages what happens in the game if the column is full and if the game is over
//     * asks user if they would like to start a new round after game over
//     * @param e actionevent
//     */
//    public void actionPerformed(ActionEvent e) {
//        int chosenCol = -1;
//        for (int i = 0; i < boxBtns.length; i++) {
//            for (int j = 0; j < boxBtns[i].length; j++) {
//                if (e.getSource() == boxBtns[i][j]) {
//                    char player = grid.setPlayer();
//                    chosenCol = j;
//    
//                    int rowToPlacePiece = openSpaceInCol(chosenCol);
//                    if (rowToPlacePiece < 0) {
//                        statusLbl.setText("Column full, choose a different column");
//                    } else {
//                        grid.placeToken(chosenCol, player);
//    
//                        refreshGUI();
//                    }
//    
//                    if (checkForWinner(player)) {
//                        p1GameWins = grid.getPlayer1Wins();
//                        p2GameWins = grid.getPlayer2Wins();
//                        clearPlayerPanel();
//                        updatePlayerPanel();
//                        int choice = JOptionPane.showConfirmDialog(null, 
//                            "Game Over. Play Another Round?", "End of Round", 
//                            JOptionPane.YES_NO_OPTION);
//                        if (choice == JOptionPane.YES_OPTION) {
//                            grid.startNextRound();
//                            resetButtons();
//                            statusLbl.setText("Place your piece.");
//                            refreshGUI(); // Refresh the entire GUI for a new round
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Thank You For Playing!!");
//                            System.exit(0);
//                        }
//                    }
//                }
//            }
//        }
//    }
//    
//    /**
//     * resets the buttons on the gui
//     */
//    private void resetButtons() {
//        for (int i = 0; i < numRows; i++){
//            for (int j = 0; j < numColumns; j++) {
//                boxBtns[i][j].setText("");
//            }
//        }
//    }
//
//    /**
//     * updates the player panel with number of wins for each player
//     */
//    private void updatePlayerPanel(){
//        String initialWinsStringp1 = "Player 1 # of Wins - " + p1GameWins;
//        JLabel p1Wins = new JLabel (initialWinsStringp1);
//        winPanel.add(p1Wins);
//
//
//        JLabel space = new JLabel (" ");
//        winPanel.add(space);
//
//
//        String initialWinsStringp2 = "Player 2 # of Wins - " + p2GameWins;
//        JLabel p2Wins = new JLabel (initialWinsStringp2);
//        winPanel.add(p2Wins);
//    }
//
//    /**
//     * clears the player panel when a new round of the game starts
//     */
//    private void clearPlayerPanel(){
//        winPanel.removeAll();
//    }
//   
//    /**
//     * finds if there is still space in a certain column for tokens to be placed in it
//     * @param col int column
//     * @return availableRow 
//     */
//    private int openSpaceInCol(int col){
//        int avaliableRow = -1;
//        for (int i = boxBtns.length - 1; i >= 0; i--){
//            if(grid.isFilled(i, col) == false){
//                avaliableRow = i;
//                return avaliableRow;
//            }
//        }
//        return avaliableRow;
//    }
//
//    /**
//     * refreshes the GUI
//     * adds labels such as player 1 pieces, player 2 pieces, player 1 highest connect,
//     *  and player 2 highest connect to the GUI and updates those numbers during gameplay
//     */
//    private void refreshGUI() {
//        for (int i = 0; i < numRows; i++) {
//            for (int j = 0; j < numColumns; j++) {
//                char player = grid.playerPiece(i, j);
//                String piece = player == ' ' ? "" : String.valueOf(player);
//                boxBtns[i][j].setText(piece);
//            }
//        }
//    
//        int player1Count = grid.getCountPlayer1();
//        int player2Count = grid.getCountPlayer2();
//        int player1HC = grid.getPlayer1Connect();
//        int player2HC = grid.getPlayer2Connect();
//        statusLbl.setText("Player 1 pieces: " + player1Count + 
//            "    Player 2 pieces: " + player2Count
//            + "        Player 1 Highest Connect: " + player1HC + 
//            "    Player 2 Highest Connect: " + player2HC);
//    }
//
//    /**
//     * checks for a winner
//     * @param player char for player 1 or 2
//     * @return true if it is the end of the round and there is a winner, otherwise return false
//     */
//    private boolean checkForWinner(char player){
//        if (grid.isEndOfRound(player) == true || 
//            gridSize == (grid.getCountPlayer1() + grid.getCountPlayer2())){
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    /**
//     * main method that creates the GameGUI
//     * @param args command line argument
//     */
//    public static void main(String[] args) {
//        new GameGUI();
//    }
//}