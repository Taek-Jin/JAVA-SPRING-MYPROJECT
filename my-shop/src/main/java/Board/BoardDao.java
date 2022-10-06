package Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


public class BoardDao {
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Board> boardRowMapper = 
		new RowMapper<Board>() {
		@Override
		public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
			Board board = new Board(
				rs.getString("title"),
				rs.getString("content"),
				rs.getTimestamp("regdate").toLocalDateTime());
			board.setBoard_no(rs.getLong("board_no"));
			board.setView(rs.getLong("view"));
			board.setEMAIL(rs.getString("EMAIL"));
			board.setWriter(rs.getString("writer"));
			return board;
	}
	};
	public BoardDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Board> selectAll(int displayPost, int postNum){
		List<Board> results =  jdbcTemplate.query(	
						"select * from spring5fs.BOARD order by board_no desc limit ?, ?",
						boardRowMapper, displayPost, postNum);
				return results;
		}
		
	public int count() {
		int count = jdbcTemplate.queryForObject("select count(*) from spring5fs.board", Integer.class);
		return count;
	}
	
	public void update(Board board) {
		jdbcTemplate.update("update spring5fs.BOARD set title = ?, content = ? where EMAIL = ?",
				board.getTitle(), board.getContent(), board.getEMAIL());
	}
	
	public Board selectByBoardN(Long board_no) {
		List<Board> results = jdbcTemplate.query("select * from spring5fs.BOARD where board_no = ?", boardRowMapper, board_no);
		return results.isEmpty() ? null : results.get(0);
	}
	public void insert(final Board board) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into spring5fs.BOARD (title, content, writer, EMAIL, regdate)" + "values (?,?,?,?,?)", new String[] {"board_no"});
				pstmt.setString(1, board.getTitle());
				pstmt.setString(2, board.getContent());
				pstmt.setString(3, board.getWriter());
				pstmt.setString(4, board.getEMAIL());
				pstmt.setTimestamp(5, Timestamp.valueOf(board.getRegDate()));
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		board.setBoard_no(keyValue.longValue());
	}
}
