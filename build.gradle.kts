plugins{
    java
    kotlin("jvm") version ("1.3.72")
    kotlin("plugin.allopen") version ("1.3.72")
    id("io.quarkus") version("1.4.1.Final")
}
allOpen {
    annotation("javax.enterprise.context.ApplicationScoped")
    annotation("javax.enterprise.context.RequestScoped")
}

repositories {
    maven("http://maven.aliyun.com/nexus/content/groups/public/")
    maven("http://git.tech.meizhuli.net:8082/repository/maven-public")
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.quarkus:quarkus-kotlin:1.4.1.Final")
    implementation("io.quarkus:quarkus-resteasy:1.4.1.Final")
    implementation("io.quarkus:quarkus-resteasy-jsonb:1.4.1.Final")
    implementation("io.quarkus:quarkus-agroal:1.4.1.Final")
    implementation("io.quarkus:quarkus-jdbc-mariadb:1.4.1.Final")
    implementation("io.quarkus:quarkus-hibernate-orm:1.4.1.Final")
    implementation("io.quarkus:quarkus-hibernate-orm-panache:1.4.1.Final")
    implementation("io.quarkus:quarkus-smallrye-jwt:1.4.1.Final")
    implementation("com.moandjiezana.toml:toml4j:0.7.2")
    implementation("com.line:arch-commons:2.7.51")
    testImplementation("io.quarkus:quarkus-junit5:1.4.1.Final")
}
tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.create("generate").doFirst {
    exec{
        workingDir("./tto")
        commandLine("sh","-c","./tto.sh")
    }
}

tasks.getByName("classes") {
    doLast {
        println("start copy some files...")
        copy{
            from("./config/application.properties")
            into("$buildDir/config")
        }
        // 外置Jar包
        copy {
            from(configurations.runtimeClasspath)
            into("build/libs/lib")
        }
    }
}