package da;

import entity.Product;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductDataAccess {
    // file thuc hien cac cong viet ket noi lay du lieu gom ca method de xu ly

    // tao ra cac bien la cac cau querry

    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    // cau lenh insert
    private static final String INSERT_PRODUCT = "INSERT INTO product"+
            "(pro_name,pro_desc) VALUES (?,?)";
    private static final String DELETE_PRODUCT = "DELETE FROM product WHERE id = ?";
    private static final String SELECT_ALL_PRODUCT = "SELECT * FROM product";
    private static final String UPDAATE_PRODUCT = "UPDATE product SET pro_name=?,pro_desc=?"+"WHERE id=?";
    private static final String GETONE_PRODUCT = "SELECT * FROM product WHERE id = ?";

    // các hàm xử lý
    // create
    public PreparedStatement insertStatement() throws SQLException, ClassNotFoundException {
        if(preparedStatement == null){
            Connection connection = new DBConnection().getConnection();
            preparedStatement =  connection.prepareStatement(INSERT_PRODUCT);
        }
        return preparedStatement;
    }
    //read
    public PreparedStatement getAllStatement() throws SQLException, ClassNotFoundException {
        if(preparedStatement == null){
            Connection connection = new DBConnection().getConnection();
            preparedStatement =  connection.prepareStatement(SELECT_ALL_PRODUCT);
        }
        return preparedStatement;
    }
    public PreparedStatement getOneStatement() throws SQLException, ClassNotFoundException {
        if(preparedStatement == null){
            Connection connection = new DBConnection().getConnection();
            preparedStatement =  connection.prepareStatement(GETONE_PRODUCT);
        }
        return preparedStatement;
    }
    //update
    public PreparedStatement updateStatement() throws SQLException, ClassNotFoundException {
        if(preparedStatement == null){
            Connection connection = new DBConnection().getConnection();
            preparedStatement =  connection.prepareStatement(UPDAATE_PRODUCT);
        }
        return preparedStatement;
    }
    //delete
    public PreparedStatement deleteStatement() throws SQLException, ClassNotFoundException {
        if(preparedStatement == null){
            Connection connection = new DBConnection().getConnection();
            preparedStatement =  connection.prepareStatement(DELETE_PRODUCT);
        }
        return preparedStatement;
    }

    // create statement
    public boolean createProduct(Product product) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = insertStatement();
        preparedStatement.setString(1,product.getName());
        preparedStatement.setString(2,product.getDesc());
        preparedStatement.executeUpdate();
        return true;
    }
    //delete statement
    public boolean deleteProduct(int productID) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = deleteStatement();
        preparedStatement.setInt(1,productID);
        preparedStatement.executeUpdate();
        return true;
    }
    //select all statement
    public List<Product> selectAllProduct() throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getAllStatement();
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Product> productList = new LinkedList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String pro_name = resultSet.getString("pro_name");
            String pro_desc = resultSet.getString("pro_desc");
            productList.add(new Product(id,pro_name,pro_desc));
        }
        return productList;
    }
    public boolean updateProduct(Product product) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = updateStatement();
        preparedStatement.setString(1,product.getName());
        preparedStatement.setString(2,product.getDesc());
        preparedStatement.setInt(3,product.getId());
        preparedStatement.executeUpdate();
        return true;

    }
    public Product getOneProduct(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getOneStatement();
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Product product = new Product();
        while (resultSet.next()){
            product.setName(resultSet.getString("pro_name"));
            product.setDesc(resultSet.getString("pro_desc"));
            product.setId(resultSet.getInt("id"));
        }
        return product;
    }

}
