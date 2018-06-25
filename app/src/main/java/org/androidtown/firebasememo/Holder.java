package org.androidtown.firebasememo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Holder extends RecyclerView.ViewHolder {
  @BindView(R.id.tv_key)
  TextView tvKey;
  @BindView(R.id.tv_memo)
  TextView tvMemo;
  public Holder(View view) {
    super(view); // TODO: 반드시 필요한 요소인지 확인
    ButterKnife.bind(view);
  }
}
