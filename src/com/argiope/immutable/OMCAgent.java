package com.argiope.immutable;

/**
 * 操作者
 * 模式角色ImmutableObject.manipulator
 * Created by leeXiang on 2017/1/20.
 */
public class OMCAgent extends Thread {
    @Override
    public void run() {
        boolean isTableModificationMsg = false;
        String updateTableName = null;
        while (true){
            //与其他服务进行通信
            if(isTableModificationMsg){
                if("MMSCInfo".equals(updateTableName)){
                    MMSCRouter.setInstance(new MMSCRouter());
                }
            }
        }
    }
}
