public class Piece {
  private String name;
  private String abbreviation;
  private String att_type;
  private String move_type;
  private String[] move_coords;
  private String[] att_coords;

  public Piece(String name, String abbreviation, String att_type, String move_type, String[] move_coords, String[] att_coords) {
    this.name = name;
    this.abbreviation = abbreviation;
    this.att_type = att_type;
    this.move_type = move_type;
    this.move_coords = move_coords;
    this.att_coords = att_coords;
  }

  public String getName() {
  	return name;
  }
  
  public void setName(String name) {
  	this.name = name;
  }
  
  public String getAbbreviation() {
  	return abbreviation;
  }
  
  public void setAbbreviation(String abbreviation) {
  	this.abbreviation = abbreviation;
  }
  
  public String getAtt_type() {
  	return att_type;
  }
  
  public void setAtt_type(String att_type) {
  	this.att_type = att_type;
  }
  
  public String getMove_type() {
  	return move_type;
  }
  
  public void setMove_type(String move_type) {
  	this.move_type = move_type;
  }
  
  public String[] getMove_coords() {
  	return move_coords;
  }
  
  public void setMove_coords(String[] move_coords) {
  	this.move_coords = move_coords;
  }
  
  public String[] getAtt_coords() {
  	return att_coords;
  }
  
  public void setAtt_coords(String[] att_coords) {
  	this.att_coords = att_coords;
  }
}