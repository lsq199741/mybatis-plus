package org.luo.mybatisplus.framework.model.convert;

import org.luo.mybatisplus.framework.converter.BeanConverter;

import java.io.Serializable;

/*
 * @Author shuqiang
 * @Desc 普通实体父类
 * @Date 2019-04-28 13:00
 */
public class Convert implements Serializable {

    /**
     * 获取自动转换后的JavaBean对象
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T convert(Class<T> clazz) {
        return BeanConverter.convert(clazz, this);
    }
}
