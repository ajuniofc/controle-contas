package ajuniofc.com.br.controledecontastelas.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.model.Bill;

/**
 * Created by admin on 10/05/2018.
 */

class BillListAdapter extends RecyclerView.Adapter<BillListAdapter.BillViewHolder> {
    private final List<Bill> bills;

    public BillListAdapter(List<Bill> bills){
        this.bills = bills;
    }

    @Override
    public BillListAdapter.BillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_list_item, parent, false);

        return new BillListAdapter.BillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BillListAdapter.BillViewHolder holder, int position) {
        Bill bill = bills.get(position);
        holder.bind(bill);
    }

    @Override
    public int getItemCount() {
        return bills.size();
    }

    class BillViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;

        public BillViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.bill_item_title);
        }

        public void bind(Bill bill){
            name.setText(bill.getName());
        }
    }
}

