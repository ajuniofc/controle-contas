package ajuniofc.com.br.controledecontastelas.ui.activity.bill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import ajuniofc.com.br.controledecontastelas.R;

public class ValorBIllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valor_bill);
    }

    public void finishView(View view) {
        finish();
    }

    public void addValor(View view) {
        startActivity(new Intent(this, VencimentoBillActivity.class));
        finish();
    }
}
