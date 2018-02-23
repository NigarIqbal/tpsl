package com.example.admin.signapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class DisplayDic extends AppCompatActivity implements View.OnClickListener{
    private ImageButton finishbtn, previousbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int choice;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_dic);

        int position = getIntent().getExtras().getInt("Image Int");
        choice = getIntent().getExtras().getInt("Choice");
        ImageView imagev = (ImageView) findViewById(R.id.imagedisplay);
        finishbtn = (ImageButton) findViewById(R.id.Exit_button);
        previousbtn = (ImageButton) findViewById(R.id.Gobackbutton);

        finishbtn.setOnClickListener(this);
        previousbtn.setOnClickListener(this);

        if (choice == 2)
            position = position + 26;
        else if (choice == 3)
            position = position + 46;


        int[] bLogos = {

                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.f,
                R.drawable.g,
                R.drawable.h,
                R.drawable.i,
                R.drawable.j,
                R.drawable.k,
                R.drawable.l,
                R.drawable.m,
                R.drawable.n,
                R.drawable.o,
                R.drawable.p,
                R.drawable.q,
                R.drawable.r,
                R.drawable.s,
                R.drawable.t,
                R.drawable.u,
                R.drawable.v,
                R.drawable.w,
                R.drawable.x,
                R.drawable.y,
                R.drawable.z,
                R.drawable.frame_027,
                R.drawable.frame_028,
                R.drawable.frame_029,
                R.drawable.frame_030,
                R.drawable.frame_031,
                R.drawable.frame_032,
                R.drawable.frame_033,
                R.drawable.frame_034,
                R.drawable.frame_035,
                R.drawable.frame_036,
                R.drawable.frame_037,
                R.drawable.frame_038,
                R.drawable.frame_039,
                R.drawable.frame_040,
                R.drawable.frame_041,
                R.drawable.frame_042,
                R.drawable.frame_043,
                R.drawable.frame_044,
                R.drawable.frame_045,
                R.drawable.frame_046,
//                R.drawable.Alif,
//                R.drawable.Ba,
//                R.drawable.Pa,
                R.drawable.ta,
//                R.drawable.Sa,
//                R.drawable.Jeem,
                R.drawable.che,
//                R.drawable.Kha,
//                R.drawable.Daal,
                R.drawable.ta,
//                R.drawable.Zaa,
//                R.drawable.Zaad,
//                R.drawable.Fa,
                R.drawable.kaaf,
                R.drawable.gaaf,
//                R.drawable.Saad,
//                R.drawable.seen,
//                R.drawable.Sheen
        };
        int cImage = bLogos[position];
        imagev.setImageResource(cImage);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Gobackbutton) {
            Intent intent = new Intent(DisplayDic.this, Dictionary.class);
            startActivity(intent);
            finish();
        }

        /*if (v.getId() == R.id.Exit_button) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle(R.string.exit_application);
            alertDialogBuilder
                    .setMessage("Click yes to exit!")
                    .setCancelable(false)
                    .setPositiveButton(R.string.yes,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    moveTaskToBack(true);
                                    Process.killProcess(Process.myPid());
                                    System.exit(i1);
                                }
                            })
                    .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            dialog.cancel();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
*/

    }
}
