package com.example.asif.demopardomorm.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by asif on 12/14/17.
 */

@Table(name = "products")
public class Product extends Model{
    @Column(name = "product_name")
    public String product_name;

    public Product() {
        super();
    }

    public static List<Product> getAll() {
        return new Select()
                .from(Product.class)
                .orderBy("Id ASC")
                .execute();
    }

}
