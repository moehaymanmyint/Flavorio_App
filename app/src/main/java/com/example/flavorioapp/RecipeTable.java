package com.example.flavorioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class RecipeTable extends AppCompatActivity {
    //Initialize variables
    EditText etName, etDes, etTime, etType;
    Button btnAdd;
    Spinner spinner;
    ListView listView1, listView2, listView3;

    DatabaseHelper databaseHelper;

    ArrayList arrayList1, arrayList2, arrayList3;
    ArrayAdapter arrayAdapter1, arrayAdapter2, arrayAdapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_table);

        //Assign variables
        etName = findViewById(R.id.et_name);
        etDes = findViewById(R.id.et_des);
        etTime = findViewById(R.id.et_time);
        etType = findViewById(R.id.et_type);
        btnAdd = findViewById(R.id.btn_add);
        spinner = findViewById(R.id.spinner);
        listView1 = findViewById(R.id.list_view1);
        listView2 = findViewById(R.id.list_view2);
        listView3 = findViewById(R.id.list_view3);

        databaseHelper = new DatabaseHelper(this);

        //Add Database Values to ArrayList
        arrayList1 = databaseHelper.getRecipe();
        arrayList2 = databaseHelper.getDescription();
        arrayList3 = databaseHelper.getTime();

        //Initialize ArrayAdapter For ListView
        arrayAdapter1 = new ArrayAdapter(RecipeTable.this
                ,android.R.layout.simple_list_item_1, arrayList1);
        listView1.setAdapter(arrayAdapter1);

        arrayAdapter2 = new ArrayAdapter(RecipeTable.this
                ,android.R.layout.simple_list_item_1, arrayList2);
        listView2.setAdapter(arrayAdapter2);

        arrayAdapter3 = new ArrayAdapter(RecipeTable.this
                ,android.R.layout.simple_list_item_1, arrayList3);
        listView3.setAdapter(arrayAdapter3);


        //Create String Array
        String[] spinnerList = new String[] {"Recipe", "Description", "Time", "Type"};

        //Initialize Array Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this
                , android.R.layout.simple_spinner_item, spinnerList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //If Recipe Selected
                if (position == 0) {
                    listView1.setVisibility(View.VISIBLE);
                    listView2.setVisibility(View.GONE);
                    listView3.setVisibility(View.GONE);
                }

                //If Description Selected
                if (position == 1) {
                    listView1.setVisibility(View.GONE);
                    listView2.setVisibility(View.VISIBLE);
                    listView3.setVisibility(View.GONE);
                }

                //If TIME Selected
                if (position == 2) {
                    listView1.setVisibility(View.GONE);
                    listView2.setVisibility(View.GONE);
                    listView3.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get Values From EditText
                String recipe = etName.getText().toString();
                String description = etDes.getText().toString();
                String time = etTime.getText().toString();

                if (!recipe.isEmpty() && !description.isEmpty() && !time.isEmpty()) {
                    if (databaseHelper.insert(recipe,description,time)) {

                        //Display Toast Message
                        Toast.makeText(getApplicationContext(), "Data Inserted.."
                                ,Toast.LENGTH_SHORT).show();

                        //Clear EditText
                        etName.setText("");
                        etDes.setText("");
                        etTime.setText("");

                        //Clear ArrayList
                        arrayList1.clear();
                        arrayList2.clear();
                        arrayList3.clear();

                        //Add Data to ArrayList
                        arrayList1.addAll(databaseHelper.getRecipe());
                        arrayList2.addAll(databaseHelper.getDescription());
                        arrayList3.addAll(databaseHelper.getTime());

                        //Notify ArrayAdapter
                        arrayAdapter1.notifyDataSetChanged();
                        arrayAdapter2.notifyDataSetChanged();
                        arrayAdapter3.notifyDataSetChanged();

                        //Refresh ListView
                        listView1.invalidateViews();
                        listView1.refreshDrawableState();

                    }
                }
            }
        });
    }
}