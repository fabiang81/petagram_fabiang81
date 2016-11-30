package com.fabcode.miscontactos2.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fabcode.miscontactos2.db.ConstructorContactos;
import com.fabcode.miscontactos2.pojo.Contacto;
import com.fabcode.miscontactos2.DetalleContacto;
import com.fabcode.miscontactos2.R;
import com.fabcode.miscontactos2.presentador.IRecyclerViewFragmentPresenter;
import com.fabcode.miscontactos2.presentador.RecyclerViewFragmentPresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by RGonzales on 10/21/2016.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;
    private IRecyclerViewFragmentPresenter iRecyclerViewFragmentPresenter;

        public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }

    //Inflar el layout y lo pasará al viewholder para que obtenga los views
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        Picasso.with(activity)
                .load(contacto.getUrlFoto())
                .placeholder(R.drawable.hueso_del_perro_48)
                .into(contactoViewHolder.imgFoto);
        contactoViewHolder.tvLikes.setText(String.valueOf(contacto.getLikes()));
        contactoViewHolder.tvNombreCV.setText(String.valueOf(contacto.getNombreCompleto()));
        contactoViewHolder.tvMediaId.setText(String.valueOf(contacto.getMedia_id()));
        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("url", contacto.getUrlFoto());
                intent.putExtra("like", contacto.getLikes());
                activity.startActivity(intent);
            }
        });

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(activity, "Like enviado correctamente",
                        Toast.LENGTH_SHORT).show();
                iRecyclerViewFragmentPresenter = new RecyclerViewFragmentPresenter();
                iRecyclerViewFragmentPresenter.darLike(contacto.getMedia_id());
                iRecyclerViewFragmentPresenter.almacenarLike(contacto.getId(), contacto.getMedia_id(), contacto.getNombreCompleto());
                iRecyclerViewFragmentPresenter.notificarLike("-KXiLvQYC6504YPSpppS", contacto.getUrlFoto(), contacto.getNombreCompleto());
            }
        });

    }

    @Override
    public int getItemCount() {//Cantidad de elementos que contiene la lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        //private TextView tvTelefonoCV;
        private ImageView btnLike;
        private TextView tvMediaId;
        private TextView tvLikes;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV      = (TextView) itemView.findViewById(R.id.tvNameId);
            /*tvTelefonoCV    = (TextView) itemView.findViewById(R.id.tvTelefonoCV);*/
            btnLike = (ImageView) itemView.findViewById(R.id.imgBone);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
            tvMediaId = (TextView) itemView.findViewById(R.id.tvMediaId);
        }
    }

}
