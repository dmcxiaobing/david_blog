package com.david.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @Author ：David
 * @weibo ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
/**
 * html工具类封装
 */
public class HtmlUtil {

	public static void main(String[] args) {
		String content = "<p>比如我们有个项目想要发布到互联网上，我们首先需要购买域名以及主机，主机的话，推荐云主机（本人推荐西部数码或者阿里云），性能好；</p><p>当然也有其他的比较好的，各有好坏吧，看你个人选择了。</p><p>我们先在云主机上搭建环境，比如Mysql，Jdk，Tomcat；</p><p>然后我们把自己开发的项目打包，打成War包；</p><p>具体操作；右击项目-&gt; Export</p><p><img alt=\"QQ鎴浘20160224184605.jpg\" src=\"/emd_blog/static/userImages/20160224/1456310792100080598.jpg\" title=\"1456310792100080598.jpg\"/></p><p><br/></p><p>然后点击 Next ;</p><p><img alt=\"QQ鎴浘20160224184644.jpg\" src=\"/emd_blog/static/userImages/20160224/1456310837522027928.jpg\" title=\"1456310837522027928.jpg\"/></p><p><br/></p><p>选择Browse，我们随便选个地方&nbsp; 然后点击Finish即可；</p><p>这样我们就可以生成一个War包了；</p><p>我们把War包传到主机上去，放到Tomcat的webapps下，启动tomcat的startup.bat，会自动解压项目；</p><p>到了这里，还不够。我们只能通过 <a _src=\"http://外网IP:8080/项目名称访问；\" href=\"http://外网IP:8080/项目名称访问；\">http://外网IP:8080/项目名称访问；</a><br/></p><p>我们现在要干两个事情，第一个是去掉端口，第二个是去掉项目名称</p><p>我们找到tomcat安装包下的conf文件夹下的server.xml文件；</p><p><img alt=\"QQ鎴浘20160224185006.jpg\" src=\"/emd_blog/static/userImages/20160224/1456311055147010296.jpg\" title=\"1456311055147010296.jpg\"/></p><p>找到Connector节点；</p><pre class=\"brush:xml;toolbar:false\">&lt;Connector&nbsp;port=&quot;8080&quot;&nbsp;protocol=&quot;HTTP/1.1&quot;\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;connectionTimeout=&quot;20000&quot;\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;redirectPort=&quot;8443&quot;&nbsp;/&gt;</pre><p>我们把port=&quot;8080&quot;改成80端口即可，这样我们就可以不用端口了。不加端口就是默认访问80端口；</p><p><br/></p><p>我们在最后 找到Host节点：</p><pre class=\"brush:xml;toolbar:false\">&lt;Host&nbsp;name=&quot;localhost&quot;&nbsp;&nbsp;appBase=&quot;webapps&quot;\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;unpackWARs=&quot;true&quot;&nbsp;autoDeploy=&quot;true&quot;&gt;\n"
				+ "\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;!--&nbsp;SingleSignOn&nbsp;valve,&nbsp;share&nbsp;authentication&nbsp;between&nbsp;web&nbsp;applications\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Documentation&nbsp;at:&nbsp;/docs/config/valve.html&nbsp;--&gt;\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;!--\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;Valve&nbsp;className=&quot;org.apache.catalina.authenticator.SingleSignOn&quot;&nbsp;/&gt;\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--&gt;\n" + "\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;!--&nbsp;Access&nbsp;log&nbsp;processes&nbsp;all&nbsp;example.\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Documentation&nbsp;at:&nbsp;/docs/config/valve.html\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Note:&nbsp;The&nbsp;pattern&nbsp;used&nbsp;is&nbsp;equivalent&nbsp;to&nbsp;using&nbsp;pattern=&quot;common&quot;&nbsp;--&gt;\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;Valve&nbsp;className=&quot;org.apache.catalina.valves.AccessLogValve&quot;&nbsp;directory=&quot;logs&quot;\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;prefix=&quot;localhost_access_log.&quot;&nbsp;suffix=&quot;.txt&quot;\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;pattern=&quot;%h&nbsp;%l&nbsp;%u&nbsp;%t&nbsp;&amp;quot;%r&amp;quot;&nbsp;%s&nbsp;%b&quot;&nbsp;/&gt;\n"
				+ "\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/Host&gt;</pre><p><br/></p><p>我们在里面加一个节点：</p><pre class=\"brush:java;toolbar:false\">&lt;Context&nbsp;path=&quot;&quot;&nbsp;docBase=&quot;C:\\apache-tomcat-7.0.11-windows-x86\\apache-tomcat-7.0.11\\webapps\\Blog&quot;&nbsp;debug=&quot;0&quot;&nbsp;reloadable=&quot;true&quot;&nbsp;/&gt;</pre><pre class=\"brush:xml;toolbar:false\">&lt;Host&nbsp;name=&quot;localhost&quot;&nbsp;&nbsp;appBase=&quot;webapps&quot;\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;unpackWARs=&quot;true&quot;&nbsp;autoDeploy=&quot;true&quot;&gt;\n"
				+ "\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;!--&nbsp;SingleSignOn&nbsp;valve,&nbsp;share&nbsp;authentication&nbsp;between&nbsp;web&nbsp;applications\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Documentation&nbsp;at:&nbsp;/docs/config/valve.html&nbsp;--&gt;\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;!--\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;Valve&nbsp;className=&quot;org.apache.catalina.authenticator.SingleSignOn&quot;&nbsp;/&gt;\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--&gt;\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;Context&nbsp;path=&quot;&quot;&nbsp;docBase=&quot;C:\\apache-tomcat-7.0.11-windows-x86\\apache-tomcat-7.0.11\\webapps\\BaiduYun&quot;&nbsp;debug=&quot;0&quot;&nbsp;reloadable=&quot;true&quot;&nbsp;/&gt;&nbsp;&nbsp;&nbsp;\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;!--&nbsp;Access&nbsp;log&nbsp;processes&nbsp;all&nbsp;example.\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Documentation&nbsp;at:&nbsp;/docs/config/valve.html\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Note:&nbsp;The&nbsp;pattern&nbsp;used&nbsp;is&nbsp;equivalent&nbsp;to&nbsp;using&nbsp;pattern=&quot;common&quot;&nbsp;--&gt;\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;Valve&nbsp;className=&quot;org.apache.catalina.valves.AccessLogValve&quot;&nbsp;directory=&quot;logs&quot;&nbsp;&nbsp;\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;prefix=&quot;localhost_access_log.&quot;&nbsp;suffix=&quot;.txt&quot;\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;pattern=&quot;%h&nbsp;%l&nbsp;%u&nbsp;%t&nbsp;&amp;quot;%r&amp;quot;&nbsp;%s&nbsp;%b&quot;&nbsp;resolveHosts=&quot;false&quot;/&gt;\n"
				+ "\n"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/Host&gt;</pre><p><br/></p><p>这里的docBase要给成你的项目所在你服务器的本机的绝对路径；</p><p>其他不用变；</p><p><br/></p><p>项目数据库脚本的话自己导入下即可；这样就完整了项目部署；</p><p>我们可以直接通过外网IP直接访问项目；</p><p>域名解析下服务器外网IP。我们就可以通过域名访问了；</p><p><br/></p>";
		System.out.println(getImagesByHTML(content));
		
		String path = "/emd_blog/static/userImages/20160224/1456310792100080598.jpg";
		// /emd_blog/static/userImages/20160224/1456310792100080598.jpg
		System.out.println( path.replace("\\","/"));
		// \emd_blog\staticuserImages\20160224\1456310792100080598.jpg
		path =  path.replace("/","\\");
		System.out.println( path);
		System.out.println(path.substring(9,path.length()));
	}

