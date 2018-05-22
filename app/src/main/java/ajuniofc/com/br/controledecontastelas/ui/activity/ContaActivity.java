package ajuniofc.com.br.controledecontastelas.ui.activity;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.model.Bill;
import ajuniofc.com.br.controledecontastelas.model.Booklet;
import ajuniofc.com.br.controledecontastelas.model.BookletList;
import ajuniofc.com.br.controledecontastelas.ui.activity.adicionarbooklet.CompartilharActivity;
import ajuniofc.com.br.controledecontastelas.ui.activity.home.HomeActivity;

public class ContaActivity extends AppCompatActivity {
    private Button btnPagar;
    private TextView txtStatus, txtImage;
    private LinearLayout anexoLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);
        btnPagar = findViewById(R.id.conta_pagar);
        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pagar();
            }
        });

        txtStatus = findViewById(R.id.conta_status);
        txtImage = findViewById(R.id.conta_nenhum_anexo);
        anexoLayout = findViewById(R.id.conta_anexo);
    }

    private void pagar() {
        txtStatus.setText("Paga");
        txtStatus.setTextColor(ContextCompat.getColor(this, R.color.verde));
        btnPagar.setVisibility(View.INVISIBLE);
        BookletList bookletList = EventBus.getDefault().getStickyEvent(BookletList.class);
        Booklet booklet = bookletList.getBooklets().get(0);
        booklet.getBills().get(0).setStatus(true);
        bookletList.getBooklets().set(0, booklet);
        EventBus.getDefault().postSticky(bookletList);
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
        }

        return super.onOptionsItemSelected(item);
    }

    public void addImagem(View view) {
        txtImage.setVisibility(View.INVISIBLE);
        anexoLayout.setVisibility(View.VISIBLE);
    }
}
