package com.fabcode.miscontactos2;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.fabcode.miscontactos2.adapter.PageAdapter;
import com.fabcode.miscontactos2.fragment.PerfilFragment;
import com.fabcode.miscontactos2.fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView tvNameId;
    private String nameId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.dog_paw);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home_50);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog_50);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent1 = new Intent(this, AboutActivity.class);
                startActivity(intent1);
                break;
            case R.id.mContact:
                Intent intent2 = new Intent(this, ContactoActivity.class);
                startActivity(intent2);
                break;
            case R.id.mSettings:
                Intent intent3 = new Intent(this, FormActivity.class);
                startActivity(intent3);
                break;
            case R.id.mNotificaciones:
                Intent intent4 = new Intent(this, NotificationsActivity.class);
                tvNameId = (TextView) findViewById(R.id.tvNameId);
                nameId = String.valueOf(tvNameId.getText());
                intent4.putExtra("nameId", nameId);
                startActivity(intent4);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
