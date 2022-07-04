package com.example.homework4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.bumptech.glide.Glide;
import com.example.homework4.databinding.ItemBinding;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHoldor> {

    ArrayList<GameModel> list ;

    public GameAdapter(ArrayList<GameModel> list, ItemNotesOnClikc notesOnClikc) {
        this.list = list;
    }

    @NonNull
    @Override
    public GameViewHoldor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new GameViewHoldor(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHoldor holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class GameViewHoldor extends RecyclerView.ViewHolder {
        ItemBinding binding;

        public GameViewHoldor(@NonNull ViewBinding binding) {
            super(binding.getRoot());
            this.binding = (ItemBinding) binding;
        }

        public void onBind(GameModel gameModel) {
            binding.name.setText(GameModel.name);
            binding.surname.setText(gameModel.surname);
            binding.post.setText(gameModel.post);
            Glide.with(binding.image).load(gameModel.avatar).circleCrop().into(binding.image);
            itemView.setOnClickListener(new View.OnClickListener() {

                public ItemNotesOnClikc notesOnClikc;

                @Override
                public void onClick(View view) {
                    notesOnClikc.itemClick(GameModel.name);
                }
            });
        }
    }
}
