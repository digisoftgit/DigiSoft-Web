package com.digisoft.com.digisoftitweb;

import com.digisoft.com.digisoftitweb.security.entity.position.response.PositionsResponse;
import com.digisoft.com.digisoftitweb.security.entity.role.request.RoleRequest;
import com.digisoft.com.digisoftitweb.security.mapper.PositionsMapper;
import com.digisoft.com.digisoftitweb.security.repository.PositionsRepository;
import com.digisoft.com.digisoftitweb.security.services.positions.impl.CommandPositionServiceImplementation;
import com.digisoft.com.digisoftitweb.security.services.positonsCategory.impl.PositionCategoryServiceImpl;
import com.digisoft.com.digisoftitweb.security.services.role.CommandRoleService;
import com.digisoft.com.digisoftitweb.security.services.user.impl.CommandUserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.constraints.NotNull;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
@RequiredArgsConstructor
public class DigiSoftItWebApplication extends SpringBootServletInitializer implements CommandLineRunner {

    private final PositionCategoryServiceImpl positionsCategoryServiceImpl;
    private final CommandPositionServiceImplementation positionsService;
    private final CommandUserServiceImplementation commandUserImplementation;
    private final CommandRoleService roleControllerService;
    private final PositionsMapper positionsMapper;
    private final PositionsRepository positionsRepository;

    public static void main(String[] args) {
        SpringApplication.run(DigiSoftItWebApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NotNull org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE","PATCH");
            }
        };
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DigiSoftItWebApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        List<PositionsResponse> allPositions = positionsMapper.toResponse(positionsRepository.findAll());
        if (allPositions.isEmpty()) {
            roleControllerService.createAdminRole( RoleRequest.builder().name("admin").build());
            positionsCategoryServiceImpl.fillData();
            commandUserImplementation.addAdmin();
        }
    }

}
