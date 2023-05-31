package by.asb.mti.config;

import by.asb.mti.config.bean.Folder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:folder.properties")
@RequiredArgsConstructor
public class FolderConfig {

    private final Environment env;

    @Bean
    public Folder folderPaths() {
        return Folder.builder()
                .archive(env.getRequiredProperty("path.archive"))
                .spfi(env.getRequiredProperty("path.spfi"))
                .spfs(env.getRequiredProperty("path.spfs"))
                .swift(env.getRequiredProperty("path.swift"))
                .finline(env.getRequiredProperty("path.finline"))
                .build();
    }
}
