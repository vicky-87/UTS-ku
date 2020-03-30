package com.example.uts_recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_recyclerview.View.LogoAdapter;
import com.example.uts_recyclerview.model.Logo;

import java.util.ArrayList;
import java.util.List;

public class LogoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityLogo);
        RecyclerView teamsView = findViewById(R.id.rv_teams);

        List<Logo> logos = new ArrayList<>();
        logos.add(new Logo("https://upload.wikimedia.org/wikipedia/en/thumb/0/0c/Polinema.svg.png", "Polinema"));

        LogoAdapter adapter = new LogoAdapter(this, logos);
        teamsView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        teamsView.setLayoutManager(layoutManager);
    }

}
