package ajuniofc.com.br.controledecontastelas.ui.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.model.Bill;
import ajuniofc.com.br.controledecontastelas.model.Booklet;
import ajuniofc.com.br.controledecontastelas.model.CurrentDebt;
import ajuniofc.com.br.controledecontastelas.model.MonthlyDebt;
import ajuniofc.com.br.controledecontastelas.ui.activity.ContasActivity;
import ajuniofc.com.br.controledecontastelas.ui.activity.home.HomeActivity;


public class ContasAdapter extends RecyclerView.Adapter<ContasAdapter.BillViewHolder> {
    private final List<Bill> list;
    private Activity activity;

    public ContasAdapter(List<Bill> bills, Activity activity){
        this.list = bills;
        this.activity = activity;
    }

    @Override
    public BillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contas_item_list, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity, ContasActivity.class));
                activity.finish();
            }
        });
        return new BillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BillViewHolder holder, int position) {
        Bill bill = list.get(position);
        holder.bind(bill);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BillViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView vencimento;
        private final TextView valor;
        private final TextView status;

        public BillViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.contas_list_item_titulo);
            vencimento = itemView.findViewById(R.id.contas_list_item_vencimento);
            valor = itemView.findViewById(R.id.contas_list_item_valor);
            status = itemView.findViewById(R.id.contas_list_item_status);
        }

        public void bind(Bill bill1){
            if (bill1.getName().length() >8){
                title.setText(bill1.getName().substring(0,8)+"...");
            }else {
                title.setText(bill1.getName());
            }
            vencimento.setText(bill1.getExpirationDate().toString());
            if (bill1.isHasExpiration()){
                status.setTextColor(ContextCompat.getColor(activity, R.color.verde));
                status.setText("Paga");
            }else {
                status.setTextColor(ContextCompat.getColor(activity, R.color.vermelho));
                status.setText("Não paga");
            }
            if (bill1 instanceof CurrentDebt){
                bindMontly(bill1);
            }else {
                bindCurrent(bill1);
            }
        }

        private void bindCurrent(Bill bill1) {
            CurrentDebt currentDebt = (CurrentDebt) bill1;
            valor.setText(currentDebt.getValue().toString());
        }

        private void bindMontly(Bill bill1) {
            MonthlyDebt monthlyDebt = (MonthlyDebt) bill1;
            valor.setText(monthlyDebt.getValue().toString());
        }
    }
}
