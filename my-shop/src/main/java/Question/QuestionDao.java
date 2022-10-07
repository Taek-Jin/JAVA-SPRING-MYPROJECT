package Question;

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

import Question.Question;

public class QuestionDao {
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Question> questionRowMapper = 
		new RowMapper<Question>() {
		@Override
		public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
			Question question = new Question(
				rs.getString("title"),
				rs.getString("content"),
				rs.getTimestamp("regdate").toLocalDateTime());
			question.setQuestion_no(rs.getInt("question_no"));
			question.setEMAIL(rs.getString("EMAIL"));
			question.setWriter(rs.getString("writer"));
			return question;
	}
	};
	public QuestionDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Question> selectAll(int displayPost, int postNum){
		List<Question> results =  jdbcTemplate.query(	
						"select * from spring5fs.question order by question_no desc limit ?, ?",
						questionRowMapper, displayPost, postNum);
				return results;
		}
		
	public int count() {
		int count = jdbcTemplate.queryForObject("select count(*) from spring5fs.question", Integer.class);
		return count;
	}
	
	public void delete(Question question) {
		jdbcTemplate.update("delete from spring5fs.question where question_no = ?",
			 question.getQuestion_no());
	}
	
	public void update(Question question) {
		jdbcTemplate.update("update spring5fs.question set title = ?, content = ? where question_no = ?",
				question.getTitle(), question.getContent(), question.getQuestion_no());
	}
	public void updateStatus(Question question) {
		jdbcTemplate.update("update spring5fs.question set status = ? where question_no = ?",
				question.getStatus(), question.getQuestion_no());
	}
	
	public Question selectByQuestionN(int question_no) {
		List<Question> results = jdbcTemplate.query("select * from spring5fs.question where question_no = ?", questionRowMapper, question_no);
		return results.isEmpty() ? null : results.get(0);
	}
	public void insert(final Question question) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into spring5fs.question (title, content, writer, EMAIL, regDate)" + "values (?,?,?,?,?)", new String[] {"question_no"});
				pstmt.setString(1, question.getTitle());
				pstmt.setString(2, question.getContent());
				pstmt.setString(3, question.getWriter());
				pstmt.setString(4, question.getEMAIL());
				pstmt.setTimestamp(5, Timestamp.valueOf(question.getRegDate()));
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		question.setQuestion_no(keyValue.intValue());
	}
}

