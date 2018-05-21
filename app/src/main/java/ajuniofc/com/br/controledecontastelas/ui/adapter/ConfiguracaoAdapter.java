package ajuniofc.com.br.controledecontastelas.ui.adapter;

import android.app.Activity;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.model.Configuracao;

public class ConfiguracaoAdapter extends BaseAdapter {
    private final Activity activity;
    private final List<Configuracao> lista;

    public ConfiguracaoAdapter(Activity activity, List<Configuracao> lista) {
        this.activity = activity;
        this.lista = lista;
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
        View view = activity.getLayoutInflater()
                    .inflate(R.layout.configuracao_item_list, parent, false);
        Configuracao configuracao = lista.get(position);
        view.findViewById(R.id.configuracao_list_img);

        ImageView img = view.findViewById(R.id.configuracao_list_img);
        img.setImageDrawable(configuracao.getImg());
        TextView titulo = view.findViewById(R.id.configuracao_list_titulo);
        titulo.setText(configuracao.getTitulo());
        TextView descricao = view.findViewById(R.id.configuracao_list_descricao);
        descricao.setText(configuracao.getDescricao());
        AppCompatCheckBox checkBox = view.findViewById(R.id.configuracao_list_check);
        if (!configuracao.isCheck()){
            checkBox.setVisibility(View.INVISIBLE);
        }


        return view;
    }
}
