package com.bill.mygitosc.ui.fragment;

import android.os.Bundle;

import com.bill.mygitosc.adapter.BaseStateRecyclerAdapter;
import com.bill.mygitosc.adapter.EventAdapter;
import com.bill.mygitosc.bean.Event;
import com.bill.mygitosc.common.AppContext;
import com.bill.mygitosc.common.HttpUtils;
import com.bill.mygitosc.ui.base.BaseSwipeRefreshFragment;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by liaobb on 2015/7/27.
 */
public class EventsRefreshFragment extends BaseSwipeRefreshFragment<Event> {
    private static String UserID = "user_id";
    private int userID;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userID = getArguments().getInt(UserID);
        }
    }

    @Override
    protected boolean itemCompareTo(List<Event> list, Event item) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (item.getId() == list.get(i).getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected String getItemType() {
        return "event";
    }

    @Override
    protected Type getGsonArrayType() {
        return new TypeToken<List<Event>>() {
        }.getType();
    }


    public static EventsRefreshFragment newInstance(int userID) {
        EventsRefreshFragment fragment = new EventsRefreshFragment();
        Bundle args = new Bundle();
        args.putInt(UserID, userID);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected String getCacheKey() {
        return "event_self_" + userID + "_";
    }

    @Override
    protected String getItemURL(int page) {
        if (AppContext.getInstance().getSession() != null && userID == AppContext.getInstance().getSession().getId()) {
            return HttpUtils.getMySelfEventURL(page);
        }
        return HttpUtils.getSelfEventURL(userID, page);
    }


    @Override
    protected BaseStateRecyclerAdapter getRecyclerAdapter() {
        return new EventAdapter(getActivity());
    }

}
