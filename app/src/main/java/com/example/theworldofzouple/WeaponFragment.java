package com.example.theworldofzouple;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeaponFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeaponFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WeaponFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeaponFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeaponFragment newInstance(String param1, String param2) {
        WeaponFragment fragment = new WeaponFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weapon, container, false);
        ListView shopListView= view.findViewById(R.id.shopListView);
        List<Weapon>weaponsList=new ArrayList<>();
        weaponsList.add(new Weapon("Cure dent","curedent_foreground",100,1000,0));
        weaponsList.add(new Weapon("Baguette de pain","baguette_foreground",200,2000,0));
        weaponsList.add(new Weapon("Canne a pêche","canne_foreground",300,4000,0));
        weaponsList.add(new Weapon("Hand spinner","handspinner_foreground",350,5000,0));
        weaponsList.add(new Weapon("Shuriken","shuriken_foreground",450,8000,0));
        weaponsList.add(new Weapon("Dagues du scorpion","dagues1_foreground",750,14000,0));
        weaponsList.add(new Weapon("Epee basique","epee1_foreground",750,18000,3));
        weaponsList.add(new Weapon("Epee rafiné","epee2_foreground",900,35000,5));
        weaponsList.add(new Weapon("Epee du tueur de zouples","epee3_foreground",1550,78000,5));
        weaponsList.add(new Weapon("Katana en ambre","katana1_foreground",1550,120000,10));
        weaponsList.add(new Weapon("Katana antique","katana2_foreground",2200,210000,10));
        weaponsList.add(new Weapon("Katana spirituel","katana3_foreground",2420,390000,20));



        shopListView.setAdapter(new WeaponItemAdapter(getActivity(),weaponsList));
        return view;
    }
}