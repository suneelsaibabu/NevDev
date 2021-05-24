package com.navdeventerprise.nevdev.data.strategy;

public interface DirtyStateIdentifiable {
    boolean isDirty();

    void setDirty(boolean dirty);
}
