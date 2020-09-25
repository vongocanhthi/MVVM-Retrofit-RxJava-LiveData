package com.vnat.mvvmretrofitrxjavalivedata.Helper;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.vnat.mvvmretrofitrxjavalivedata.Features.Login.Model.User;

import java.util.List;

public class UserDiffUtil extends DiffUtil.Callback {
    private List<User> oldList;
    private List<User> newList;

    public UserDiffUtil(List<User> oldList, List<User> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList == null ? 0 : oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList == null ? 0 : newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldItemPosition == newItemPosition;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition) == newList.get(newItemPosition);
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}