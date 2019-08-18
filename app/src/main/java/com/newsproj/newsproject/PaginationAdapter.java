package com.newsproj.newsproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.newsproj.newsproject.Model.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by delaroy on 12/5/17.
 */

public class PaginationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM = 0;
    private static final int LOADING = 1;
    private List<News> newsdata = new ArrayList<>();
    private Context context;
    private boolean isLoadingAdded = false;

    public PaginationAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;

        switch (viewType) {
            case ITEM:
                View v1 = LayoutInflater.from(context).inflate(R.layout.newslist, parent, false);
                viewHolder = new DataViewHolder(v1);
                break;
            case LOADING:
                View v2 = LayoutInflater.from(context).inflate(R.layout.row_progress, parent, false);
                viewHolder = new LoadingViewHolder(v2);
                break;
        }
        return viewHolder;

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        News news= newsdata.get(position);

        switch (getItemViewType(position)) {
            case ITEM:
                final DataViewHolder dataVH = (DataViewHolder) holder;
                try {

                    dataVH.txtTitle.setText(news.getTitle());
                    dataVH.pub.setText("published At : " +news.getPubAt());
                    dataVH.uname.setText("Posted By : " + news.getUserName());

                    dataVH.shdesc.setText(news.getShortdesc());
                    dataVH.desc.setText(news.getDecription());
//        Picasso.with(ctx).load(dataValue.getImage()).into(newsHolder.imgIcon);

                } catch (Exception e) {
                }
                break;

            case LOADING:
//                Do nothing
                break;
        }

    }

    @Override
    public int getItemCount() {
        return newsdata == null ? 0 : newsdata.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == newsdata.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }

    /*
   Helpers
   _________________________________________________________________________________________________
    */

    public void add(News r) {
        newsdata.add(r);
        notifyItemInserted(newsdata.size() - 1);
    }

    public void addAll(List<News> newsResult) {
        for (News result : newsResult) {
            add(result);
        }
    }


    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new News());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = newsdata.size() - 1;
        News result = getItem(position);

        if (result != null) {
            newsdata.remove(position);
            notifyItemRemoved(position);
        }
    }

    public News getItem(int position) {
        return newsdata.get(position);
    }

   /*
   View Holders
   _________________________________________________________________________________________________
    */

    /**
     * Main list's content ViewHolder
     */
    protected class DataViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgIcon;
        private TextView txtTitle,pub,desc,uname,shdesc;

        public DataViewHolder(View itemView) {
            super(itemView);
            imgIcon= itemView.findViewById(R.id.imgIcon);
            txtTitle=itemView.findViewById(R.id.txtTitle);
            pub= itemView.findViewById(R.id.pubAt);
            uname= itemView.findViewById(R.id.uname);
            shdesc=itemView.findViewById(R.id.shdesc);
            desc= new TextView(context);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // passing data from one activity to another throug intent
                    // key value must be same in next activity to get data

                    Intent intent= new Intent(context,NewsDetails.class);
                    intent.putExtra("desc",desc.getText().toString()); // here key  is = desc
                    intent.putExtra("pubdate",pub.getText().toString());  //key is = pubdate  ,, nd in next activity key must be same
                    intent.putExtra("title",txtTitle.getText().toString());
                    intent.putExtra("shdesc",shdesc.getText().toString());
                    intent.putExtra("postedby",uname.getText().toString());
                    context.startActivity(intent);
                }
            });
        }
    }

    protected class LoadingViewHolder extends RecyclerView.ViewHolder {

        public LoadingViewHolder(View itemView) {
            super(itemView);
        }
    }


}