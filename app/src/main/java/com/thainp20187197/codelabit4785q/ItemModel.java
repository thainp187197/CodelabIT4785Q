package com.thainp20187197.codelabit4785q;

public class ItemModel {
    private String title;
    private String description;
    private int imageAvatar = R.drawable.ic_launcher_foreground;
    private boolean favorite = false;

    public ItemModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageAvatar() {
        return imageAvatar;
    }

    public void setImageAvatar(int imageAvatar) {
        this.imageAvatar = imageAvatar;
    }

    public void setFavorite(boolean favorite) { this.favorite = favorite; }

    public boolean isFavorite() { return favorite; }
}
