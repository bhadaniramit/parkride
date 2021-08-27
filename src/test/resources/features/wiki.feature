Feature: User navigate to wiki page and perform
  @auto
  Scenario: the headings listed in the `Contents` box are used as headings on the page
    Given User navigates to wiki Page
    Given User navigates to contents table and check of hyperlinks mentioned under table
#    And Check for the hyperlinks mentioned under the content
    Then check all headings on the page
    And Validate that headings on the page with the list mentioned under the content matches

  Scenario: the headings listed in the `Contents` box have functioning hyperlinks
    Given User navigates to wiki Page
    And User navigates to contents table and check of hyperlinks mentioned under table
    Then validate all the links are navigating user respective headings

  Scenario: Validate the text contains in the 'Nike' popup
    Given User navigates to wiki Page
    When User navigates to NIKE link
    Then Validate the text displayed in the Nike popup

  Scenario: Validate family tree when clicked on `Nike`
    When User navigates to wiki Page
    Then click on the Nike hyperlink
    And validate user navigated to Nike Page
    Then check for the family tree heading on the Nike page

##Note - Below are the Negative Test Cases I will cover
#Scenario: Validate that headings on the page with the list mentioned under the content does not matches
#Scenario: validate links are broken and not navigating to respective headings
#Scenario: Validate Nike popup also navigate to next screen
#Scenario: Fonts of the elements