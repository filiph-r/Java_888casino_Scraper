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

888casino_Scraper.jar file -> [here](https://github.com/filiph-r/Java_888casino_Scraper/raw/main/executables/888casino_Scraper.jar) (Tested with Java 17)<br>

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
The webpage https://www.888casino.com/jackpots/ has been analyzed and inspected. The page HTML code, as well as the network connectivity, have been inspected to identify the request that is holding the value for the »hourly jackpot«. <br>
The identified reoccurring GET request to the URL: https://feed-casino888.redtiger.cash/jackpots?jackpotId=williamHill&currency=usd <br><br>
It has been further inspected with the Insomnia REST client to analyze the data: <br><br>

![Screenshot 2024-04-17 at 18 03 10](https://github.com/filiph-r/Java_888casino_Scraper/assets/48492507/cf4c7013-94a7-40c8-9d63-d48fdf0d1afe)<br><br>

One conclusion was that there are multiple currencies supported. To identify all supported currencies the first network request to the page was inspected with the page document download for the URL https://de.888casino.com/jackpots/. By searching through the response for "Currency" a list of currencies mapped to countries was found. This information was used to include only the supported currencies in this program.<br><br>


<h3>Step 2 - Structuring classes</h3>
<b>Main class:</b><br>
This class fetches hourly jackpot amounts for various currencies using a scraper service. Let's break it down:<br>
1. Imports: It imports the HourlyJackpotScraperService class and some Java utility classes (Scanner and Timer).<br><br>
2. Main Method: The main method is the entry point of the program. It first greets the user, then checks command line arguments to determine the duration between each scrape. If no arguments are provided, it defaults to a predefined duration (TIMER_DEFAULT_DURATION). It then prompts the user to input a currency.<br><br>
3. Currency Validation: It checks if the input currency is valid by comparing it to a list of supported currencies (CURRENCIES). If the input currency is not valid, it prompts the user again until a valid currency is provided.<br><br>
4. Timer Setup: It sets up a timer using Timer.scheduleAtFixedRate to periodically call the scrapeHourlyJackpot method of HourlyJackpotScraperService. The frequency of scraping is determined by the provided duration. The fetched jackpot amount is then printed to the console.<br><br>
5. Resource Management: It closes the Scanner object to release system resources once it's done.<br><br><br>

<b>HourlyJackpotScraperService class:</b><br>
This class, is responsible for scraping hourly jackpot amounts for a given currency from a remote server. Let's delve into its components:<br>
1. Package and Imports: It belongs to the services package and imports necessary classes from external libraries (Gson for JSON parsing) and internal models (JackpotResponse). It is used to map the response as a Java object.<br><br>
2. scrapeHourlyJackpot Method: This is the core functionality of the class. It takes a currency as input and returns the hourly jackpot amount for that currency.<br><br>
a. Building URL: It constructs the URL for the HTTP request using the provided currency and a predefined request URL (REQUEST_URL).<br><br>
b. HTTP Client and Request Setup: It creates an instance of HttpClient and prepares an HTTP request with the constructed URL.<br><br>
c. Sending Request and Handling Response: It sends the HTTP request synchronously and waits for the response. Upon receiving the response, it extracts the response body as a string.<br><br>
d. JSON Parsing: It uses Gson to parse the JSON response body into a JackpotResponse object, which represents the structure of the response.<br><br>
e. Handling Response Data: It checks if the response indicates success. If successful, it iterates through the jackpot data to find the specific jackpot named JACKPOT_NAME and returns its amount. If the jackpot is not found or there's an error in the process, it returns a predefined "not found" message (MESSAGE_NOT_FOUND).<br><br>
f. Exception Handling: It catches any IO or InterruptedException that might occur during the HTTP request/response process and prints the stack trace.<br><br>

