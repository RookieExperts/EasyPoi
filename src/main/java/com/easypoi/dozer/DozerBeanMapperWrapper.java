package com.easypoi.dozer;


import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * vo与domain互转工具类
 * @author brb
 * @date 2020年08月30日
 */
@Component
public class DozerBeanMapperWrapper {

    private static DozerBeanMapper dozerBeanMappee = new DozerBeanMapper();

    public <T> T mapper(Object source, Class<T> destinationClass) {
        return dozerBeanMappee.map(source, destinationClass);
    }

    public void mapper(Object source, Object destinationSource) {
        dozerBeanMappee.map(source, destinationSource);
    }

    public <T> List<T> mapperList(List<?> sources, Class<T> destinationClass) {
        List<T> targetList = new ArrayList<T>();
        for (Object source : sources) {
            targetList.add(dozerBeanMappee.map(source, destinationClass));
        }
        return targetList;
    }

}
