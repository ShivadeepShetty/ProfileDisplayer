package com.app.profiledisplayer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.profiledisplayer.R;
import com.app.profiledisplayer.dto.PeopleResponse;
import com.app.profiledisplayer.dto.Results;
import com.app.profiledisplayer.dto.Root;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ProfileHolder> {
    List<Results> itemList = new ArrayList<>();

    private scrollToPosition  listener;

    public  void  setResults(List<Results> results){
        this.itemList = results;
        notifyDataSetChanged();
    }

    public  void  setListener(scrollToPosition  listener){
        this.listener = listener;
    }
    @NonNull
    @Override
    public ProfileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view, parent, false);

        return new ProfileHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileHolder holder, int position) {
          holder.email.setText(itemList.get(position).getEmail());
          holder.name.setText(itemList.get(position).getName().getFirst() + " "+itemList.get(position).getName().getLast());
          holder.gender.setText(itemList.get(position).getGender());
          holder.cardView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  listener.scrollToPositon(position);
              }
          });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ProfileHolder extends RecyclerView.ViewHolder {
        private TextView gender;
        private TextView name;
        private TextView email;
        private CardView cardView;

        public ProfileHolder(@NonNull View itemView) {
            super(itemView);
            gender = itemView.findViewById(R.id.gender);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            cardView = itemView.findViewById(R.id.root);

        }
    }
    public interface  scrollToPosition{
        void  scrollToPositon(int position);
    }
}
