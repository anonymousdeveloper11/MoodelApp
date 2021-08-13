package com.anonymousdevloper.moodelapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anonymousdevloper.moodelapp.databinding.ItemCoursesBinding;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder>{

    private List<CourseModel> courses;

    public CourseAdapter(List<CourseModel> courses) {
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemCoursesBinding itemCoursesBinding = ItemCoursesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CourseViewHolder(itemCoursesBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {

        holder.setCourses(courses.get(position));
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }


    class CourseViewHolder extends RecyclerView.ViewHolder{
        ItemCoursesBinding binding;

       CourseViewHolder(ItemCoursesBinding itemCoursesBinding){
           super(itemCoursesBinding.getRoot());
           binding=itemCoursesBinding;
       }

       void setCourses(CourseModel course){
           binding.courseImageView.setImageResource(course.getImageId());
           binding.titleTv.setText(course.getTitle());
       }

    }
}
