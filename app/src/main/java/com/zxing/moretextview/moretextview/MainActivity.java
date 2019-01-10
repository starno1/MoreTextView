package com.zxing.moretextview.moretextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zxing.moretextview.MoreTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MoreTextView moreView = findViewById(R.id.moreTextView);
        moreView.setContent("1月8日，中共中央总书记、国家主席习近平同当日抵京对中国进行访问的朝鲜劳动党委员长、国务委员会委员长金正恩举行会谈。两国领导人在亲切友好的气氛中，就中朝关系和共同关心的问题深入交换意见，达成重要共识。双方一致表示，愿共同努力推动中朝关系在新的时期不断取得新的发展，持续推进半岛问题政治解决进程，更好造福两国人民，为地区和世界和平稳定与繁荣发展作出积极贡献。");
    }
}
