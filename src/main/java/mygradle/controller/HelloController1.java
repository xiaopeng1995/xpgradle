package mygradle.controller;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;


/**
 * Created by miaorf on 2016/6/19.
 */
@RestController
public class HelloController1 {
    @RequestMapping(value = "/NYControl/servlet/GetSBP", method = RequestMethod.GET)
    public String test(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getRequestURL());
        Map<String, String> urlkeydare = URLRequest(request.getQueryString());
        System.out.println(urlkeydare);
        response.setHeader("Accept-Charset", "big5, big5-hkscs, compound_text, euc-jp, euc-kr, gb18030, gb2312, gbk, ibm-thai, ibm00858, ibm01140, ibm01141, ibm01142, ibm01143, ibm01144, ibm01145, ibm01146, ibm01147, ibm01148, ibm01149, ibm037, ibm1026, ibm1047, ibm273, ibm277, ibm278, ibm280, ibm284, ibm285, ibm297, ibm420, ibm424, ibm437, ibm500, ibm775, ibm850, ibm852, ibm855, ibm857, ibm860, ibm861, ibm862, ibm863, ibm864, ibm865, ibm866, ibm868, ibm869, ibm870, ibm871, ibm918, iso-2022-cn, iso-2022-jp, iso-2022-jp-2, iso-2022-kr, iso-8859-1, iso-8859-13, iso-8859-15, iso-8859-2, iso-8859-3, iso-8859-4, iso-8859-5, iso-8859-6, iso-8859-7, iso-8859-8, iso-8859-9, jis_x0201, jis_x0212-1990, koi8-r, koi8-u, shift_jis, tis-620, us-ascii, utf-16, utf-16be, utf-16le, utf-32, utf-32be, utf-32le, utf-8, windows-1250, windows-1251, windows-1252, windows-1253, windows-1254, windows-1255, windows-1256, windows-1257, windows-1258, windows-31j, x-big5-hkscs-2001, x-big5-solaris, x-euc-jp-linux, x-euc-tw, x-eucjp-open, x-ibm1006, x-ibm1025, x-ibm1046, x-ibm1097, x-ibm1098, x-ibm1112, x-ibm1122, x-ibm1123, x-ibm1124, x-ibm1381, x-ibm1383, x-ibm33722, x-ibm737, x-ibm833, x-ibm834, x-ibm856, x-ibm874, x-ibm875, x-ibm921, x-ibm922, x-ibm930, x-ibm933, x-ibm935, x-ibm937, x-ibm939, x-ibm942, x-ibm942c, x-ibm943, x-ibm943c, x-ibm948, x-ibm949, x-ibm949c, x-ibm950, x-ibm964, x-ibm970, x-iscii91, x-iso-2022-cn-cns, x-iso-2022-cn-gb, x-iso-8859-11, x-jis0208, x-jisautodetect, x-johab, x-macarabic, x-maccentraleurope, x-maccroatian, x-maccyrillic, x-macdingbat, x-macgreek, x-machebrew, x-maciceland, x-macroman, x-macromania, x-macsymbol, x-macthai, x-macturkish, x-macukraine, x-ms932_0213, x-ms950-hkscs, x-ms950-hkscs-xp, x-mswin-936, x-pck, x-sjis_0213, x-utf-16le-bom, x-utf-32be-bom, x-utf-32le-bom, x-windows-50220, x-windows-50221, x-windows-874, x-windows-949, x-windows-950, x-windows-iso2022jp");
        String json = null;
        //判断 大区数
        if (urlkeydare.get("page").equals("0")) {
            json = "{\"ss\":[{\"id\":\"220002\",\"name\":\"官服-猫咪老师\",\"state\":2,\"url\":\"182.61.61.215:10099\",\"new\":1,\"desc\":\"欢迎来到猫咪老师游戏！\",\"s_id\":220002,\"time\":\"2017-03-07 11:55:20.0\",\"column\":2}],\"rsids\":[1,2,3]}";
        } else {
            json = "{\"ss\":[{\"id\":\"230122\",\"name\":\"喵喵电信\",\"state\":2,\"url\":\"183.60.227.46 :10099\",\"desc\":\"欢迎来到寻秦！\",\"s_id\":230122,\"new\":1,\"time\":\"2016-12-20 15:10:19.0\",\"column\":1},{\"id\":\"230016\",\"name\":\"喵咪114\",\"state\":2,\"url\":\"114.119.113.145:10099\",\"desc\":\"欢迎来到寻秦！\",\"s_id\":230016,\"new\":1,\"time\":\"2016-12-29 14:00:00.0\",\"column\":1},{\"id\":\"220002\",\"name\":\"官服-猫咪老师\",\"state\":2,\"url\":\"182.61.61.215:10099\",\"desc\":\"欢迎来到猫咪老师游戏！\",\"s_id\":220002,\"new\":1,\"time\":\"2017-01-04 10:02:37.0\",\"column\":1}]}";
        }
        String json1 = "{\"ss\":[{\"id\":\"230178\",\"name\":\"59服.猫咪老师\",\"state\":2,\"url\":\"182.61.61.215:10099\",\"new\":1,\"desc\":\"欢迎来到梦幻秦时!\",\"s_id\":230259,\"login_time\":1509809764,\"column\":3,\"role\":{\"level\":16,\"sex\":1,\"race\":3,\"faction\":5}},{\"id\":\"230179\",\"name\":\"60服.猫咪老师\",\"state\":2,\"url\":\"182.61.61.215:10099\",\"new\":1,\"desc\":\"欢迎来到梦幻秦时!\",\"s_id\":230260,\"column\":2}],\"rsids\":[1,2,3,10,11,12]}";
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "/NYControl/servlet/updatecheck", method = RequestMethod.GET)
    public String test2(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getRequestURL());
        System.out.println(request.getQueryString());

        response.setHeader("Accept-Charset", "big5, big5-hkscs, compound_text, euc-jp, euc-kr, gb18030, gb2312, gbk, ibm-thai, ibm00858, ibm01140, ibm01141, ibm01142, ibm01143, ibm01144, ibm01145, ibm01146, ibm01147, ibm01148, ibm01149, ibm037, ibm1026, ibm1047, ibm273, ibm277, ibm278, ibm280, ibm284, ibm285, ibm297, ibm420, ibm424, ibm437, ibm500, ibm775, ibm850, ibm852, ibm855, ibm857, ibm860, ibm861, ibm862, ibm863, ibm864, ibm865, ibm866, ibm868, ibm869, ibm870, ibm871, ibm918, iso-2022-cn, iso-2022-jp, iso-2022-jp-2, iso-2022-kr, iso-8859-1, iso-8859-13, iso-8859-15, iso-8859-2, iso-8859-3, iso-8859-4, iso-8859-5, iso-8859-6, iso-8859-7, iso-8859-8, iso-8859-9, jis_x0201, jis_x0212-1990, koi8-r, koi8-u, shift_jis, tis-620, us-ascii, utf-16, utf-16be, utf-16le, utf-32, utf-32be, utf-32le, utf-8, windows-1250, windows-1251, windows-1252, windows-1253, windows-1254, windows-1255, windows-1256, windows-1257, windows-1258, windows-31j, x-big5-hkscs-2001, x-big5-solaris, x-euc-jp-linux, x-euc-tw, x-eucjp-open, x-ibm1006, x-ibm1025, x-ibm1046, x-ibm1097, x-ibm1098, x-ibm1112, x-ibm1122, x-ibm1123, x-ibm1124, x-ibm1381, x-ibm1383, x-ibm33722, x-ibm737, x-ibm833, x-ibm834, x-ibm856, x-ibm874, x-ibm875, x-ibm921, x-ibm922, x-ibm930, x-ibm933, x-ibm935, x-ibm937, x-ibm939, x-ibm942, x-ibm942c, x-ibm943, x-ibm943c, x-ibm948, x-ibm949, x-ibm949c, x-ibm950, x-ibm964, x-ibm970, x-iscii91, x-iso-2022-cn-cns, x-iso-2022-cn-gb, x-iso-8859-11, x-jis0208, x-jisautodetect, x-johab, x-macarabic, x-maccentraleurope, x-maccroatian, x-maccyrillic, x-macdingbat, x-macgreek, x-machebrew, x-maciceland, x-macroman, x-macromania, x-macsymbol, x-macthai, x-macturkish, x-macukraine, x-ms932_0213, x-ms950-hkscs, x-ms950-hkscs-xp, x-mswin-936, x-pck, x-sjis_0213, x-utf-16le-bom, x-utf-32be-bom, x-utf-32le-bom, x-windows-50220, x-windows-50221, x-windows-874, x-windows-949, x-windows-950, x-windows-iso2022jp");
        String json1 = "{\"order\":\"0\",\"res2\":{\"url\":\"xq.hh108.com/hc/ailiyou/res/Resource2/10001/hc_bundle2_10001_20160805172944.zip\",\"ver\":\"10001\",\"must\":\"1\",\"size\":\"20487193\",\"type\":\"4\",\"md5\":\"f87b266ca6a33c3c1d9c2b2d27be4be1\"}}";
        if (request.getQueryString().contains("es_v2=0")) {
            json1 = "{\"order\":\"0\"}";
        }
        System.out.println(json1);
        return json1;
    }

    @RequestMapping(value = "/NYControl/servlet/LoginLog333", method = RequestMethod.GET)
    public String test4(HttpServletRequest request, HttpServletResponse response) {
        Random random = new Random();
        int result = random.nextInt(10) * random.nextInt(10) + random.nextInt(10) + random.nextInt(10) * random.nextInt(10);
        String json = result + "";
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "/NYControl/login/*", method = RequestMethod.GET)
    public String test5(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getRequestURL());
        System.out.println(request.getQueryString());
        Map<String, String> urlkeydare = URLRequest(request.getQueryString());
        String uin = urlkeydare.get("uin");
        String json = get("http://gdv1.mhjqb.jinkehc.com:8080/NYControl/login/yijieguandu?os=2&sdk=EE76A3092912D890&sub=maxvip&app=E2AFC9D1292B0500&uin=" + urlkeydare.get("uin") + "&sess=OWNjNTFjNWM0NzZlN2Q2ODFhZTg2OWMzZWQwNDNmZDg&", null);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "/NYControl/servlet/GetUpdateNoticeServlet", method = RequestMethod.GET)
    public String test6(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> urlkeydare = URLRequest(request.getQueryString());
        String json = "{\"notice_dt\":\"2017年11月16日\",\"popup\":1,\"content\":\"#000000删档内测公告：\\r\\n《梦幻猫咪》将于11月16日12：00~11月22日18：00开启删档内测，凡是在内测中充值的玩家，公测时不仅全额返还充值，还可以额外享受双倍返利\\r\\n\\r\\n福利介绍：\\r\\n#FF0000\\r\\n1、充值比例1：1000，首次充值双倍水玉返还\\r\\n2、上线即送至尊VIP（满V），28888水玉，999W银币\\r\\n3、首充赠送神兽、40级无级别极品武器，40级橙色套装\\r\\n4、每日活跃送水玉，40、100活跃分别可领取500、1000水玉\\r\\n5、七日登录奖励大幅提升，次日送珍兽，五日送坐骑，7天累计10000水玉\\r\\n7、等级礼包奖励升级，靓丽时装免费送，累计可领取12万水玉\\r\\n8.战力争霸赛：战力第一获得战力第一礼包，内含紫兽*1、80无级别红色衣服*1\\r\\n9.最强帮派：争夺最强帮派后，整个帮的所有成员都将获得丰厚奖励，职位越高，奖励越好\\r\\n10.全服冲级：欢乐冲级拿水玉，50万元宝等你来拿!等级第一获得水玉*500000，第二获得水玉*200000，第三获得水玉*100000\\r\\n\\r\\n#000000防盗防骗提醒\\r\\n#FF0000为保障玩家账号安全，官方不推荐任何形式的线下交易，任何线下交易均存在安全隐患，尽量避免您的利益受到损失。请您不要轻易相信线下交易行为，感谢您的配合，祝您游戏愉快。\\r\\n\",\"end_time\":3910156,\"show_time\":100000}";
        System.out.println(json);
        return json;
    }

    /**
     * 解析出url参数中的键值对
     * 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
     *
     * @param URL url地址
     * @return url请求参数部分
     */
    public static Map<String, String> URLRequest(String URL) {
        Map<String, String> mapRequest = new HashMap<String, String>();

        String[] arrSplit = null;

        String strUrlParam = URL;
        if (strUrlParam == null) {
            return mapRequest;
        }
        //每个键值为一组 www.2cto.com
        arrSplit = strUrlParam.split("[&]");
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");

            //解析出键值
            if (arrSplitEqual.length > 1) {
                //正确解析
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

            } else {
                if (arrSplitEqual[0] != "") {
                    //只有参数没有值，不加入
                    mapRequest.put(arrSplitEqual[0], "");
                }
            }
        }
        return mapRequest;
    }

    public String get(String url, Map<String, String> headers) {
        HttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        String response;
        if (headers != null) {
            Set<String> keys = headers.keySet();
            for (String key : keys) {
                get.addHeader(key, headers.get(key));

            }
        }
        try {
            HttpResponse httpResponse = client.execute(get);
            InputStream inStream = httpResponse.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "utf-8"));
            StringBuilder strber = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null)
                strber.append(line).append("\n");
            inStream.close();
            response = strber.toString();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
        return response;
    }
}