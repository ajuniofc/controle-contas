package ajuniofc.com.br.controledecontastelas.ui.activity.bill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import java.util.Calendar;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.model.Booklet;
import ajuniofc.com.br.controledecontastelas.model.BookletList;
import ajuniofc.com.br.controledecontastelas.model.CurrentDebt;
import ajuniofc.com.br.controledecontastelas.ui.activity.ContaActivity;

public class BillMensalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_mensal);
    }

    public void onCreateBill(View view) {
        createBills();
        startActivity(new Intent(this, ContaActivity.class));
        finish();
    }

    private void createBills() {
        BookletList bookletList = EventBus.getDefault().getStickyEvent(BookletList.class);
        CurrentDebt ceb = new CurrentDebt("CEB", "Conta de energia", Calendar.getInstance(), 78.90);
        bookletList.getBooklets().get(0).getBills().add(ceb);

        CurrentDebt caesb = new CurrentDebt("CAESB", "Conta de água", Calendar.getInstance(), 59.90);
        caesb.setStatus(true);
        bookletList.getBooklets().get(0).getBills().add(caesb);

        CurrentDebt net = new CurrentDebt("NET", "Conta de internet", Calendar.getInstance(), 95.90);
        bookletList.getBooklets().get(0).getBills().add(net);

        EventBus.getDefault().postSticky(bookletList);
    }
}
