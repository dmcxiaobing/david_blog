package com.david.utils;

import com.youbenzi.mdtool.tool.MDTool;

import java.io.IOException;
/**
 * @Author ：David
 * @weibo ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */

/**
 * markdown转html工具类
 */
public class MarkdownToHtmlUtil {

    public static String mdToHtml(String markdownContent) throws IOException {
        return MDTool.markdown2Html(markdownContent);
    }
}
