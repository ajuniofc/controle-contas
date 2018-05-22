package ajuniofc.com.br.controledecontastelas.ui.activity.bill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import ajuniofc.com.br.controledecontastelas.R;

public class AdicionarBillActivity extends AppCompatActivity {
    private LinearLayout erroLayout;
    private boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_bill);
        erroLayout = findViewById(R.id.bill_erro_nome);
    }

    public void finishView(View view) {
        finish();
    }

    public void addNome(View view) {
        if (!isValid){
            erroLayout.setVisibility(View.VISIBLE);
            isValid = true;
        }else {
            erroLayout.setVisibility(View.INVISIBLE);
            startActivity(new Intent(this, ValorBIllActivity.class));
            finish();
        }
    }
}
