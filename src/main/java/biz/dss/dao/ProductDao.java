package biz.dss.dao;


import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Component;

@Component
public class ProductDao {

    private JdbcTemplate jdbcTemplate;

    public void add(final Product product) {

        final String query = "insert into tbl_product values(?,?,?)";
        this.jdbcTemplate.update(query, product.getId(), product.getName(), product.getPrice());




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

            public Product mapRow(final ResultSet rs, final int index) throws SQLException {
                System.out.println(rs);
                System.out.println(index);
                final Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                System.out.println(product);
                return product;
            }

        }
        final String query = "select * from tbl_product";
        final List<Product> list = this.jdbcTemplate.query(query, new ProductMapper());
        return list;
    }
}
