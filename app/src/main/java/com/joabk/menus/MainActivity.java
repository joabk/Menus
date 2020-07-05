package com.joabk.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    ActionMode mActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView)findViewById(R.id.tvTitle);
        this.registerForContextMenu(tv);

        Button button = (Button)findViewById(R.id.btnActionMode);
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(mActionMode !=null)
                    return false;

                mActionMode = startActionMode(mActionModeCallBack);
                return false;
            }
        });
    }


    private ActionMode.Callback mActionModeCallBack = new ActionMode.Callback(){

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.actionmode_context_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch(menuItem.getItemId()){
                case R.id.actionmodemenu1:
                    Toast.makeText(MainActivity.this, "Action Mode 1 clicked", Toast.LENGTH_SHORT).show();
                    actionMode.finish();
                    return true;
                case R.id.actionmodemenu2:
                    Toast.makeText(getApplicationContext(), "Action Mode 2 clicked", Toast.LENGTH_SHORT).show();
                    actionMode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            mActionMode = null;
        }
    };

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
                Toast.makeText(this,"Context menu 1 clicked", Toast.LENGTH_SHORT).show();
            case R.id.menucontext2:
                Toast.makeText(this, "Context menu 2 clicked", Toast.LENGTH_SHORT).show();
            case R.id.menucontext3:
                Toast.makeText(this, "Context menu 3 clicked", Toast.LENGTH_SHORT).show();
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

    public void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(this,view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.popupMenu1:
                Toast.makeText(this, "Popup Menu 1 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.popupMenu2:
                Toast.makeText(this, "Popup Menu 2 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.popupMenu3:
                Toast.makeText(this, "Popup Menu 3 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                Toast.makeText(this, "No button clicked", Toast.LENGTH_SHORT).show();
                return false;
        }
    }
}