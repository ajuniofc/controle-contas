package ajuniofc.com.br.controledecontastelas.ui.activity.recuperarsenha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.ui.adapter.RecuperarSenhaAdapter;

public class RecuperarSenhaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);
        listView = findViewById(R.id.recuperar_senha_list);
        ArrayList<String> lista = new ArrayList<>();
        lista.add("SMS");
        lista.add("E-MAIL");
        listView.setAdapter(new RecuperarSenhaAdapter(this, lista,2));
        listView.setOnItemClickListener(this);
    }

    public void finishView(View view) {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(this, CodigoSegurancaActivity.class));
    }
}
