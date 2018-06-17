package com.hamro.nepalidol;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class Ranking extends Fragment {
    String url= "http://nepalidol.tk/wp-content/uploads/2018/02/ranking.png";


    public Ranking() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            getActivity().setTitle("Ranking");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ranking, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageview= (ImageView)view.findViewById(R.id.ranking);

        Picasso.with(getActivity()).load(url)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .placeholder(R.drawable.small)
                .into(imageview);
}}
