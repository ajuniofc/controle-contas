package ajuniofc.com.br.controledecontastelas.ui.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ajuniofc.com.br.controledecontastelas.R;

public class RecuperarSenhaAdapter extends BaseAdapter {
    private final Activity recuperarSenha;
    private final ArrayList<String> lista;
    private int color;

    public RecuperarSenhaAdapter(Activity recuperarSenha, ArrayList<String> lista, int color) {
        this.recuperarSenha = recuperarSenha;
        this.lista = lista;
        this.color = color;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = recuperarSenha.getLayoutInflater()
                    .inflate(R.layout.recuperar_senha_item_list, parent, false);
        TextView nome = (TextView)
                view.findViewById(R.id.recuperar_senha_list_text);

        nome.setText(lista.get(position));

        return view;
    }
}
