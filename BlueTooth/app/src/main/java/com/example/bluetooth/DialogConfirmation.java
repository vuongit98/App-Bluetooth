package com.example.bluetooth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DialogConfirmation extends DialogFragment {


    DatabaseReference databaseReference ;
    TextView txtTitle , txtIntro ;
    EditText edtCode ;
    Button btTake ;
    List<String> mListToken = new ArrayList<>() ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dialog_confirmation,container,false) ;
        Mapping(view);
        databaseReference = FirebaseDatabase.getInstance().getReference("mems-mcu");
        getToken();
        btTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = edtCode.getText().toString() ;
                int flag = 0 ;
                Log.d("mListToken = ",mListToken + " ");
                for (String token: mListToken) {
                    if(temp.equals(token) == true ){
                        flag = 1 ;
                        Intent intent = new Intent(getContext(),ConfigLesson.class) ;
                        startActivity(intent);
                        getDialog().dismiss();
                        break;
                    }
                }
                if(flag == 0) {
                    Toast.makeText(getContext(), "Fail a code ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view ;
    }
    public void Mapping(View view )
    {

        txtTitle = view.findViewById(R.id.name) ;
        txtIntro = view.findViewById(R.id.intro) ;
        edtCode = view.findViewById(R.id.edtma);
        btTake = view.findViewById(R.id.btkh);
    }
    public void getToken() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        String TAG = "Log";
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                mListToken.clear();
                for (DataSnapshot dt : dataSnapshot.getChildren()) {
                    String temp = dt.getValue(String.class);
                   mListToken.add(temp);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        /*
        Toast.makeText(getContext(),token,Toast.LENGTH_SHORT).show();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mListToken.clear();
                for (DataSnapshot keyToken : snapshot.getChildren() ){
                    Toast.makeText(getContext(), ""+keyToken.getValue(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

         */
    }
}