package com.example.flavorioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteRecipeItem extends AppCompatActivity {

    //Declaration of variables
    private EditText delete_id;
    private Button btn_delete;
    RecipeDatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_recipe_item);
        myDb = new RecipeDatabaseHelper(this);

        delete_id = findViewById(R.id.delete_id);
        btn_delete = findViewById(R.id.btn_delete);
        DeleteRecipe();

    }

    public void DeleteRecipe() {
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteRecipe(Long.parseLong(delete_id.getText().toString()));
                if(deletedRows > 0)
                    Toast.makeText(DeleteRecipeItem.this, "Recipe Deleted", Toast.LENGTH_SHORT).show();

                else
                    Toast.makeText(DeleteRecipeItem.this, "Recipe not deleted.", Toast.LENGTH_LONG).show();
            }
        });
    }
}