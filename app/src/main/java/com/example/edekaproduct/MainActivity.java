package com.example.edekaproduct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    GridView productGV;
    ArrayList<ShoppingItem> shoppingItems = new ArrayList<>();
    ShoppingAdapter shoppingAdapter;
    int LastPass;

    int Qauntity = 0;
    float Price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<ShoppingItem> Fruit = new ArrayList<ShoppingItem>();
        Fruit.add(new ShoppingItem("Lemon", R.drawable.lemon, "Fruit", (float) 1.10, false, false, 0, 0));
        Fruit.add(new ShoppingItem("Banana", R.drawable.banana, "Fruit", (float) 2.05, false, false, 0, 0));
        Fruit.add(new ShoppingItem("Grape", R.drawable.grape, "Fruit", (float) 3.15, false, false, 0, 0));
        Fruit.add(new ShoppingItem("Orange", R.drawable.orange, "Fruit", (float) 2, false, false, 0, 0));
        Fruit.add(new ShoppingItem("Apple", R.drawable.apple, "Fruit", (float) 4.10, false, false, 0, 0));
        Fruit.add(new ShoppingItem("Mango", R.drawable.mango, "Fruit", (float) 2.10, false, false, 0, 0));
        Fruit.add(new ShoppingItem("Cherry", R.drawable.cherry, "Fruit", (float) 5, false, false, 0, 0));
        Fruit.add(new ShoppingItem("Kiwi", R.drawable.kiwi, "Fruit", (float) 3.10, false, false, 0, 0));

        ArrayList<ShoppingItem> Bakery = new ArrayList<ShoppingItem>();
        Bakery.add(new ShoppingItem("Bread", R.drawable.bread, "Bakery", (float) 1.10, false, false, 0, 0));
        Bakery.add(new ShoppingItem("Cake", R.drawable.cake, "Bakery", (float) 2.05, false, false, 0, 0));
        Bakery.add(new ShoppingItem("Khari", R.drawable.khari, "Bakery", (float) 3.15, false, false, 0, 0));
        Bakery.add(new ShoppingItem("Cookie", R.drawable.cookie, "Bakery", (float) 4.10, false, false, 0, 0));
        Bakery.add(new ShoppingItem("Chocolate", R.drawable.chocolate, "Bakery", (float) 2.10, false, false, 0, 0));
        Bakery.add(new ShoppingItem("Pastry", R.drawable.pastry, "Bakery", (float) 2, false, false, 0, 0));

        ArrayList<ShoppingItem> Vegetables = new ArrayList<ShoppingItem>();
        Vegetables.add(new ShoppingItem("Broccoli", R.drawable.broccoli, "Vegetables", (float) 1.10, false, false, 0, 0));
        Vegetables.add(new ShoppingItem("Peas", R.drawable.peas, "Vegetables", (float) 2.05, false, false, 0, 0));
        Vegetables.add(new ShoppingItem("Sweet potatoes", R.drawable.sweetpotatoes, "Vegetables", (float) 3.15, false, false, 0, 0));
        Vegetables.add(new ShoppingItem("Carrots", R.drawable.carrots, "Vegetables", (float) 2, false, false, 0, 0));
        Vegetables.add(new ShoppingItem("Tomato", R.drawable.tameto, "Vegetables", (float) 4.10, false, false, 0, 0));
        Vegetables.add(new ShoppingItem("Potatoes", R.drawable.potatoes, "Vegetables", (float) 2.10, false, false, 0, 0));
        Vegetables.add(new ShoppingItem("Cabbage", R.drawable.cabbage, "Vegetables", (float) 5, false, false, 0, 0));
        Vegetables.add(new ShoppingItem("Capsicum", R.drawable.capsicum, "Vegetables", (float) 3.10, false, false, 0, 0));

        ArrayList<ShoppingItem> Milk = new ArrayList<ShoppingItem>();
        Milk.add(new ShoppingItem("Butter", R.drawable.butter, "Milk", (float) 10.10, false, false, 0, 0));
        Milk.add(new ShoppingItem("Cheese", R.drawable.cheese, "Milk", (float) 15.05, false, false, 0, 0));
        Milk.add(new ShoppingItem("Yogurt", R.drawable.yogurt, "Milk", (float)13.15, false, false, 0, 0));
        Milk.add(new ShoppingItem("Ghee", R.drawable.ghee, "Milk", (float) 12, false, false, 0, 0));
        Milk.add(new ShoppingItem("ice cream", R.drawable.icecream, "Milk", (float) 14.10, false, false, 0, 0));
        Milk.add(new ShoppingItem("Cream", R.drawable.cream, "Milk", (float) 10.10, false, false, 0, 0));

        ArrayList<ShoppingItem> Drinks = new ArrayList<ShoppingItem>();
        Drinks.add(new ShoppingItem("Tea", R.drawable.tea, "Drinks", (float) 1.10, false, false, 0, 0));
        Drinks.add(new ShoppingItem("Coffee", R.drawable.coffee, "Drinks", (float) 2.05, false, false, 0, 0));
        Drinks.add(new ShoppingItem("Coconut Water", R.drawable.coconatewater, "Drinks", (float) 3.15, false, false, 0, 0));
        Drinks.add(new ShoppingItem("Soft Drinks", R.drawable.softdrinks, "Drinks", (float) 2, false, false, 0, 0));
        Drinks.add(new ShoppingItem("Green Tea", R.drawable.greentea, "Drinks", (float) 4.10, false, false, 0, 0));
        Drinks.add(new ShoppingItem("Nutritional Drinks", R.drawable.nutritionaldrinks, "Drinks", (float) 2.10, false, false, 0, 0));


        shoppingItems.addAll(Milk);
        shoppingItems.addAll(Drinks);
        shoppingItems.addAll(Bakery);
        shoppingItems.addAll(Fruit);
        shoppingItems.addAll(Vegetables);

        productGV = findViewById(R.id.idGridView);
        shoppingAdapter = new ShoppingAdapter(this, shoppingItems);
        productGV.setAdapter(shoppingAdapter);

