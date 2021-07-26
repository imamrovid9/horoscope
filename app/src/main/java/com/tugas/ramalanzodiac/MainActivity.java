package com.tugas.ramalanzodiac;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tugas.ramalanzodiac.api.ApiClient;
import com.tugas.ramalanzodiac.api.ApiInterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    Dialog popup;
    public String zodiakasd, detailasd;
    TextView tvDate;
    EditText etDate;
    DatePickerDialog.OnDateSetListener setListener;

    private EditText inputName;
    private EditText inputTanggal;
    private Button buttonExe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvDate = findViewById(R.id.tv_date);
        etDate = findViewById(R.id.et_date);

        inputName = findViewById(R.id.editTextName);
        inputTanggal = findViewById(R.id.et_date);
        buttonExe = findViewById(R.id.button);


        Calendar calendar = Calendar.getInstance();
        final  int year = calendar.get(Calendar.YEAR);
        final  int month = calendar.get(Calendar.MONTH);
        final  int day = calendar.get(Calendar.DAY_OF_MONTH);




        tvDate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                MainActivity context;
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                    context =  MainActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();


            }
        });

    setListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            month = month+1;
            String date = day+"/"+month+"/"+year;
            tvDate.setText(date);

        }
    };
    etDate.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){

            MainActivity context;
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    context = MainActivity.this, new DatePickerDialog.OnDateSetListener(){
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){
                    month = month+1;
                    String date = dayOfMonth+"/"+month+"/"+year;
                    etDate.setText(date);
                }
            }, year,month,day);
            datePickerDialog.show();
        }
    });


        buttonExe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString();
                String tanggal = inputTanggal.getText().toString();



                if (name.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "Please Fill Form Name";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }
                if(tanggal.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "Please Fill Form Date Birth";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }

                    String[] temp;
                    String delimiter = "/";

                    temp = tanggal.split(delimiter);
                    String tanggalTerbaru = temp[0];
                    String bulanTerbaru = temp[1];

                    int tanggalInteger=Integer.parseInt(tanggalTerbaru);
                    int bulanInteger=Integer.parseInt(bulanTerbaru);

                    if (bulanInteger==1)
                    {
                        if (tanggalInteger<20)
                        {
                           capricorn();

                        }
                        else{
                            aquarius();
                        }
                    }
                    else if (bulanInteger==2)
                    {
                        if (tanggalInteger<19)
                        {
                            aquarius();
                        }
                        else {
                            pisces();
                        }
                    }
                    else if (bulanInteger==3)
                    {
                        if (tanggalInteger<21)
                        {
                            pisces();

                        }
                        else {
                            aries();
                        }
                    }
                else if (bulanInteger==4)
                    {
                        if (tanggalInteger<20)
                        {
                           aries();
                        }
                        else {
                            taurus();
                        }
                    }
                else if (bulanInteger==5)
                    {
                        if (tanggalInteger<21)
                        {
                            taurus();
                        }
                        else {
                            gemini();
                        }
                    }
                else if (bulanInteger==6)
                    {
                        if (tanggalInteger<21)
                        {
                            gemini();
                        }
                        else {
                            cancer();
                        }
                    }
                    else if (bulanInteger==7)
                    {
                        if (tanggalInteger<23)
                        {
                           cancer();
                        }
                        else {
                            leo();
                        }
                    }
                    else if (bulanInteger==8)
                    {
                        if (tanggalInteger<23)
                        {
                           leo();
                        }
                        else {
                            virgo();
                        }
                    }
                    else  if (bulanInteger==9)
                    {
                        if (tanggalInteger<23)
                        {
                           virgo();
                        }
                        else {
                            libra();
                        }
                    }
                    else  if (bulanInteger==10)
                    {
                        if (tanggalInteger<23)
                        {
                            libra();
                        }
                        else
                           scorpio();
                    }
                    else if (bulanInteger==11)
                    {
                        if (tanggalInteger<22)
                        {
                           scorpio();
                        }
                        else {
                            sagittarius();
                        }
                    }
                else if (bulanInteger==12)
                    {
                        if (tanggalInteger<22)
                        {
                           sagittarius();
                        }
                        else{
                            capricorn();
                        }
                    }
                }

        });


    }


    private void aries() {
        Call<MainModel> userlist = ApiClient.getAries().getAries();
            userlist.enqueue(new Callback<MainModel>() {
                @Override
                public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                    Context context = getApplicationContext();
                    CharSequence text = "Please Wait";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    if(response.isSuccessful()){
                        String sunSign = response.body().getSunsign();
                        String getHoroscope = response.body().getHoroscope();
                        Log.d(TAG, sunSign);
                        Log.d(TAG, getHoroscope);
                        Intent i = new Intent(MainActivity.this, DetailActivity.class);
                        i.putExtra("zodiakasd", sunSign);
                        i.putExtra("detailasd", getHoroscope);
                        startActivity(i);
                        return;
                    }
                }
                @Override
                public void onFailure(Call<MainModel>call, Throwable t) {
                }
            });
        }

    private void taurus() {
        Call<MainModel> userlist = ApiClient.getTaurus().getTaurus();
        userlist.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                Context context = getApplicationContext();
                CharSequence text = "Please Wait";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                if(response.isSuccessful()){
                    String sunSign = response.body().getSunsign();
                    String getHoroscope = response.body().getHoroscope();
                    Log.d(TAG, sunSign);
                    Log.d(TAG, getHoroscope);
                    Intent i = new Intent(MainActivity.this, DetailActivity.class);
                    i.putExtra("zodiakasd", sunSign);
                    i.putExtra("detailasd", getHoroscope);
                    startActivity(i);
                    return;
                }
            }
            @Override
            public void onFailure(Call<MainModel>call, Throwable t) {
            }
        });
    }



    private void gemini() {
        Call<MainModel> userlist = ApiClient.getGemini().getGemini();
        userlist.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                Context context = getApplicationContext();
                CharSequence text = "Please Wait";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                if(response.isSuccessful()){
                    String sunSign = response.body().getSunsign();
                    String getHoroscope = response.body().getHoroscope();
                    Log.d(TAG, sunSign);
                    Log.d(TAG, getHoroscope);
                    Intent i = new Intent(MainActivity.this, DetailActivity.class);
                    i.putExtra("zodiakasd", sunSign);
                    i.putExtra("detailasd", getHoroscope);
                    startActivity(i);
                    return;
                }
            }
            @Override
            public void onFailure(Call<MainModel>call, Throwable t) {
            }
        });
    }


    private void cancer() {
        Call<MainModel> userlist = ApiClient.getCancer().getCancer();
        userlist.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                Context context = getApplicationContext();
                CharSequence text = "Please Wait";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                if(response.isSuccessful()){
                    String sunSign = response.body().getSunsign();
                    String getHoroscope = response.body().getHoroscope();
                    Log.d(TAG, sunSign);
                    Log.d(TAG, getHoroscope);
                    Intent i = new Intent(MainActivity.this, DetailActivity.class);
                    i.putExtra("zodiakasd", sunSign);
                    i.putExtra("detailasd", getHoroscope);
                    startActivity(i);
                    return;
                }
            }
            @Override
            public void onFailure(Call<MainModel>call, Throwable t) {
            }
        });
    }

    private void leo() {
        Call<MainModel> userlist = ApiClient.getLeo().getLeo();
        userlist.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                Context context = getApplicationContext();
                CharSequence text = "Please Wait";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                if(response.isSuccessful()){
                    String sunSign = response.body().getSunsign();
                    String getHoroscope = response.body().getHoroscope();
                    Log.d(TAG, sunSign);
                    Log.d(TAG, getHoroscope);
                    Intent i = new Intent(MainActivity.this, DetailActivity.class);
                    i.putExtra("zodiakasd", sunSign);
                    i.putExtra("detailasd", getHoroscope);
                    startActivity(i);
                    return;
                }
            }
            @Override
            public void onFailure(Call<MainModel>call, Throwable t) {
            }
        });
    }

    private void virgo() {
        Call<MainModel> userlist = ApiClient.getVirgo().getVirgo();
        userlist.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                Context context = getApplicationContext();
                CharSequence text = "Please Wait";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                if(response.isSuccessful()){
                    String sunSign = response.body().getSunsign();
                    String getHoroscope = response.body().getHoroscope();
                    Log.d(TAG, sunSign);
                    Log.d(TAG, getHoroscope);
                    Intent i = new Intent(MainActivity.this, DetailActivity.class);
                    i.putExtra("zodiakasd", sunSign);
                    i.putExtra("detailasd", getHoroscope);
                    startActivity(i);
                    return;
                }
            }
            @Override
            public void onFailure(Call<MainModel>call, Throwable t) {
            }
        });
    }

    private void libra() {
        Call<MainModel> userlist = ApiClient.getLibra().getLibra();
        userlist.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                Context context = getApplicationContext();
                CharSequence text = "Please Wait";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                if(response.isSuccessful()){
                    String sunSign = response.body().getSunsign();
                    String getHoroscope = response.body().getHoroscope();
                    Log.d(TAG, sunSign);
                    Log.d(TAG, getHoroscope);
                    Intent i = new Intent(MainActivity.this, DetailActivity.class);
                    i.putExtra("zodiakasd", sunSign);
                    i.putExtra("detailasd", getHoroscope);
                    startActivity(i);
                    return;
                }
            }
            @Override
            public void onFailure(Call<MainModel>call, Throwable t) {
            }
        });
    }



    private void scorpio() {
        Call<MainModel> userlist = ApiClient.getScorpio().getScorpio();
        userlist.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                Context context = getApplicationContext();
                CharSequence text = "Please Wait";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                if(response.isSuccessful()){
                    String sunSign = response.body().getSunsign();
                    String getHoroscope = response.body().getHoroscope();
                    Log.d(TAG, sunSign);
                    Log.d(TAG, getHoroscope);
                    Intent i = new Intent(MainActivity.this, DetailActivity.class);
                    i.putExtra("zodiakasd", sunSign);
                    i.putExtra("detailasd", getHoroscope);
                    startActivity(i);
                    return;
                }
            }
            @Override
            public void onFailure(Call<MainModel>call, Throwable t) {
            }
        });
    }



    private void sagittarius() {
        Call<MainModel> userlist = ApiClient.getSagitarius().getSagitarius();
        userlist.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                Context context = getApplicationContext();
                CharSequence text = "Please Wait";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                if(response.isSuccessful()){
                    String sunSign = response.body().getSunsign();
                    String getHoroscope = response.body().getHoroscope();
                    Log.d(TAG, sunSign);
                    Log.d(TAG, getHoroscope);
                    Intent i = new Intent(MainActivity.this, DetailActivity.class);
                    i.putExtra("zodiakasd", sunSign);
                    i.putExtra("detailasd", getHoroscope);
                    startActivity(i);
                    return;
                }
            }
            @Override
            public void onFailure(Call<MainModel>call, Throwable t) {
            }
        });
    }



    private void capricorn() {
        Call<MainModel> userlist = ApiClient.getCapricorn().getCapricorn();
        userlist.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                Context context = getApplicationContext();
                CharSequence text = "Please Wait";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                if(response.isSuccessful()){
                    String sunSign = response.body().getSunsign();
                    String getHoroscope = response.body().getHoroscope();
                    Log.d(TAG, sunSign);
                    Log.d(TAG, getHoroscope);
                    Intent i = new Intent(MainActivity.this, DetailActivity.class);
                    i.putExtra("zodiakasd", sunSign);
                    i.putExtra("detailasd", getHoroscope);
                    startActivity(i);
                    return;
                }
            }
            @Override
            public void onFailure(Call<MainModel>call, Throwable t) {
            }
        });
    }


    private void aquarius() {
        Call<MainModel> userlist = ApiClient.getAquarius().getAquarius();
        userlist.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                Context context = getApplicationContext();
                CharSequence text = "Please Wait";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                if(response.isSuccessful()){
                    String sunSign = response.body().getSunsign();
                    String getHoroscope = response.body().getHoroscope();
                    Log.d(TAG, sunSign);
                    Log.d(TAG, getHoroscope);
                    Intent i = new Intent(MainActivity.this, DetailActivity.class);
                    i.putExtra("zodiakasd", sunSign);
                    i.putExtra("detailasd", getHoroscope);
                    startActivity(i);
                    return;
                }
            }
            @Override
            public void onFailure(Call<MainModel>call, Throwable t) {
            }
        });
    }


    private void pisces() {
        Call<MainModel> userlist = ApiClient.getPisces().getPisces();
        userlist.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                Context context = getApplicationContext();
                CharSequence text = "Please Wait";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                if(response.isSuccessful()){
                    String sunSign = response.body().getSunsign();
                    String getHoroscope = response.body().getHoroscope();
                    Log.d(TAG, sunSign);
                    Log.d(TAG, getHoroscope);
                    Intent i = new Intent(MainActivity.this, DetailActivity.class);
                    i.putExtra("zodiakasd", sunSign);
                    i.putExtra("detailasd", getHoroscope);
                    startActivity(i);
                    return;
                }
            }
            @Override
            public void onFailure(Call<MainModel>call, Throwable t) {
            }
        });
    }




    }







