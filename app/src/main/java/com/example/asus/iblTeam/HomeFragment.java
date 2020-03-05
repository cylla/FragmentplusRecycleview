package com.example.asus.iblTeam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView rv_ibl_list;
    private ArrayList<IBLModel> list = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rv_ibl_list = view.findViewById(R.id.rv_team_list);
        list.addAll(IBLData.getListData());

        ShowRecycleList();
        return view;
    }

    private void ShowRecycleList(){
        rv_ibl_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        IBLAdapter iblAdapter = new IBLAdapter(getActivity());
        iblAdapter.setIBLList(list);
        rv_ibl_list.setAdapter(iblAdapter);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
