set CHROMEDRIVER_PATH=C:\\Users\\YOUR_USERNAME\\.wdm\\drivers\\chromedriver\\win32\\114.0.5735.90\\chromedriver.exe
set APP_URL=https://authenticationtest.com
set APP_USERNAME=user
set APP_PASSWORD=pass
mvn clean compile assembly:single
java -jar target/testng-browserstack-1.0-SNAPSHOT-jar-with-dependencies.jar