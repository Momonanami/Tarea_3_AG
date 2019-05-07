package com.example.a19134355_7.listview_ag;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity
{
    private List<String>nombres;
    private GridView gridView;
    private  Myadapter  myadapter;
    private int contador=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = findViewById(R.id.gridView);

        nombres= new ArrayList<String>();
        nombres.add("diego");
        nombres.add("juan");
        nombres.add("bakugo");
        nombres.add("occhako");

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(GridActivity.this,"Clic en"+nombres.get(i),Toast.LENGTH_LONG).show();
            }
        });

        myadapter = new Myadapter(this,R.layout.grid_item,nombres);
        gridView.setAdapter(myadapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.add_item:
                this.nombres.add("nombre "+(++contador));
                this.myadapter.notifyDataSetChanged();
                return true;

           case R.id.delete_item:
                this.nombres.remove("nombre"+(contador--));
                this.myadapter.notifyDataSetChanged();
                return true;
            default:
                return  super.onOptionsItemSelected(item);

        }
    }
}
