package com.jota.marvel.ui.features.comicdetails.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.jota.marvel.R;
import com.jota.marvel.app.BaseFragment;
import com.jota.marvel.app.MainApplication;
import com.jota.marvel.app.di.component.ViewComponent;
import com.jota.marvel.app.di.component.application.ApplicationComponent;
import com.jota.marvel.app.di.provider.ComponentProvider;
import com.jota.marvel.model.ComicModel;
import com.jota.marvel.ui.BasePresenter;
import com.jota.marvel.ui.features.comicdetails.presenter.ComicDetailsPresenter;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;

public class ComicDetailFragment extends BaseFragment {

  private static final String ARG_COMIC = "comicArg";

  @Inject ComicDetailsPresenter mComicDetailsPresenter;

  @BindView(R.id.comicImage) ImageView mComicImage;
  @BindView(R.id.titleText) TextView mComicTitle;
  @BindView(R.id.descriptionText) TextView mComicDescription;

  public static ComicDetailFragment newInstance(ComicModel comicModel) {
    ComicDetailFragment comicDetailFragment = new ComicDetailFragment();
    Bundle args = new Bundle();
    args.putParcelable(ARG_COMIC, comicModel);
    comicDetailFragment.setArguments(args);
    return comicDetailFragment;
  }

  @Override public ViewComponent bindViewComponent() {
    ApplicationComponent applicationComponent =
        ((MainApplication) getActivity().getApplication()).getApplicationComponent();
    return ComponentProvider.getComicDetailsComponent(applicationComponent);
  }

  @Override public BasePresenter bindPresenter() {
    return mComicDetailsPresenter;
  }

  @Override public int bindLayout() {
    return R.layout.fragment_comic_details;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initComicList();
  }

  private void initComicList() {
    ComicModel comicModel = getArguments().getParcelable(ARG_COMIC);
    if (comicModel != null) {
      if (comicModel.getThumbnailUrl() != null) {
        Picasso.with(getContext()).load(comicModel.getThumbnailUrl()).into(mComicImage);
      }
      mComicTitle.setText(comicModel.getTitle());
      mComicDescription.setText(comicModel.getDescription());
    }
  }
}
