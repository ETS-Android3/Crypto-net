package com.moringaschool.cryptonet;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CryptosInfoArrayAdapter extends ArrayAdapter {
    Context context;
    String[] mCuisines;
    public CryptosInfoArrayAdapter( Context context, int resource, String[] mCuisines) {
        super(context, resource);
        this.context = context;
        this.mCuisines = mCuisines;
    }

    @Override
    public Object getItem(int position) {
        String cuisine = mCuisines[position];
        return  cuisine;
    }

    @Override
    public int getCount() {
        return mCuisines.length;
    }
}
