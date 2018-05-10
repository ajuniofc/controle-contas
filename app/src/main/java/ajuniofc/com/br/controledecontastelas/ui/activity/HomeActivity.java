package ajuniofc.com.br.controledecontastelas.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.model.Bill;
import ajuniofc.com.br.controledecontastelas.model.BillType;
import ajuniofc.com.br.controledecontastelas.model.Booklet;
import ajuniofc.com.br.controledecontastelas.model.CurrentDebt;
import ajuniofc.com.br.controledecontastelas.model.MonthlyDebt;
import ajuniofc.com.br.controledecontastelas.model.BookletType;
import ajuniofc.com.br.controledecontastelas.model.Programming;
import ajuniofc.com.br.controledecontastelas.ui.adapter.BookletListAdapter;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setupRecyclerView();
        setupAddButton();
        configRecyclerView();
    }
    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.task_list);
    }

    private void setupAddButton() {
        addButton = findViewById(R.id.task_list_add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, AdicionarCardenetaActivity.class));
            }
        });
    }

    private void configRecyclerView() {
        setAdapter();
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    private void setAdapter() {
        recyclerView.setAdapter(new BookletListAdapter(list(), this));
    }

    private List<Booklet> list() {
        List<Booklet> list = new ArrayList<>();
        list.add(new Booklet( "Pessoais",  "Gastos pessoais",  Calendar.getInstance(), BookletType.SPARSE, getOwnerBills()));
        list.add(new Booklet( "Casa",  "Todas as contas de casa",  Calendar.getInstance(), BookletType.FIXED, getHomeBills()));
        list.add(new Booklet( "Confraternização",  "Valores a serem gastos na confraternização da empresa.",  Calendar.getInstance(), BookletType.SPARSE, getWorkBills()));
        return list;
    }

    private List<Bill> getWorkBills() {
        List<Bill> bills = new ArrayList<>();
        bills.add(new CurrentDebt("Local", "Chacara a ser alugada", 459.90));
        bills.add(new CurrentDebt("Refri", "Um engradado", 65.00));
        bills.add(new CurrentDebt("Cerveja", "Dois engradados", 80.00));
        bills.add(new CurrentDebt("Suco", "10 caixas de suco", 32.89));
        bills.add(new CurrentDebt("Carne", "Carnes para churrasco", 289.90));
        return bills;
    }

    private List<Bill> getHomeBills() {
        List<Bill> bills = new ArrayList<>();
        bills.add(new MonthlyDebt("CAESB", "Conta de agua", Calendar.getInstance(),
                new Programming(true, BillType.FIXED, 0), 59.00, false));
        bills.add(new MonthlyDebt("CEB", "Conta de energia", Calendar.getInstance(),
                new Programming(true, BillType.FIXED, 0), 84.00, false));
        bills.add(new MonthlyDebt("NET", "Conta de internet", Calendar.getInstance(),
                new Programming(true, BillType.FIXED, 0), 457.97, false));
        bills.add(new MonthlyDebt("Pós", "Mensalidade da pos", Calendar.getInstance(),
                new Programming(true, BillType.FIXED, 0), 538.65, false));
        bills.add(new MonthlyDebt("CEB", "Mensalidade da academia", Calendar.getInstance(),
                new Programming(true, BillType.FIXED, 0), 89.90, true));
        return bills;
    }

    private List<Bill> getOwnerBills() {
        List<Bill> bills = new ArrayList<>();
        bills.add(new CurrentDebt("Camisa do inter", "Camisa de treino do inter", Calendar.getInstance(),149.99));
        bills.add(new CurrentDebt("Amigo", "Dinheiro pego emprestado com Fulano", 65.00));
        return bills;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.form_task_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void contas(View view) {

    }
}
