package ajuniofc.com.br.controledecontastelas.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by admin on 21/05/2018.
 */

public class Configuracao {
    private Drawable img;
    private String titulo;
    private String descricao;
    private boolean isCheck;

    public Configuracao(Drawable img, String titulo, String descricao, boolean isCheck) {
        this.img = img;
        this.titulo = titulo;
        this.descricao = descricao;
        this.isCheck = isCheck;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
