package mygradle.controller;


import mygradle.base.entity.Tokeninfo;
import mygradle.dao.ServerDao;
import mygradle.dao.TokenDao;
import mygradle.dao.UserDao;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


/**
 * Created by xiaopeng on 2017/11/15.
 */
@RestController
public class GmController {
    @Autowired
    UserDao userDao;
    @Autowired
    TokenDao tokenDao;
    @Autowired
    ServerDao serverDao;

    @RequestMapping(value = "/XQCenter/servlet/GetSBP", method = RequestMethod.GET)
    public String test(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getRequestURL());
        Map<String, String> urlkeydare = URLRequest(request.getQueryString());
        System.out.println(urlkeydare);
        response.setHeader("Accept-Charset", "big5, big5-hkscs, compound_text, euc-jp, euc-kr, gb18030, gb2312, gbk, ibm-thai, ibm00858, ibm01140, ibm01141, ibm01142, ibm01143, ibm01144, ibm01145, ibm01146, ibm01147, ibm01148, ibm01149, ibm037, ibm1026, ibm1047, ibm273, ibm277, ibm278, ibm280, ibm284, ibm285, ibm297, ibm420, ibm424, ibm437, ibm500, ibm775, ibm850, ibm852, ibm855, ibm857, ibm860, ibm861, ibm862, ibm863, ibm864, ibm865, ibm866, ibm868, ibm869, ibm870, ibm871, ibm918, iso-2022-cn, iso-2022-jp, iso-2022-jp-2, iso-2022-kr, iso-8859-1, iso-8859-13, iso-8859-15, iso-8859-2, iso-8859-3, iso-8859-4, iso-8859-5, iso-8859-6, iso-8859-7, iso-8859-8, iso-8859-9, jis_x0201, jis_x0212-1990, koi8-r, koi8-u, shift_jis, tis-620, us-ascii, utf-16, utf-16be, utf-16le, utf-32, utf-32be, utf-32le, utf-8, windows-1250, windows-1251, windows-1252, windows-1253, windows-1254, windows-1255, windows-1256, windows-1257, windows-1258, windows-31j, x-big5-hkscs-2001, x-big5-solaris, x-euc-jp-linux, x-euc-tw, x-eucjp-open, x-ibm1006, x-ibm1025, x-ibm1046, x-ibm1097, x-ibm1098, x-ibm1112, x-ibm1122, x-ibm1123, x-ibm1124, x-ibm1381, x-ibm1383, x-ibm33722, x-ibm737, x-ibm833, x-ibm834, x-ibm856, x-ibm874, x-ibm875, x-ibm921, x-ibm922, x-ibm930, x-ibm933, x-ibm935, x-ibm937, x-ibm939, x-ibm942, x-ibm942c, x-ibm943, x-ibm943c, x-ibm948, x-ibm949, x-ibm949c, x-ibm950, x-ibm964, x-ibm970, x-iscii91, x-iso-2022-cn-cns, x-iso-2022-cn-gb, x-iso-8859-11, x-jis0208, x-jisautodetect, x-johab, x-macarabic, x-maccentraleurope, x-maccroatian, x-maccyrillic, x-macdingbat, x-macgreek, x-machebrew, x-maciceland, x-macroman, x-macromania, x-macsymbol, x-macthai, x-macturkish, x-macukraine, x-ms932_0213, x-ms950-hkscs, x-ms950-hkscs-xp, x-mswin-936, x-pck, x-sjis_0213, x-utf-16le-bom, x-utf-32be-bom, x-utf-32le-bom, x-windows-50220, x-windows-50221, x-windows-874, x-windows-949, x-windows-950, x-windows-iso2022jp");
        String json = null;
        String channel = "maxvip";
        if (urlkeydare.get("channel") != null) {
            channel = urlkeydare.get("channel").toString();
        }
        //判断 大区数
        if (urlkeydare.get("page").equals("0")) {
            json = serverDao.findbyname("server0",channel).get(0).getServer();
        } else {
            String ss = urlkeydare.get("page");
            json = serverDao.findbyname("server" + ss,channel).get(0).getServer();
        }
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "/a/XQCenter/servlet/updatecheck", method = RequestMethod.GET)
    public String test2(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getRequestURL());
        System.out.println(request.getQueryString());
        String xzdz = getPropertiesConfiguration().getString("xzdz");
        response.setHeader("Accept-Charset", "big5, big5-hkscs, compound_text, euc-jp, euc-kr, gb18030, gb2312, gbk, ibm-thai, ibm00858, ibm01140, ibm01141, ibm01142, ibm01143, ibm01144, ibm01145, ibm01146, ibm01147, ibm01148, ibm01149, ibm037, ibm1026, ibm1047, ibm273, ibm277, ibm278, ibm280, ibm284, ibm285, ibm297, ibm420, ibm424, ibm437, ibm500, ibm775, ibm850, ibm852, ibm855, ibm857, ibm860, ibm861, ibm862, ibm863, ibm864, ibm865, ibm866, ibm868, ibm869, ibm870, ibm871, ibm918, iso-2022-cn, iso-2022-jp, iso-2022-jp-2, iso-2022-kr, iso-8859-1, iso-8859-13, iso-8859-15, iso-8859-2, iso-8859-3, iso-8859-4, iso-8859-5, iso-8859-6, iso-8859-7, iso-8859-8, iso-8859-9, jis_x0201, jis_x0212-1990, koi8-r, koi8-u, shift_jis, tis-620, us-ascii, utf-16, utf-16be, utf-16le, utf-32, utf-32be, utf-32le, utf-8, windows-1250, windows-1251, windows-1252, windows-1253, windows-1254, windows-1255, windows-1256, windows-1257, windows-1258, windows-31j, x-big5-hkscs-2001, x-big5-solaris, x-euc-jp-linux, x-euc-tw, x-eucjp-open, x-ibm1006, x-ibm1025, x-ibm1046, x-ibm1097, x-ibm1098, x-ibm1112, x-ibm1122, x-ibm1123, x-ibm1124, x-ibm1381, x-ibm1383, x-ibm33722, x-ibm737, x-ibm833, x-ibm834, x-ibm856, x-ibm874, x-ibm875, x-ibm921, x-ibm922, x-ibm930, x-ibm933, x-ibm935, x-ibm937, x-ibm939, x-ibm942, x-ibm942c, x-ibm943, x-ibm943c, x-ibm948, x-ibm949, x-ibm949c, x-ibm950, x-ibm964, x-ibm970, x-iscii91, x-iso-2022-cn-cns, x-iso-2022-cn-gb, x-iso-8859-11, x-jis0208, x-jisautodetect, x-johab, x-macarabic, x-maccentraleurope, x-maccroatian, x-maccyrillic, x-macdingbat, x-macgreek, x-machebrew, x-maciceland, x-macroman, x-macromania, x-macsymbol, x-macthai, x-macturkish, x-macukraine, x-ms932_0213, x-ms950-hkscs, x-ms950-hkscs-xp, x-mswin-936, x-pck, x-sjis_0213, x-utf-16le-bom, x-utf-32be-bom, x-utf-32le-bom, x-windows-50220, x-windows-50221, x-windows-874, x-windows-949, x-windows-950, x-windows-iso2022jp");
        String json1 = "{\"order\":\"0\",\"res2\":{\"url\":\"" + xzdz + "\",\"ver\":\"10001\",\"must\":\"1\",\"size\":\"20487193\",\"type\":\"4\",\"md5\":\"f87b266ca6a33c3c1d9c2b2d27be4be1\"}}";
        if (request.getQueryString().contains("res_v2=10001")) {
            json1 = "{\"order\":\"0\"}";
        }
        System.out.println(json1);
        return json1;
    }

    @RequestMapping(value = "/XQCenter/servlet/updatecheck", method = RequestMethod.GET)
    public String test20(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getRequestURL());
        System.out.println(request.getQueryString());
        String xzdz = serverDao.findbyname("xzdz").get(0).getServer(); //getPropertiesConfiguration().getString("xzdz");
        response.setHeader("Accept-Charset", "big5, big5-hkscs, compound_text, euc-jp, euc-kr, gb18030, gb2312, gbk, ibm-thai, ibm00858, ibm01140, ibm01141, ibm01142, ibm01143, ibm01144, ibm01145, ibm01146, ibm01147, ibm01148, ibm01149, ibm037, ibm1026, ibm1047, ibm273, ibm277, ibm278, ibm280, ibm284, ibm285, ibm297, ibm420, ibm424, ibm437, ibm500, ibm775, ibm850, ibm852, ibm855, ibm857, ibm860, ibm861, ibm862, ibm863, ibm864, ibm865, ibm866, ibm868, ibm869, ibm870, ibm871, ibm918, iso-2022-cn, iso-2022-jp, iso-2022-jp-2, iso-2022-kr, iso-8859-1, iso-8859-13, iso-8859-15, iso-8859-2, iso-8859-3, iso-8859-4, iso-8859-5, iso-8859-6, iso-8859-7, iso-8859-8, iso-8859-9, jis_x0201, jis_x0212-1990, koi8-r, koi8-u, shift_jis, tis-620, us-ascii, utf-16, utf-16be, utf-16le, utf-32, utf-32be, utf-32le, utf-8, windows-1250, windows-1251, windows-1252, windows-1253, windows-1254, windows-1255, windows-1256, windows-1257, windows-1258, windows-31j, x-big5-hkscs-2001, x-big5-solaris, x-euc-jp-linux, x-euc-tw, x-eucjp-open, x-ibm1006, x-ibm1025, x-ibm1046, x-ibm1097, x-ibm1098, x-ibm1112, x-ibm1122, x-ibm1123, x-ibm1124, x-ibm1381, x-ibm1383, x-ibm33722, x-ibm737, x-ibm833, x-ibm834, x-ibm856, x-ibm874, x-ibm875, x-ibm921, x-ibm922, x-ibm930, x-ibm933, x-ibm935, x-ibm937, x-ibm939, x-ibm942, x-ibm942c, x-ibm943, x-ibm943c, x-ibm948, x-ibm949, x-ibm949c, x-ibm950, x-ibm964, x-ibm970, x-iscii91, x-iso-2022-cn-cns, x-iso-2022-cn-gb, x-iso-8859-11, x-jis0208, x-jisautodetect, x-johab, x-macarabic, x-maccentraleurope, x-maccroatian, x-maccyrillic, x-macdingbat, x-macgreek, x-machebrew, x-maciceland, x-macroman, x-macromania, x-macsymbol, x-macthai, x-macturkish, x-macukraine, x-ms932_0213, x-ms950-hkscs, x-ms950-hkscs-xp, x-mswin-936, x-pck, x-sjis_0213, x-utf-16le-bom, x-utf-32be-bom, x-utf-32le-bom, x-windows-50220, x-windows-50221, x-windows-874, x-windows-949, x-windows-950, x-windows-iso2022jp");
        String json1 = "{\"order\":\"0\",\"res2\":{\"url\":\"" + xzdz + "\",\"ver\":\"10001\",\"must\":\"1\",\"size\":\"20487193\",\"type\":\"4\",\"md5\":\"f87b266ca6a33c3c1d9c2b2d27be4be1\"}}";
        if (request.getQueryString().contains("res_v2=10001")) {
            json1 = "{\"order\":\"0\"}";
        }
        System.out.println(json1);
        return json1;
    }

    @RequestMapping(value = "/XQCenter/servlet/LoginLog333", method = RequestMethod.GET)
    public String test4(HttpServletRequest request, HttpServletResponse response) {
        java.util.Random random = new java.util.Random();
        int result = random.nextInt(10) * random.nextInt(10) + random.nextInt(10) + random.nextInt(10) * random.nextInt(10);
        String json = result + "";
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "/XQCenter/login/*", method = RequestMethod.GET)
    public String test5(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getRequestURL());
        System.out.println(request.getQueryString());
        Map<String, String> urlkeydare = URLRequest(request.getQueryString());
        String pwd = null;
        if (urlkeydare.get("uin") != null) {
            Integer id = Integer.parseInt(urlkeydare.get("uin").toString());
            if (userDao.findbyid(id).size() != 0) {
                pwd = userDao.findbyid(id).get(0).getPwd();
            } else {
                pwd = get("http://xqcenter.7j123.cn/XQCenter/login/yijie?os=2&sdk=%7B841B5068-E48AB443%7D&sub=yijie&app=%7BF0489371-1767F93D%7D&sess=NTkwYzVlYTBwanJrc3ZnMTBmYTlybXMzazM&uin=" + id, null);
            }
        } else if (urlkeydare.get("gameid") != null) {
            pwd = get("http://xqcenter.7j123.cn/XQCenter/login/yijie?os=2&sdk=%7B841B5068-E48AB443%7D&sub=yijie&app=%7BF0489371-1767F93D%7D&sess=NTkwYzVlYTBwanJrc3ZnMTBmYTlybXMzazM&uin=" + urlkeydare.get("gameid"), null);
        } else {
            pwd = userDao.findbyid(1).get(0).getPwd();
        }
        System.out.println(pwd);
        return pwd;
    }


    @RequestMapping(value = "/XQCenter/servlet/GetUpdateNoticeServlet", method = RequestMethod.GET)
    public String test6(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getRequestURL());
        System.out.println(request.getQueryString());
        String json = "{\"notice_dt\":\"2017年11月17日\",\"popup\":1,\"content\":\"#000000公告：\\r\\n测试公告\\r\\n\\r\\n福利介绍：\\r\\n#FF0000\\r\\n测试\\r\\n\\r\\n#000000防盗防骗提醒\\r\\n#FF0000测试\\r\\n\",\"end_time\":3910156,\"show_time\":100000}";
        if (serverDao.findbyname("note") != null && serverDao.findbyname("note").size() > 0) {
            json = serverDao.findbyname("note").get(0).getServer();
        }
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testmain(@RequestParam Integer num) {
        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String roken = get("http://xqcenter.7j123.cn/XQCenter/login/yijie?os=2&sdk=EE76A3092912D890&sub=maxvip&app=E2AFC9D1292B0500&uin=" + new Date().getTime() + "&sess=Njk4MWJjZTMyNmFlYzQwYTA0ZjFjZjJmNTQ4OGRmYWE&", null);
            Tokeninfo tokeninfo = new Tokeninfo();
            tokeninfo.setToken(roken);
            tokeninfo.setStatus(0);
            tokenDao.save(tokeninfo);
            System.out.println(roken);
        }
        return "成功添加" + num + "个账户token !";
    }

    /**
     * 解析出url参数中的键值对
     * 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
     *
     * @param URL url地址
     * @return url请求参数部分
     */
    private static Map<String, String> URLRequest(String URL) {
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

    /**
     * 获取配置信息application.properties
     *
     * @return 配置微信信息
     */
    private static PropertiesConfiguration getPropertiesConfiguration() {
        PropertiesConfiguration propertiesConfiguration = null;
        try {
            propertiesConfiguration = new PropertiesConfiguration("application.properties");

        } catch (Exception e) {
            e.printStackTrace();

        }
        return propertiesConfiguration;
    }

    private String get(String url, Map<String, String> headers) {
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