//        ArrayList<HashMap<String, ArrayList<ShoppingItem>>> arrayList = new ArrayList<>();

        HashMap<String, ArrayList<ShoppingItem>> arrayListHashMap = new HashMap<>();

        arrayListHashMap.put("Bakery", Bakery);
        arrayListHashMap.put("Fruit", Fruit);
        arrayListHashMap.put("Vegetables", Vegetables);
        arrayListHashMap.put("Milk", Milk);
        arrayListHashMap.put("Drinks", Drinks);


        ImageView idImgBakery = findViewById(R.id.idImgBakery);
        idImgBakery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoppingItems = arrayListHashMap.get("Bakery");
                shoppingAdapter.Update(shoppingItems);
            }
        });


        ImageView idImgFruits = findViewById(R.id.idImgFruits);
        idImgFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoppingItems = arrayListHashMap.get("Fruit");
                shoppingAdapter.Update(shoppingItems);
            }
        });


        ImageView idImgVegetables = findViewById(R.id.idImgVegetables);
        idImgVegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoppingItems = arrayListHashMap.get("Vegetables");
                shoppingAdapter.Update(shoppingItems);
            }
        });


        ImageView idImgMilk = findViewById(R.id.idImgMilk);
        idImgMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoppingItems = arrayListHashMap.get("Milk");
                shoppingAdapter.Update(shoppingItems);
            }
        });


        ImageView idImgDrink = findViewById(R.id.idImgDrink);
        idImgDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoppingItems = arrayListHashMap.get("Drinks");
                shoppingAdapter.Update(shoppingItems);
            }
        });


        TextView idTotalProduct = findViewById(R.id.idTotalProduct);
        TextView idTotalPrice = findViewById(R.id.idTotalPrice);

        shoppingAdapter.setOnSetAddClickListener(new ShoppingAdapter.ProductAddClickEvent() {
            @Override
            public void onAddClick(ShoppingItem shoppingItems, int pos) {
                Qauntity = Qauntity + 1;
                idTotalProduct.setText("" + Qauntity);

                Price = Price + (shoppingItems.getProduct_price());
                idTotalPrice.setText("" + Price);
            }
        });

        shoppingAdapter.setOnsetMinusClickListner(new ShoppingAdapter.ProductMinusClickEvent() {
            @Override
            public void onMinusClick(ShoppingItem shoppingItems, int pos) {
                if (Qauntity >= 1) {
                    Qauntity -= 1;
                }
                idTotalProduct.setText("" + Qauntity);

                Price = Price - (shoppingItems.getProduct_price());
                idTotalPrice.setText("" + Price);
            }
        });
    }
}
