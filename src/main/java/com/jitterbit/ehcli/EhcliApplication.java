package com.jitterbit.ehcli;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;

@SpringBootApplication
public class EhcliApplication {
    public static String tcConfig = null;

    public static void main(String[] args) {
        if (args.length == 1) {
            // Check if the argument is a valid ehcache.xml file
            File f = new File(args[0]);
            if (!f.exists()) {
                System.err.println("File " + args[0] + " is not valid");
                System.exit(1);
            }

            EhcliApplication.tcConfig = args[0];
        }

        SpringApplication.run(EhcliApplication.class);
    }

    @Component
    public static class TCConfig {
        public Resource getConfig() {
            String file = EhcliApplication.tcConfig;

            if (!StringUtils.hasLength(file)) {
                return new ClassPathResource("ehcache.xml");
            }

            return new FileSystemResource(file);
        }
    }

    @Bean
    public PromptProvider myPromptProvider() {
        return () -> new AttributedString("Ehcache:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
    }

}
