package com.example.administrator.demohttpconnection.Screen.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.administrator.demohttpconnection.R;
import com.example.administrator.demohttpconnection.Screen.User_AsyncTask;
import com.example.administrator.demohttpconnection.utils.OnFetchData;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnFetchData {
    public static final String LOG_TAG = MainActivity.class.getName();
    private ArrayList<UsersGitHub> mListUser = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private User_Adapter mUserAdapter;
    private static final String REQUEST_URL = "https://api.github.com/users/google/repos";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayRecyclerView();

        //
        User_AsyncTask task = new User_AsyncTask(this);
        task.execute(REQUEST_URL);
    }
    private void displayRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mUserAdapter = new User_Adapter(this, mListUser);

        mRecyclerView.setAdapter(mUserAdapter);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(mRecyclerView.getContext(),
                        linearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
    }
    @Override
    public void OnFetchDataSuccess(ArrayList<UsersGitHub> listUser) {

    }
}
