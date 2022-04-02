Healenium BE Setup :

1: Install docker https://hub.docker.com/editions/community/docker-ce-desktop-windows

2: After installation , create a folder in a same hierarchy like 

* infra -> db -> sql

3: Go to sql directory path and type the command $ curl https://raw.githubusercontent.com/healenium/healenium-client/master/example/init.sql -o init.sql

4: Go to infra directory and type the command $ curl  https://raw.githubusercontent.com/healenium/healenium-client/master/example/docker-compose.yaml  -o docker-compose.yaml

5: Go to infra folder and Run the command docker-compose up -d // this command will create the image for healenium and up the docker images for healenium

6: To check your docker is up and running , try the command docker ps


Healenium FE Setup : 

1: Go to pom file and add the dependency

    <dependency>
    <groupId>com.epam.healenium</groupId>
    <artifactId>healenium-web</artifactId>
    <version>3.2.4</version>
    </dependency>

2: Delegate the selenium driver

    WebDriver delegate = new ChromeDriver();
    SelfHealingDriver driver = SelfHealingDriver.create(delegate);

3: Specify custom healing config file healenium.properties under test/resources directory, and write the below parameters

    recovery-tries = 1
    score-cap = 0.5
    heal-enabled = true
    serverHost = localhost
    serverPort = 7878
    imitatePort = 8000

Healenium Reporter Setup : 

1: Go to pom file and add the reporter plugin

    `<plugin>
    <groupId>com.epam.healenium</groupId>
    <artifactId>hlm-report-mvn</artifactId>
    <version>1.1</version>
    <executions>
    <execution>
    <id>hlmReport</id>
    <phase>compile</phase>
    <goals>
    <goal>initReport</goal>
    </goals>
    </execution>
    <execution>
    <id>hlmReportB</id>
    <phase>test</phase>
    <goals>
    <goal>buildReport</goal>
    </goals>
    </execution>
    </executions>
    </plugin>`

2: Run the test by command mvn clean test 

3: Report URL will be generated in the output for example : http://localhost:7878/healenium/report/c24e5374-e6e8-4574-9ac7-3b7e4b66c422


Complete guideline on setup is
https://github.com/healenium
https://www.linkedin.com/pulse/self-healing-selenium-healenium-opensource-test-solution-murari

