package com.example.handson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityData extends AppCompatActivity {

    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        tvData = findViewById(R.id.textView);

        try {
            ContactsDb db = new ContactsDb(this);
            db.open();
            tvData.setText(db.getData());

            db.close();
            Toast.makeText(ActivityData.this, "Successfully updated!",
                    Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(ActivityData.this, e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }
}
