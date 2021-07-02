package com.example.gamerace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtdiem;
    ImageButton imageButtonplay;
    CheckBox checkBoxcar,checkBoxbike,checkBoxwalker;
    SeekBar seekBarcar,seekBarbike,seekBarwalker;
    int diemso=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
       seekBarwalker.setEnabled(false);
       seekBarbike.setEnabled(false);
       seekBarcar.setEnabled(false);
        CountDownTimer countDownTimer=new CountDownTimer(60000,200) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number=5;
                Random random=new Random();
                int numbercar=random.nextInt(number);
                int numberbike=random.nextInt(number);
                int numberwalker=random.nextInt(number);
                seekBarcar.setProgress(seekBarcar.getProgress()+numbercar);
                seekBarbike.setProgress(seekBarbike.getProgress()+numberbike);
                seekBarwalker.setProgress(seekBarwalker.getProgress()+numberwalker);
                txtdiem.setText(diemso+"");

                //Check WINNER
                if (seekBarcar.getProgress()>=seekBarcar.getMax()){
                    this.cancel();
                    checkBoxwalker.setEnabled(true);
                    checkBoxbike.setEnabled(true);
                    checkBoxcar.setEnabled(true);
                    imageButtonplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"CAR WIN",Toast.LENGTH_SHORT).show();
                    if (checkBoxcar.isChecked()==true)
                    {
                        Toast.makeText(MainActivity.this,"Ban doan dung",Toast.LENGTH_SHORT).show();
                        diemso+=10;
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Doan sai",Toast.LENGTH_SHORT).show();
                        diemso-=5;
                    }
                    txtdiem.setText(diemso+"");
                }
                if (seekBarbike.getProgress()>=seekBarbike.getMax()){
                    this.cancel();
                    checkBoxwalker.setEnabled(true);
                    checkBoxbike.setEnabled(true);
                    checkBoxcar.setEnabled(true);
                    imageButtonplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"BIKE WIN",Toast.LENGTH_SHORT).show();
                    if (checkBoxbike.isChecked()==true)
                    {
                        Toast.makeText(MainActivity.this,"Ban doan dung",Toast.LENGTH_SHORT).show();
                        diemso+=10;
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Doan sai",Toast.LENGTH_SHORT).show();
                        diemso-=5;
                    }
                    txtdiem.setText(diemso+"");
                }
                if (seekBarwalker.getProgress()>=seekBarwalker.getMax()){
                    this.cancel();
                    checkBoxwalker.setEnabled(true);
                    checkBoxbike.setEnabled(true);
                    checkBoxcar.setEnabled(true);
                    imageButtonplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"WALKER WIN",Toast.LENGTH_SHORT).show();
                    if (checkBoxwalker.isChecked()==true)
                    {
                        Toast.makeText(MainActivity.this,"Ban doan dung",Toast.LENGTH_SHORT).show();
                        diemso+=10;
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Doan sai",Toast.LENGTH_SHORT).show();
                        diemso-=5;
                    }
                    txtdiem.setText(diemso+"");
                }
            }

            @Override
            public void onFinish() {

            }
        };
        imageButtonplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxcar.isChecked()||checkBoxbike.isChecked()||checkBoxwalker.isChecked()){
                    seekBarcar.setProgress(0);
                    seekBarbike.setProgress(0);
                    seekBarwalker.setProgress(0);
                    imageButtonplay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    checkBoxwalker.setEnabled(false);
                    checkBoxbike.setEnabled(false);
                    checkBoxcar.setEnabled(false);
                }
                else {Toast.makeText(MainActivity.this,"Vui long doan",Toast.LENGTH_SHORT).show();}

            }
        });
        checkBoxcar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    checkBoxbike.setChecked(false);
                    checkBoxwalker.setChecked(false);
                }
            }
        });
        checkBoxbike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxwalker.setChecked(false);
                checkBoxcar.setChecked(false);
            }
        });
        checkBoxwalker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxcar.setChecked(false);
                checkBoxbike.setChecked(false);
            }
        });

    }

    public void AnhXa(){
        txtdiem=(TextView) findViewById(R.id.diemcuoc);
        imageButtonplay=(ImageButton) findViewById(R.id.playgame);
        checkBoxbike=(CheckBox) findViewById(R.id.chkbike);
        checkBoxcar=(CheckBox) findViewById(R.id.chkcar);
        checkBoxwalker=(CheckBox) findViewById(R.id.chkwalker);
        seekBarcar=(SeekBar) findViewById(R.id.seekbarcar);
        seekBarbike=(SeekBar) findViewById(R.id.seekbarbike);
        seekBarwalker=(SeekBar)findViewById(R.id.seekbarwalker);
    }
}