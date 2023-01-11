package com.hieund.mailapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ItemModel> items;
    ItemClickListener listener;

    public ItemAdapter(List<ItemModel> items, ItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item, null);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemModel item = items.get(position);
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        viewHolder.textThumb.setText(item.getTextThumb());
        viewHolder.textTitle.setText(item.getTextTitle());
        viewHolder.content.setText(item.getContent());
        viewHolder.datetime.setText(item.getDatetime());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private Context context;
    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView textThumb;
        TextView textTitle;
        TextView content;
        TextView datetime;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();

            textThumb = itemView.findViewById(R.id.text_thumb);
            textTitle = itemView.findViewById(R.id.text_title);
            content = itemView.findViewById(R.id.text_content);
            datetime = itemView.findViewById(R.id.datetime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null)
                        listener.OnItemClick(position);
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (!textThumb.getText().equals("\u2713")) {
                        textThumb.setTypeface(Typeface.DEFAULT);
                        textThumb.setText("\u2713");
                    } else {
                        textThumb.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                        textThumb.setText(String.valueOf(textTitle.getText().toString().toUpperCase().charAt(0)));
                    }

                    return true;
                }
            });
//            itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
//                @Override
//                public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//
//                    menu.setHeaderTitle("Options");
//                    menu.add("Goi").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                        @Override
//                        public boolean onMenuItemClick(MenuItem menuItem) {
//                            Toast.makeText(v.getContext(), "Da goi", Toast.LENGTH_SHORT).show();
//                            context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0987654321")));
//                            return true;
//                        }
//                    });
//                    menu.add("Nhan tin").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                        @Override
//                        public boolean onMenuItemClick(MenuItem menuItem) {
//                            Toast.makeText(v.getContext(), "Da gui tin", Toast.LENGTH_SHORT).show();
//                            context.startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:0987654321")));
//                            return true;
//                        }
//                    });
//                    menu.add("Gui Email").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                        @Override
//                        public boolean onMenuItemClick(MenuItem menuItem) {
//                            Toast.makeText(v.getContext(), "Da gui email", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(Intent.ACTION_SEND);
//                            intent.setType("vnd.android.cursor.dir/email");
//                            intent.putExtra(Intent.EXTRA_EMAIL, "112233@temp.mail");
//                            context.startActivity(intent);
//                            return true;
//                        }
//                    });
//                }
//            });
        }
    }
}