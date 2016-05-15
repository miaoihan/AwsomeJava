package commonUnit;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.trs.gab.beans.AppPhrasseDataResult;
import com.trs.gab.beans.DicDataModel;

import sun.misc.UCEncoder;
/**
 * 时间工具类
 *
 */
public class DateUtil {

    /**
     * 返回数据库中以'YYYY-MM-DD HH24:MI:SS'格式表示当前时间的字符串
     * 用法:to_date(?,'YYYY-MM-DD HH24:MI:SS')
     * ?设置strNowtime
     * @return
     */
    public static String getNowTimeStr(){
        Calendar m_cal = Calendar.getInstance();
        String strNowtime = m_cal.get(Calendar.YEAR) + "-"
                + (m_cal.get(Calendar.MONTH) + 1) + "-"
                + m_cal.get(Calendar.DAY_OF_MONTH) + " "
                + m_cal.get(Calendar.HOUR_OF_DAY) + ":"
                + m_cal.get(Calendar.MINUTE) + ":" + m_cal.get(Calendar.SECOND);
        return strNowtime;
    }

    /**
     * 获得当前时间，格式yyyy-MM-dd hh:mm:ss
     *
     * @param format
     * @return
     */
    public static String getCurrentDateTime() {
        return getCurrentDate("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获得当前时间，格式自定义
     *
     * @param format
     * @return
     */
    public static String getCurrentDate(String format) {
        Calendar day = Calendar.getInstance();
        day.add(Calendar.DATE, 0);
        SimpleDateFormat sdf = new SimpleDateFormat(format);// "yyyy-MM-dd"
        String date = sdf.format(day.getTime());
        return date;
    }

    /**
     * 获得昨天时间，格式自定义
     *
     * @param format
     * @return
     */
    public static String getYesterdayDate(String format) {
        Calendar day = Calendar.getInstance();
        day.add(Calendar.DATE, -1);
        SimpleDateFormat sdf = new SimpleDateFormat(format);// "yyyy-MM-dd"
        String date = sdf.format(day.getTime());
        return date;
    }

    /**
     * @param date1
     *            需要比较的时间 不能为空(null),需要正确的日期格式 ,如：2009-09-12
     * @param date2
     *            被比较的时间 为空(null)则为当前时间
     * @param stype
     *            返回值类型 0为多少天，1为多少个月，2为多少年
     * @return 举例： compareDate("2009-09-12", null, 0);//比较天
     *         compareDate("2009-09-12", null, 1);//比较月
     *         compareDate("2009-09-12", null, 2);//比较年
     */
    public static int compareDate(String startDay, String endDay, int stype) {
        int n = 0;
        String[] u = { "天", "月", "年" };
        String formatStyle = stype == 1 ? "yyyy-MM" : "yyyy-MM-dd";

        endDay = endDay == null ? getCurrentDate("yyyy-MM-dd") : endDay;

        DateFormat df = new SimpleDateFormat(formatStyle);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(df.parse(startDay));
            c2.setTime(df.parse(endDay));
        } catch (Exception e3) {
            System.out.println("wrong occured");
        }
        // List list = new ArrayList();
        while (!c1.after(c2)) { // 循环对比，直到相等，n 就是所要的结果
            // list.add(df.format(c1.getTime())); // 这里可以把间隔的日期存到数组中 打印出来
            n++;
            if (stype == 1) {
                c1.add(Calendar.MONTH, 1); // 比较月份，月份+1
            } else {
                c1.add(Calendar.DATE, 1); // 比较天数，日期+1
            }
        }
        n = n - 1;
        if (stype == 2) {
            n = (int) n / 365;
        }
        // System.out.println(startDay+" -- "+endDay+" 相差多少"+u[stype]+":"+n);
        return n;
    }

    /**
     * 判断时间是否符合时间格式
     */
    public static boolean isLegalDateString(String date, String dateFormat) {
        if (date != null) {
            java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
                    dateFormat);
            format.setLenient(false);
            try {
                format.format(format.parse(date));
            } catch (ParseException e) {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * 实现给定某日期，判断是星期几 date:必须yyyy-MM-dd格式
     */
    public static String getWeekday(String date) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdw = new SimpleDateFormat("E");
        Date d = null;
        try {
            d = sd.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdw.format(d);
    }

    /**
     * 用来全局控制 上一周，本周，下一周的周数变化
     */
    private static int weeks = 0;

    /**
     * 获得当前日期与本周一相差的天数
     */
    private static int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1)
            return -6;
        else
            return 2 - dayOfWeek;
    }

    /**
     * 获得本周星期一的日期
     */
    public static String getCurrentMonday(String format) {
        weeks = 0;
        int mondayPlus = getMondayPlus();
        Calendar currentDate = Calendar.getInstance();
        currentDate.add(Calendar.DATE, mondayPlus);
        SimpleDateFormat sdf = new SimpleDateFormat(format);// "yyyy-MM-dd"
        String date = sdf.format(currentDate.getTime());
        return date;
    }

    /**
     * 获得上周星期一的日期
     */
    public static String getPreviousMonday(String format) {
        weeks--;
        int mondayPlus = getMondayPlus();
        Calendar currentDate = Calendar.getInstance();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);
        SimpleDateFormat sdf = new SimpleDateFormat(format);// "yyyy-MM-dd"
        String date = sdf.format(currentDate.getTime());
        return date;
    }

