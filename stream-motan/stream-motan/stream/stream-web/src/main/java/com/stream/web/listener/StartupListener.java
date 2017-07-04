package com.stream.web.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;

public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(StartupListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(6000);
                        MotanSwitcherUtil.setSwitcherValue(
                                MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
                        LOG.info("注册服务成功");
                    } catch (InterruptedException e) {
                        LOG.error(e.getMessage());
                    }
                }
            }).start();
        }
    }
}
