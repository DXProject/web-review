package com.review.www.dao;

import com.jopool.jweb.mybatis.page.Pagination;
import com.review.www.entity.Announcement;
import com.review.www.vo.SearchProjectVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface AnnouncementMapper {
    int deleteByPrimaryKey(String id);

    int insert(Announcement record);

    int insertSelective(Announcement record);

    Announcement selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Announcement record);

    int updateByPrimaryKey(Announcement record);

    /**
     * search
     *
     * @param searchProjectVo
     * @param page
     * @return
     */
    List<Announcement> searchAnnouncement(SearchProjectVo searchProjectVo, RowBounds page);

    /**
     * select index announcement
     *
     * @return
     */
    List<Announcement> selectIndexAnnouncement();

    /**
     * announcement list by type
     *
     * @param type
     * @param page
     * @return
     */
    List<Announcement> selectAnnouncementListByType(@Param("type") int type, RowBounds page);
}