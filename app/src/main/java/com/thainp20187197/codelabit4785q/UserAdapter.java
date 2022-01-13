package com.thainp20187197.codelabit4785q;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.thainp20187197.codelabit4785q.model.User;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private final ArrayList<User> users;

    public UserAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return users.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewUser;
        if (convertView == null)
        {
            viewUser = View.inflate(parent.getContext(), R.layout.user_basic_view, null);
        } else viewUser = convertView;

        User user = (User) getItem(position);
        ImageView thumbnailImageView = (ImageView) viewUser.findViewById(R.id.userBasicThumbnail);
        Picasso.get().load(user.getAvatar().getThumbnailUrl()).into(thumbnailImageView);
        ((TextView) viewUser.findViewById(R.id.userBasicUsername)).setText(user.getUsername());
        ((TextView) viewUser.findViewById(R.id.userBasicEmail)).setText(user.getEmail());
        return viewUser;
    }
}
