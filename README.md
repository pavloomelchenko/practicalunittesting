This project contains all my own solved exercises from book 'Practical unit testing with JUnit and Mockito' (2013) by Tomek Kaczanowski.


Some basic unit testing techniques you can find here:  
[BookingSystemRevisitedTest.java](src/test/java/com/mycompany/put/bookingrevisited/BookingSystemRevisitedTest.java),  
[RaceResultsServiceTest.java](src/test/java/com/mycompany/put/raceresults/RaceResultsServiceTest.java),  
[HashMapTest.java](src/test/java/com/mycompany/put/other/HashMapTest.java),  
[HelpDeskTest.java](src/test/java/com/mycompany/put/other/HelpDeskTest.java), etc.

Besides basic techniques it contains:
Parametrized tests (ex. [BookingSystemTest](src/test/java/com/mycompany/put/booking/BookingSystemTest.java), [FahrenheitCelciusConverterTest](src/test/java/com/mycompany/put/other/FahrenheitCelciusConverterTest.java), [PasswordValidatorTest](src/test/java/com/mycompany/put/other/PasswordValidatorTest.java), etc)  
Time testing (ex. [TimeProviderImplTest](src/test/java/com/mycompany/put/other/TimeProviderImplTest.java))  
Multithreading testing ([AtomicIdGeneratorParallelTest](src/test/java/com/mycompany/put/other/AtomicIdGeneratorParallelTest.java))  
Written some code using TDD ([BookingSystemRevisitedTest](src/test/java/com/mycompany/put/bookingrevisited/BookingSystemRevisitedTest.java) and [BookingSystem](src/main/java/com/mycompany/put/bookingrevisited/BookingSystem.java))  
Legacy code testing techniques ([MailClientRedesignedArgumentsTest](src/test/java/com/mycompany/put/legacy/MailClientRedesignedArgumentsTest.java),[MainClientPowerMockTest](src/test/java/com/mycompany/put/legacy/MainClientPowerMockTest.java))  
JUnit enhanced features (custom matchers - [OperatingSystemTest](src/test/java/com/mycompany/put/other/OperatingSystemTest.java), custom test execution listeners - [TimeTestListener](src/main/java/com/mycompany/put/other/TimeSuiteListener.java),
custom junit annotations - [EnhancedRetryTest](src/test/java/com/mycompany/put/test/utils/EnhancedRetryTest.java))

Important to understand that classes under test here DO NOT include full functionality. They were implemented for SOLE PURPOSE: learn best practices of testing.
