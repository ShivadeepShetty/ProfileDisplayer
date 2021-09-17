package com.app.profiledisplayer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.profiledisplayer.R;
import com.app.profiledisplayer.dto.Results;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder> {

    List<Results> itemList = new ArrayList<>();
    private Context mContext;
    private PeopleAdapter.scrollToPosition listener;

    public  void  setListener(PeopleAdapter.scrollToPosition listener){
        this.listener = listener;
    }

    public  void  setResults(List<Results> results){
        this.itemList = results;
        notifyDataSetChanged();
    }
    public  void  setContext(Context context){
       mContext = context;
    }
    @NonNull
    @Override
    public CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_carousel, parent, false);

        return new CarouselAdapter.CarouselViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarouselViewHolder holder, int position) {
    //    holder.profile.setText(itemList.get(position).getEmail());
        holder.name.setText(itemList.get(position).getName().getFirst() + " "+itemList.get(position).getName().getLast());
        Glide.with(mContext)
                .load(itemList.get(position).getPicture().getMedium())
                .into(holder.profile);
        if(position == 0){
            holder.left.setVisibility(View.GONE);
        }else if(position == itemList.size() - 1){
            holder.right.setVisibility(View.GONE);
        }else {
            holder.left.setVisibility(View.VISIBLE);
            holder.right.setVisibility(View.VISIBLE);
        }
        holder.left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position>0)
                listener.scrollToPositon(position - 1);
            }
        });
        holder.right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position<itemList.size()-1)
                    listener.scrollToPositon(position + 1);

            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class CarouselViewHolder extends RecyclerView.ViewHolder {
        private ImageView profile;
        private ImageView left;
        private ImageView right;
        private TextView name;

        public CarouselViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.profile);
            left = itemView.findViewById(R.id.left);
            right = itemView.findViewById(R.id.right);
            name = itemView.findViewById(R.id.name);
        }
    }
    public interface  scrollToPosition{
        void  scrollToCarouselPositon(int position);
    }

}
