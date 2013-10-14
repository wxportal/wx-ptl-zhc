package org.wxportal.util;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.wxportal.message.resp.ArticleResp;
import org.wxportal.message.resp.MusicListResp;
import org.wxportal.message.resp.NewsResp;
import org.wxportal.message.resp.TextResp;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class Util {
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXml(HttpServletRequest request)
			throws Exception {
		Map<String, String> map = new HashMap<String, String>();

		InputStream inputStream = request.getInputStream();
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		Element root = document.getRootElement();
		List<Element> elementList = root.elements();

		for (Element e : elementList)
			map.put(e.getName(), e.getText());

		inputStream.close();
		inputStream = null;

		return map;
	}

	public static String textMessageToXml(TextResp textMessage) {
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}

	public static String musicMessageToXml(MusicListResp musicMessage) {
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}

	public static String newsMessageToXml(NewsResp newsMessage) {
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new ArticleResp().getClass());
		return xstream.toXML(newsMessage);
	}
	
    /** 
     * 计算采用utf-8编码方式时字符串所占字节数 
     *  
     * @param content 
     * @return 
     */  
    public static int getByteSize(String content) {  
        int size = 0;  
        if (null != content) {  
            try {  
                // 汉字采用utf-8编码时占3个字节  
                size = content.getBytes("utf-8").length;  
            } catch (UnsupportedEncodingException e) {  
                e.printStackTrace();  
            }  
        }  
        return size;  
    }  

    /** 
     * xiaoqrobot的主菜单 
     *  
     * @return 
     */  
    public static String getMainMenu() {  
        StringBuffer buffer = new StringBuffer();  
        buffer.append("您好，我是小q，请回复数字选择服务：").append("\n\n");  
        buffer.append("1  天气预报").append("\n");  
        buffer.append("2  公交查询").append("\n");  
        buffer.append("3  周边搜索").append("\n");  
        buffer.append("4  歌曲点播").append("\n");  
        buffer.append("5  经典游戏").append("\n");  
        buffer.append("6  美女电台").append("\n");  
        buffer.append("7  人脸识别").append("\n");  
        buffer.append("8  聊天唠嗑").append("\n\n");  
        buffer.append("回复“?”显示此帮助菜单");  
        return buffer.toString();  
    }  
    
    /** 
     * 判断是否是QQ表情 
     *  
     * @param content 
     * @return 
     */  
    public static boolean isQqFace(String content) {  
        boolean result = false;  
      
        // 判断QQ表情的正则表达式  
        String qqfaceRegex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";  
        Pattern p = Pattern.compile(qqfaceRegex);  
        Matcher m = p.matcher(content);  
        if (m.matches()) {  
            result = true;  
        }  
        return result;  
    }  
    
    /** 
     * 将微信消息中的CreateTime转换成标准格式的时间（yyyy-MM-dd HH:mm:ss） 
     *  
     * @param createTime 消息创建时间 
     * @return 
     */  
    public static String formatTime(String createTime) {  
        // 将微信传入的CreateTime转换成long类型，再乘以1000  
        long msgCreateTime = Long.parseLong(createTime) * 1000L;  
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        return format.format(new Date(msgCreateTime));  
    }  
    
    /** 
     * emoji表情转换(hex -> utf-16) 
     *  
     * @param hexEmoji 
     * @return 
     */  
    public static String emoji(int hexEmoji) {  
        return String.valueOf(Character.toChars(hexEmoji));  
    }  
    
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				boolean cdata = true;

				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
}
