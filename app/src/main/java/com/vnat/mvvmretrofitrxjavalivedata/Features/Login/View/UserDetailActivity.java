package com.vnat.mvvmretrofitrxjavalivedata.Features.Login.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.vnat.mvvmretrofitrxjavalivedata.Features.Login.Model.User;
import com.vnat.mvvmretrofitrxjavalivedata.Features.Login.ViewModel.UserViewModel;
import com.vnat.mvvmretrofitrxjavalivedata.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailActivity extends AppCompatActivity {
    @BindView(R.id.txtId)
    TextView txtId;
    @BindView(R.id.txtName)
    TextView txtName;

    UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        ButterKnife.bind(this);

        int id = (int) getIntent().getExtras().get("id");
        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        viewModel.init();

        viewModel.getUser(id);

        viewModel.getUserLiveData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                txtId.setText(user.getId()+"");
                txtName.setText(user.getName());
            }
        });

    }
}