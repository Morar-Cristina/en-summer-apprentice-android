package com.example.tmsystemdemo.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tmsystemdemo.Activities.UntoldActivity;
import com.example.tmsystemdemo.Domain.ItemsDomain;
import com.example.tmsystemdemo.R;
import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {

    List<ItemsDomain> items;

    public OrdersAdapter(List<ItemsDomain> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public OrdersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_order, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersAdapter.ViewHolder holder, int position) {
        holder.titleText.setText(items.get(position).getEventName());
        holder.locationText.setText(items.get(position).getEventLocation());

        int drawableResourceID = holder.itemView.getResources().getIdentifier(items.get(position).getPic(),
                "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceID)
                .into(holder.pic);

        holder.itemView.setOnClickListener(view -> {
            Intent intent=new Intent(holder.itemView.getContext(), UntoldActivity.class);
            intent.putExtra("object", items.get(position));
            holder.itemView.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleText, locationText, ticketsText;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.nameTextt);
            locationText = itemView.findViewById(R.id.locationTextt);
            ticketsText=itemView.findViewById(R.id.ticketsTextt);
            pic = itemView.findViewById(R.id.iconImg);
        }
    }
}
