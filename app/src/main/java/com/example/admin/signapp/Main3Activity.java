package com.example.admin.signapp;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    private GridView gridView;
    private GridViewAdapter customGridAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final int choice =getIntent().getExtras().getInt("Userchoice");
        gridView =(GridView) findViewById(R.id.gridView);
        customGridAdapter = new GridViewAdapter(this,R.layout.row_grid,getData(choice));
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                /* Call DisplayActivity with the choice and image position */
                Intent intent = new Intent(Main3Activity.this, DisplayDic.class);
                intent.putExtra("Image Int", position);
                intent.putExtra("Choice", choice);
                startActivity(intent);
                finish();
            }

        });
    }

    private ArrayList<imageItem> getData(int choice) {
        final ArrayList<imageItem> imageItems = new ArrayList<imageItem>();

        int[] arr_st = {R.array.image_ids,
                R.array.image_num,
                R.array.image_fuw};
        TypedArray imgs = getResources().obtainTypedArray(arr_st[choice - 1]);

        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),
                    imgs.getResourceId(i, -1));
            imageItems.add(new imageItem(bitmap, " " + i + 1));
        }

        return imageItems;
    }
    }
