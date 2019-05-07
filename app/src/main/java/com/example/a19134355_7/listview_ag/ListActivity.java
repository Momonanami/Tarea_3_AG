package com.example.a19134355_7.listview_ag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.ListView);

        final List<String> nombres= new ArrayList<String>();
        nombres.add("diego");
        nombres.add("juan");
        nombres.add("bakugo");
        nombres.add("occhako");
        nombres.add("diego");
        nombres.add("juan");
        nombres.add("bakugo");
        nombres.add("occhako");
        nombres.add("diego");
        nombres.add("juan");
        nombres.add("bakugo");
        nombres.add("occhako");
        nombres.add("diego");
        nombres.add("juan");
        nombres.add("bakugo");
        nombres.add("occhako");
        // forma visual que mostraremos los datos
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombres);
        //enlazamos el adaptador con el listview
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListActivity.this,"Clic en "+nombres.get(i),Toast.LENGTH_LONG).show();
            }
        });
        //enlazamos con nuestro adaptador personalizado
        Myadapter myadapter= new Myadapter(this,R.layout.list_item,nombres);
        listView.setAdapter(myadapter);
    }
}
