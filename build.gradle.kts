

plugins{
    java
    kotlin("jvm") version ("1.3.72")
    kotlin("plugin.allopen") version ("1.3.72")
    id("io.quarkus") version("1.4.0.Final")
}
allOpen {
    annotation("javax.enterprise.context.ApplicationScoped")
}

repositories {
    maven("http://maven.aliyun.com/nexus/content/groups/public/")
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.quarkus:quarkus-kotlin:1.4.0.Final")
    implementation("io.quarkus:quarkus-resteasy:1.4.0.Final")
    implementation("com.moandjiezana.toml:toml4j:0.7.2")
    testImplementation("io.quarkus:quarkus-junit5:1.4.0.Final")
}
tasks.withType<Test> {
    useJUnitPlatform()
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