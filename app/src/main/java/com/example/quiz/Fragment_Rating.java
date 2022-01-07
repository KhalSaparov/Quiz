package com.example.quiz;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.quiz.entity.Question;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Rating extends Fragment {

    private Button backButton;
    private ArrayList<SaveUser> getSavedUser = new ArrayList<>();
    private RecyclerView userList;

    private DatabaseReference mDataBase;
    private String USER_KEY = "User";
    private UserAdapter userAdapter;
    private String TAG_USER = "Tag Users";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rating, container, false);
        init(v);
        userAdapter = new UserAdapter(this.getActivity(), getSavedUser);
        mDataBase = FirebaseDatabase.getInstance().getReference().child(USER_KEY);
        userList.setAdapter(userAdapter);
        getFromData();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).changeFragment(0);
            }
        });

        return v;
    }

    public void init(View v){
        backButton = v.findViewById(R.id.backButton);
        userList = v.findViewById(R.id.rv_rating);
        userList.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void getFromData(){
//        ValueEventListener valueEventListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(getSavedUser.size() > 0){
//                    getSavedUser.clear();
//                }
//                for (DataSnapshot ds : snapshot.getChildren()){
//                    SaveUser saveUser = ds.getValue(SaveUser.class);
//                    assert saveUser != null;
//                    getSavedUser.add(new SaveUser(saveUser.getUserName(), saveUser.getScore()));
//                }
//                userAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        };
//        mDataBase.addValueEventListener(valueEventListener);

//        Query query = mDataBase.orderByKey();
//        getSavedUser = new ArrayList<>();
//
//        ValueEventListener valueEventListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(getSavedUser.size() > 0){
//                    getSavedUser.clear();
//                }
//                for (DataSnapshot ds : snapshot.getChildren()){
//                    SaveUser saveUser = ds.getValue(SaveUser.class);
//                    assert saveUser != null;
//                    getSavedUser.add(new SaveUser(saveUser.getUserName(), saveUser.getScore()));
//                    Log.i(TAG_USER, "Tag users in for" + getSavedUser);
//                    userAdapter.notifyDataSetChanged();
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        };
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        query.addValueEventListener(valueEventListener);

        mDataBase.orderByChild(USER_KEY).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                SaveUser user = snapshot.getValue(SaveUser.class);
                getSavedUser.add(new SaveUser(user.getUserName(), user.getScore()));
                userAdapter.notifyDataSetChanged();
                Log.i(TAG_USER,"Users in onChildAdded" + getSavedUser);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

//    private class RatingHolder extends RecyclerView.ViewHolder {
//
//        private TextView mName;
//        private TextView mScore;
//        private SaveUser mSaveUser;
//
//        public RatingHolder(LayoutInflater inflater, ViewGroup parent) {
//            super(inflater.inflate(R.layout.rating_item, parent, false));
//
//            mName = itemView.findViewById(R.id.rating_item_name);
//            mScore = itemView.findViewById(R.id.rating_item_score);
//        }
//
//        public void bind(SaveUser saveUser) {
//            mSaveUser = saveUser;
//            mName.setText(mSaveUser.getUserName());
//            mScore.setText(mSaveUser.getScore());
//        }
//    }
//
//    private class RatingAdapter extends RecyclerView.Adapter<RatingHolder> {
//        private List<SaveUser> mUsers;
//        public RatingAdapter(List<SaveUser> users) {
//            mUsers = users;
//        }
//
//        @NonNull
//        @Override
//        public RatingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
//            return new RatingHolder(layoutInflater, parent);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull RatingHolder holder, int position) {
//            SaveUser saveUser = mUsers.get(position);
//            holder.bind(saveUser);
//        }
//
//        @Override
//        public int getItemCount() {
//            return mUsers.size();
//        }
//    }
}