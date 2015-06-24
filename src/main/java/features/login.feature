Feature: As Lucianna User I shoubd be able to login to application

   Scenario: Login
   Given I open lucianna
   When I enter login "nadin.slusarenko1@gmail.com" and password "1qwerty12"
   Then I should be logged in"