package model;

import da.ProductDataAccess;
import entity.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductDP {
    //design pattern để gọi ra các hàm crud
    public List<Product> getAllProduct() throws SQLException, ClassNotFoundException {
        return new ProductDataAccess().selectAllProduct();
    }
    public boolean createProduct(Product product) throws SQLException, ClassNotFoundException {
        return new ProductDataAccess().createProduct(product);
    }
    public boolean deleteProduct(int productID) throws SQLException, ClassNotFoundException {
        return new ProductDataAccess().deleteProduct(productID);
    }
    public boolean updateProduct(Product product) throws SQLException, ClassNotFoundException {
        return new ProductDataAccess().updateProduct(product);
    }
    public Product getOneProduct(int productID) throws SQLException, ClassNotFoundException {
        return new ProductDataAccess().getOneProduct(productID);
    }
}
