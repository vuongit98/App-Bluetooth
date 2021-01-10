package com.example.bluetooth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ConfigLesson extends AppCompatActivity {
    RecyclerView recyclerViewHinhThucTinh,recyclerViewTocDoTinh,recyclerViewPhamViPhepTinh,recyclerViewDoDaiPhepTinh,getRecyclerViewCongThucTinh ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_lesson);
    }
}