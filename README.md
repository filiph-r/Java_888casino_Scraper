# Java_888casino_Scraper

<h2>Task Description:</h2>
888Casino is offering a dedicated pool called »hourly jackpot«. You can find more information by visiting the following link:
<br> https://www.888casino.com/jackpots/.
<br><br>
The first image on the left is displaying the information that we need as follows (€373.46):

![Screenshot 2024-04-17 at 17 12 32](https://github.com/filiph-r/Java_888casino_Scraper/assets/48492507/41db4801-3cef-4acd-8465-1c9eeac00bc0)
Prepare a script that can programmatically access the data and log it to the console every 30 seconds whilst the script is running.<br>
There are many ways to access this data. One is to observe the HTML and just gather the information from within the relative tag. Whilst this is a valid option, finding the right endpoint (if feasible) and extract the data from a JSON or XML response is more complicated to work out initially but easier to maintain in the long run.<br>

<h2>Executable:</h2>

Desktop .jar file -> [here](https://github.com/filiph-r/Java_888casino_Scraper/raw/main/executables/888casino_Scraper.jar) (Tested with Java 17)<br>

<h2>How to use:</h2>
Download and execute the 888casino_Scraper.jar file in the terminal<br>
You can also add one argument to the command that indicates how long you want to wait in between each request in seconds. <br>
If no argument is provided the default value is 30s<br><br>
Example1: java -jar 888casino_Scraper.jar<br>
Example2: java -jar 888casino_Scraper.jar 5<br>
(In Example2 the waiting time is 5s)<br><br>
You will also be prompted to input the desired currency.<br>
After that, the program will infinitely print out the value of the hourly jackpot in the given time intervals.<br><br>

![example](https://github.com/filiph-r/Java_888casino_Scraper/assets/48492507/2d31c117-5adb-4b31-8843-fb4b2de5b1bb)

<h2>How it's done:</h2>
<h3>Step 1 - Analyzing the webpage</h3>
The webpage https://www.888casino.com/jackpots/ has been analysed and inspeced. The page html code as well as the network connectivity have been inspected in order to identify the request that is holding the value for »hourly jackpot«. <br>
The identified reocouring GET request to the url: https://feed-casino888.redtiger.cash/jackpots?jackpotId=williamHill&currency=usd <br><br>
It has been further inspected with Insomnia REST client to analyse the data: <br><br>

![Screenshot 2024-04-17 at 18 03 10](https://github.com/filiph-r/Java_888casino_Scraper/assets/48492507/cf4c7013-94a7-40c8-9d63-d48fdf0d1afe)<br><br>

One conclusion was that there are multiple currencies supported. In order to identify all supported courencies the firts network request to the page was inspected with is the page document download for the url https://de.888casino.com/jackpots/. By searching trough the response for "Currency" a list of currencies maped to countries was found. This information was used to include only the supported currencies in this program.




