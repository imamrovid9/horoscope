package com.tugas.ramalanzodiac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends Activity {
    TextView txtHello;
    TextView details;
    private String zodiac;
    private String detail;
    String zodiakasd,detailasd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        txtHello = (TextView) findViewById(R.id.txtHello);
        details = (TextView) findViewById(R.id.details);



        if(getIntent().getStringExtra("zodiakasd") != null){
            zodiakasd = getIntent().getStringExtra("zodiakasd");
            txtHello.setText(zodiakasd);
        }
        if(getIntent().getStringExtra("detailasd") != null){
            detailasd = getIntent().getStringExtra("detailasd");
            details.setText(detailasd);
        }

        Button btn = (Button)findViewById(R.id.backbutton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailActivity.this, MainActivity.class));
            }
        });


    }

}