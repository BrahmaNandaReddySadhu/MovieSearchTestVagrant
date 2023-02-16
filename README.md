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





