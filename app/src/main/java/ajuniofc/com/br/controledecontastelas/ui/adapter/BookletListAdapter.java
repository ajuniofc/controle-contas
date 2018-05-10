package ajuniofc.com.br.controledecontastelas.ui.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.model.Bill;
import ajuniofc.com.br.controledecontastelas.model.Booklet;
import ajuniofc.com.br.controledecontastelas.ui.activity.ContasActivity;
import ajuniofc.com.br.controledecontastelas.ui.activity.HomeActivity;


public class BookletListAdapter extends RecyclerView.Adapter<BookletListAdapter.BookletViewHolder> {
    private final List<Booklet> booklets;
    private HomeActivity activity;

    public BookletListAdapter(List<Booklet> booklets, HomeActivity activity){
        this.booklets = booklets;
        this.activity = activity;
    }

    @Override
    public BookletViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booklet_list_item, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity, ContasActivity.class));
            }
        });
        return new BookletViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookletViewHolder holder, int position) {
        Booklet booklet = booklets.get(position);
        holder.bind(booklet);
    }

    @Override
    public int getItemCount() {
        return booklets.size();
    }

    class BookletViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final ListView listView;

        public BookletViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.booklet_item_title);
            listView = itemView.findViewById(R.id.booklet_item_list);
        }

        public void bind(Booklet booklet){
            if (booklet.getTitle().length() >8){
                title.setText(booklet.getTitle().substring(0,8)+"...");
            }else {
                title.setText(booklet.getTitle());
            }
            listView.setAdapter(new ArrayAdapter<Bill>(activity,
                    android.R.layout.simple_list_item_1, booklet.getBills()));
        }
    }
}
