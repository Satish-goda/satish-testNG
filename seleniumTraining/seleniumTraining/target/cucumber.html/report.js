$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/cucumber/SubmitOrder.feature");
formatter.feature({
  "name": "Purchasing an order from Ecommerce website",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenarioOutline({
  "name": "positive test of submittting the order",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag2"
    }
  ]
});
formatter.step({
  "name": "Logged in with username \u003cname\u003e and password \u003cpassword\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "I add product \u003cproductName\u003e to cart",
  "keyword": "When "
});
formatter.step({
  "name": "Checkout \u003cproductName\u003e and submit the order",
  "keyword": "And "
});
formatter.step({
  "name": "\"THANKYOU FOR THE ORDER.\" message is displayed on ConfirmPage",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "name",
        "password",
        "productName"
      ]
    },
    {
      "cells": [
        "satishpractice8@gmail.com",
        "Satish@123",
        "IPHONE 13 PRO"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I landed on Ecommerce Page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitionImple.I_landed_on_Ecommerce_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "positive test of submittting the order",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag2"
    }
  ]
});
formatter.step({
  "name": "Logged in with username satishpractice8@gmail.com and password Satish@123",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitionImple.loged_in_username_and_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add product IPHONE 13 PRO to cart",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitionImple.i_add_product_to_cart(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Checkout IPHONE 13 PRO and submit the order",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitionImple.checkout_submit_order(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"THANKYOU FOR THE ORDER.\" message is displayed on ConfirmPage",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitionImple.message_displayed_confirmationPage(String)"
});
formatter.result({
  "status": "passed"
});
});