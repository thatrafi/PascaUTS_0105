package com.example.pascauts_0105.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pascauts_0105.DetailActivity;
import com.example.pascauts_0105.ItemClickSupport;
import com.example.pascauts_0105.R;
import com.example.pascauts_0105.adapter.EntertainmentAdapter;
import com.example.pascauts_0105.model.Entertainment;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_LANG = "Lang";
    private static final String ARG_KEY = "key";
    private String Lang = "en-US";
    private PageViewModel pageViewModel;
    private RecyclerView recyclerView ;
    private EntertainmentAdapter entertainmentAdapter;
    private ProgressBar progressBar;


    public static PlaceholderFragment newInstance(int index,String Lang,String key) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        bundle.putString(ARG_LANG,Lang);
        bundle.putString(ARG_KEY,key);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        progressBar = root.findViewById(R.id.progressbar);
        entertainmentAdapter = new EntertainmentAdapter(getActivity());
        entertainmentAdapter.notifyDataSetChanged();

        recyclerView = root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);


        if (getArguments() != null) {
            String language = getArguments().getString(ARG_LANG);
            if(language.equals("in") ){
                Lang = "id-ID";
            }

        }


        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.getMovie().observe(getViewLifecycleOwner(),getMovieList);
        pageViewModel.getTv().observe(getViewLifecycleOwner(),getTvList);
        showLoading(true);

        //Toast.makeText(getContext(),"try"+ getArguments().getString(ARG_LANG),Toast.LENGTH_LONG).show();
        pageViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                switch (Integer.parseInt(String.valueOf(s.charAt(s.length()-1)))){
                    case 0:
                        pageViewModel.setMovie(Lang,getArguments().getString(ARG_KEY));
                        break;
                    case 1:
                        pageViewModel.setTv(Lang,getArguments().getString(ARG_KEY));
                        break;
                }
            }
        });


        return root;

    }
    private Observer<List<Entertainment>> getMovieList = new Observer<List<Entertainment>>() {
        @Override
        public void onChanged(List<Entertainment> entertainments) {
            if(entertainments!=null){
                showData(entertainments,true,0);
                showLoading(false);
                //Toast.makeText(getContext(),entertainments.get(0).getTitle_movie(),Toast.LENGTH_LONG).show();
            }
        }
    };
    private Observer<List<Entertainment>> getTvList = new Observer<List<Entertainment>>() {
        @Override
        public void onChanged(List<Entertainment> entertainments) {
            if(entertainments!=null){
                showData(entertainments,false,1);
                showLoading(false);
                //Toast.makeText(getContext(),entertainments.get(0).getTitle_tv(),Toast.LENGTH_LONG).show();
            }
        }
    };


    private void showSelectedEntertainment(Entertainment entertainment,int flag){
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(DetailActivity.DETAIL_KEY,entertainment);
        intent.putExtra(DetailActivity.FLAG,flag);
        intent.putExtra(DetailActivity.DETAIL_Lang,Lang);
        startActivity(intent);
    }
    private void showData(final List<Entertainment> data, boolean flagbol, final int flagint){
        entertainmentAdapter.setEntertainmentList(data);
        entertainmentAdapter.setFlag(flagbol);
        recyclerView.setAdapter(entertainmentAdapter);
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedEntertainment(data.get(position),flagint);
            }
        });
    }
    private void showLoading(Boolean state){
        if(state){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.GONE);
        }
    }
}