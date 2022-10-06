package Login;

public class AuthInfo {

	private Long id;
	private String email;
	private String name;
	private int id_num;
	
	public AuthInfo(Long id, String email, String name, int id_num) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.id_num = id_num;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId_num() {
		return id_num;
	}
}
