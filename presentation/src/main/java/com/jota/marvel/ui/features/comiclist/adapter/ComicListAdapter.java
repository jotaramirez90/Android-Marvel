package com.jota.marvel.ui.features.comiclist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jota.marvel.R;
import com.jota.marvel.model.ComicModel;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class ComicListAdapter extends RecyclerView.Adapter<ComicListAdapter.ComicViewHolder> {

  private ComicItemListener mComicItemListener;
  private List<ComicModel> mComicModelList;

  public ComicListAdapter() {
    mComicModelList = new ArrayList<>();
  }

  @Override public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comic, parent, false);
    return new ComicViewHolder(view, mComicItemListener);
  }

  @Override public void onBindViewHolder(ComicViewHolder holder, int position) {
    final ComicModel recipient = mComicModelList.get(position);
    holder.itemView.setTag(position);
    holder.title.setText(recipient.getTitle());
    Picasso.with(holder.itemView.getContext())
        .load(recipient.getThumbnailUrl())
        .into(holder.thumbnail);
  }

  @Override public int getItemCount() {
    return mComicModelList.size();
  }

  public void setComicItemListener(ComicItemListener mComicItemListener) {
    this.mComicItemListener = mComicItemListener;
  }

  public void addComics(List<ComicModel> comicModelList) {
    this.mComicModelList = comicModelList;
    notifyDataSetChanged();
  }

  public class ComicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.thumbnailComic) ImageView thumbnail;
    @BindView(R.id.titleComic) TextView title;

    private ComicItemListener listener;

    public ComicViewHolder(View itemView, ComicItemListener listener) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      this.listener = listener;
      itemView.setOnClickListener(this);
    }

    @Override public void onClick(View view) {
      int position = getAdapterPosition();
      if (position >= 0) {
        ComicModel comicModel = mComicModelList.get(position);
        listener.onItemClick(comicModel);
      }
    }
  }
}
