package com.example.asif.demopardomorm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asif.demopardomorm.model.Product;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etProductName;
    Button btnAdd;
    RecyclerView recyclerView;
    ProductAdapter adapter;


    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.myProducts);
        etProductName=findViewById(R.id.productname);
        btnAdd=findViewById(R.id.btnAdd);

        adapter=new ProductAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product=new Product();
                product.product_name=etProductName.getText().toString();
                product.save();
                adapter.data=Product.getAll();
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"Saved !",Toast.LENGTH_SHORT).show();
                etProductName.setText("");
//                etProductName.requestFocus();
            }
        });
    }
}
