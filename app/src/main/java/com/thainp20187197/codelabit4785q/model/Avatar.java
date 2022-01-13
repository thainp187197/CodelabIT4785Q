package com.thainp20187197.codelabit4785q.model;

import java.io.Serializable;

public class Avatar implements Serializable {
    private final String thumbnailUrl;
    private final String photoUrl;

    public Avatar(String thumbnailUrl, String photoUrl){
        this.thumbnailUrl = thumbnailUrl;
        this.photoUrl = photoUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
