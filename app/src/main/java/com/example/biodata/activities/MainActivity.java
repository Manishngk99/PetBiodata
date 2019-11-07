package com.example.biodata.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.biodata.R;
import com.example.biodata.adapter.DataAdapter;
import com.example.biodata.model.DataModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private EditText etEnterName, etAge;
    private Button btnSave;
    private RecyclerView recyclerView;
    Spinner spin;
    RadioGroup radioGroup;
    String gender;
    int imageId;
    String image[] = {"Cat", "Dog", "Mouse", "Parrot"};
    final List<DataModel> dataModelList = new ArrayList<>();

    //int imageValue[] = {R.drawable.cat, R.drawable.dog, R.drawable.mouse, R.drawable.parrot};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding;
        spin = findViewById(R.id.spin);
        etEnterName = findViewById(R.id.etEnterName);
        etAge = findViewById(R.id.etAge);
        radioGroup = findViewById(R.id.radioGroup);
        btnSave = findViewById(R.id.btnSave);
        recyclerView = findViewById(R.id.recycleView);

        ArrayAdapter<String> imageAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                image
        );
        spin.setAdapter(imageAdapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spin.getSelectedItem().equals("Cat")){
                    imageId = R.drawable.cat;
                }
                else if (spin.getSelectedItem().equals("Dog")){
                    imageId = R.drawable.dog;
                }
                else if (spin.getSelectedItem().equals("Mouse")){
                    imageId = R.drawable.mouse;
                }
                else if (spin.getSelectedItem().equals("Parrot")){
                    imageId = R.drawable.parrot;
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int isSelected = radioGroup.getCheckedRadioButtonId();

                if(isSelected == R.id.rbMale){
                    gender = "M";
                }
                else if(isSelected == R.id.rbFemale){
                    gender = "F";
                }
                else if(isSelected == R.id.rbOther){
                    gender = "O";
                }
                dataModelList.add(new DataModel(etEnterName.getText().toString(), etAge.getText().toString(),gender, imageId));

                DataAdapter dataAdapter = new DataAdapter(MainActivity.this, dataModelList);
                recyclerView.setAdapter(dataAdapter);
                recyclerView.setLayoutManager(
                        new LinearLayoutManager(MainActivity.this)
                );
            }
        });
    }
}
