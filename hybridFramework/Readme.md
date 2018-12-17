Project :-
Aconex Automation

Getting Started:-
AconexTests consists 3 tests

Prerequisites:
Install autoIT tool to handle file upload window

Installing:-
Download the project
Download dependent libraries by right click pom file -> maven install

Running the tests:-
testng file has the tests.
Right click and run as testNG

Scenario1:
1. Open url https://qa123.aconex.com/Logon
2. Enter username/password as: challenge1 / dEMO12345!@#$%
3. Select project as “Hotel VIP Resort” from project menu
4. Navigate to Documents à upload new document
5. Enter details as
• Document number as any 12 digit random number ( have to use the same
number for searching document)
• attach local file provided as attachment (test.pdf)
• Fill other mandatory fields with any data
6. Click on upload button
7. Navigate to Documents à Document Register from the menu, Enter document
number( 12 digit random number ) and verify that document exists in search results

Scenario2:
1. Open url https://qa123.aconex.com/Logon
2. Enter username/password as: challenge1 / dEMO12345!@#$%
3. Select project as “world games”
4. Navigate to workflows à assigned to my organization from menu and get results
count and verify count is not “zero”

Scenraio3:
1. Open url https://qa123.aconex.com/Logo
2. Enter username/password as: challenge1 / dEMO12345!@#$%
3. Navigate to Mail à Blank mail
4. Select type as “ transmittal”
5. Fill all mandatory details with random data
• Enter “lewis” in to and click on enter it will display Mr Lewis Miller - AJ
6. Click on “send” button and close browser

Environment - down message

Sorry, that request didn’t go through

If you need help, contact the Helpdesk.

