package spring;

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

public class MemberDao {

	private JdbcTemplate jdbcTemplate;

	private RowMapper<Member> memRowMapper = 
		new RowMapper<Member>() {
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member member = new Member(
				rs.getString("EMAIL"),
				rs.getString("PASSWORD"),
				rs.getString("NAME"),
				rs.getTimestamp("REGDATE").toLocalDateTime());
			member.setId(rs.getLong("ID"));
			member.setId_num(rs.getInt("id_num"));
			return member;
	}
	};
	private RowMapper<Member> memRowMapper2 = 
			new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(
					rs.getString("EMAIL"),
					rs.getString("PASSWORD"),
					rs.getString("NAME"),
					rs.getTimestamp("REGDATE").toLocalDateTime());
				member.setId(rs.getLong("ID"));
				member.setId_num(rs.getInt("id_num"));
				member.setPhoneNumber(rs.getString("phoneNumber"));
				member.setAddr1(rs.getString("addr1"));
				member.setAddr2(rs.getString("addr2"));
				member.setAddr3(rs.getString("addr3"));
				member.setAddr(rs.getString("addr1"),rs.getString("addr2"),rs.getString("addr3"));
				return member;
		}
		};
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query(
			"select * from spring5fs.MEMBER where EMAIL = ?",
			memRowMapper, email);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public List<Member> selectAll(){
		List<Member> results = jdbcTemplate.query("select * from spring5fs.MEMBER",
								memRowMapper);
		return results;
	}
	
	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from spring5fs.MEMBER", Integer.class);
		return count;
	}
	
	public void update(Member member) {
		jdbcTemplate.update("update spring5fs.MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?",
				member.getName(), member.getPassword(), member.getEmail());
	}
	
	public void insert(final Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into spring5fs.MEMBER (EMAIL, PASSWORD, NAME, REGDATE, phoneNumber, addr1, addr2, addr3, addr)" + "values (?,?,?,?,?,?,?,?,?)", new String[] {"ID"});
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
				pstmt.setString(5, member.getPhoneNumber());
				pstmt.setString(6, member.getAddr1());
				pstmt.setString(7, member.getAddr2());
				pstmt.setString(8, member.getAddr3());
				pstmt.setString(9, member.getAddr());
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}
	
	public Member selectById(Long memId) {
		List<Member> results = jdbcTemplate.query("select * from spring5fs.MEMBER where ID = ?", memRowMapper2, memId);
		return results.isEmpty() ? null : results.get(0);
	}
}
