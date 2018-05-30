package com.example.fzksb.feladatfelado.Controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.example.fzksb.feladatfelado.Model.User;
import com.example.fzksb.feladatfelado.R;

public class UsersConstroller extends RecyclerView.Adapter<UsersConstroller.MyViewHolder> {

    private Context context;
    private List<User> usersList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView user;

        public MyViewHolder(View view) {
            super(view);
            user = view.findViewById(R.id.user);
        }
    }

    public UsersConstroller(Context context) {
        this.context = context;

        this.usersList = usersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        User user = usersList.get(position);

        holder.user.setText(user.getUsername());
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
