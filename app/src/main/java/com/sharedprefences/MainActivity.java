package com.sharedprefences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button kaydet,veriGetir;
    EditText edText;
    TextView tvText;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kaydet = (Button)findViewById(R.id.btKayit);
        veriGetir = (Button)findViewById(R.id.btGetir);
        edText = (EditText)findViewById(R.id.edText);
        tvText = (TextView)findViewById(R.id.tvYazi);

        kaydet.setOnClickListener(this);
        veriGetir.setOnClickListener(this);

        sp=getSharedPreferences("veriTut",MODE_PRIVATE);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btKayit:

                String gelenVeri = edText.getText().toString();
                SharedPreferences.Editor editor ;
                editor=sp.edit();
                editor.putString("isteVeri",gelenVeri);
                editor.commit();

                break;
            case R.id.btGetir:
                sp=getSharedPreferences("veriTut",MODE_PRIVATE);
                String okunanVeri = "";
                okunanVeri=sp.getString("isteVeri","Alınamadı");
                tvText.setText(okunanVeri);
                break;
        }
    }
}
