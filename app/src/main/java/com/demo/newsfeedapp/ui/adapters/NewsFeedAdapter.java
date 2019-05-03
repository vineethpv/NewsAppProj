package com.demo.newsfeedapp.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.newsfeedapp.R;
import com.demo.newsfeedapp.data.models.Result;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.ViewHolder> {
    private List<Result> mResultsList;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Result item);
    }

    public NewsFeedAdapter(List<Result> results, OnItemClickListener listener) {
        this.mResultsList = results;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_feed, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mResultsList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mResultsList != null) {
            return mResultsList.size();
        }
        return 0;
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtTitle, txtAuthor, txtDate;
        Result mResult;

        ViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
            txtDate = itemView.findViewById(R.id.txtDate);
        }

        public void bind(Result result) {
            this.mResult = result;
            txtTitle.setText(result.getTitle());
            txtAuthor.setText(result.getByline());
            txtDate.setText(result.getPublishedDate());

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(mResult);
        }
    }
}
