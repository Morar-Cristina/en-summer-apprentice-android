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

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    List<ItemsDomain> items;

    public PopularAdapter(List<ItemsDomain> items) {
        this.items = items;
    }

    public void setFilteredList(List<ItemsDomain> filteredList){
        this.items =filteredList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public PopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, int position) {
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
        TextView titleText, locationText;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.titleTxt);
            locationText = itemView.findViewById(R.id.locationTxt);
            pic = itemView.findViewById(R.id.untoldPic);
        }
    }
}
