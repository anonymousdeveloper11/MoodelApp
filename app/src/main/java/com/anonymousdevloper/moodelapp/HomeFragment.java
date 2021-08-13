package com.anonymousdevloper.moodelapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anonymousdevloper.moodelapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private List<CourseModel> course;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        binding.courseRv.setHasFixedSize(true);
        binding.courseRv.setAdapter(new CourseAdapter(initData()));
        return binding.getRoot();
       // initData();
    }

    private List<CourseModel> initData() {
        course = new ArrayList<>();
        course.add(new CourseModel("Course category",R.drawable.folder));
        course.add(new CourseModel("Available courses",R.drawable.cap));
        return  course;


    }


}