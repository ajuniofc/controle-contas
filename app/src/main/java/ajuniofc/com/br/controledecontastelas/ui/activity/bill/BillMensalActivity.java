package ajuniofc.com.br.controledecontastelas.ui.activity.bill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import java.util.Calendar;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.model.Booklet;
import ajuniofc.com.br.controledecontastelas.model.CurrentDebt;
import ajuniofc.com.br.controledecontastelas.ui.activity.ContaActivity;

public class BillMensalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_mensal);
    }

    public void onCreateBill(View view) {
        Booklet booklet = EventBus.getDefault().getStickyEvent(Booklet.class);
        CurrentDebt currentDebt = new CurrentDebt("CEB", "Conta de energia", Calendar.getInstance(), 78.90);
        booklet.getBills().add(currentDebt);
        EventBus.getDefault().postSticky(booklet);
        startActivity(new Intent(this, ContaActivity.class));
        finish();
    }
}
