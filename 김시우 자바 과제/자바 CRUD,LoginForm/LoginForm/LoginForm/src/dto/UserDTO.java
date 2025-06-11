package dto;

public class UserDTO {
    private String id;
    private String pw;
    private String name;
    
    //alt+shift+s 
    // generate getter
    // generate constructor with using field
    
    public UserDTO(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }
}
