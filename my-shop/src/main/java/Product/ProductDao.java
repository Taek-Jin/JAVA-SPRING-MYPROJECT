package Product;

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


public class ProductDao {

	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Product> productRowMapper = 
		new RowMapper<Product>() {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
				product.setProductsId(rs.getInt("productsId"));
				product.setProductsName(rs.getString("productsName"));
				product.setBrandId(rs.getString("brandId"));
				product.setPubleYear(rs.getString("publeYear"));
				product.setPublisher(rs.getString("publisher"));
				product.setCateCode(rs.getString("cateCode"));
				product.setCateName(rs.getString("cateName"));
				product.setProductsPrice(rs.getInt("productsPrice"));
				product.setProductsStock(rs.getInt("productsStock"));
				product.setProductsDiscount(rs.getDouble("productsDiscount"));
				product.setProductsIntro(rs.getString("productsIntro"));
				product.setProductsContents(rs.getString("productsContents"));
				product.setRegDate(rs.getTimestamp("regDate").toLocalDateTime());
				product.setUpdateDate(rs.getTimestamp("updateDate").toLocalDateTime());
				product.setImagePath(rs.getString("imagePath"));
				product.setImageName(rs.getString("imageName"));
				return product;
	}
	};
	public ProductDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
		
	public int count() {
		int count = jdbcTemplate.queryForObject("select count(*) from spring5fs.products", Integer.class);
		return count;
	}
	
	public void update(Product product) {
		jdbcTemplate.update("update spring5fs.products set productsName = ?, productsPrice = ?, productsStock = ?, productsDiscount = ?,productsIntro = ?, productsContents where productsId = ?",
				product.getProductsName(), product.getProductsPrice(),
				product.getProductsStock(),product.getProductsDiscount(),
				product.getProductsIntro(), product.getProductsContents() ,product.getProductsId());
	}
	
	public Product selectByProductId(int productsId) {
		List<Product> results = jdbcTemplate.query("select * from spring5fs.products where productsId = ?", productRowMapper, productsId);
		return results.isEmpty() ? null : results.get(0);
	}
	public List<Product> selectAll(){
		List<Product> results =  jdbcTemplate.query(	
						"select * from spring5fs.products order by regDate desc limit 0, 7",
						productRowMapper);
				return results;
		}
	public void insert(final Product product) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into spring5fs.products (productsName, brandId, publeYear, publisher, cateCode, cateName, productsPrice, productsStock, productsDiscount, productsIntro, productsContents, regDate, updateDate, imagePath, imageName)" + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new String[] {"productsId"});
				pstmt.setString(1, product.getProductsName());
				pstmt.setString(2, product.getBrandId());
				pstmt.setString(3, product.getPubleYear());
				pstmt.setString(4, product.getPublisher());
				pstmt.setString(5, product.getCateCode());
				pstmt.setString(6, product.getCateName());
				pstmt.setInt(7, product.getProductsPrice());
				pstmt.setInt(8, product.getProductsStock());
				pstmt.setDouble(9, product.getProductsDiscount());
				pstmt.setString(10, product.getProductsIntro());
				pstmt.setString(11, product.getProductsContents());
				pstmt.setTimestamp(12, Timestamp.valueOf(product.getRegDate()));
				pstmt.setTimestamp(13, Timestamp.valueOf(product.getUpdateDate()));
				pstmt.setString(14, product.getImagePath());
				pstmt.setString(15, product.getImageName());
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		product.setProductsId(keyValue.intValue());
	}
}
