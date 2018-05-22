package ajuniofc.com.br.controledecontastelas.ui.activity.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.model.Bill;
import ajuniofc.com.br.controledecontastelas.model.BillType;
import ajuniofc.com.br.controledecontastelas.model.Booklet;
import ajuniofc.com.br.controledecontastelas.model.BookletList;
import ajuniofc.com.br.controledecontastelas.model.CurrentDebt;
import ajuniofc.com.br.controledecontastelas.model.MonthlyDebt;
import ajuniofc.com.br.controledecontastelas.model.BookletType;
import ajuniofc.com.br.controledecontastelas.model.Programming;
import ajuniofc.com.br.controledecontastelas.ui.activity.adicionarbooklet.AdicionarCardenetaActivity;
import ajuniofc.com.br.controledecontastelas.ui.activity.configuracao.ConfiguracaoActivity;
import ajuniofc.com.br.controledecontastelas.ui.adapter.BookletListAdapter;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button addButton;
    private List<Booklet> list = new ArrayList<>();
    private LinearLayout semContaLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        semContaLayout = findViewById(R.id.home_sem_contas_adicionadas);
        setupRecyclerView();
        setupAddButton();
        configRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hasBookletAdded();
        setAdapter();
    }

    private void hasBookletAdded() {
        BookletList bookletList = EventBus.getDefault().getStickyEvent(BookletList.class);
        if (bookletList != null){
            list = bookletList.getBooklets();
        }
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
                finish();
            }
        });
    }

    private void configRecyclerView() {
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    private void setAdapter() {
        recyclerView.setAdapter(new BookletListAdapter(list, this));
        if (list.size() >= 1){
            semContaLayout.setVisibility(View.INVISIBLE);
        }else {
            semContaLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(this, ConfiguracaoActivity.class));
        return super.onOptionsItemSelected(item);
    }
}
