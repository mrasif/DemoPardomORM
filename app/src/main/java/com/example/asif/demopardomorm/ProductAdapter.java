package com.example.asif.demopardomorm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asif.demopardomorm.model.Product;

import java.util.Collections;
import java.util.List;

/**
 * Created by asif on 12/14/17.
 */

public class ProductAdapter  extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private final LayoutInflater iflater;
    List<Product> data= Collections.emptyList();
    Context context;

    public ProductAdapter(Context context) {
        this.iflater = LayoutInflater.from(context);
        this.data = Product.getAll();
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=iflater.inflate(R.layout.product_item,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Product current=data.get(position);
        holder.tvTitle.setText(current.product_name);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvTitle;
        Button btnDelete;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tvProduct);
            btnDelete=itemView.findViewById(R.id.btnDelete);
            btnDelete.setOnClickListener(this);
            tvTitle.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Product p=data.get(getPosition());
            switch (view.getId()){
                case R.id.btnDelete:
                    Toast.makeText(context,"Deleted !",Toast.LENGTH_SHORT).show();
                    p.delete();
                    data.remove(getPosition());
                    notifyItemRemoved(getPosition());
                    break;
                case R.id.tvProduct:
                    Intent intent=new Intent(context,DetailsActivity.class);
                    intent.putExtra("pid",p.getId());
                    context.startActivity(intent);
            }

        }
    }
}
