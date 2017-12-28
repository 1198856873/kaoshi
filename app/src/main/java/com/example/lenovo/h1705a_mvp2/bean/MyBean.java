package com.example.lenovo.h1705a_mvp2.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/26.
 */
public class MyBean {

    /**
     * state : true
     * more : true
     * time : 0
     * data : [{"contentid":11581,"modelid":1,"title":"全国大学生学习宣传贯彻党的十九大精神网络接力活动","thumb":"http://upload.univs.cn/2017/1130/thumb_160_120_1512009536371.png","description":"教育部思想政治工作司将指导中国大学生在线举办\u201c大学生点赞新时代\u201d全国大学生学习宣传贯彻党的十九大精神网络接力活动。现面向全国高校征集活动方案及特色作品，具体事项通知如下：","comments":0,"sorttime":1512034491},{"contentid":11859,"modelid":2,"title":"潍坊学院点赞十九大书法作品展","thumb":"http://upload.univs.cn/2017/1226/thumb_160_120_1514253390392.jpg","description":"文化兴则国运兴，文化强则民族强。潍坊学院大学生网络传媒中心为响应十九大报告中指出的\u201c坚定文化自信，推动社会主义文化繁荣兴盛\u201d的思想，举办了以\u201c不忘初心，砥砺前行\u2014\u2014感悟十九大\u201d为主","comments":0,"sorttime":1514255375},{"contentid":11858,"modelid":2,"title":"潍坊学院点赞十九大书法作品展","thumb":"http://upload.univs.cn/2017/1226/thumb_160_120_1514253390392.jpg","description":"文化兴则国运兴，文化强则民族强。潍坊学院大学生网络传媒中心为响应十九大报告中指出的\u201c坚定文化自信，推动社会主义文化繁荣兴盛\u201d的思想，举办了以\u201c不忘初心，砥砺前行\u2014\u2014感悟十九大\u201d为主","comments":0,"sorttime":1514254200},{"contentid":11829,"modelid":1,"title":"如何建好中教华影\u201c全国校园电影院线\u201d？教育部领导这样说","thumb":"http://upload.univs.cn/2017/1225/thumb_160_120_1514178299350.jpg","description":"2017年12月23日，由教育部思政司和国家新闻出版广电总局电影局主办的中教华影全国校园电影院线\u201c学习宣传贯彻十九大精神系列电影主题活动\u201d在清华大学大礼堂举行。教育部党组成员、部长助理郑富芝出席活动并讲话。","comments":0,"sorttime":1514178444},{"contentid":11826,"modelid":1,"title":"赣师大校园红色越野赛，百名学子重走长征路","thumb":"http://upload.univs.cn/2017/1225/thumb_160_120_1514169429841.jpeg","description":"2017年12月22日下午，赣南师范大学\u201c我们的长征\u201d第二届校园红色定向越野比赛在青春广场举行。来自红色文化学院的\u201c肖华班\u201d\u201c瑞昌班\u201d\u201c兴国班\u201d等15个红色班级的150余名选手参加了本次比赛。","comments":0,"sorttime":1514169578},{"contentid":11824,"modelid":1,"title":"中教华影全国校园电影院线助力学习宣传贯彻十九大精神","thumb":"http://upload.univs.cn/2017/1224/thumb_160_120_1514085595313.jpg","description":"2017年12月23日，中教华影\u201c全国校园电影院线\u201d在清华大学大礼堂举行了\u201c牢记青春使命，书写人生华章\u2014\u2014学习宣传贯彻十九大精神系列电影主题活动\u201d。","comments":0,"sorttime":1514086378},{"contentid":11788,"modelid":4,"title":"大学生点赞新时代：清华嘻哈单曲《水木道》震撼来袭！","thumb":"http://upload.univs.cn/2017/1220/thumb_160_120_1513743274395.png","description":"清华有嘻哈！清华首支学生原创中国风嘻哈单曲《水木道》震撼来袭！\u201c西山苍苍东海茫，四海填八荒，水清木华坐中央，血脉承炎黄！\u201d《水木道》告诉你，爱国爱校可以这样酷！","comments":0,"sorttime":1513743303},{"contentid":11779,"modelid":1,"title":"海大研究生党员骨干训练营教你工作技能","thumb":"http://upload.univs.cn/2017/1219/thumb_160_120_1513645392240.jpg","description":"12月14日下午，由中国海洋大学党委研究生工作部主办的第十届\u201c行远先锋\u201d研究生党员骨干训练营闭营仪式暨研究生党支部书记工作技能展示大赛在大学生活动中心多功能厅举办。","comments":0,"sorttime":1513645796},{"contentid":11778,"modelid":1,"title":"纪录片《有个学校叫南开》在央视播出","thumb":"http://upload.univs.cn/2017/1219/thumb_160_120_1513645589348.jpg","description":"12月18日20时，历史人文纪录片《有个学校叫南开》将于中央电视台纪录频道隆重推出。","comments":0,"sorttime":1513645782},{"contentid":11777,"modelid":1,"title":"\u201c光音依然\u201d郑祖光琵琶专场音乐会南开举行","thumb":"http://upload.univs.cn/2017/1219/thumb_160_120_1513645700483.jpg","description":"\u201c光音依然\u201d郑祖光琵琶专场音乐会南开举行","comments":0,"sorttime":1513645768}]
     */

    private boolean state;
    private boolean more;
    private int time;
    private List<DataBean> data;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * contentid : 11581
         * modelid : 1
         * title : 全国大学生学习宣传贯彻党的十九大精神网络接力活动
         * thumb : http://upload.univs.cn/2017/1130/thumb_160_120_1512009536371.png
         * description : 教育部思想政治工作司将指导中国大学生在线举办“大学生点赞新时代”全国大学生学习宣传贯彻党的十九大精神网络接力活动。现面向全国高校征集活动方案及特色作品，具体事项通知如下：
         * comments : 0
         * sorttime : 1512034491
         */

        private int contentid;
        private int modelid;
        private String title;
        private String thumb;
        private String description;
        private int comments;
        private int sorttime;

        public int getContentid() {
            return contentid;
        }

        public void setContentid(int contentid) {
            this.contentid = contentid;
        }

        public int getModelid() {
            return modelid;
        }

        public void setModelid(int modelid) {
            this.modelid = modelid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }

        public int getSorttime() {
            return sorttime;
        }

        public void setSorttime(int sorttime) {
            this.sorttime = sorttime;
        }
    }
}
