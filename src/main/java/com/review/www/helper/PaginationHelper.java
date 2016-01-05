package com.review.www.helper;

import com.jopool.jweb.utils.URLUtils;

/**
 * 分页工具类。
 * <p/>
 * Created by gexin on 15/7/10.
 */
public class PaginationHelper {

    private PaginationHelper() {
    }

    public static String pagination(String url, com.jopool.jweb.mybatis.page.Pagination page) {
        return pagination(url, page, false);
    }

    public static String pagination(String url, com.jopool.jweb.mybatis.page.Pagination page, boolean needJump) {
        if (page == null) {
            return "";
        }

        StringBuilder pagination = new StringBuilder();
        final String separator = "&nbsp;&nbsp;";

        String sortString = "";

        if (page.getPage() > page.getTotalPages()) {
            page.setPage(page.getTotalPages());
        }

        if (page.getTotalCount() > 0) {
            pagination.append("<div class=\"message\">共<i class=\"blue\">" + page.getTotalCount() + "</i>条记录，当前显示第&nbsp;<i class=\"blue\">" + page.getPage() + "&nbsp;</i>页</div>");
            pagination.append("<ul class=\"paginList\">");
            if (page.getPage() == 1) {
                pagination.append("<li class=\"paginItem current\"><a href=\"javascript:;\"><span class=\"pagepre_disabled\"></span></a></li>");
            } else {
                pagination.append("<li class=\"paginItem\"><a href=\"" + URLUtils.addQueryString(url, "page", String.valueOf(page.getPage() - 1)) + sortString + "\"><span class=\"pagepre\"></span></a></li>");
            }
            int temp = page.getPage() / 5;
            int n;
            if (page.getPage() % 5 == 0) {
                n = temp - 1;
            } else {
                n = temp;
            }

            int leftPreviousePage = n * 5;
            int leftPage = leftPreviousePage + 1;
            if (page.getPage() > 5) {
                pagination.append("<li class=\"paginItem more\"><a href=\"" + URLUtils.addQueryString(url, "page", String.valueOf(leftPreviousePage)) + sortString + "\">...</a></li>");
            }
            int curRightPage = n * 5 + 5;
            int rightPage;
            if (page.getTotalPages() > curRightPage) {
                rightPage = curRightPage;
            } else {
                rightPage = page.getTotalPages();
            }
            for (int index = leftPage; index <= rightPage; index++) {
                if (index != page.getPage()) {
                    pagination.append("<li class=\"paginItem\"><a href=\"" + URLUtils.addQueryString(url, "page", String.valueOf(index)) + sortString + "\">" + index + "</a></li>");

                } else {
                    pagination.append("<li class=\"paginItem current\"><a href=\"javascript:;\">" + index + "</a></li>");
                }
            }
            if (page.getTotalPages() > rightPage) {
                int rightNextPage = rightPage + 1;
                pagination.append("<li class=\"paginItem more\"><a href=\"" + URLUtils.addQueryString(url, "page", String.valueOf(rightNextPage)) + sortString + "\">...</a></li>");
            }
            if (page.getPage() == page.getTotalPages()) {
                pagination.append("<li class=\"paginItem current\"><a href=\"javascript:;\"><span class=\"pagenxt_disabled\"></span></a></li>");
            } else {
                pagination.append("<li class=\"paginItem\"><a href=\"" + URLUtils.addQueryString(url, "page", String.valueOf(page.getPage() + 1)) + sortString + "\"><span class=\"pagenxt\"></span></a></li>");
            }
            pagination.append("</ul>");
        } else {
            pagination.append("没有相关记录！");
        }
        return pagination.toString();
    }


}
