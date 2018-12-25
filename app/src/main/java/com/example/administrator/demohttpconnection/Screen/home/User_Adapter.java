package com.example.administrator.demohttpconnection.Screen.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.administrator.demohttpconnection.R;
import java.util.ArrayList;

public class User_Adapter extends RecyclerView.Adapter<User_Adapter.ViewHolder> {
    private ArrayList<UsersGitHub> mListUser = new ArrayList<>();
    private Context mContext;

    public User_Adapter(Context context, ArrayList<UsersGitHub> arrUser) {
        mContext = context;
        mListUser = arrUser;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return mListUser.size();
    }

    public void updateData(ArrayList<UsersGitHub> usersList) {
        // Clear the list of previous user GitHub data, then add them to the
        mListUser.clear();
        mListUser.addAll(usersList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextViewId, mTextViewUserName, mTextViewDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextViewId = itemView.findViewById(R.id.text_id);
            mTextViewUserName = itemView.findViewById(R.id.text_name);
            mTextViewDescription = itemView.findViewById(R.id.text_descrip);
        }

        public void setData(int position) {
            UsersGitHub user = mListUser.get(position);
            mTextViewId.setText(String.valueOf(user.getID()));
            mTextViewUserName.setText(user.getName());
            mTextViewDescription.setText(user.getDescription());
        }
    }
}
