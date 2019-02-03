package com.examples.osanfer.simplerssreader.rsslist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.examples.osanfer.simplerssreader.R;
import com.examples.osanfer.simplerssreader.pojo.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RSSItemAdapter extends RecyclerView.Adapter<RSSItemViewHolder> {
    private List<Item> data;
    private RSSListPresenter presenter;

    public RSSItemAdapter(RSSListPresenter presenter) {
        this.presenter = presenter;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public RSSItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RSSItemViewHolder(this.presenter, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rss_list_recycler_row_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RSSItemViewHolder rssItemViewHolder, int i) {
        rssItemViewHolder.getTxtTitle().setText(data.get(i).getTitle());
        rssItemViewHolder.getTxtDescription().setText(data.get(i).getDescription());
        if (data.get(i).getEnclosure().getType().startsWith("image")) {
            Picasso.get().load(data.get(i).getEnclosure().getUrl()).into(rssItemViewHolder.getImgEnclosure());
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public Item getItemAtPosition(int position) {
        return this.data.get(position);
    }

    public void setData(List<Item> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
