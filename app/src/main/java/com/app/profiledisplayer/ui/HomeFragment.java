package com.app.profiledisplayer.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.profiledisplayer.adapter.CarouselAdapter;
import com.app.profiledisplayer.adapter.PeopleAdapter;
import com.app.profiledisplayer.databinding.FragmentHomeBinding;
import com.app.profiledisplayer.dto.PeopleResponse;
import com.app.profiledisplayer.dto.Root;
import com.app.profiledisplayer.viewmodel.HomeViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment implements PeopleAdapter.scrollToPosition,CarouselAdapter.scrollToPosition {

    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;
    private static final String TAG = "HomeFragment";

    private PeopleAdapter peopleAdapter = new PeopleAdapter();
    private CarouselAdapter carouselAdapter = new CarouselAdapter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
        setRecyclerView();
    }

    private void initViewModel(){
        viewModel =  new ViewModelProvider(this).get(HomeViewModel.class);
        viewModel.init();
        viewModel.getPeopleResponse().observe(getViewLifecycleOwner(), new Observer<Root>() {
            @Override
            public void onChanged(Root peopleResponse) {
                peopleAdapter.setResults(peopleResponse.getResults());
                carouselAdapter.setResults(peopleResponse.getResults());
            }
        });
    }
    private void setRecyclerView(){
        RecyclerView recyclerView = binding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(peopleAdapter);
        carouselAdapter.setContext(getContext());
        peopleAdapter.setListener(this);
        carouselAdapter.setListener(this);
        binding.carousel.setLayoutManager( new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        binding.carousel.setAdapter(carouselAdapter);
    }


    @Override
    public void scrollToPositon(int position) {
        binding.carousel.getLayoutManager().scrollToPosition(position);
    }

    @Override
    public void scrollToCarouselPositon(int position) {
        binding.carousel.getLayoutManager().scrollToPosition(position);

    }
}
