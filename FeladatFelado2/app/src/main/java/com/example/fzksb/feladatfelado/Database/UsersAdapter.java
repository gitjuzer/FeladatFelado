package com.example.fzksb.feladatfelado.Database;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.fzksb.feladatfelado.R;
import com.example.fzksb.feladatfelado.Database.User;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private Context context;
    private List<User> usersList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView user;

        public MyViewHolder(View view) {
            super(view);
            user = view.findViewById(R.id.user);
        }
    }


    public UsersAdapter(Context context, List<User> notesList) {
        this.context = context;
        this.usersList = notesList;
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
