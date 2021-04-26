$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/features/order.feature");
formatter.feature({
  "name": "To place a order for Automation practise in Retailer Online portal",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "As a online customer, i need to place a order and verify order history",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user lands on login page",
  "keyword": "Given "
});
formatter.match({
  "location": "login_step_def.launchBroswer()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters email address and password",
  "keyword": "When "
});
formatter.match({
  "location": "login_step_def.logindetails()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on First name on right top corner",
  "keyword": "And "
});
formatter.match({
  "location": "login_step_def.clickPersonalDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Changed personal information of first name",
  "keyword": "Then "
});
formatter.match({
  "location": "login_step_def.Details()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});