import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	application
	java
	id("org.springframework.boot") version "2.4.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.4.31"
	kotlin("plugin.spring") version "1.4.31"
	kotlin("plugin.jpa") version "1.4.30"
}

application{
	mainClass.set("com.mycompany.shop2you.Shop2youApplication")
}

apply(plugin = "io.spring.dependency-management")

group = "com.mycompany"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	// persistence
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation ("org.springframework.data:spring-data-jpa:2.4.6")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("com.zaxxer:HikariCP:3.3.1")
	runtimeOnly("com.h2database:h2")

	// web
	implementation("org.springframework.boot:spring-boot-starter-web")

	//utils
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// tests
	implementation("junit:junit:4.12")
	implementation ("com.ninja-squad:springmockk:3.0.1")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.jar {
	manifest {
		attributes["Main-Class"] = "Shop2youApplication"
	}
	configurations["compileClasspath"].forEach { file: File ->
		from(zipTree(file.absoluteFile))
	}
}