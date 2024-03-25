package org.example.lab2.services;
import org.example.lab2.domain.Product;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.stereotype.Service;

import org.example.lab2.services.CoreJDBCDao;

import java.sql.*;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl extends CoreJDBCDao implements ProductService {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    List<Product> products = new ArrayList(List.of(
            new Product(13L, "ice cream", 200L, Product.cathegory.Cheap),
            new Product(15L, "bike", 5000L, Product.cathegory.Cheap),
            new Product(19L, "car", 10000L, Product.cathegory.Old))
    );

    @Override
    public List<Product> findAll() {
        List<Product> addresses=new ArrayList<>();
        String findAllAddressSQL = "SELECT * FROM Products";
        try (
                PreparedStatement findAllAddress = connection.prepareStatement(findAllAddressSQL);
        ) {
            ResultSet rs = findAllAddress.executeQuery();
            while (rs.next()){
                Product ad=new Product(rs.getLong("id"),rs.getString("city"), 
                                    rs.getLong("price"),Product.cathegory.values()[rs.getInt("cathegory") - 1]);
                addresses.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    @Override
    public void save(Product p) {
        List<Product> products = findAll();
        if(products.contains(p))
            return;

        String insertAddressSQL = "INSERT into products(name, price, cathegory) values(?,?,?)";
        try (
           PreparedStatement insertAddress = connection.prepareStatement(insertAddressSQL);
        ) {
            insertAddress.setString(2, p.getName());
            insertAddress.setLong(2, p.getPrice());
            insertAddress.setString(2, p.getCategory().name());

            insertAddress.executeQuery();
            ResultSet generatedKeys = insertAddress.getGeneratedKeys();
            if (generatedKeys.next()) {
                p.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> filter(Product.cathegory ncategory, Long price) {
        List<Product> filteredProducts = products.stream().filter(p->p.getPrice() <= price && p.getCategory().equals(ncategory)).collect(Collectors.toList());
        return filteredProducts;
    }

}
