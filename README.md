# WmCi
> A lighter *Testing Automation Framework* for [WebMethods Integration Server](http://www.softwareag.com/corporate/products/webmethods_integration/integration/overview/default.asp), pointed to maximize your *Continuous Integration* capabilities. The backend for the `Flows` and `Java Services` are imported from the `WmCiJava.jar` file, and no other Jar dependency is required on installation, you can see more on [WmCiJava ](https://github.com/wm-ci/WmCiJava/tree/master) project for backend details.

[How to install](#how-to-install)

## Basic Assertions
This are the basic assertion flows, you can use them for developing testing units inside your WebMethods Integration Server.

   |IS Java Service||
---|---|---
1.|WmCi.assertion:equal|Evaluates if two variables are equals
2.|WmCi.assertion:notEqual|Evaluates if two variables are different
3.|WmCi.assertion:matches|Evaluates the match using java `Matcher.matches()`
4.|WmCi.assertion:contains|Evaluates the match using java `Matcher.find()`
5.|WmCi.assertion:notContains|Evaluates the match using java `Matcher.find()`
6.|WmCi.assertion:decode|An `SQL Decode` function like implementation, it evaluates if a variable is equal to a value from a `PairConditionsArray`, and then return the value for the condition that matches the input value, otherwise it will return the `default value`.
7.|WmCi.assertion:greatThan|Evaluates if an `A variable` is great than `B variable`
8.|WmCi.assertion:greatThanEqual|Evaluates if an `A variable` is great or equal than `B variable`
9.|WmCi.assertion:isNull|Evaluates if a variable is `Null`
10.|WmCi.assertion:isNotNull|Evaluates if a variable is `Not Null`
11.|WmCi.assertion:lessThan|Evaluates if an `A variable` is less than `B variable`
12.|WmCi.assertion:lessThanEqual|Evaluates if an `A variable` is less or equal than `B variable`

To add a Unit Test on your IS, you need to need to develop a `Flow Service` implementing the `WmCi.spec:BasicUnitTest` interface, and then add many steps using `Java Services` from `WmCi.assertion:*` package.

## Specifications
Yo can extend the testing framework developing your own *Custom Assertions* or add new *Unit Tests*, just create `IS Services` implementing the `Basic Specifications`:

   |Basic IS Specification| |
---|---|---
1.|WmCi.spec:BasicAssert|Used to build custom made assertions
2.|WmCi.spec:BasicUnitTest|Implement this interface to add new *Unit Tests* on your IS Server


## Utility API
And extra utility Api with useful functions that will help you to ease your work while developing flow services.

   |IS Java Service||
---|---|---
1.|WmCi.util:nvl|Evaluates if a variable is `Null`
2.|WmCi.util:decode|And `SQL Decode` function like implementation, it evaluates if a variable is equal to a value from `PairConditionsArray`, and then return the value for the condition that matches the input value, otherwise it will return the `default value`.
3.|WmCi.util:doNotMapNullOrBlanks|If will not map a variable to `Pipe Line` if it is `Null` or `Empty`
4.|WmCi.util:buildPairConditionsArray|Returns an array with many `PairCondition`, which `PairCondition = new [Key, Value]`, and a `default value` that will be returned if nothing matches the conditions.


## How to install
TODO:
