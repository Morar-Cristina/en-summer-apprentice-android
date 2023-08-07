package com.example.tmsystemdemo.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tmsystemdemo.Adapter.CategoryAdapter;
import com.example.tmsystemdemo.Adapter.PopularAdapter;
import com.example.tmsystemdemo.Domain.CategoryDomain;
import com.example.tmsystemdemo.Domain.ItemsDomain;
import com.example.tmsystemdemo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterCategory;
    private RecyclerView recyclerViewPopular, recyclerViewCategory;
    private SearchView searchView;
    private PopularAdapter itemAdapter;
    private List<ItemsDomain> itemDomain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button introButton = findViewById(R.id.ordersBtn);
        introButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, OrdersActivity.class)));

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        itemDomain = new ArrayList<>();
        itemDomain.add(new ItemsDomain("Untold Festival", "Cluj Napoca", "  The 'Untold' Music Festival is an extraordinary and electrifying celebration of music and culture, renowned for its unparalleled lineup, immersive experiences, and vibrant atmosphere. Held annually in a magnificent venue, this multi-day festival has become a global sensation, attracting music enthusiasts from all walks of life.\"", "Music Festival", "untold"));
        itemDomain.add(new ItemsDomain("Electric Castle", "Bontida", "   Nestled amidst the historic walls of a magnificent Transylvanian castle, the Electric Castle festival transports attendees into a surreal world where the past and the future coexist harmoniously. This enchanting setting adds an air of mystery and grandeur, making the festival an extraordinary escape from reality.", "Music Festival", "electric7"));
        itemDomain.add(new ItemsDomain("'U Cluj' Match", "Cluj Arena", "   Regardless of the outcome, U Cluj's matches are known for their intensity and the emotional rollercoaster they provide for both the players and the supporters. Like any football club with a strong following, U Cluj's matches create lasting memories for fans, who eagerly anticipate each encounter as an opportunity to witness their team's success and showcase the pride of Cluj-Napoca.", "Football Match", "fot4"));
        itemDomain.add(new ItemsDomain("Wine Festival", "Iulius Park", "   The Wine Festival is an annual event that brings together wine enthusiasts, connoisseurs, and casual drinkers alike, creating an ambiance of joy, relaxation, and camaraderie. Set in the picturesque backdrop of vineyards or a charming outdoor venue, the festival offers a delightful experience for all your senses.", "Wine Festival", "winefestival"));
        recyclerViewPopular = findViewById(R.id.view_pop);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        itemAdapter = new PopularAdapter(itemDomain);
        recyclerViewPopular.setAdapter(itemAdapter);

        ArrayList<CategoryDomain> catList = new ArrayList<>();
        catList.add(new CategoryDomain("Festival", "music"));
        catList.add(new CategoryDomain("Wine", "wine"));
        catList.add(new CategoryDomain("Football", "football"));
        catList.add(new CategoryDomain("Food", "food"));
        catList.add(new CategoryDomain("Theatre", "art"));

        recyclerViewCategory = findViewById(R.id.view_cat);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterCategory = new CategoryAdapter(catList);
        recyclerViewCategory.setAdapter(adapterCategory);

    }

    private void filterList(String newText) {
        ArrayList<ItemsDomain> filteredList = new ArrayList<>();
        for (ItemsDomain item : itemDomain) {
            if (item.getEventName().toLowerCase().contains(newText.toLowerCase())) {
                filteredList.add(item);
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No Event found", Toast.LENGTH_SHORT).show();
        } else {
            itemAdapter.setFilteredList(filteredList);
        }
    }
}
