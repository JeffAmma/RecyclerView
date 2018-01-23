package dongyang.jeff.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by song on 2018-01-23.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<RecycylerItem> listItems;
    private Context context;

    public MyAdapter(List<RecycylerItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        RecycylerItem itemList = listItems.get(position);
        holder.textViewTitle.setText(itemList.getTitle());
        holder.textViewDescription.setText(itemList.getDescription());
        holder.textViewOptionDigit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, holder.textViewOptionDigit);
                popupMenu.inflate(R.menu.option_memu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.itme_save:
                                Toast.makeText(context, "saved", Toast.LENGTH_LONG).show();
                            case R.id.item_delete:
                                listItems.remove(position);
                                notifyDataSetChanged();
                                Toast.makeText(context, "deleted", Toast.LENGTH_LONG).show();
                            default:
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewTitle;
        public TextView textViewDescription;
        public TextView textViewOptionDigit;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewTitle =(TextView)itemView.findViewById(R.id.txtTitle);
            textViewDescription =(TextView)itemView.findViewById(R.id.txtDescription);
            textViewOptionDigit=(TextView)itemView.findViewById(R.id.txtOptionDigit);
        }
    }

}
