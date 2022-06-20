package com.demo.dubbo;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.GenericService;

import java.util.Arrays;

public class jsonTest {

    public static void main(String[] args) {
        ApplicationConfig app = new ApplicationConfig("ConsumerTest");
        RegistryConfig reg = new RegistryConfig("zookeeper://localhostt:2181");

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(app);
        bootstrap.registry(reg);
        bootstrap.start();

        try {
            // 引用远程服务
            ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
            // 弱类型接口名
            reference.setInterface("com.**.RoleCustomAdminApiService");
            reference.setRetries(0);
            // RpcContext中设置generic=gson
            RpcContext.getContext().setAttachment("generic","gson");
            // 声明为泛化接口
            reference.setGeneric(true);
            reference.setCheck(false);
            GenericService genericService = ReferenceConfigCache.getCache().get(reference);
            // 传递参数对象的json字符串进行一次调用
            Object res = genericService.$invoke("isUsedByUsers", new String[]{"java.util.List"}, new Object[]{Arrays.asList("111")});
            System.out.println("result[setUser]："+res); // 响应结果:result[setUser]：{name=Tom, class=com.xxx.api.service.User, age=24}

        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

}
