package com.mlds.whasappcloneapp.whatsappcloneapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.mlds.whasappcloneapp.whatsappcloneapp.R;

public class LoginActivity extends AppCompatActivity {

    private TextView telefone, nome, cod_area, cod_pais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nome = (TextView) findViewById(R.id.textNome);
        cod_pais = (TextView) findViewById(R.id.textCdPais);
        cod_area = (TextView) findViewById(R.id.textCodArea);
        telefone = (TextView) findViewById(R.id.textTelefone);

        SimpleMaskFormatter simpleMaskCdPais = new SimpleMaskFormatter("+NN");
        MaskTextWatcher maskTextCdPais = new MaskTextWatcher(cod_area, simpleMaskCdPais);
        cod_pais.addTextChangedListener(maskTextCdPais);

        SimpleMaskFormatter simpleMaskDDD = new SimpleMaskFormatter("NN");
        MaskTextWatcher maskTextCodArea = new MaskTextWatcher(cod_area, simpleMaskDDD);
        cod_area.addTextChangedListener(maskTextCodArea);

        SimpleMaskFormatter simpleMaskTelefone = new SimpleMaskFormatter("N NNNN-NNNN");
        MaskTextWatcher maskTextTelefone = new MaskTextWatcher(telefone, simpleMaskTelefone);
        telefone.addTextChangedListener(maskTextTelefone);
    }
}
