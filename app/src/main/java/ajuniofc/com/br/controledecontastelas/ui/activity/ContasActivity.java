package ajuniofc.com.br.controledecontastelas.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.model.Bill;
import ajuniofc.com.br.controledecontastelas.model.BookletList;
import ajuniofc.com.br.controledecontastelas.model.CurrentDebt;
import ajuniofc.com.br.controledecontastelas.model.MonthlyDebt;
import ajuniofc.com.br.controledecontastelas.ui.activity.adicionarbooklet.CompartilharActivity;
import ajuniofc.com.br.controledecontastelas.ui.activity.bill.AdicionarBillActivity;
import ajuniofc.com.br.controledecontastelas.ui.activity.home.HomeActivity;
import ajuniofc.com.br.controledecontastelas.ui.adapter.ContasAdapter;

public class ContasActivity extends AppCompatActivity {
    private RecyclerView listView;
    private LinearLayout semContaLayout;
    private List<Bill> bills = new ArrayList<>();
    private BookletList bookletList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contas);
        bookletList = EventBus.getDefault().getStickyEvent(BookletList.class);
        listView = findViewById(R.id.contas_list);
        semContaLayout = findViewById(R.id.contas_sem_conta_adicionada);
        hasBookletAdded();
        setAdapter();
    }

    private void hasBookletAdded() {
        if (bookletList != null){
            bills = bookletList.getBooklets().get(0).getBills();
        }
    }
    private void setAdapter() {
        listView.setAdapter(new ContasAdapter(bills, this));
        listView.setLayoutManager(new LinearLayoutManager(this));
        if (bills.size() >= 1){
            semContaLayout.setVisibility(View.INVISIBLE);
        }else {
            semContaLayout.setVisibility(View.VISIBLE);
        }
        resumeView();
    }

    private void resumeView() {
        TextView total = findViewById(R.id.resumo_card_total);
        double totalNaoPago = getTotalByStatus(false);
        double totalValue = totalNaoPago;
        double totalPago = getTotalByStatus(true);
        totalValue += totalPago;
        if (totalValue == 0.0){
            total.setText("R$ " + "0.00");
        }else {
            total.setText("R$ " + "234.70");
        }
        TextView naoPago = findViewById(R.id.resumo_card_nao_pago);
        naoPago.setText("R$ "+totalNaoPago+"0");
        TextView pago = findViewById(R.id.resumo_card_pago);
        pago.setText("R$ "+totalPago+"0");
    }

    private double getTotalByStatus(boolean status) {
        double total = 0.0;
        for (Bill bill: bills) {
            if (bill.isStatus() == status) {
                if (bill instanceof CurrentDebt) {
                    total += ((CurrentDebt) bill).getValue();
                } else {
                    total += ((MonthlyDebt) bill).getValue();
                }
            }
        }
        return total;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.contas_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_contas_voltar:
                startActivity(new Intent(this, HomeActivity.class));
                finish();
                break;
            case R.id.menu_contas_finalizar:
                startActivity(new Intent(this, HomeActivity.class));
                EventBus.getDefault().removeAllStickyEvents();
                finish();
                Toast.makeText(this, "Tarefa finalizada!",Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_contas_compartilhar:
                startActivity(new Intent(this, CompartilharActivity.class));
                finish();
                break;
            case R.id.menu_contas_sincronizar:
                Toast.makeText(this, "Tarefa sincronizada!",Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void conta(View view) {
        startActivity(new Intent(this, ContaActivity.class));
    }

    public void addConta(View view) {
        startActivity(new Intent(this, AdicionarBillActivity.class));
        finish();
    }
}
