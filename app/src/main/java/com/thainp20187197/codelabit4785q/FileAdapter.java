package com.thainp20187197.codelabit4785q;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileAdapter extends BaseAdapter {
    private List<File> files = new ArrayList<>();

    public void newList(List<File> files) {
        this.files.clear();
        this.files.add(null);
        this.files.addAll(files);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return files.size();
    }

    @Override
    public Object getItem(int position) {
        return files.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewUser;
        if (convertView == null)
            viewUser = View.inflate(parent.getContext(), R.layout.file_list_view, null);
        else
            viewUser = convertView;

        ImageView fileTypeIV = (ImageView) viewUser.findViewById(R.id.fileTypeImageView);
        TextView fileNameTV = (TextView) viewUser.findViewById(R.id.fileNameTextView);
        if (position == 0) {
            fileTypeIV.setImageResource(R.drawable.ic_baseline_parent_folder_24);
            fileNameTV.setText("..");
        } else {
            File file = (File) getItem(position);
            String fileName = file.getName();

            if (file.isFile()) {
                if (fileName.contains(".txt"))
                    fileTypeIV.setImageResource(R.drawable.ic_baseline_file_text_24);
                else
                    fileTypeIV.setImageResource(R.drawable.ic_baseline_file_24);
            }
            else {
                fileTypeIV.setImageResource(R.drawable.ic_baseline_folder_24);
            }

            fileNameTV.setText(fileName);
        }

        return viewUser;
    }
}
