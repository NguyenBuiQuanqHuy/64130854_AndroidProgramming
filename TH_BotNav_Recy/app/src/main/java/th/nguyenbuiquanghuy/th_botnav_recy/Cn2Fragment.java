package th.nguyenbuiquanghuy.th_botnav_recy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Cn2Fragment extends Fragment {
    Cn2Adapter adapter;
    ArrayList<Cn2> cn2ArrayList;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cn2, container, false);

        cn2ArrayList=getCn2ArrayList();
        recyclerView=view.findViewById(R.id.recyCn2);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Cn2Adapter(getActivity(),cn2ArrayList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    ArrayList<Cn2> getCn2ArrayList(){
        ArrayList<Cn2> listData=new ArrayList<>();
        listData.add(new Cn2("project","Tóm tắt 1"));
        listData.add(new Cn2("project","Tóm tắt 2"));
        listData.add(new Cn2("project","Tóm tắt 3"));
        listData.add(new Cn2("project","Tóm tắt 4"));
        listData.add(new Cn2("project","Tóm tắt 5"));

        return listData;
    }
}