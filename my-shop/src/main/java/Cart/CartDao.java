package Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


public class CartDao {

	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Cart> cartRowMapper = 
		new RowMapper<Cart>() {
		@Override
		public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cart cart = new Cart();
			cart.setCartId(rs.getInt("cartId"));
			cart.setEMAIL(rs.getString("EMAIL"));
			cart.setProductsId(rs.getInt("productsId"));
			cart.setProductsCount(rs.getInt("productsCount"));
			return cart;
	}
	};
	private RowMapper<Cart> cartRowMapper2 = 
			new RowMapper<Cart>() {
			@Override
			public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cart cart = new Cart();
				cart.setCartId(rs.getInt("cartId"));
				cart.setEMAIL(rs.getString("EMAIL"));
				cart.setProductsId(rs.getInt("productsId"));
				cart.setProductsCount(rs.getInt("productsCount"));
				cart.setProductsName(rs.getString("productsName"));
				cart.setProductsPrice(rs.getInt("productsPrice"));
				cart.setProductsDiscount(rs.getDouble("productsDiscount"));
				return cart;
		}
		};
	public CartDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Cart> selectAll(String EMAIL){
		List<Cart> results =  jdbcTemplate.query(	
						"select * from spring5fs.cart join spring5fs.products using (productsId) where EMAIL= ?",
						cartRowMapper2, EMAIL);
		for(Cart cart : results) {
			cart.initSaleTotal();
		}
		return results;
		}
		
	public int count() {
		int count = jdbcTemplate.queryForObject("select count(*) from spring5fs.cart", Integer.class);
		return count;
	}
	
	public void update(Cart cart) {
		jdbcTemplate.update("update spring5fs.cart set productsCount = ? where cartId = ?",
				cart.getProductsCount(), cart.getCartId());
	}
	
	public void delete(Cart cart) {
		jdbcTemplate.update("delete from spring5fs.cart where cartId = ?",
				cart.getCartId());
	}
	
	public Cart checkCart(Cart cart) {
		List<Cart> results = jdbcTemplate.query("select * from spring5fs.cart where EMAIL = ? AND productsId = ?", cartRowMapper, cart.getEMAIL(), cart.getProductsId());
		return results.isEmpty() ? null : results.get(0);
	}
	
	public int insert(final Cart cart) throws Exception {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into spring5fs.cart (EMAIL, productsId, productsCount)" + "values (?,?,?)", new String[] {"cartId"});
				pstmt.setString(1, cart.getEMAIL());
				pstmt.setInt(2, cart.getProductsId());
				pstmt.setInt(3, cart.getProductsCount());
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		cart.setCartId(keyValue.intValue());
		return 1;
	}
}
