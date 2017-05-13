This project contains all written by myself exercises from book 'Practical unit testing with JUnit and Mockito' (2013) by Tomek Kaczanowski.


Some basic unit testing techniques you can find here:
[BookingSystemRevisitedTest.java](src/test/java/com/mycompany/put/bookingrevisited/BookingSystemRevisitedTest.java), RaceResultsServiceTest.java, HashMapTest.java, HelpDeskTest.java, etc.

Besides basic techniques it contains:
Parametrized tests(ex. BookingSystemTest, FahrenheitCelciusConverterTest, PasswordValidatorTest, etc)
Time testing(ex. TimeProviderImplTest)
Multithreading testing (AtomicIdGeneratorParallelTest)
Written some code using TDD (BookingSystemRevisitedTest and com.mycompany.put.bookingrevisited.BookingSystem)
Legacy code testing techniques (MailClientRedesignedArgumentsTest,MainClientPowerMockTest)
JUnit enhanced features (custom matchers - OperatingSystemTest, custom test execution listeners - TimeTestListener,
custom junit annotations - EnhancedRetryTest)

Important to understand that classes under test here DO NOT include full functionality. They were implemented for SOLE PURPOSE: learn best practices of testing.
