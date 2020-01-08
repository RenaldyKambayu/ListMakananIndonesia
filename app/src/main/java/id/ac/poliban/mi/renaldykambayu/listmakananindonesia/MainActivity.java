package id.ac.poliban.mi.renaldykambayu.listmakananindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Food> foods = new ArrayList<>();
    private ListView lvFood;
    private BaseAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvFood = findViewById(R.id.listview);

        foods.addAll(FoodData.getAllFoods());

        adapter = new FoodAdapter(foods);

        lvFood.setAdapter(adapter);

        lvFood.setOnItemClickListener(((parent, view, position, id) -> {
            new AlertDialog.Builder(this)
                    .setTitle("info")
                    .setMessage(foods.get(position).toString())
                    .setPositiveButton("Ok", null).show();
        }));
    }
}
