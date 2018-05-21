package ajuniofc.com.br.controledecontastelas.ui.activity.configuracao;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.model.Configuracao;
import ajuniofc.com.br.controledecontastelas.ui.adapter.ConfiguracaoAdapter;

public class ConfiguracaoActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);
        listView = findViewById(R.id.configuracao_list);
        listView.setAdapter(new ConfiguracaoAdapter(this, listOfConfiguracao()));
    }

    private List<Configuracao> listOfConfiguracao() {
        List<Configuracao> list = new ArrayList<>();
        Drawable notficacao = ContextCompat.getDrawable(this, R.drawable.ic_action_notification);
        list.add(new Configuracao(notficacao, "Notificações", "Rececer notificações de vencimento de conta...", true));
        Drawable remover = ContextCompat.getDrawable(this, R.drawable.ic_action_delete_configuracao);
        list.add(new Configuracao(remover, "Apagar conta", "Remover as contas pagas da lista de contas", true));
        Drawable sair = ContextCompat.getDrawable(this, R.drawable.ic_action_logout);
        list.add(new Configuracao(sair, "Sair", "Fazer logout", false));
        return list;
    }

    public void ok(View view) {
        finish();
    }
}