	/**
	 * 从html源码中获取到图片的地址。
	 * [/emd_blog/static/userImages/20160224/1456310792100080598.jpg,
	 *  /emd_blog/static/userImages/20160224/1456310837522027928.jpg, 
	 *  /emd_blog/static/userImages/20160224/1456311055147010296.jpg]
	 */
	public static List<String> getImagesByHTML(String htmlContent) {
		String imgs[] = getImgsLabel(htmlContent);
		List<String> imgList = deleteImagesLabel(imgs);
		return imgList;
	}

	/**
	 * 取出html中的图片.这里可能包含其他不适图片地址的标签。如：http://外网IP:8080/项目名称访问
	 */
	public static String[] getImgsLabel(String htmlContent) {
		String img = "";
		Pattern p_image;
		Matcher m_image;
		String str = "";
		String[] images = null;
		String regEx_img = "(<img.*src\\s*=\\s*(.*?)[^>]*?>)";
		p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(htmlContent);
		while (m_image.find()) {
			img = m_image.group();
			Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
			while (m.find()) {
				String tempSelected = m.group(1);

				if ("".equals(str)) {
					str = tempSelected;
				} else {
					String temp = tempSelected;
					str = str + "," + temp;
				}
			}
		}
		if (!"".equals(str)) {
			images = str.split(",");
		}
		return images;
	}

	public static List<String> deleteImagesLabel(String[] imsLabel) {
		List<String> imgsDeleteLabelList = new ArrayList<>();
		if (imsLabel != null && imsLabel.length > 0) {
			for (int i = 0; i < imsLabel.length; i++) {
				if (imsLabel[i].contains("jpg") || imsLabel[i].contains("bmp") || imsLabel[i].contains("jpeg")
						|| imsLabel[i].contains("gif") || imsLabel[i].contains("jpeg2000")
						|| imsLabel[i].contains("tiff") || imsLabel[i].contains("png") || imsLabel[i].contains("psd")
						|| imsLabel[i].contains("dxf") || imsLabel[i].contains("pcx") || imsLabel[i].contains("wmf")
						|| imsLabel[i].contains("emf") || imsLabel[i].contains("JPG") || imsLabel[i].contains("BMP")
						|| imsLabel[i].contains("JPEG") || imsLabel[i].contains("GIF")
						|| imsLabel[i].contains("JPEG2000") || imsLabel[i].contains("TIFF")
						|| imsLabel[i].contains("PNG") || imsLabel[i].contains("PSD") || imsLabel[i].contains("DXF")
						|| imsLabel[i].contains("PCX") || imsLabel[i].contains("WMF") || imsLabel[i].contains("EMF")) {
					imgsDeleteLabelList.add(imsLabel[i]);
				}
			}
		}
		return imgsDeleteLabelList;
	}
}
