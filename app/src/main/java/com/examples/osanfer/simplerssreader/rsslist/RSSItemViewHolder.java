package com.examples.osanfer.simplerssreader.rsslist;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.examples.osanfer.simplerssreader.R;

public class RSSItemViewHolder extends RecyclerView.ViewHolder {
    private TextView txtTitle;
    private TextView txtDescription;
    private ImageView imgEnclosure;
    private ConstraintLayout constraintLayoutContainer;

    public RSSItemViewHolder(@NonNull View itemView) {
        super(itemView);

        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtDescription = itemView.findViewById(R.id.txtDescription);
        imgEnclosure = itemView.findViewById(R.id.imgEnclosure);
        constraintLayoutContainer = itemView.findViewById(R.id.RSSItemLayout);

        constraintLayoutContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                clickListener.launchIntent(data.get(getAdapterPosition()).name);
            }
        });
    }

    public TextView getTxtTitle() {
        return txtTitle;
    }

    public void setTxtTitle(TextView txtTitle) {
        this.txtTitle = txtTitle;
    }

    public TextView getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(TextView txtDescription) {
        this.txtDescription = txtDescription;
    }

    public ImageView getImgEnclosure() {
        return imgEnclosure;
    }

    public void setImgEnclosure(ImageView imgEnclosure) {
        this.imgEnclosure = imgEnclosure;
    }

    public ConstraintLayout getConstraintLayoutContainer() {
        return constraintLayoutContainer;
    }

    public void setConstraintLayoutContainer(ConstraintLayout constraintLayoutContainer) {
        this.constraintLayoutContainer = constraintLayoutContainer;
    }
}