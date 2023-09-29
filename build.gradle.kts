plugins {
	java
	id("org.springframework.boot") version "2.5.4"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "com.sea"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	
	// https://mvnrepository.com/artifact/junit/junit
	testImplementation("junit:junit:4.13.1")
	
}

tasks.withType<Test> {
	useJUnitPlatform()
}
