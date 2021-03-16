package controller;

import entity.Product;
import model.ProductDP;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.SQLException;

public class ProductController extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            response.sendRedirect("index.jsp");
        }
        if(action.equals("Add")){
            String name = request.getParameter("name");
            String desc = request.getParameter("desc");
            System.out.println(name.isEmpty());
            Product product = new Product();
            product.setName(name);
            product.setDesc(desc);
            ProductDP productDP = new ProductDP();
            try {
                if(name.isEmpty() && desc.isEmpty()){
                    request.getRequestDispatcher("create.jsp?msgError=Error when create please check").forward(request,response);
                }
                if(productDP.createProduct(product)){
                    request.getRequestDispatcher("index.jsp?msgSuccess=Add New Product Successfully").forward(request,response);
//                    response.sendRedirect("index.jsp?msgSuccess=Add New Product Successfully");
                }else{
                    request.getRequestDispatcher("create.jsp?msgError=Error when create please check").forward(request,response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if(action.equals("Delete")){
            String productID = request.getParameter("productID");
            System.out.println(productID);
            ProductDP productDP = new ProductDP();
            try {
                if(productDP.deleteProduct(Integer.parseInt(productID))){
                    request.getRequestDispatcher("index.jsp?msgSuccess=Delete Successfully").forward(request,response);

                }
            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
            } catch (ClassNotFoundException e) {
                System.out.println(e.getException());
            }
        }
        if(action.equals("Update")){
            String productID = request.getParameter("productID");
            System.out.println(productID);
            System.out.println(action);
            ProductDP productDP = new ProductDP();
            try {
                System.out.println(productDP.getOneProduct(Integer.parseInt(productID)));
                request.setAttribute("product",productDP.getOneProduct(Integer.parseInt(productID)));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("update.jsp").forward(request,response);

        }
        if(action.equals("SubmitUpdate")){
            String id = request.getParameter("productID");
            String name= request.getParameter("name");
            String desc = request.getParameter("desc");
            Product product = new Product();
            product.setId(Integer.parseInt(id));
            product.setName(name);
            product.setDesc(desc);
            ProductDP productDP = new ProductDP();
            try {
                if(productDP.updateProduct(product)){
                    request.getRequestDispatcher("index.jsp?msgSuccess=Update New Product Successfully").forward(request,response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            String action = request.getParameter("action");
            if(action.equals("Detail")){
                String productID = request.getParameter("productID");
                ProductDP productDP = new ProductDP();
                try {
                    request.setAttribute("product",productDP.getOneProduct(Integer.parseInt(productID)));
                    request.getRequestDispatcher("detail.jsp").forward(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }
    }

}
