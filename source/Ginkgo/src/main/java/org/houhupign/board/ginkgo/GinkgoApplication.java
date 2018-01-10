package org.houhupign.board.ginkgo;

import org.houhupign.board.ginkgo.entity.repositories.impl.CustomedRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan
@EnableScheduling
@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "org.houhupign.board.ginkgo.entity")
@ServletComponentScan(basePackages = "org.houhupign.board.ginkgo.servlet")
@EnableJpaRepositories(repositoryBaseClass = CustomedRepositoryImpl.class, basePackages = "org.houhupign.board.ginkgo.entity.repositories")
public class GinkgoApplication {
	public static void main(String[] args) {
		SpringApplication.run(GinkgoApplication.class, args);
	}
}
