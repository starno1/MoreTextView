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
        String str="<p><span style=\"color: rgb(51, 51, 51); font-family: arial, tahoma, &quot;Microsoft Yahei&quot;, 宋体, sans-serif; font-size: 14px; text-indent: 28px; background-color: rgb(255, 255, 255);\">澳大利亚纽卡索大学（英文名：The University of Newcastle, Australia，简称UoN），或译纽卡斯尔大学、纽卡素大学等，是位于澳大利亚新南威尔士州纽卡斯尔的公立大学，</span><span style=\"color: rgb(51, 51, 51); font-family: arial, tahoma, &quot;Microsoft Yahei&quot;, 宋体, sans-serif; font-size: 14px; text-indent: 28px; background-color: rgb(255, 255, 255);\">距离悉尼北部约150公里处。大学原为新南威尔士大学纽卡斯尔分校，后于1965年独立建校，目前共计有300门本科课程，研究生课程等，涵盖了经济和法律、医学、教育和艺术、工程和建筑环境、以及信息科学与技术等五大方面。</span></p>";
        moreView.setHtmlContent(str);
//        String str = "1月8日，中共中央总书记、国家主席习近平同当日抵京对中国进行访问的朝鲜劳动党委员长、国务委员会委员长金正恩举行会谈。两国领导人在亲切友好的气氛中，就中朝关系和共同关心的问题深入交换意见，达成重要共识。双方一致表示，愿共同努力推动中朝关系在新的时期不断取得新的发展，持续推进半岛问题政治解决进程，更好造福两国人民，为地区和世界和平稳定与繁荣发展作出积极贡献。";
//        moreView.setContent(str);
    }
}
