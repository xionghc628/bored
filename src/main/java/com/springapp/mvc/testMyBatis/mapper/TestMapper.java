package com.springapp.mvc.testMyBatis.mapper;

import org.apache.ibatis.annotations.Select;

/*******************************************************
 * Copyright (C) 2019 iQIYI.COM - All Rights Reserved
 *
 * <p>This file is part of bored.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 *
 * <p>Author(s): xionghuacheng
 * Created: 2019/9/3
 *******************************************************/
public interface TestMapper {

    @Select("SELECT * FROM blog WHERE id = #{id}")
    void getTest();
}
