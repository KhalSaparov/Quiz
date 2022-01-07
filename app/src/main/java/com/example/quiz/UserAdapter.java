package com.example.quiz;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final ArrayList<SaveUser> userInf;

    UserAdapter(Context context, ArrayList<SaveUser> userInf) {
        this.userInf = userInf;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rating_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SaveUser saveUser = userInf.get(position);
        holder.userName.setText(saveUser.getUserName());
        holder.userRating.setText(saveUser.getScore());
    }

    @Override
    public int getItemCount() {
        return userInf == null ? 0 : userInf.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView userRating;
        final TextView userName;

        public ViewHolder(View view) {
            super(view);
            userName = view.findViewById(R.id.rating_item_name);
            userRating = view.findViewById(R.id.rating_item_score);
        }
    }
}