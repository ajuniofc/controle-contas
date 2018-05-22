package ajuniofc.com.br.controledecontastelas.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.ui.activity.adicionarbooklet.CompartilharActivity;
import ajuniofc.com.br.controledecontastelas.ui.activity.home.HomeActivity;

public class ContaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.conta_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_conta_voltar:
                startActivity(new Intent(this, ContasActivity.class));
                finish();
                break;
            case R.id.menu_conta_finalizar:
                startActivity(new Intent(this, ContasActivity.class));
                finish();
                Toast.makeText(this, "Conta finalizada!",Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_conta_pagar:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
