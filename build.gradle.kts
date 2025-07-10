plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

repositories {
    mavenCentral()
}

dependencies {
    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")

    // Selenium
    implementation("org.seleniumhq.selenium:selenium-java:4.21.0")

    // Selenide
    testImplementation("com.codeborne:selenide:7.2.3")

    // Apache Commons
    implementation("commons-io:commons-io:2.19.0")

    // JSON
    implementation("com.google.code.gson:gson:2.12.1")


    // WebDriverManager
    implementation("io.github.bonigarcia:webdrivermanager:5.8.0")

    testImplementation ("org.seleniumhq.selenium:selenium-devtools-v125:4.21.0")

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")

    // Allure
    testImplementation("io.qameta.allure:allure-junit5:2.25.0")
    testImplementation("io.qameta.allure:allure-selenide:2.25.0")

    // Faker
    implementation("com.github.javafaker:javafaker:1.0.2")

    // Logging
    implementation("org.slf4j:slf4j-api:2.0.12")
    testImplementation("ch.qos.logback:logback-classic:1.4.14")

    // AspectJ для Allure
    testImplementation("org.aspectj:aspectjweaver:1.9.20.1")
}

allure {
    version.set("2.25.0")
    adapter {
        frameworks {
            junit5 {
                adapterVersion.set("2.25.0")
            }
        }
    }
}


tasks.test {
    useJUnitPlatform()
    systemProperties = mapOf(
        "allure.results.directory" to layout.buildDirectory.dir("allure-results").get().asFile.absolutePath,
        "junit.jupiter.extensions.autodetection.enabled" to "true"
    )
    jvmArgs = listOf(
        "-javaagent:${configurations.testRuntimeClasspath.get().find { it.name.contains("aspectjweaver") }}"
    )
}

