package com.arons.mvp.ui.main;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;

public class FindItemsInteractor {

    interface OnFinishedListener {
        void onFinished(List<String> items);
    }

    public void findItems(final OnFinishedListener listener) {
        new Handler().postDelayed(() -> listener.onFinished(createArrayList()), 2000);
    }

    public List<String> createArrayList() {
        return Arrays.asList(
                "张无忌",
                "张三丰",
                "张松溪",
                "张翠山",
                "宋远桥",
                "俞莲舟",
                "俞岱岩",
                "殷梨亭",
                "莫声谷",
                "宋青书"
        );
    }


}
