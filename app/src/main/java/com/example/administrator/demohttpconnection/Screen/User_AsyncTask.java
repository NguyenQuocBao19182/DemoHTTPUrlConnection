package com.example.administrator.demohttpconnection.Screen;

import android.os.AsyncTask;
import com.example.administrator.demohttpconnection.Screen.home.UsersGitHub;
import com.example.administrator.demohttpconnection.utils.OnFetchData;
import com.example.administrator.demohttpconnection.utils.QueryUtils;
import java.util.ArrayList;

public class User_AsyncTask extends AsyncTask<String, Void, ArrayList<UsersGitHub>> {
    private ArrayList<UsersGitHub> mListUser = new ArrayList<>();
    private OnFetchData mOnFetchData = null;

    public User_AsyncTask(OnFetchData onFetchData) {
        mOnFetchData = onFetchData;
    }

    @Override
    protected ArrayList<UsersGitHub> doInBackground(String... urls) {
        // Don't perform the request if there are no URLs, or the first URL is null.
        if (urls.length < 1 || urls[0] == null) {
            return null;
        }

        mListUser = QueryUtils.fetchUserGitHub(urls[0]);
        return mListUser;
    }

    @Override
    protected void onPostExecute(ArrayList<UsersGitHub> usersGitHubs) {
        super.onPostExecute(usersGitHubs);
        mOnFetchData.OnFetchDataSuccess(usersGitHubs);
    }
}
