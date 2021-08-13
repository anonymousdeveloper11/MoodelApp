package com.anonymousdevloper.moodelapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import com.anonymousdevloper.moodelapp.databinding.FragmentDashboardBinding;

import java.util.ArrayList;
import java.util.List;


public class DashboardFragment extends Fragment {


private FragmentDashboardBinding binding;
private List<SliderModel> sliders;
private PreferenceManager preferenceManager;
//private SharedPreferences.Editor editor;
    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDashboardBinding.inflate(inflater,container, false);
        preferenceManager = new PreferenceManager(getContext());
//        preferenceManager = new PreferenceManager((Context) getActivity().getSharedPreferences("loginApi", Context.MODE_PRIVATE));
//        preferenceManager = new PreferenceManager(getApplicationContextontext());
//        SharedPreferences pref = getActivity().getSharedPreferences("loginApi",Context.MODE_PRIVATE);
//        editor.putString("username",null);
//        editor.commit();

        //LoginModel model = new LoginModel();
       // binding.usernameTv.setText( preferenceManager.getString(A));
       // binding.usernameTv.setText(preferenceManager.getString(ApiConstant.KEY_USERNAME));

        binding.usernameTextTv.setText(preferenceManager.getString(ApiConstant.KEY_USERNAME));

        binding.usernameTv.setText(preferenceManager.setUserName(getString(preferenceManager.putString(ApiConstant.KEY_USERNAME))));
        binding.sliderRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        binding.sliderRv.setHasFixedSize(true);
        binding.sliderRv.setAdapter(new SliderAdapter(initData()));
        return binding.getRoot();

        //LoginModel model = new LoginModel(getActivity(),getString(ApiConstant.KEY_USERNAME));

       // binding.usernameTv.setText(String.format("%s",preferenceManager.getString(ApiConstant.KEY_USERNAME)));

//        binding.usernameTv.setText(String.format("%s,%s",ApiConstant.KEY_USERNAME));
    }

    private List<SliderModel> initData(){
        sliders = new ArrayList<>();
        sliders.add(new SliderModel("Elective(March 2021 Semester)","Strategic Marketing(Marketing)",R.color.colorAccent));
        sliders.add(new SliderModel("Regular(September 2021 Semester","Digital Marketing(Marketing)", R.color.colorPrimary));
        sliders.add(new SliderModel("Msc CSIT","Software Development", R.color.colorBlue));
        return sliders;
    }
}