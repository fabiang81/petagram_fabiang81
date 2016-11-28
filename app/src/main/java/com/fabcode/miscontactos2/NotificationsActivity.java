package com.fabcode.miscontactos2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.fabcode.miscontactos2.presentador.IRecyclerViewFragmentPresenter;
import com.fabcode.miscontactos2.presentador.RecyclerViewFragmentPresenter;

public class NotificationsActivity extends AppCompatActivity {

    private IRecyclerViewFragmentPresenter iRecyclerViewFragmentPresenter;
    private TextView tvNameId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        Bundle extras = getIntent().getExtras();
        String nameId = extras.getString("nameId");

        iRecyclerViewFragmentPresenter = new RecyclerViewFragmentPresenter();
        iRecyclerViewFragmentPresenter.enviarToken(String.valueOf(nameId));

    }
}
