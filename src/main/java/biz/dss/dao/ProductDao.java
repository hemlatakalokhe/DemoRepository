package biz.dss.dao;

import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Component;

@Component
public class ProductDao {
	@Autowired
	// private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void add(Product product) {

		String query = "insert into tbl_product values(?,?,?)";
		jdbcTemplate.update(query, product.getId(), product.getName(), product.getPrice());
		
		
		

		// Using JDBCTemplate
		/*
		  String query = "insert into tbl_product values(?,?,?)";
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 jdbcTemplate.update(query, product.getId(), product.getName(),product.getPrice());
		 
		 */

		// Regular Connection
		/*
		 * Connection con=null;
		 * 
		 * try { con=dataSource.getConnection(); 
		 * PreparedStatementpst=con.prepareStatement(query);
		 * pst.setInt(1, product.getId());
		 * pst.setString(2, product.getName());
		 * pst.setDouble(3,
		 * product.getPrice());
		 * 
		 * pst.execute();
		 * }
		 */

	}

	// select query
	public List<Product> getAllProduct() {
		class ProductMapper implements RowMapper<Product> {

			public Product mapRow(ResultSet rs, int index) throws SQLException {

				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));

				return product;
			}

		}
		String query = "select * from tbl_product";
		List<Product> list = jdbcTemplate.query(query, new ProductMapper());
		return list;
	}
}
