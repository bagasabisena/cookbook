package com.example.cookbook;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by bagas on 8/26/14.
 */
public class RecipeActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);

        Food food = (Food) getIntent().getSerializableExtra("food");

        ImageView recipeImage = (ImageView) findViewById(R.id.recipe_image);
        TextView ingredientsText = (TextView) findViewById(R.id.recipe_ingredients);
        TextView instructionsText = (TextView) findViewById(R.id.recipe_instructions);

        // init image
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), food.getResId());

        int imageWidth = bitmap.getWidth();
        int imageHeight = bitmap.getHeight();

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;

        int newWidth = width; //this method should return the width of device screen.
        float scaleFactor = (float)newWidth/(float)imageWidth;
        int newHeight = (int)(imageHeight * scaleFactor);

        bitmap = Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true);
        recipeImage.setImageBitmap(bitmap);

        // init food name in the actionbar title
        getActionBar().setTitle(getString(food.getTitle()) + " (" + getString(food.getFrom()) + ")");

        // set back button on actionbar
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        // init ingredients
        ingredientsText.setText(getString(food.getIngredients()));

        // init instructions
        instructionsText.setText(getString(food.getInstructions()));

        // init button
        Button shopButton = (Button) findViewById(R.id.recipe_shop);
        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecipeActivity.this, DummyMapsActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, HomeActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}