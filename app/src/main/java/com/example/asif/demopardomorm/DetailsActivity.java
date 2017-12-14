package com.example.asif.demopardomorm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asif.demopardomorm.model.Product;

public class DetailsActivity extends AppCompatActivity {

    TextView tvProductName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tvProductName=findViewById(R.id.tvProductName);
        Intent i=getIntent();
        long id=i.getLongExtra("pid",0);
        if(id!=0){
//            Toast.makeText(getApplicationContext(),String.valueOf(id),Toast.LENGTH_SHORT).show();
//            tvProductName.setText(id);
//            Product product=Product.get(id);
            Product product=Product.load(Product.class,id);
            tvProductName.setText(product.product_name);
        }
    }
}
