package com.core.coreapi.util;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import java.util.List;
import java.util.Set;

public class StringUtil {

    /**
     * 将List<String>集合 转化为String
     * 如{"aaa","bbb"} To 'aaa','bbb'
     */
    public static String convertListToString(List<String> strlist){
        StringBuffer sb = new StringBuffer();
        if(CollectionUtils.isNotEmpty(strlist)){
            for (int i=0;i<strlist.size();i++) {
                if(i==0){
                    sb.append("'").append(strlist.get(i)).append("'");
                }else{
                    sb.append(",").append("'").append(strlist.get(i)).append("'");
                }
            }
        }
        return sb.toString();
    }
}
