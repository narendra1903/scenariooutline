

Feature: i am automating orangeHRM application

Background: common re-usable steps

Given user launch browser 
Then  user opens URL as "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
And user enters username as "Admin" and password as "admin123" and clicks login btn

Scenario Outline: AddSkills functionality

Then user clicks admin 

Then clicks qualification dropdown and clicks skills option

Then click add button
Then enter skillname as <SkillName> and skill description as <SkillDescription> and clicks save btn

Then logout
Then close browser

Examples: 
|SkillName|SkillDescription|
|"Java46"|"Java46 desc"|
|"Java47"|"Java47 desc"|
|"Java48"|"Java48 desc"|





