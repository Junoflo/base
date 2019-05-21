package com.liuyibo.me.component;

import com.liuyibo.me.service.WarnService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.Serializable;

/**
 * @Author liuyibo
 * @Date 2019-05-20
 * @Desc
 */
@Plugin(name = "WechatLogAppender", category = "Core", elementType="appender", printObject = true)
public class WechatLogAppender extends AbstractAppender {

    private WarnService warnService;

    private WechatLogAppender(String name, Filter filter, Layout<? extends Serializable> layout) {
        super(name, filter, layout);
    }

    @Override
    public void append(LogEvent logEvent) {
        if (logEvent.getLevel() != Level.ERROR) {
            return;
        }
    }

    @PluginFactory
    public static WechatLogAppender createAppender(@PluginAttribute("name") String name,
                                                   @PluginElement("Layout") Layout<? extends Serializable> layout,
                                                   @PluginElement("Filter") final Filter filter) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        return new WechatLogAppender(name, filter, layout);
    }

    private void initBean() {
        if (warnService != null) {
            return;
        }
//        warnService = (WarnService) SpringUtil.getBean("warnService");
    }

}
