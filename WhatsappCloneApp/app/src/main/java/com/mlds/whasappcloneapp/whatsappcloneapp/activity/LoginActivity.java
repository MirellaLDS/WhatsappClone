package com.mlds.whasappcloneapp.whatsappcloneapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.mlds.whasappcloneapp.whatsappcloneapp.R;

import java.util.Random;

public class LoginActivity extends AppCompatActivity {

    private TextView telefone, nome, cod_area, cod_pais;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nome = (TextView) findViewById(R.id.textNome);
        cod_pais = (TextView) findViewById(R.id.textCdPais);
        cod_area = (TextView) findViewById(R.id.textCodArea);
        telefone = (TextView) findViewById(R.id.textTelefone);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        SimpleMaskFormatter simpleMaskCdPais = new SimpleMaskFormatter("+NN");
        MaskTextWatcher maskTextCdPais = new MaskTextWatcher(cod_pais, simpleMaskCdPais);
        cod_pais.addTextChangedListener(maskTextCdPais);

        SimpleMaskFormatter simpleMaskDDD = new SimpleMaskFormatter("NN");
        MaskTextWatcher maskTextCodArea = new MaskTextWatcher(cod_area, simpleMaskDDD);
        cod_area.addTextChangedListener(maskTextCodArea);

        SimpleMaskFormatter simpleMaskTelefone = new SimpleMaskFormatter("N NNNN-NNNN");
        MaskTextWatcher maskTextTelefone = new MaskTextWatcher(telefone, simpleMaskTelefone);
        telefone.addTextChangedListener(maskTextTelefone);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeUsuario = nome.getText().toString();
                String telefoneCompleto =
                        cod_pais.getText().toString() +
                        cod_area.getText().toString() +
                        telefone.getText().toString();

                String telefoneSemFormatacao = telefoneCompleto.replace("+", "");
                telefoneSemFormatacao = telefoneSemFormatacao.replace("-", "");
                telefoneSemFormatacao = telefoneSemFormatacao.replace(" ", "");

                Log.i("TELEFONE", telefoneSemFormatacao);

                //Gerando token aleatório
                Random randomico = new Random();
                int numeroAleatorio = randomico.nextInt(9999 - 1000) + 1000;

                String token = String.valueOf(numeroAleatorio);
                Log.i("TOKEN", token);
            }
        });
    }
}
