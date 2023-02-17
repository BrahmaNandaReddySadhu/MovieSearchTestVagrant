Page Object Model for MovieSearch
The Assignemnet is use to compare moovie Release date and Country present in two Webpages ie IMDB and WIKI
Techstack used in this model are Selenium java TestNG, Data Driven testing ,maven,jenkins
Input Data with movie name which needs to search from two websites can be add in the excel sheet 
Launching browser is dependant on the value mentioned in the property file

steps to execute:
1) Clone project
2) load the project into your IDE
3) Load the dependencies  into your local system which are required to run this project by using mvn clean install in comnand prompt  after navigating to project specificfolder or  update the pom.xml file in the ide level
4) Run the TestNG.xml file to view the output
5) you can alos execute through the command prompt with mavne command mvn test
6) you can update the input data in the excel file presrent in the location "src/test/resources/moviesearch/exceldata/MovieSearch.xlsx"
  Fisrt column belongs to IMDB MOvieName and Second Column belongs Wiki MOvie Name
7) you can view the output in the console
8) If data between the two websites are matching then test case will pass other wise it will fail



Run Using Jenkins:
-----------------
1)download the jenkins war file from jenkins website
2)run the jenkins war using : java -jar jenkins.war commannd in command prompt and click on enter
3)then jenkin will create the Admin user for your and it will generate the password key , this will helpful initial set up
4)Open any Browser then type : localhost:8080 , then getting started window will appaer
5)Enter password generated in the 3rd step and click on continue
6)click on install suggeted pugins, then it will start downloading the plugins info
7)once done set up username and password 
8)Install maven plugins using Dashboard-> Manage jenkins Plugin Mananger  
9) Click on new Item provide project name and select maven project and ok
10) provide some description
11) select Sorce code manangemnet option as Git ,provide the repository url 
    my repository url is https://github.com/BrahmaNandaReddySadhu/MovieSearchTestVagrant i can provide this , in your case you can provide yours 
    In the Branch to Build select wich branch you want to build (main/master/ some other branch )
12) Build section : Root pom as pom.xmland goal clean test
13) post steps : run regardless of build status
14) Post Build Actions section : select the option publish testng report , if this option not avaialble you can download by 
    Goto DashBoard Page ->Manage Jenkins -> Manage Plugins ->  and search for testng result plugin an install itand click on apply and save
 15) since it required you can configure it by go to  Dashboard -> Manage jenkis ->Global tool configuration -> Maven section ->Add maven
     Provide the any name for the maven and select which version you want to install from  inthe  Install from apche version select box and click on apply save
 16) Now you can see the job name with projet name mentioned in the 9th step and click on it
 17) you can click on Build Now , once execution completed ,you can see the results by go inside particular build number
    

