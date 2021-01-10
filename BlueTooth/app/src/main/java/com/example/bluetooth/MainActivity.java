package com.example.bluetooth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btNhapMa ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mapping() ;
        btNhapMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogConfirmation dialog = new DialogConfirmation() ;
                dialog.show(getSupportFragmentManager(),"MyCustomer");
            }
        });
    }

    public void Mapping()
    {
        btNhapMa = findViewById(R.id.btma) ;
    }
}