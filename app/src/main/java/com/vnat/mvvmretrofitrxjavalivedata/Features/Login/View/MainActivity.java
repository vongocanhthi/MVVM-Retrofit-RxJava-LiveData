package com.vnat.mvvmretrofitrxjavalivedata.Features.Login.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vnat.mvvmretrofitrxjavalivedata.Features.Login.Model.User;
import com.vnat.mvvmretrofitrxjavalivedata.Features.Login.adapter.UserAdapter;
import com.vnat.mvvmretrofitrxjavalivedata.Features.Login.ViewModel.UserViewModel;
import com.vnat.mvvmretrofitrxjavalivedata.Helper.RecyclerViewItemClickListener;
import com.vnat.mvvmretrofitrxjavalivedata.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rcvUser)
    RecyclerView rcvUser;

    @BindView(R.id.edtSearch)
    EditText edtSearch;

    @BindView(R.id.btnSearch)
    Button btnSearch;

    @BindView(R.id.txtSearch)
    TextView txtSearch;

    UserViewModel viewModel;
    UserAdapter userAdapter;

    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
//        viewModel.init();

        funGetUserList();
        funClickRecyclerView();
        funGetUser();
    }

    private void funGetUser() {
        viewModel.getNameLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String name) {
                txtSearch.setText(name);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = Integer.parseInt(edtSearch.getText().toString());
                viewModel.getUser(id );
            }
        });

    }

    private void funClickRecyclerView() {
        rcvUser.addOnItemTouchListener(new RecyclerViewItemClickListener(this, rcvUser, new RecyclerViewItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, ""+ (position + 1), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), UserDetailActivity.class);
                intent.putExtra("id", position + 1);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

    }


    private void funGetUserList() {
        rcvUser.setHasFixedSize(true);
        rcvUser.setLayoutManager(new LinearLayoutManager(this));

        viewModel.getUserList();

        viewModel.getUserListLiveData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                userAdapter = new UserAdapter(users);
                rcvUser.setAdapter(userAdapter);
                userAdapter.notifyDataSetChanged();
            }
        });
    }


}