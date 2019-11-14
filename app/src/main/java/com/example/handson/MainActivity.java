package com.example.handson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editText);
        etPhone = findViewById(R.id.editText2);
    }

    public void btnSubmit(View v){
        String name = etName.getText().toString().trim();
        String cell = etPhone.getText().toString().trim();

        try{
            ContactsDb db = new ContactsDb(this);
            db.open();
            db.createEntry(name,cell);
            db.close();
            Toast.makeText(MainActivity.this,"Successfully saved!",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void btnShowData(View v){

        startActivity(new Intent(this, ActivityData.class));
    }

    public void btnEdit(View v){

        try{
            ContactsDb db = new ContactsDb(this);
            db.open();
            db.updateEntry("5", "Johan Ju", "27845673455");
            db.close();
            Toast.makeText(MainActivity.this, "Successfully updated!", Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void btnDelete(View v){

        try{
            ContactsDb db = new ContactsDb(this);
            db.open();
            db.deleteEntry("6");
            db.close();
            Toast.makeText(MainActivity.this, "Successfully updated!", Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
