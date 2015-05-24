@regression
Feature: Greetings

  Scenario: Say greetings
    Given a persons name is Tom
    When he says hello
    Then he gets a greeting back
