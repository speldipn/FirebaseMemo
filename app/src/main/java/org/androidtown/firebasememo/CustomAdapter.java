package org.androidtown.firebasememo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<Holder>{
  List<Memo> list;

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
    return new Holder(v);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    Memo m = list.get(position);
    if(m != null) {
      holder.tvKey.setText(m.key);
      holder.tvMemo.setText(m.memo);
    }
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  public void setDataAndRefresh(List list) {
    this.list = list;
    notifyDataSetChanged();
  }
}
