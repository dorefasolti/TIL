package com.example.firstandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//                                이걸 상속받고있다
public class MainActivity extends AppCompatActivity {
//상속을받았다..
//    메인함수가없다..
//    메인함수는 유저에게 노출되지 않아야한다..
//    실행될 내용만 여기에 정의한다..
//    콜백함수 : 앱에서 클릭했을때 이 함수가 불리도록 해라.. 클릭했을 떄 일어날 함수를 짜면된다.. 클릭했을때 클릭 이벤트에 의해 호출되는 함수를
//    이벤트핸들러, 이벤트콜백이라고 부른다
//    어떤 앱이 있으면 거기서 일어나는 이벤트들(클릭, 스와이프, 키보드 등)
//    앱이 어떻게 굴러가는지 정해진 틀을 내부에 가지고 있고
//    개발하는 사람은 콜백함수만 구현하면 된다
//    = 이벤트가 생겼을 때 어떻게 반응할 지만 만들며 됨

//    메인액티비티클래스에서 오버라이드를 왜?
//    onCreate를 오버라이드하는이유?
//    이벤트 핸들러 함수는 앞에 on을 붙인다
//    on의 의미 = 크리에이트라는 이벤트가 발생했을 때 어떻게 할 것이다라는 의미
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void on(View view){
        TextView textview = findViewById(R.id.and1);
        textview.setText("BYE MIRA");

    }
}