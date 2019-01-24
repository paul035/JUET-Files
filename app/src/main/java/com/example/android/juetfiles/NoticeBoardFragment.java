package com.example.android.juetfiles;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoticeBoardFragment extends Fragment {

    private ImageView mNoticeimg;
    private TextView mNoticedeatil, mNoticedate, mNoticevenu;
    private Uri imageUri;

    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;

    public static final String FB_STORAGE_PAHT = "image/";
    public static final String FB_DATABASE_PATH = "image";


    public NoticeBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice_board, container, false);
/*
       mStorageRef = FirebaseStorage.getInstance().getReference();
       mDatabaseRef = FirebaseDatabase.getInstance().getReference(FB_DATABASE_PATH);

        mNoticeimg = view.findViewById(R.id.noticeimg);
        mNoticedeatil = view.findViewById(R.id.noticedetail);
        mNoticedate = view.findViewById(R.id.noticedate);
        mNoticevenu = view.findViewById(R.id.noticevenu);

        StorageReference ref = mStorageRef.child(FB_STORAGE_PAHT + System.currentTimeMillis());*/

        return view;
    }

}
