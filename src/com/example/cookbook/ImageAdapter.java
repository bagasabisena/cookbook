package com.example.cookbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bagas on 8/26/14.
 */
public class ImageAdapter extends BaseAdapter {

    private Context context;
    private List<Food> foods = new ArrayList<Food>();

    public ImageAdapter(Context context) {
        this.context = context;
        init();
    }

    static class GridHolder {
        ImageView imageView;
        TextView upTextView;
        TextView bottomTextView;
    }

    private void init() {
        Food caFood = new Food(R.string.ca_title, R.string.ca_from, R.drawable.ca, R.string.ca_ingredients, R.string.ca_instructions);
        Food ca2Food = new Food(R.string.ca2_title, R.string.ca2_from, R.drawable.ca2, R.string.ca2_ingredients, R.string.ca2_instructions);
        Food chFood = new Food(R.string.ch_title, R.string.ch_from, R.drawable.ch, R.string.ch_ingredients, R.string.ch_instructions);
        Food deFood = new Food(R.string.de_title, R.string.de_from, R.drawable.de, R.string.de_ingredients, R.string.de_instructions);
        Food grFood = new Food(R.string.gr_title, R.string.gr_from, R.drawable.gr, R.string.gr_ingredients, R.string.gr_instructions);
        Food inFood = new Food(R.string.in_title, R.string.in_from, R.drawable.in, R.string.in_ingredients, R.string.in_instructions);
        Food idFood = new Food(R.string.id_title, R.string.id_from, R.drawable.id, R.string.id_ingredients, R.string.id_instructions);
        Food itFood = new Food(R.string.it_title, R.string.it_from, R.drawable.it, R.string.it_ingredients, R.string.it_instructions);
        Food it2Food = new Food(R.string.it2_title, R.string.it2_from, R.drawable.it2, R.string.it2_ingredients, R.string.it2_instructions);


        foods.add(caFood);
        foods.add(ca2Food);
        foods.add(chFood);
        foods.add(deFood);
        foods.add(grFood);
        foods.add(inFood);
        foods.add(idFood);
        foods.add(itFood);
        foods.add(it2Food);
    }

    private Integer[] imageIds = {
            R.drawable.ca, R.drawable.ca2, R.drawable.ch, R.drawable.de, R.drawable.gr,
            R.drawable.in, R.drawable.id, R.drawable.it, R.drawable.it2
    };

    private String[] textUps = {"Macaroni and Cheese", "Poutine", "Cheese with Rice",
    "Spätzle with Cheese", "Cheese Pie", "Cheese Mini Puri Sandwich", "Choco Cheese Roasted Banana",
    "Lasagna Bolognese", "Spaghetti Cacio e Pepe"};

    private String[] textDowns = {"Canada", "Canada", "China", "Germany", "Greece", "India",
    "Indonesia", "Italia", "Italia"};

    @Override
    public int getCount() {
        return imageIds.length;
    }

    @Override
    public Object getItem(int position) {
        return foods.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView imageView;
//        if (view == null) {
//            imageView = new ImageView(context);
//            imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500));
//            imageView.setScaleType(ImageView.ScaleType.CENTER);
//            imageView.setPadding(8, 8, 8, 8);
//        } else {
//            imageView = (ImageView) view;
//        }
//
//        imageView.setImageResource(imageIds[position]);
//        return imageView;

        View grid;
        GridHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = new View(context);
            grid = inflater.inflate(R.layout.grid, null);
            holder = new GridHolder();
            holder.imageView = (ImageView) grid.findViewById(R.id.image_grid);
            holder.upTextView = (TextView) grid.findViewById(R.id.text_gridup);
            holder.bottomTextView = (TextView) grid.findViewById(R.id.text_gridbottom);
            grid.setTag(holder);
        } else {
            grid = convertView;
            holder = (GridHolder) grid.getTag();
        }

//        holder.imageView.setImageResource(imageIds[position]);
//        holder.upTextView.setText(textUps[position]);
//        holder.bottomTextView.setText(textDowns[position]);

        holder.imageView.setImageResource(foods.get(position).getResId());
        holder.upTextView.setText(context.getString(foods.get(position).getTitle()));
        holder.bottomTextView.setText(context.getString(foods.get(position).getFrom()));


        return grid;
    }
}
