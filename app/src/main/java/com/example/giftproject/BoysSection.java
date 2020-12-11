package com.example.giftproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BoysSection#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BoysSection extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BoysSection() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BoysSection.
     */
    // TODO: Rename and change types and number of parameters
    public static BoysSection newInstance(String param1, String param2) {
        BoysSection fragment = new BoysSection();
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
        final View view1= inflater.inflate(R.layout.fragment_kids_section, container, false);
        ImageView boyCloth=(ImageView) view1.findViewById(R.id.boysClothing);
        ImageView boyAccessory=(ImageView) view1.findViewById(R.id.boysAccessory);
        ImageView boyShoes=(ImageView) view1.findViewById(R.id.boysShoes);

        boyCloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(),BoysClothing.class);
                startActivity(i);
            }
        });
        boyAccessory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(),BoysAccessory.class);
                startActivity(i);
            }
        });
        boyShoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(),BoysShoes.class);
                startActivity(i);
            }
        });
        return view1;
    }
}