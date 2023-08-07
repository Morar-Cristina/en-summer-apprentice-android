package com.example.tmsystemdemo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.tmsystemdemo.Adapter.OrdersAdapter;
import com.example.tmsystemdemo.Domain.ItemsDomain;
import com.example.tmsystemdemo.R;

import java.util.ArrayList;
import java.util.List;

public class OrdersActivity extends AppCompatActivity {

    private RecyclerView recyclerViewOrders;
    private OrdersAdapter ordersAdapter;
    private List<ItemsDomain> ordersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(view -> startActivity(new Intent(OrdersActivity.this, MainActivity.class)));

        ordersList = new ArrayList<>();
        ordersList.add(new ItemsDomain("Electric Castle", "Bontida", "   Nestled amidst the historic walls of a magnificent Transylvanian castle, the Electric Castle festival transports attendees into a surreal world where the past and the future coexist harmoniously. This enchanting setting adds an air of mystery and grandeur, making the festival an extraordinary escape from reality.", "Music Festival", "electric4"));
        ordersList.add(new ItemsDomain("'U Cluj' Match", "Cluj Arena", "   Regardless of the outcome, U Cluj's matches are known for their intensity and the emotional rollercoaster they provide for both the players and the supporters. Like any football club with a strong following, U Cluj's matches create lasting memories for fans, who eagerly anticipate each encounter as an opportunity to witness their team's success and showcase the pride of Cluj-Napoca.", "Football Match", "fot4"));

        recyclerViewOrders = findViewById(R.id.view_order);
        recyclerViewOrders.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ordersAdapter = new OrdersAdapter(ordersList);
        recyclerViewOrders.setAdapter(ordersAdapter);
    }
}