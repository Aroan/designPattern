package com.argiope.immutable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 彩信中心路由规则管理器
 * 模式角色ImmutableObject.immutableObject
 * Created by leeXiang on 2017/1/20.
 */
public final class MMSCRouter {
    //用volatile修饰，保证多线程环境下该变量的可见性
    private static volatile MMSCRouter instance = new MMSCRouter();
    //维护手机号码前缀到彩信中心之间的映射关系
    private final Map<String,MMSCInfo> routeMap;

    public MMSCRouter() {
        //将数据库表中的信息加载到内存，存为Map
        this.routeMap = MMSCRouter.retrieveRouteMapFromDB();
    }

    private static Map<String, MMSCInfo> retrieveRouteMapFromDB(){
        Map<String,MMSCInfo> result = new HashMap<>();

        return result;
    }

    /**
     * 根据手机号码前缀获取彩信中心信息
     * @param msisdnPrefix
     * @return
     */
    public  MMSCInfo getMMSC(String msisdnPrefix){
        return  routeMap.get(msisdnPrefix);
    }

    public static MMSCRouter getInstance(){
        return instance;
    }

    /**
     * 将当前MMSCRouter实例更新为指定的新实例
     * @param newInstance
     */
    public static void setInstance(MMSCRouter newInstance){
        instance = newInstance;
    }

    private static Map<String,MMSCInfo> deepCopy(Map<String,MMSCInfo> m){
        Map<String,MMSCInfo> result = new HashMap<>();
        for (String key : m.keySet()) {
            result.put(key,new MMSCInfo(m.get(key)));
        }
        return result;
    }
    public Map<String,MMSCInfo> getRouteMap(){
        //做防御性复制
        return Collections.unmodifiableMap(deepCopy(routeMap));
    }
}
