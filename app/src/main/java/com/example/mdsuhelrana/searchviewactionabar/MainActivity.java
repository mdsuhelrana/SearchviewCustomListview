package com.example.mdsuhelrana.searchviewactionabar;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String>list=new ArrayList<>();
    CustomAdapter adapter;

   /* this adapter is default adapter
    ArrayAdapter<String>adapter;*/

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.lv_id);
        getList();
        adapter=new CustomAdapter(this,list);

       // adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);

        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_main, menu);

        SearchManager searchManager =
               (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(TextUtils.isEmpty(newText))
                {
                    lv.clearTextFilter();
                    adapter.filter("");
                }else {
                    adapter.filter(newText);
                }
                return true;
            }
        });

        return true;
    }
    private void getList() {
        list.add("apple");
        list.add("banana");
        list.add("cat");
        list.add("dog");
        list.add("egg");
        list.add("flower");
        list.add("gun");
        list.add("hammer");
        list.add("ice-cream");
        list.add("juice");
        list.add("kite");
        list.add("ladder");
        list.add("moon");
        list.add("nose");
        list.add("orrange");
        list.add("pen");
        list.add("quilt");
        list.add("ret");
        list.add("sound");
        list.add("tie");
        list.add("umbrella");
        list.add("van");
        list.add("win");
        list.add("x-ray");
        list.add("yellow");
        list.add("zero");
    }
}
