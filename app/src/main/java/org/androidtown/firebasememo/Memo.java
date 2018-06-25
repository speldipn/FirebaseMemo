package org.androidtown.firebasememo;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Memo {

  public String key;
  public String memo;

  public Memo() {
    // Default constructor required for calls to DataSnapshot.getValue(User.class)
  }

  public Memo(String key, String memo) {
    this.key = key;
    this.memo = memo;
  }

} // end of class
