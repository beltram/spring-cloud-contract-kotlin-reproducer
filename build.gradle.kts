import org.gradle.kotlin.dsl.*
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.plugin.SpringBootPlugin.*
import org.gradle.api.tasks.wrapper.Wrapper.DistributionType.BIN

val springCloudVersion by extra { "Hoxton.RC1" }
val springContractVersion by extra { "2.2.0.RC1" }
val kotlinVersion = "1.3.50"

buildscript {
    repositories {
        mavenCentral()
		jcenter()
        maven("https://repo.spring.io/snapshot")
        maven("https://repo.spring.io/milestone")
    }
	dependencies {
		classpath("org.springframework.cloud:spring-cloud-contract-spec-kotlin:2.2.0.RC1")
		val kotlinVersion = "1.3.50"
		classpath(kotlin("scripting-compiler-embeddable:$kotlinVersion"))
		classpath(kotlin("compiler-embeddable:$kotlinVersion"))
	}
}

plugins {
    val kotlinVersion = "1.3.50"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    id("org.springframework.boot") version "2.2.0.RELEASE"
	id("org.springframework.cloud.contract") version "2.2.0.RC1"
}

apply {
    plugin("io.spring.dependency-management")
}

group = "com.spring.reproducer"
version = "0.0.1-SNAPSHOT"

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}

repositories {
    mavenCentral()
	jcenter()
    maven("https://repo.spring.io/snapshot")
    maven("https://repo.spring.io/milestone")
}

the<DependencyManagementExtension>().apply {
    imports {
        mavenBom(BOM_COORDINATES) { bomProperty("kotlin.version", kotlinVersion) }
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
		mavenBom("org.springframework.cloud:spring-cloud-contract-dependencies:$springContractVersion")
	
	}
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("io.rest-assured:spring-web-test-client")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.springframework.boot:spring-boot-starter-test") { exclude(module = "junit") }
    testRuntime("org.junit.jupiter:junit-jupiter-engine")
	testImplementation("org.springframework.cloud:spring-cloud-contract-spec-kotlin")
	testImplementation(kotlin("scripting-compiler-embeddable"))
	testImplementation(kotlin("compiler-embeddable"))
}

tasks.withType<Test> { useJUnitPlatform() }

tasks.withType<Wrapper>().configureEach {
    gradleVersion = "5.6.3"
    distributionType = BIN
}