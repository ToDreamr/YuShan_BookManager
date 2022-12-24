package com.book.util;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.Writer;

/**
 * @author Rainy-Heights
 * @version 1.0
 * @Date 2022/11/7 16:29
 */
public class ThymeleafUtil {
    private static final TemplateEngine engine;
    static {
        engine=new TemplateEngine();
        ClassLoaderTemplateResolver resolver=new ClassLoaderTemplateResolver();
        engine.setTemplateResolver(resolver);
    }
    public static void process(String template, IContext context, Writer writer){
        engine.process(template, context,writer);
    }
}
