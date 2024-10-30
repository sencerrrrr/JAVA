package com.aptproject.SpringLibraryProject.library.config;


import lombok.AccessLevel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT) //строгое совпадание
                .setFieldMatchingEnabled(true) //разрешаем совпадение по полям
                .setSkipNullEnabled(true) //разрешаем пропускать поля, которые маллер не нашел и присваивать null
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE); //доступ к private-полям
        return modelMapper;
    }
}
