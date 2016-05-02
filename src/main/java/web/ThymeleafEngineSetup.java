package web;

import io.vertx.ext.web.templ.ThymeleafTemplateEngine;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.thymeleaf.resourceresolver.FileResourceResolver;
import org.thymeleaf.templatemode.StandardTemplateModeHandlers;
import org.thymeleaf.templateresolver.TemplateResolver;

public class ThymeleafEngineSetup {

    public ThymeleafTemplateEngine create() {
        TemplateResolver templateResolver = new TemplateResolver();
        templateResolver.setResourceResolver(new FileResourceResolver());
        templateResolver.setPrefix("templates/");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(false);

        templateResolver.addTemplateAlias("", "/index");
        templateResolver.addTemplateAlias("/", "/index");

        ThymeleafTemplateEngine engine = ThymeleafTemplateEngine.create()
                .setMode(StandardTemplateModeHandlers.HTML5.getTemplateModeName());

        // enable layout
        engine.getThymeleafTemplateEngine().addDialect(new LayoutDialect());
        engine.getThymeleafTemplateEngine().setTemplateResolver(templateResolver);

        return engine;
    }
}