    /**
     * 获得下周星期一的日期
     */
    public static String getNextMonday(String format) {
        weeks++;
        int mondayPlus = getMondayPlus();
        // GregorianCalendar currentDate = new GregorianCalendar();
        Calendar currentDate = Calendar.getInstance();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);
        SimpleDateFormat sdf = new SimpleDateFormat(format);// "yyyy-MM-dd"
        String date = sdf.format(currentDate.getTime());
        return date;
    }

    /**
     * 获得相应周的周日的日期 此方法必须写在getCurrentMonday，getPreviousMonday或getNextMonday方法之后
     */
    public static String getSunday(String format) {
        int mondayPlus = getMondayPlus();
        Calendar currentDate = Calendar.getInstance();
        currentDate.add(Calendar.DATE, mondayPlus + 7 * weeks + 6);
        SimpleDateFormat sdf = new SimpleDateFormat(format);// "yyyy-MM-dd"
        String date = sdf.format(currentDate.getTime());
        return date;
    }

    /**
     * method 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp）
     *
     * @param dateString
     *            需要转换为timestamp的字符串
     * @return dataTime timestamp
     */
    public final static java.sql.Timestamp string2Time(String dateString) {
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);// 设定格式
        dateFormat.setLenient(false);
        java.util.Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // java.sql.Timestamp dateTime = new java.sql.Timestamp(date.getTime());
        return new java.sql.Timestamp(date.getTime());// Timestamp类型,timeDate.getTime()返回一个long型
    }

    /**
     * method 将字符串类型的日期转换为一个Date（java.sql.Date）
     *
     * @param dateString
     *            需要转换为Date的字符串
     * @return dataTime Date
     */
    public final static java.sql.Date string2Date(String dateString) {
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        dateFormat.setLenient(false);
        java.util.Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // java.sql.Date dateTime = new java.sql.Date(date.getTime());// sql类型
        return new java.sql.Date(date.getTime());
    }

    // 记录考勤， 记录迟到、早退时间
    public static String getState() {
        String state = "正常";
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date d = new Date();
        try {
            Date d1 = df.parse("08:00:00");
            Date d2 = df.parse(df.format(d));
            Date d3 = df.parse("18:00:00");

            int t1 = (int) d1.getTime();
            int t2 = (int) d2.getTime();
            int t3 = (int) d3.getTime();
            if (t2 < t1) {

                long between = (t1 - t2) / 1000;// 除以1000是为了转换成秒
                long hour1 = between % (24 * 3600) / 3600;
                long minute1 = between % 3600 / 60;

                state = "迟到 ：" + hour1 + "时" + minute1 + "分";

            } else if (t2 < t3) {
                long between = (t3 - t2) / 1000;// 除以1000是为了转换成秒
                long hour1 = between % (24 * 3600) / 3600;
                long minute1 = between % 3600 / 60;
                state = "早退 ：" + hour1 + "时" + minute1 + "分";
            }
            return state;
        } catch (Exception e) {
            return state;
        }

    }

    /**
     * 数值型的时间改为字符串型时间
     *
     * @param time
     * @return
     */
    public static String getTime(long time) {
        try {
            Date date = new Date(time);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//
            String strdate = sdf.format(date);
            return strdate;
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    /**
     * 传入"yyyy-MM-dd HH:mm:ss"格式字符串,传出从1970 年~~~  至dateString表示时刻之间的ms。
     * @return
     */
    public static long getTimeMillis(String dateString){
        long timeMillis = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date= sdf.parse(dateString);
            timeMillis = date.getTime();
        } catch (ParseException e) {
        }
        return timeMillis;
    }

    /**
     * 获得后N天的时间，格式自定义
     *
     * @param format
     * @return
     */
    public static String getDelayDayDate(String format,int delay) {
        Calendar day = Calendar.getInstance();
        day.add(Calendar.DATE, delay);
        SimpleDateFormat sdf = new SimpleDateFormat(format);// "yyyy-MM-dd"
        String date = sdf.format(day.getTime());
        return date;
    }

    /**
     * 获得后N小时的时间，格式自定义
     * @param format
     * @param delay
     * @return
     */
    public static String getDelayHourDate(String format,int delay){
        Calendar day = Calendar.getInstance();
        day.add(Calendar.HOUR, delay);
        SimpleDateFormat sdf = new SimpleDateFormat(format);// "yyyy-MM-dd"
        String date = sdf.format(day.getTime());
        return date;
    }

    /**
     * @param date1
     *            需要比较的时间 不能为空(null),需要正确的日期格式 ,如：2009-09-12 16:24
     * @param date2
     *            被比较的时间 为空(null)则为当前时间
     * @param stype 0为比较小时，1为比较分钟。
     * @return
     */
    public static int compareTime(String startDay, String endDay,int stype) {
        int n = 0;
        String formatStyle = "yyyy-MM-dd HH:mm";

        endDay = endDay == null ? getCurrentDate("yyyy-MM-dd HH:mm") : endDay;

        DateFormat df = new SimpleDateFormat(formatStyle);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(df.parse(startDay));
            c2.setTime(df.parse(endDay));
        } catch (Exception e3) {
            System.out.println("wrong occured");
        }
        // List list = new ArrayList();
        while (!c1.after(c2)) { // 循环对比，直到相等，n 就是所要的结果
            // list.add(df.format(c1.getTime())); // 这里可以把间隔的日期存到数组中 打印出来
            n++;
            if(stype == 0){
                c1.add(Calendar.HOUR, 1); // 比较月份，月份+1
            }else{
                c1.add(Calendar.MINUTE, 1); // 比较月份，月份+1
            }
        }
        n = n - 1;
        return n;
    }
    /**
     * 获取词典（牛津英汉词典）音标的信息
     */
    public static String getYin(String content)
    {
        String result="";
        String reg="<font color=([\"'])#F17D1F([\"']) size=4>(?:.*?)</font>";
        //String str="<td class=\"longtd\" title=\"VRBZ3\">VRBZ3</td>";
        String str="<font color=red>china</font><font color=green>china</font>";
        Pattern p=Pattern.compile(reg);
        Matcher m=p.matcher(content);
        int i=1;
        while(m.find()){
            System.out.println(m.group(0));
            result=result+"<br>"+"<font color=#F17D1F>"+i+"</font>"+m.group(0).replaceAll("size=4", "style=\"font-family:Arial Unicode Ms\";");
            i++;
        }
        if(i==2)
        {
            String r="<font color=#F17D1F>";
            int x=result.indexOf(r);
            result=result.substring(x+r.length()+1);
        }
        return result;
    }
    /**
     * 获取词典（字典）中的信息、
     */
    public static String getFont(String content)
    {
        String result="";
        String reg="(?:.*?)<br>";
        //String str="<td class=\"longtd\" title=\"VRBZ3\">VRBZ3</td>";
        String str="你<br>nǐ<br>称对方，多称指一个人，有时也指称若干人：你厂。你方。<br>泛指任何人：你死我活。<br>您<br><br>笔画数：7；<br>部首：亻；<br>笔顺编号：3235234<br><br><br>";
        Pattern p=Pattern.compile(reg);
        Matcher m=p.matcher(content);
        int i=1;
        while(m.find()){
            System.out.println(m.group(0));
            if(!m.group(0).equals("<br>"))
            {
                result=result+i+"、   "+m.group(0);
                i++;
            }

        }

        return result;
    }
    public static String getDemo(String color,String content)
    {
        String result="";
        String reg="<font color="+color+">(?:.*?)</font>";
        //String str="<td class=\"longtd\" title=\"VRBZ3\">VRBZ3</td>";
        String str="<font color=red>china</font><font color=green>china</font>";
        Pattern p=Pattern.compile(reg);
        Matcher m=p.matcher(content);

        if(color.equals("blue"))
        {
            int i=1;
            while(m.find()){
                System.out.println(m.group(0));
                result=result+"<br> <font color=blue>"+i+" </font>"+m.group(0).replaceAll("size=4", "");
                i++;
            }
        }
        else
        {


            while(m.find()){
                System.out.println(m.group(0));
                result=result+"<br>"+m.group(0).replaceAll("size=4", "");

            }

        }
        return result;
    }
    public static String getUse(String content)
    {
        String result="";
        String reg="</font>(?:.*?)<br>";
        //String str="<td class=\"longtd\" title=\"VRBZ3\">VRBZ3</td>";
        String str="<font color=red>china</font><font color=green>china</font>";
        Pattern p=Pattern.compile(reg);
        Matcher m=p.matcher(content);


        while(m.find()){
            System.out.println(m.group(0));
            result=result+m.group(0).replaceAll("size=4", "");

        }


        return result;
    }
    public static String[] getContent(String content,String prefex)
    {
        String result[]=new String[3];
        String reg=prefex+"(?:.*?)</div>";
        //String str="<td class=\"longtd\" title=\"VRBZ3\">VRBZ3</td>";
        String str="<font color=red>china</font><font color=green>china</font>";
        Pattern p=Pattern.compile(reg);
        Matcher m=p.matcher(content);

        int count=0;
        while(m.find()){
            if(count<3)
            {
                result[count]=m.group(0);
            }
            count++;
        }

        return result;
    }
    public static boolean getContent(String content,String prefex,String reg)
    {
        boolean result=false;
        Pattern p=Pattern.compile(reg);
        Matcher m=p.matcher(content);


        while(m.find()){

            result=true;
        }
        return result;
    }
    public static String getC(String content,String prefex)
    {
        System.out.println("未处理的t内容"+content);
        int start=content.indexOf(prefex);
        String result="";
        if(start!=-1)
        {
            result=content.substring(start, content.length()-1);
            return result.replaceAll("</div>","")+"</div>";
        }
        else
        {
            result=content;
            return result;
        }



    }
    public static String getContent(String content)
    {
        String s_content[]=new String[2];
        for(int i=0;i<2;i++)
        {
            s_content[i]=content;
        }
        String v=getContent(s_content[0],"<div id=v>")[0];

        String c=getContent(s_content[1],"<div id=c>")[0];
        if(!getContent(c, "<div id=c>", "[\u4E00-\u9FA5]"))
        {
            c=getC(s_content[1],"<div id=c>");
        }
        return c+v;
    }

    public static String replaceTag(String content)
    {
        return content.replaceAll("<br>", " ").replaceAll("bword://", "").replaceAll("\\\\n", "").replaceAll("<img.*>.*</img>","").replaceAll("<img.*/>","");
    }
    /**
     * 获取现在时间
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("M月d日");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    public static String getNum(String content)
    {
        String result="";
        String reg="(?:.*?)。";

        //String str="<td class=\"longtd\" title=\"VRBZ3\">VRBZ3</td>";
        String str="（１）在体积、面积、数量、力量、强度等方面不及一般的或不及比较的对象（跟‘大’相对）：～河｜鞋～了点儿｜我比你～一岁｜声音太～。（２）短时间地：～坐｜～住。（３）排行最末的：～儿子｜他是我的～弟弟。（４）年纪小的人：一家大～｜上有老，下有～。（５）指妾①。（６）谦辞，称自己或与自己有关的人或事物：～弟｜～店。 …小白菜＠（～ ";
        Pattern p=Pattern.compile(reg);
        Matcher m=p.matcher(content);


        while(m.find()){
            if(m.group(0).length()>3)
            {
                System.out.println(m.group(0));
                result=result+m.group(0)+"<br>";
            }
            else
            {
                result=content;
            }
        }
        if(result.length()==0)
        {
            result=content;
        }

        return result;
    }
    /**
     * @param args
     * @return
     * @return
     */
    public static String getContentSource(String contentSource,String tag,String tagId,int wordSize)
    {
        Document doc;
        String linkText="";
        //System.out.println("未处理的文本内容:"+contentSource);
        try {
            doc = Jsoup.parse(contentSource);

            Element content = doc.getElementById(tagId);
            if(content!=null){
                Elements texts = content.select(tag + "[id=" + tagId + "]");
                for (Element link : texts) {

                    linkText = linkText + link.text();
                }
            }
            else
            {
                Element t = doc.getElementById("t");
                if(t!=null){
                    Elements texts = t.select("div[id=t]");
                    for (Element link : texts) {

                        linkText = linkText + link.text();
                    }
                }
                else
                {
                    linkText=contentSource;
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        //System.out.println("得到的文本内容："+linkText);
        if(linkText.length()>300)
        {
            linkText=linkText.substring(0, wordSize)+"...";
        }
        return linkText;
    }

    public static String getContentText(String contentSource,String tag,String tagId)
    {
        Document doc;
        String linkText="";
        //System.out.println("未处理的文本内容:"+contentSource);
        try {
            doc = Jsoup.parse(contentSource);

            Element content = doc.getElementById(tagId);
            if(content!=null){
                Elements texts = content.select(tag + "[id=" + tagId + "]");
                for (Element link : texts) {

                    linkText = linkText + link.text();
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        //System.out.println("得到的文本内容："+linkText);
        return linkText;
    }
    /**
     * 得到div id=m的内容
     * @param contentSource
     * @param tag
     * @param tagId
     * @return
     */
    public static String getContentSourceOfm(String contentSource,String tag,String tagId)
    {
        Document doc;
        String linkText="";
        //System.out.println("未处理的文本内容:"+contentSource);
        try {
            doc = Jsoup.parse(contentSource);

            Element content = doc.getElementById(tagId);
            if(content!=null){
                Elements texts = content.select(tag + "[id=" + tagId + "]");
                for (Element link : texts) {

                    linkText = linkText + link.text();
                }
            }
            else
            {
                Element t = doc.getElementById("t");
                if(t!=null){
                    Elements texts = t.select("div[id=t]");
                    for (Element link : texts) {

                        linkText = linkText + link.text();
                    }
                }
                else
                {
                    linkText=contentSource;
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        //System.out.println("得到的文本内容："+linkText);
        if(linkText.length()>300)
        {
            linkText=linkText.substring(0, 300)+"...";
        }
        return linkText;
    }
    public static boolean isHasRelativeWordlink(String content,String tag)
    {
        if(content.contains(tag))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * 得到相关词条的解释
     * @param content
     * @param request
     * @param tag
     * @return
     */
    public static String getRelativeWordlink(String content,HttpServletRequest request,String tag)
    {
        String param[]=content.split(tag);
        //URLEncoder encoder=null;


        content="参考词条：<a href="+request.getContextPath()+"/baikeSearchRelative.trs?searchWord="+param[1].replaceAll("\\\\n", "")+"  target=\"_blank\">"+param[1].replaceAll("\\\\n", "")+"</a>";
        return content;
    }

    /**
     * 得到相关词条的解释
     * @param content
     * @param request
     * @param tag
     * @return
     */
    public static DicDataModel getRelativeWordContent(String content,String tag,int type)
    {


        String param[]=content.split(tag);
        //URLEncoder encoder=null;
        DicDataModel dataModel=null;

        AppPhrasseDataResult appPhrasseDataResult=null;

        appPhrasseDataResult=new AppPhrasseDataResult();

        try {
            dataModel=appPhrasseDataResult.getBaikeInfo("TB_BAIKE", "name="+param[1].replaceAll("\\\\n", ""));
        } catch (Exception e) {

            e.printStackTrace();
        }
        if(type==0)
        {
            dataModel.setContent(DateUtil.getContentSource(dataModel.getContent(), "", "c",300),new Boolean("true"));
        }
        else
        {

            dataModel.setContent(dataModel.getContent(),new Boolean("true"));

        }
        return dataModel;
    }
    /**
     * 将相关词条添加到字符串数组中
     * @param contentSource
     * @param request
     * @return
     */
    public static String[] getRelativeWordlink(String contentSource,HttpServletRequest request)
    {Document doc;
        String relativeWord[]=null;
        int count=0;
        try {
            doc = Jsoup.parse(contentSource);

            Element content = doc.getElementById("m");
            //Elements links = content.getElementsByTag("td");
            if(content!=null){
                Elements links = content.select("a");
                relativeWord=new String[links.size()];
                for (Element link : links) {

                    String linkText = link.text();

                    if(linkText.contains("@"))
                    {
                        relativeWord[count]=linkText;
                    }
                    count++;
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return relativeWord;
    }
    /**
     * 将相关词条的细缆页链接加上
     * @param content
     * @param relativeWord
     * @param request
     * @return
     */
    public static String replaceRelativeWord(String content,String relativeWord[],HttpServletRequest request)
    {
        for(int i=0;i<relativeWord.length;i++)
        {   String c=relativeWord[i];
            if(StringUtils.isNotEmpty(c))
            {
                String r=relativeWord[i].substring(1);
                content=content.replaceFirst(r, request.getContextPath()+"/baikeSearchRelative.trs?searchWord="+r);
            }
        }
        return content;
    }
    /**
     * 得到词条的目录链接：
     * 默认取前5条链接
     * @param content
     * @return
     */
    public static String getLink(String contentSource, String linkContent,int count,String tag) {
        Document doc;
        String linkText = "";
        try {
            doc = Jsoup.parse(contentSource);

            Element content = doc.getElementById(tag);
            if(content!=null){
                Elements links = content.select("p");

                int i=1;
                for (Element link : links) {
                    String href=getChildlink(link.outerHtml());
                    if(StringUtils.isNotEmpty(href))
                    {
                        linkText = linkText +"<p>"+href+"</p>";
                    }
                    if(i==count)
                    {
                        break;
                    }

                    i++;
                }
                /*if(i<count)
                {
                    linkText = linkText+getLinkOfm(linkContent, count-i,"m");
                }*/
            }

            else
            {
                linkText=contentSource;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return linkText;
    }
    /**
     * 链接的数量不足时增加m标签的内容
     * @param contentSource
     * @param linkContent
     * @param count
     * @param tag
     * @return
     */
    public static String getLinkOfm(String linkContent,int count,String tag) {
        Document doc;
        String linkText = "";
        try {
            doc = Jsoup.parse(linkContent);

            Element content = doc.getElementById(tag);
            if(content!=null){
                Elements links = content.select("p");

                int i=0;
                for (Element link : links) {
                    linkText = linkText +"<p>"+ getChildlink(link.outerHtml())+"</p>";
                    if(i==count)
                    {
                        break;
                    }

                    i++;
                }

            }

            else
            {
                linkText=linkContent;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return linkText;
    }
    /**
     * 获取链接的子链接的第一个链接
     * @param contentSource
     * @return
     */
    public static String getChildlink(String contentSource) {

        Document doc;
        String linkText = null;
        try {
            doc = Jsoup.parse(contentSource);

            Elements links = doc.select("a");
            if (links != null) {
                int i = 0;
                for (Element link : links) {
                    if (i == 0) {
                        linkText = link.outerHtml();
                    }
                    i++;
                }
            } else {
                linkText = contentSource;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return linkText;
    }
    public static int getNowTime(int type){
        Calendar m_cal = Calendar.getInstance();
        if(type==1)
        {
            return m_cal.get(Calendar.MONTH)+1;
        }
        else
            return m_cal.get(Calendar.DAY_OF_MONTH);
    }
    public static void main(String[] args) {

        System.out.println(getContentText("<div id=t><p></div>\n","div","t"));
    }

}