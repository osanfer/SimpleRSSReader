package com.examples.osanfer.simplerssreader.rsslist;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.examples.osanfer.simplerssreader.R;

public class RSSItemViewHolder extends RecyclerView.ViewHolder implements RecyclerView.OnClickListener {
    private TextView txtTitle;
    private TextView txtDescription;
    private ImageView imgEnclosure;
    private RSSListPresenter presenter;
    private ConstraintLayout constraintLayoutContainer;

    public RSSItemViewHolder(RSSListPresenter presenter, @NonNull View itemView) {
        super(itemView);
        this.presenter = presenter;
        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtDescription = itemView.findViewById(R.id.txtDescription);
        imgEnclosure = itemView.findViewById(R.id.imgEnclosure);
        constraintLayoutContainer = itemView.findViewById(R.id.RSSItemLayout);
        itemView.setOnClickListener(this);
    }

    public TextView getTxtTitle() {
        return txtTitle;
    }

    public TextView getTxtDescription() {
        return txtDescription;
    }

    public ImageView getImgEnclosure() {
        return imgEnclosure;
    }

    @Override
    public void onClick(View v) {
        presenter.onItemClick(getAdapterPosition());
    }
}