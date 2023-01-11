package com.hieund.mailapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class RecyclerViewActivity extends AppCompatActivity implements ItemClickListener {

    List<ItemModel> items;

    Faker faker = new Faker();
//    static String fullName = faker.name().fullName();
//    static String phone = faker.phoneNumber().phoneNumber();
//    static String mail = faker.phoneNumber().cellPhone() + "@temp-mail.origin";
//    static String address = faker.address().fullAddress();

    private String getFullName() {
        return faker.name().fullName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        items = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            items.add(new ItemModel("",
                    faker.internet().emailAddress(),
                    faker.company().catchPhrase(),
                    faker.date().past(5, TimeUnit.DAYS).toString().substring(0,20)));
        }
        ItemAdapter adapter = new ItemAdapter(items, this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnItemClick(int pos) {
        Log.v("TAG", items.get(pos).getTextTitle() + " is clicked.");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}