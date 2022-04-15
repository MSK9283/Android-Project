package com.example.umore;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.slider.RangeSlider;

import java.util.ArrayList;

public class quizAdapter extends RecyclerView.Adapter<quizAdapter.InventoryViewHolder> {

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        mListener = listener;
    }

    private ArrayList<quizItem> mItemList;

    private onItemClickListener mListener;

    public static class InventoryViewHolder extends RecyclerView.ViewHolder {

        public TextView itemName_viewHolder;
        public TextView itemScore_viewHolder;
        public RangeSlider itemScoreSlider_viewHolder;

        public InventoryViewHolder(@NonNull View itemView, final onItemClickListener listener) {
            super(itemView);
            itemName_viewHolder = itemView.findViewById(R.id.question_TimeLabel);
            itemScore_viewHolder = itemView.findViewById(R.id.question_TimeScore);
            itemScoreSlider_viewHolder = itemView.findViewById(R.id.question_TimeSlider);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public quizAdapter(ArrayList<quizItem> inventoryList) {
        mItemList = inventoryList;
    }

    @NonNull
    @Override
    public InventoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_quiz_question, parent, false);
        InventoryViewHolder invHolder = new InventoryViewHolder(v, mListener);
        return invHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryViewHolder holder, int position) {
        quizItem currentItem = mItemList.get(position);

        holder.itemName_viewHolder.setText(currentItem.getTime() + "");
        holder.itemScore_viewHolder.setText(currentItem.getScore() + "");
        holder.itemScoreSlider_viewHolder.setValueTo(0.5f);

        holder.itemScoreSlider_viewHolder.setValueFrom(0);
        holder.itemScoreSlider_viewHolder.setValueTo(10);
        holder.itemScoreSlider_viewHolder.setStepSize(1);
        holder.itemScoreSlider_viewHolder.addOnChangeListener(new RangeSlider.OnChangeListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onValueChange(@NonNull RangeSlider slider, float value, boolean fromUser) {
                holder.itemScore_viewHolder.setText("" + value);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}