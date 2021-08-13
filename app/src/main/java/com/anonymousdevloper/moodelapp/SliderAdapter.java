package com.anonymousdevloper.moodelapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anonymousdevloper.moodelapp.databinding.ItemSliderBinding;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder>{

    private List<SliderModel> slider;

    public SliderAdapter(List<SliderModel> slider) {
        this.slider = slider;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemSliderBinding itemSliderBinding = ItemSliderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new SliderViewHolder(itemSliderBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {

        holder.setSlider(slider.get(position));
    }

    @Override
    public int getItemCount() {
        return slider.size();
    }


    class SliderViewHolder extends RecyclerView.ViewHolder{

        ItemSliderBinding binding;

        SliderViewHolder(ItemSliderBinding itemSliderBinding){
            super(itemSliderBinding.getRoot());
            binding = itemSliderBinding;
        }

        void setSlider(SliderModel slider){
            binding.titleTv.setText(slider.getTitle());
            //binding.colorRl.setBackground(slider.getColor());
            binding.subtitleTv.setText(slider.getSubtitle());
            binding.colorRl.setBackgroundColor(slider.getColor());
        }
    }
}
