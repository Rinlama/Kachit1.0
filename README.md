Kachit1.0/README.md
******************************
********Login Activity*******
******************************

1. The user is navigated to the login activity from the main activity
2. the user enters credentials then the login button is pressed 
3. if the user has correct credentials, he/she will be navigated to the main activity
4. if user does not have credentials or enters in wrong credentials,  a toast will pop-up “Invalid Username and Password”
5. the user can also choose to signup(signup button).

******************************
********Signup Activity*****
******************************

1. the user is navigate to the signup activity from the login activity
2. the user enters all his/her credentials username, email, password, confirm password.
3. the user then presses the signup button.
4. the data is stored in the embedded database. table_name = useracct

All verification is  done with the DatabaseHelper. If the user has credentials and if they are correct.

********************************************
********Main Activity & Post Activity*****
********************************************

1. The user is navigated to a main activity
2. If a user has not sign up, then he/she needs to sign up firs to add a post
3. If a user login, he/she can add a new post. The data stores on SqlLite 
4. After he/she added a new post, app will go to Main Activity and Listing all the post on Listview with DataAdatper.
5. User can click on list view, it shows a toast message of his/her address.
6. It also alert to navigate to their home address, if he/she clicks on yes then Map app will open and shows a the address of the   post.


