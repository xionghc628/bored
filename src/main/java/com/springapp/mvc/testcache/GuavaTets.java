package com.springapp.mvc.testcache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.ConcurrentMap;

/**
 * Created by xionghuacheng on 2018/4/23.
 */
public class GuavaTets {

    public static void main(String[] args) {
//        Cache<Object, Object> build = CacheBuilder.newBuilder().maximumSize(2).build();
//        build.put("xionghuacheng","ssssss");
//
//        System.out.println(build.getIfPresent("xionghuacheng").toString());
//
//        build.put("xionghuacheng1","ssssss");
//
//        System.out.println(build.getIfPresent("xionghuacheng").toString());
//
//        build.put("xionghuacheng2","ssssss");
//
//        System.out.println(build.getIfPresent("xionghuacheng").toString());
//
//        ConcurrentMap<Object, Object> objectObjectConcurrentMap = build.asMap();
//        System.out.println(objectObjectConcurrentMap.keySet());



            String ss = "[{title=api.IpSearchController.ipOwner, frequence=48659}, {title=api.IpSearchController.ipWithElasticSearch, frequence=980}, {title=api.IpSearchController.domain, frequence=394}, {title=api.IpSearchController.allpm, frequence=126}, {title=api.DomainController.allIpNoVipByDomainNoSecure, frequence=39}, {title=api.ProjectApiController.project, frequence=32}, {title=approval, frequence=25}]";

            System.out.println(ss.getBytes().length);


    }


}
