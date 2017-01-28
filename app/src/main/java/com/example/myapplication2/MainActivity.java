package com.example.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    //Firebase variables
    private FirebaseDatabase grantsDB;
    private DatabaseReference grantsReference;

    //Interface variables
    private EditText grantName;
    private EditText grantDescription;
    private EditText grantData;
    private Button publishButton;
    private TextView grantsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Firebase database and reference

        grantsDB = FirebaseDatabase.getInstance();
        grantsReference = grantsDB.getReference().child("grants");

        //Initialize Interface
        grantName = (EditText)findViewById(R.id.grantName);
        grantDescription = (EditText)findViewById(R.id.grantDescription);
        grantData = (EditText)findViewById(R.id.grantData);
        publishButton = (Button)findViewById(R.id.publishButton);
        grantsText = (TextView)findViewById(R.id.grantsText);

        publishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Grant grant = new Grant(grantName.getText().toString(),
                                        grantDescription.getText().toString(),
                                        grantData.getText().toString());
                grantsReference.push().setValue(grant);  //публикуем в ветку гранты

            }
        });

        grantsReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Grant grant = dataSnapshot.getValue(Grant.class);
                grantsText.append(grant.getGrantName() + "\n"); //textView
                grantsText.append(grant.getGrantDescription() + "\n\n\n");
                grantsText.append(grant.getGrantData() + "\n");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}
