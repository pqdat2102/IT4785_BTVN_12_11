// Generated by view binder compiler. Do not edit!
package vn.edu.hust.studentman.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import vn.edu.hust.studentman.R;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnAddNew;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final RecyclerView recyclerViewStudents;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnAddNew,
      @NonNull ConstraintLayout main, @NonNull RecyclerView recyclerViewStudents) {
    this.rootView = rootView;
    this.btnAddNew = btnAddNew;
    this.main = main;
    this.recyclerViewStudents = recyclerViewStudents;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_add_new;
      Button btnAddNew = ViewBindings.findChildViewById(rootView, id);
      if (btnAddNew == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.recycler_view_students;
      RecyclerView recyclerViewStudents = ViewBindings.findChildViewById(rootView, id);
      if (recyclerViewStudents == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, btnAddNew, main,
          recyclerViewStudents);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
