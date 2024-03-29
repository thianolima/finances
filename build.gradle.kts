import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.5"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
}

group = "com.finances"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2021.0.5"
extra["springAwsVersion"] = "3.0.0-M2"

dependencies {
	// SPRING
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springdoc:springdoc-openapi-ui:1.6.13")

	// H2
	runtimeOnly("com.h2database:h2")

	// KOTLIN
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// JACKSON
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// OBSERVABILITY
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("io.micrometer:micrometer-registry-prometheus:1.10.2")

	//AWS-CLI PARA O LOCALSTACK
	implementation("com.amazonaws:aws-java-sdk:1.12.372")

	//SPRING CLOUD AWS
//	implementation("io.awspring.cloud:spring-cloud-starter-aws:${property("springAwsVersion")}")
	implementation("io.awspring.cloud:spring-cloud-aws-starter-secrets-manager")
	implementation("io.awspring.cloud:spring-cloud-aws-starter-parameter-store")

	// TEST
	implementation("org.hamcrest:hamcrest:2.2")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.5.20")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")
	testImplementation("io.rest-assured:kotlin-extensions:4.4.0")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
		mavenBom("io.awspring.cloud:spring-cloud-aws-dependencies:${property("springAwsVersion")}")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}