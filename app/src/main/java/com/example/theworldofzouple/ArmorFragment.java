package com.example.theworldofzouple;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArmorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArmorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ArmorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ArmorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ArmorFragment newInstance(String param1, String param2) {
        ArmorFragment fragment = new ArmorFragment();
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
        List<Armor> armorsList=new ArrayList<>();
        armorsList.add(new Armor("Armor1","armor1_foreground",10,1000));
        armorsList.add(new Armor("Armor2","armor2_foreground",30,2000));
        armorsList.add(new Armor("Armor3","armor3_foreground",50,5000));
        armorsList.add(new Armor("Armor4","armor4_foreground",100,10000));



        shopListView.setAdapter(new ArmorItemAdapter(getActivity(),armorsList));
        return view;
    }
}