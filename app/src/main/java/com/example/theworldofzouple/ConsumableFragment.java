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
 * Use the {@link ConsumableFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsumableFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConsumableFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConsumableFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsumableFragment newInstance(String param1, String param2) {
        ConsumableFragment fragment = new ConsumableFragment();
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


        View view = inflater.inflate(R.layout.fragment_consumable, container, false);
        ListView shopListView= view.findViewById(R.id.shopListView);
        List<Consumable> consumablesList=new ArrayList<>();
        consumablesList.add(new Consumable("Petite potion de soin","potion100_foreground",100,100,0));
        consumablesList.add(new Consumable("Moyenne potion de soin","potion200_foreground",100,200,0));
        consumablesList.add(new Consumable("Grande potion de soin","potion500_foreground",100,500,0));
        consumablesList.add(new Consumable("Gigantesque potion de soin","potion1000_foreground",100,1000,0));
        consumablesList.add(new Consumable("Parchemin de caractéristiques","parchemincaracteristique_foreground",0,1000,5));


        shopListView.setAdapter(new ConsumableItemAdapter(getActivity(),consumablesList));
        return view;
    }
}