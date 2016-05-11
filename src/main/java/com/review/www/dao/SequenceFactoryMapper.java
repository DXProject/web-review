package com.review.www.dao;

import com.review.www.entity.SequenceFactory;

public interface SequenceFactoryMapper {
    int deleteByPrimaryKey(Long sequence);

    int insert(SequenceFactory record);

    int insertSelective(SequenceFactory record);

    SequenceFactory selectByPrimaryKey(Long sequence);

    int updateByPrimaryKeySelective(SequenceFactory record);

    int updateByPrimaryKey(SequenceFactory record);

    /**
     * 生成seq
     *
     * @param sequenceFactory
     */
    void generateSequence(SequenceFactory sequenceFactory);
}