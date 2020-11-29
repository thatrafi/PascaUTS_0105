package com.example.pascauts_0105;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemClickSupport {
    private final RecyclerView mRecyclerview;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(onItemClickListener !=null){
                RecyclerView.ViewHolder holder = mRecyclerview.getChildViewHolder(v);
                onItemClickListener.onItemClicked(mRecyclerview,holder.getAdapterPosition(),v);

            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            if(mOnItemLongClickListener != null){
                RecyclerView.ViewHolder holder = mRecyclerview.getChildViewHolder(v);
                return mOnItemLongClickListener.onItemLongClicked(mRecyclerview,holder.getAdapterPosition(),v);
            }
            return false;
        }
    };
    private RecyclerView.OnChildAttachStateChangeListener onChildAttachStateChangeListener = new RecyclerView.OnChildAttachStateChangeListener(){
        @Override
        public void onChildViewAttachedToWindow(@NonNull View view) {
            if(onItemClickListener !=null){
                view.setOnClickListener(mOnClickListener);
            }
            if(mOnItemLongClickListener!=null){
                view.setOnLongClickListener(mOnLongClickListener);
            }
        }

        @Override
        public void onChildViewDetachedFromWindow(@NonNull View view) {

        }
    };
    private ItemClickSupport(RecyclerView recyclerView){
        mRecyclerview = recyclerView;
        mRecyclerview.setTag(R.id.item_click_support,this);
        mRecyclerview.addOnChildAttachStateChangeListener(onChildAttachStateChangeListener);
    }
    public static ItemClickSupport addTo(RecyclerView view){
        ItemClickSupport support = (ItemClickSupport) view.getTag(R.id.item_click_support);
        if (support == null){
            support = new ItemClickSupport(view);
        }
        return support;
    }
    public static ItemClickSupport removeFrom(RecyclerView view){
        ItemClickSupport support = (ItemClickSupport) view.getTag(R.id.item_click_support);
        if(support != null){
            support.detach(view);
        }
        return support;
    }
    private void detach(RecyclerView view){
        view.removeOnChildAttachStateChangeListener(onChildAttachStateChangeListener);
        view.setTag(R.id.item_click_support,null);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        onItemClickListener = listener;
    }
    public void setOnLongClickListener(OnItemLongClickListener listener){
        mOnItemLongClickListener = listener;
    }
    public interface OnItemClickListener {
        void onItemClicked(RecyclerView recyclerView, int position, View v);
    }
    public interface OnItemLongClickListener {
        boolean onItemLongClicked(RecyclerView recyclerView, int position, View v);
    }

}
