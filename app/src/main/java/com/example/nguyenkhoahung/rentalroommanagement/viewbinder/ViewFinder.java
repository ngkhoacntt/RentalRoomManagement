package com.example.nguyenkhoahung.rentalroommanagement.viewbinder;

import android.app.Activity;
import android.view.View;

public abstract class ViewFinder {
    abstract View findViewById(int id);

    public static class ByView extends ViewFinder {
        View root;

        public ByView(View root) {this.root = root;}

        @Override
        View findViewById(int id) {
            return root.findViewById(id);
        }
    }

    public static class ByActivity extends ViewFinder{
        Activity activity;

        public ByActivity(Activity activity){
            this.activity = activity;
        }

        @Override
        View findViewById(int id) {
            return activity.findViewById(id);
        }
    }
}
