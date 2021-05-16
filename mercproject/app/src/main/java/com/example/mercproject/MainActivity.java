package com.example.mercproject;

import android.media.DrmInitData;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ArrayList<Items> mItemsData;
    private ItemsAdapter mAdapter;
    String s1[];
    int images[]={R.drawable.letters,};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        //工具?
        Toolbar toolbar = findViewById ( R.id.toolbar );
        setSupportActionBar ( toolbar );

        //浮球
        FloatingActionButton fab = findViewById ( R.id.fab );
        fab.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Snackbar.make ( view , "Replace with your own action" , Snackbar.LENGTH_LONG )
                        .setAction ( "Action" , null ).show ( );
            }
        } );
        this.recyclerView = findViewById(R.id.recyclerView);

        s1=getResources ().getStringArray ( R.array.selection_item );

        ItemsAdapter itemsAdapter = new ItemsAdapter(this,s1,images);
        recyclerView.setLayoutManager(new LinearLayoutManager( this));
        recyclerView.setAdapter(itemsAdapter);}



        //mRecyclerView=findViewById ( R.id.recyclerView );
        //設置版型
        //mRecyclerView.setLayoutManager(new LinearLayoutManager (this));

        //mItemsData=new ArrayList<> (  );

        //mAdapter=new ItemsAdapter (this,mItemsData);
        //mRecyclerView.setAdapter ( mAdapter );




    //這些是甚麼???????????????可以有菜單選項的版面喔？
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ( ).inflate ( R.menu.menu_main , menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId ( );

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected ( item );
    }
}