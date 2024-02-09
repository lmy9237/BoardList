package vo;

public class BoardVo {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private String writedate;
	private int nor;   // num of replies. 
	
	public BoardVo(int bno, String title, String content, String writer, String writedate, int nor) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writedate = writedate;
		this.nor = nor;
	}

	public int getBno() {
		return bno;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getWriter() {
		return writer;
	}

	public String getWritedate() {
		return writedate;
	}

	public int getNor() {
		return nor;
	}
}
