import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class GameState {
  private int size;
  private String[][] board;
  private String[][] attacked;

  public static HashMap<String, Piece> pieces_ntypes = new HashMap<String, Piece>();

  public static void setpiecemap() {
    String all_things = "";
    try {
      File piecedata = new File("PieceData.txt");
      Scanner reader = new Scanner(piecedata);
      while (reader.hasNextLine()) {
        all_things += reader.nextLine() + " "; 
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An Error Occurred");
      e.printStackTrace();
    }
    String[] al_things = all_things.split(" ");
    for (int i = 0; i < al_things.length; i++) {
      if (al_things[i] == "0=|==>") {
        int j = i + 5;
        int t = 0;
        while (al_things[j] != "0=|==>" || al_things[j] != "~") {
          j += 1;
          t += 1;
        }
        String[] move_coords = new String[t];
        int l = 0;
        for (int k = i + 5; k < k + t; k++){
          move_coords[l] = al_things[k];
          l += 1;
        }
        if (al_things[i+3] == "AT" || al_things[i+3] == "NO") {
          Piece new_piece = new Piece(al_things[i+1], al_things[i+2], al_things[i+3], al_things[i+4], move_coords, move_coords);
          pieces_ntypes.put(al_things[i+1], new_piece);
        }
        else {
          String[] att_coords = new String[2];
          int o = 0;
          for (int u = i + t + 6; u < 2; u++){
            att_coords[o] = al_things[u];
            o += 1;
          }
          Piece new_piece = new Piece(al_things[i+1], al_things[i+2], al_things[i+3], al_things[i+4], move_coords, att_coords);
          pieces_ntypes.put(al_things[i+1], new_piece);
        }
      }
      i += 1;
    }
    System.out.println(pieces_ntypes.get("Knight").getMove_coords());
  }
  // GameState test = new Gamestate(8);
  // Constructor will take in the size of the board and the coordinates of different pieces (in their starting locations) in a 2d array, in the format [[Piece, x_coord, y_coord, color], [Piece, x_coord, y_coord, color]]
  public GameState(int size, String[][] pieces) {
  // ArrayList<String> piece_types = new ArrayList<String>();
  // Initialize an empty board
  String[][] board = new String[size][size];
  for (int i = 0; i < size; i++) {
    for (int j = 0; j < size; j++) {
      board[i][j] = "E";
    }
  }
  // Initialize pieces in their starting locations
  for (int i = 0; i < pieces.length; i++) {
    String piece = pieces[i][0];
    int x_coord = Integer.parseInt(pieces[i][1]);
    int y_coord = Integer.parseInt(pieces[i][2]);
    String color = pieces[i][3];
    
    board[8 - y_coord][x_coord] = color + " " + piece;
  }

  this.size = size;
  this.board = board;
  }

  public int getSize() {
    return this.size;
  }

  public String[][] getBoard() {
    return this.board;
  }
  
  public boolean checkMove(boolean specialMove, int x1, int y1, int x2, int y2) {
    // Check whether a move is valid according to 3 conditions: The starting square contains a piece, the move is valid for the piece at the starting square, and the ending square is empty or contains a capturable opposite colored piece.
    String piece_type = this.board[x1][x2];
    if (specialMove == false) {
      Piece piece = pieces_ntypes.get(piece_type);
      if (piece.getMove_type() == "non-infinite") {
        
      }
    }
    
    return false;
  }

  // public void exchangePiece() {
    
  // }
}
