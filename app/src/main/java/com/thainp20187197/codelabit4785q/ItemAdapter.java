package com.thainp20187197.codelabit4785q;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    List<ItemModel> items;

    public ItemAdapter(List<ItemModel> items) {
        this.items = items;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, null);

        ImageView imageAvatar = itemView.findViewById(R.id.image_avatar);
        TextView textTitle = itemView.findViewById(R.id.text_title);
        TextView textDescription = itemView.findViewById(R.id.text_description);
        ImageButton imageFavorite = itemView.findViewById(R.id.image_favorite);

        ItemModel item = items.get(position);

        imageAvatar.setImageResource(item.getImageAvatar());
        textTitle.setText(item.getTitle());
        textDescription.setText((item.getDescription()));
        if (item.isFavorite()) {
            imageFavorite.setImageResource(R.drawable.ic_baseline_star_24);
        } else {
            imageFavorite.setImageResource(R.drawable.ic_baseline_star_border_24);
        }

        imageFavorite.setOnClickListener(v -> {
            item.setFavorite(!item.isFavorite());
            notifyDataSetChanged();
        });

        return itemView;
    }
}
