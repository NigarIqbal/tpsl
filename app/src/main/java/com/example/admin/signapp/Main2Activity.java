package com.example.admin.signapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.design.widget.NavigationView;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.postag.POSSample;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.InvalidFormatException;


public class Main2Activity extends AppCompatActivity  implements OnClickListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private EditText entertext;
    private TextView textgen;
    private ImageButton searchbtn, vsearchbtn, exitbtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mDrawerLayout =(DrawerLayout) findViewById(R.id.activity_main2);
        searchbtn = (ImageButton) findViewById(R.id.searchb);
        vsearchbtn = (ImageButton) findViewById(R.id.vbtn);
        entertext = (EditText) findViewById(R.id.edtext);
        textgen = (TextView) findViewById(R.id.txtview);

        textgen.setOnClickListener(this);
        searchbtn.setOnClickListener(this);
        vsearchbtn.setOnClickListener(this);
        entertext.setOnClickListener(this);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        NavigationView nvDrawer = (NavigationView) findViewById(R.id.nv);
        mToggle.syncState();
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nvDrawer);

    }

    @Override
    public void onClick(View v) {

        InputStream tokenModelIn = null;
        InputStream posModelIn = null;

        InputMethodManager inputManager = (InputMethodManager) this.getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        if (v.getId() == R.id.searchb) {

            Toast.makeText(getApplicationContext(), "Processing text...please wait", Toast.LENGTH_SHORT).show();

            String strtxt;

            if (entertext.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "Enter some text here !!", Toast.LENGTH_SHORT).show();
                return;
            } else
               // try {
                    strtxt = entertext.getText().toString();
                    Tokenizer tokenizer = WhitespaceTokenizer.INSTANCE;
                    String tokens[] = tokenizer.tokenize(strtxt);
                    textgen.setText(Arrays.toString(tokens));
                   /* Context context = null;
                    AssetFileDescriptor fileDescriptor = context.getAssets().openFd("en_pos_maxent(1).bin");
                    FileInputStream inputStream = fileDescriptor.createInputStream();
                    POSModel posModel = new POSModel(inputStream);

                    /*InputStream inputStream = new FileInputStream("C:\\Users\\admin\\Documents\\final year\\FYP\\SignApp\\app\\libs\\en-pos-maxent (1).bin");
                    POSModel model = new POSModel(inputStream);

                    POSTaggerME tagger = new POSTaggerME(posModel);
                    String[] tags = tagger.tag(tokens);
                    POSSample sample = new POSSample(tokens, tags);
                    textgen.setText(sample.toString());
                } catch (InvalidFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "invalid format !!", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "file not found !!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "IO !!", Toast.LENGTH_SHORT).show();
                }
                }*/



        }
    }

    public void selectItemDrawer(MenuItem menuitem){
        int id = menuitem.getItemId();
        intent =new Intent(this, ListView.class);
        if(id==R.id.nav_home){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else if(id == R.id.dictionary){
            startActivity(new Intent(this, Dictionary.class));
        }
    }

    public void setupDrawerContent(NavigationView navigationView) {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return true;
            }
        });

    }

}

