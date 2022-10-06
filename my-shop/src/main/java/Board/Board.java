package Board;

import java.time.LocalDateTime;

public class Board {

    private Long board_no;
    private String title;
    private String content;
    private String writer;
    private String EMAIL;
    private LocalDateTime regdate;
    private Long view;

	public Board(String title, String content, LocalDateTime regdate) {
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}
	
		
	public Long getBoard_no() {
		return board_no;
	}
	
	public void setBoard_no(Long board_no) {
		this.board_no = board_no;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getEMAIL() {
		return EMAIL;
	}
	
	public void setEMAIL(String EMAIL) {
		this.EMAIL = EMAIL;
	}
	
	public LocalDateTime getRegDate() {
		return regdate;
	}
	
	public void setRegDate(LocalDateTime regdate) {
		this.regdate = regdate;
	}
	
	public Long getView() {
		return view;
	}
	
	public void setView(Long view) {
		this.view = view;
	}


}
