package org.androidtown.firebasememo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

  public final String TAG_NAME = "speldipn";
  private final String REFNAME_MEMO = "memo";

  FirebaseDatabase database;
  DatabaseReference memoRef;

  @BindView(R.id.et_memo)
  EditText etMemo;
  @BindView(R.id.recyclerView)
  RecyclerView recyclerView;

  CustomAdapter customAdapter;
  List<Memo> list = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);
    initDB();
    setAdpater();
    setEvent();
  }

  private void setAdpater() {
    customAdapter = new CustomAdapter();
    customAdapter.setDataAndRefresh(list);
    recyclerView.setAdapter(customAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
  }

  private void initDB() {
    database = FirebaseDatabase.getInstance();
    memoRef = database.getReference(REFNAME_MEMO);
  }

  private void setEvent() {
    memoRef.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {
        list.clear();
        for(DataSnapshot dss: dataSnapshot.getChildren()) {
          Memo m = dss.getValue(Memo.class);
          list.add(m);
        }
        customAdapter.setDataAndRefresh(list);
      }

      @Override
      public void onCancelled(DatabaseError databaseError) {
        Log.d(TAG_NAME, "onCancelled 호출됨 " + databaseError.getMessage());
      }
    });
  }

  public void addMemo(View v) {
    String key = memoRef.push().getKey();
    String memo = etMemo.getText().toString();

    Memo m = new Memo(key, memo);
    memoRef.child(key).setValue(m);
    memoRef.push();
  }
} // end of class
