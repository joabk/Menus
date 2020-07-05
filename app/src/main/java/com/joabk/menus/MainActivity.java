package com.joabk.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView)findViewById(R.id.tvTitle);
        this.registerForContextMenu(tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        //return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.floating_context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menucontext1:
                Toast.makeText(this,"Context menu 1 clicked", Toast.LENGTH_LONG).show();
            case R.id.menucontext2:
                Toast.makeText(this, "Context menu 2 clicked", Toast.LENGTH_LONG).show();
            case R.id.menucontext3:
                Toast.makeText(this, "Context menu 3 clicked", Toast.LENGTH_LONG);
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuItel1:
                Toast.makeText(this, "Menu item 1 clicked", Toast.LENGTH_SHORT).show();
            case R.id.menuItel2:
                Toast.makeText(this, "Menu item 2 clicked", Toast.LENGTH_SHORT).show();
            case R.id.menuItel3:
                Toast.makeText(this, "Menu item 3 clicked", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}