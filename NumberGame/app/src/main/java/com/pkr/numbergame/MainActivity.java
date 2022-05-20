package com.pkr.numbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //선언(xml에 선언됀 id)
    EditText edtNumber;
    Button btnGameStart, btnConfirm;
    TextView tVHint;
    ImageView imageGame;
    int conNum;//1부터100사이의 난수
    int count;//시도 횟수
    int myNum;//입력숫자 모음
    @Override
    protected void onCreate(Bundle savedInstanceState) {//메인
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //xml 선언됀 객체를 위젯과연결
        edtNumber=findViewById(R.id.edtNumber);
        btnGameStart=findViewById(R.id.btnGameStart);
        btnConfirm=findViewById(R.id.btnConfirm);
        tVHint=findViewById(R.id.tVHint);
        imageGame=findViewById(R.id.ingGame);
        tVHint.setText("게임을 시작 하세요");
        //메소드 기능 처리

        //게임 시작 버튼
        btnGameStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//클릭동작 추상 메소드
                conNum=(int) (Math.random()*100)+1;
                count=0;
                tVHint.setText("게임이 시작 됐습니다.");
                btnConfirm.setEnabled(true);//터치가능 불가능을 만드는 메소드
                btnGameStart.setEnabled(false);
            }//게임시작 메소드

            //확인버튼
        });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                myNum=Integer.parseInt(edtNumber.getText().toString());
                if (myNum > conNum) {
                    tVHint.setText("당신의 숫자가 큽니다");
                    imageGame.setImageResource(R.drawable.wrong);
                }else if (myNum < conNum) {
                    tVHint.setText("당신의 숫자가 작습니다");
                    imageGame.setImageResource(R.drawable.wrong);
                }else {
                    tVHint.setText("맞습니다. 시도횟수는 "+count+" 입니다.");
                    imageGame.setImageResource(R.drawable.good);
                    btnGameStart.setEnabled(true);
                    btnConfirm.setEnabled(false);
                }
            }
        });
    }//onCreate
}//MainActivity