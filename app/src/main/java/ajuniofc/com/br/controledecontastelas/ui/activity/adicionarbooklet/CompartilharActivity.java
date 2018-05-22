package ajuniofc.com.br.controledecontastelas.ui.activity.adicionarbooklet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.model.Bill;
import ajuniofc.com.br.controledecontastelas.model.Booklet;
import ajuniofc.com.br.controledecontastelas.model.BookletType;
import ajuniofc.com.br.controledecontastelas.ui.activity.ContasActivity;

public class CompartilharActivity extends AppCompatActivity {
    private EditText edtEmail;
    private ListView listView;
    private List<String> list = new ArrayList<>();
    private LinearLayout erroLayout;
    private boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartilhar);
        edtEmail = findViewById(R.id.cadastro_caderneta_compartilhar_email);
        listView = findViewById(R.id.cadastro_caderneta_compartilhar_list);
        erroLayout = findViewById(R.id.cadastro_caderneta_compartilhar_erro);
    }

    public void finishView(View view) {
        finish();
    }

    public void add(View view) {
        String stringEmail = edtEmail.getText().toString();
        if (!isValid){
            erroLayout.setVisibility(View.VISIBLE);
            isValid = true;
        }else{
            erroLayout.setVisibility(View.INVISIBLE);
            list.add(stringEmail);
            setAdapter();
        }
    }

    public void createCaderneta(View view) {
        Booklet booklet = new Booklet("Casa", "Contas de casa", Calendar.getInstance(), BookletType.SPARSE, new ArrayList<Bill>());
        EventBus.getDefault().postSticky(booklet);
        startActivity(new Intent(this, ContasActivity.class));
        finish();
    }

    private void setAdapter(){
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list));
    }
}
