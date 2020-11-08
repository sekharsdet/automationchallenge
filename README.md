# automationchallenge

## Prerequisites

* Java 8 and above 
* Gradle 


Please run the tests from command line by using below template
```
$ gradle clean build  cucumber -Dtags="@careers" 
```

To run different types of test , juts change the tags value
To run regression tests
```
$ gradle build  cucumber -Dtags="@regression" 
```

We can change url, browser values from config.properties

##### Cucumber Report 

Once the execution is completed, from the console you can find the cucumber report link like below

https://reports.cucumber.io/reports/0792b1ab-b1f9-493c-8ba6-c7ca417857de

##### The report will look like below
<img width="1278" alt="Screenshot 2020-11-08 at 12 06 18" src="https://user-images.githubusercontent.com/44940087/98463560-4b8c8280-21bc-11eb-8829-dc7e0b4cda78.png">
<img width="1278" alt="Screenshot 2020-11-08 at 12 06 43" src="https://user-images.githubusercontent.com/44940087/98463561-4f200980-21bc-11eb-81df-a15e4ab4d235.png">
