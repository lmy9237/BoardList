package vo;

public class ReplyVo {
	private int rno;
	private int bno;
	private String content;
	private String writer;
	private String writedate;
	
	public ReplyVo(int rno, int bno, String content, String writer, String writedate) {
		this.rno = rno;
		this.bno = bno;
		this.content = content;
		this.writer = writer;
		this.writedate = writedate;
	}

	public int getRno() {
		return rno;
	}

	public int getBno() {
		return bno;
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
}
