package com.vnat.mvvmretrofitrxjavalivedata.Features.Login.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vnat.mvvmretrofitrxjavalivedata.Features.Login.Model.User;
import com.vnat.mvvmretrofitrxjavalivedata.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    List<User> userArrayList;

    public UserAdapter(List<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_user, parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UserViewHolder holder, final int position) {
        User user = userArrayList.get(position);
        holder.txtName.setText(user.getName());
        holder.txtEmail.setText(user.getEmail());

    }

    @Override
    public int getItemCount() {
        return userArrayList == null ? 0 : userArrayList.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtName)
        TextView txtName;

        @BindView(R.id.txtEmail)
        TextView txtEmail;


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}
