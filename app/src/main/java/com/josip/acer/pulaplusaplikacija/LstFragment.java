package com.josip.acer.pulaplusaplikacija;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Korisnik on 5.11.2016..
 */

public class LstFragment extends ListFragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){

        //inflate fragmenta
        ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.fragmentlayout,container,false);
        //stvaranje izbora podataka
        String [] datasource={"Trgovine","Događaj","Znamenitost","Bolnica","Restoran","Hotel"};
        //kreiranje adaptera
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(getActivity(), R.layout.rowlayout,R.id.txtitem,datasource);
        //bindanje adaptera u list fragment
        setListAdapter(adapter);
        //zadržati listfragment preko konfiguracijkih promjena
        setRetainInstance(true);
        return rootView;


    }
    //rukovanje klikom stavke
    public void onListItemClick(ListView l, View view, int position, long id){
        ViewGroup viewGroup=(ViewGroup)view;
        TextView txt=(TextView)viewGroup.findViewById(R.id.txtitem);
        if(position==0){
            Intent i = new Intent(getActivity(), TrgovineActivity.class);
            getActivity().startActivity(i);
        }
        if(position==1){
            Intent i = new Intent(getActivity(),DogadjajActivity.class);
            getActivity().startActivity(i);
        }
        if(position==5){
            Intent i = new Intent(getActivity(), BookingActivity.class);
            getActivity().startActivity(i);
        }







        //   Toast.makeText(getActivity(),txt.getText().toString(),Toast.LENGTH_LONG).show();
        /*"http://booking.hr"
        * "http://www.pulainfo.hr/hr/main-highlights/main-highlights/0/";
        *
        * */
    }


}
