package com.example.user.gallarywedget;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mySelection;
    Gallery myGallery;
    ImageView img;
    private int[] myImageIds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImageIds =new int[]
                {
                        R.drawable.img4, R.drawable.img5,R.drawable.img1, R.drawable.img2, R.drawable.img3,
                        R.drawable.img4, R.drawable.img5, R.drawable.img6,R.drawable.img7, R.drawable.img1, R.drawable.img2, R.drawable.img3,
                        R.drawable.img4, R.drawable.img5, R.drawable.img6,R.drawable.img7
                };


        mySelection = (TextView) findViewById(R.id.mySelection);
        myGallery = (Gallery) findViewById(R.id.myGallery);
        myGallery.setAdapter(new ImageAdapter(this));
        myGallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mySelection.setText("Selected Option " + position);
                showScreen2(position);
            }

            public void onNothingSelected(AdapterView<?> parent) {
                mySelection.setText("Nothing Selected");

            }


        });

        //@Override
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public class ImageAdapter extends BaseAdapter {
        private Context myContext;


        public ImageAdapter(Context c) {
            this.myContext = c;

        }

        public int getCount() {
            return myImageIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView iv = new ImageView(this.myContext);
            iv.setImageResource(myImageIds[position]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setLayoutParams(new Gallery.LayoutParams(150,100));
            return iv;
        }
    }

    private void showScreen2(int position) {
        img = (ImageView) findViewById(R.id.img);
        img.setImageResource(myImageIds[position]);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
