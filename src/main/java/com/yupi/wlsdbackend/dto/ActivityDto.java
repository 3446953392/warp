package com.yupi.wlsdbackend.dto;

import com.yupi.wlsdbackend.domain.Activity;

public class ActivityDto {
    private Activity activity;
    private boolean isSubscribed;
    private boolean isThumbed;
    private long thumbCount;


    public boolean isSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(boolean subscribed) {
        isSubscribed = subscribed;
    }

    public boolean isThumbed() {
        return isThumbed;
    }

    public void setThumbed(boolean thumbed) {
        isThumbed = thumbed;
    }

    public long getThumbCount() {
        return thumbCount;
    }

    public void setThumbCount(long thumbCount) {
        this.thumbCount = thumbCount;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}