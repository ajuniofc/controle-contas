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
import ajuniofc.com.br.controledecontastelas.model.Task;
import ajuniofc.com.br.controledecontastelas.ui.adapter.TaskListAdapter;

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
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
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
        recyclerView.setAdapter(new TaskListAdapter(list(), this));
    }

    private List<Task> list() {
        List<Task> list = new ArrayList<>();
        list.add(new Task( "Pessoais",  "Descricao teste da tarefa",  Calendar.getInstance()));
        list.add(new Task( "Casa",  "Descricao teste da tarefa 2 para verificar o tamanho da nota",  Calendar.getInstance()));
        list.add(new Task( "Trabalho",  "Descricao",  Calendar.getInstance()));
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.form_task_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void contas(View view) {

    }
}
