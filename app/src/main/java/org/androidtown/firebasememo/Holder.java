package org.androidtown.firebasememo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;

public class Holder extends RecyclerView.ViewHolder {
  TextView tvKey;
  TextView tvMemo;
  public Holder(View view) {
    super(view);
    tvKey = view.findViewById(R.id.tv_key);
    tvMemo = view.findViewById(R.id.tv_memo);
  }
}
