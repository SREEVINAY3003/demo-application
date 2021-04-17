package com.sample.demoapplication.model;

public class TallyUserIds {
    int userIds;
    int count;

    public TallyUserIds(){

    }
    public TallyUserIds(int userIds, int count) {
        this.userIds = userIds;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUserIds() {
        return userIds;
    }

    public void setUserIds(int userIds) {
        this.userIds = userIds;
    }
}
