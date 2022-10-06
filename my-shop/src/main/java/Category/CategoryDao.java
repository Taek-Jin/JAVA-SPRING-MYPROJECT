package Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class CategoryDao {

private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Category> categoryRowMapper = 
		new RowMapper<Category>() {
		@Override
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category category = new Category();
			category.setTier(rs.getInt("tier"));
			category.setCateName(rs.getString("cateName"));
			category.setCateCode(rs.getInt("cateCode"));
			category.setCateParent(rs.getInt("cateParent"));
			return category;
	}
	};
	public CategoryDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Category> selectAll(){
		List<Category> results =  jdbcTemplate.query(	
						"select * from spring5fs.CATEGORY",
						categoryRowMapper);
				return results;
		}
}
