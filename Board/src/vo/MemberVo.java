package vo;

public class MemberVo {
	private String id;
	private String pw;
	private String name;
	
	public MemberVo(String id, String pw, String name) {
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
