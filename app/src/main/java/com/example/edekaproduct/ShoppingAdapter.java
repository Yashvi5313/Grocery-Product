package com.example.edekaproduct;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingAdapter extends ArrayAdapter<ShoppingItem> {

    ArrayList<ShoppingItem> list;
    ProductAddClickEvent productAddClickEvent;
    ProductMinusClickEvent productMinusClickEvent;

    public ShoppingAdapter(@NonNull Context context, ArrayList<ShoppingItem> shoppingItems) {
        super(context, R.layout.card_view);

        this.list = shoppingItems;
    }

    public void Update(ArrayList<ShoppingItem> shoppingItems) {
        this.list = shoppingItems;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    public ShoppingItem getItem(int position) {
        return this.list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {

        View listProductView = convertView;
        RecordHolder holder = null;

        if (listProductView == null) {
            listProductView = LayoutInflater.from(getContext()).inflate(R.layout.card_view, parent, false);

            holder = new RecordHolder();

            holder.idProductName = (TextView) listProductView.findViewById(R.id.idProductName);
            holder.idProductType = (TextView) listProductView.findViewById(R.id.idProductType);
            holder.idProductPrice = (TextView) listProductView.findViewById(R.id.idProductPrice);
            holder.idIVitem = (ImageView) listProductView.findViewById(R.id.idIVitem);
            holder.idIVlike = (ImageView) listProductView.findViewById(R.id.idIVlike);
            holder.idImgAdd = (ImageView) listProductView.findViewById(R.id.idImgAdd);
            holder.idImgMinus = (ImageView) listProductView.findViewById(R.id.idImgMinus);
            holder.idProductQuntity = (TextView) listProductView.findViewById(R.id.idProductQuntity);

            listProductView.setTag(holder);

        } else {
            holder = (RecordHolder) listProductView.getTag();
        }

        ShoppingItem shoppingItem = getItem(position);


        holder.idProductName.setText(shoppingItem.getProduct_name());
        holder.idProductType.setText(shoppingItem.getProduct_type());
        holder.idProductPrice.setText("" + shoppingItem.getProduct_price());
        holder.idIVitem.setImageResource(shoppingItem.getProduct_img());
        holder.idProductQuntity.setText("" + shoppingItem.getNumberOfProduct());

        if (shoppingItem.getProduct_like()) {
            holder.idIVlike.setImageResource(R.drawable.img_heart_red);
        } else {
            holder.idIVlike.setImageResource(R.drawable.img_heart_white);
        }

        holder.idIVlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!shoppingItem.getProduct_like()) {
                    shoppingItem.setProduct_like(true);
                } else {
                    shoppingItem.setProduct_like(false);
                }
                notifyDataSetChanged();
            }
        });

        RecordHolder finalHolder = holder;
        holder.idImgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoppingItem.addToNumber();
                finalHolder.idProductQuntity.setText("" + shoppingItem.getNumberOfProduct());
                notifyDataSetChanged();
                productAddClickEvent.onAddClick(shoppingItem, position);
            }
        });

        holder.idImgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shoppingItem.getNumberOfProduct() != 0){
                    shoppingItem.removeFromNumber();
                    finalHolder.idProductQuntity.setText("" + shoppingItem.getNumberOfProduct());
                    notifyDataSetChanged();
                    productMinusClickEvent.onMinusClick(shoppingItem, position);
                }

            }
        });

        return listProductView;
    }

    public class RecordHolder {
        TextView idProductName;
        TextView idProductType;
        TextView idProductPrice;
        ImageView idIVitem;
        ImageView idIVlike;
        ImageView idImgAdd;
        ImageView idImgMinus;
        TextView idProductQuntity;
    }

    public void setOnSetAddClickListener(ProductAddClickEvent productAddClickEvent) {
        this.productAddClickEvent = productAddClickEvent;
    }

    public interface ProductAddClickEvent {
        void onAddClick(ShoppingItem shoppingItems, int pos);
    }

    public void setOnsetMinusClickListner(ProductMinusClickEvent productMinusClickEvent) {
        this.productMinusClickEvent = productMinusClickEvent;
    }


    public interface ProductMinusClickEvent {
        void onMinusClick(ShoppingItem shoppingItems, int pos);
    }
}
