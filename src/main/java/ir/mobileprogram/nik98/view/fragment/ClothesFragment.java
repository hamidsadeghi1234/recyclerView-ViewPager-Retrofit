package ir.mobileprogram.nik98.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import ir.mobileprogram.nik98.classes.webservice.DataFakeGenerator;
import ir.mobileprogram.nik98.R;
import ir.mobileprogram.nik98.view.adapter.ClothesAdapter;

public class ClothesFragment extends Fragment {
    private RecyclerView recyclerView;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_clothes,container,false);
       recyclerView =(RecyclerView)view.findViewById(R.id.clothes_recycler);
        ClothesAdapter clothesAdapter=new ClothesAdapter(getActivity(), DataFakeGenerator.getClothes(getActivity()));
        recyclerView.setLayoutManager((new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)));
        recyclerView.setAdapter(clothesAdapter);


        return view;
    }

    public static ClothesFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ClothesFragment fragment = new ClothesFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
