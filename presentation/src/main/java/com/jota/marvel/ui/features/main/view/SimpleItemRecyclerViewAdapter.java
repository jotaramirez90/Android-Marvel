package com.jota.marvel.ui.features.main.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jota.marvel.R;
import com.jota.marvel.model.DummyContent;
import java.util.List;

public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

  private final List<DummyContent.DummyItem> mValues;

  public SimpleItemRecyclerViewAdapter(List<DummyContent.DummyItem> items) {
    mValues = items;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.mItem = mValues.get(position);
    holder.mIdView.setText(mValues.get(position).id);
    holder.mContentView.setText(mValues.get(position).content);

    holder.mView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //if (mTwoPane) {
        //  Bundle arguments = new Bundle();
        //  arguments.putString(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
        //  ItemDetailFragment fragment = new ItemDetailFragment();
        //  fragment.setArguments(arguments);
        //  getSupportFragmentManager().beginTransaction()
        //      .replace(R.id.item_detail_container, fragment)
        //      .commit();
        //} else {
        //  Context context = v.getContext();
        //  Intent intent = new Intent(context, ItemDetailActivity.class);
        //  intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
        //
        //  context.startActivity(intent);
        //}
      }
    });
  }

  @Override public int getItemCount() {
    return mValues.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final TextView mIdView;
    public final TextView mContentView;
    public DummyContent.DummyItem mItem;

    public ViewHolder(View view) {
      super(view);
      mView = view;
      mIdView = (TextView) view.findViewById(R.id.id);
      mContentView = (TextView) view.findViewById(R.id.content);
    }

    @Override public String toString() {
      return super.toString() + " '" + mContentView.getText() + "'";
    }
  }
}
