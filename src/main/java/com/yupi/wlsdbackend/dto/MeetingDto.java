package com.yupi.wlsdbackend.dto;

import com.yupi.wlsdbackend.domain.Meeting;

public class MeetingDto {
    private Meeting meeting;
    private boolean isSubscribed;
    private boolean isThumbed;
    private long thumbCount;

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

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
}