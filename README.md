# Food Blog

# Getting Started
This project is meant to be used in tandem with the FullStackFrontend application. For instructions on how to open the front end application, please see the README file under the FullStackFrontend directory.

Begin by opening application.properties in the resources folder. Ensure that your local database contains a Schema title 'blogdatabase'.

input your personal username and password used for your mySQL on lines 5 and 6 respectively. In addition to those fields, also be sure to change line 9 for the spring.jpa.hibernate.ddl-auto to 'create'

Next open the DemoApplication file under the src folder. You can run the application at this time.

Navigate to your database and open the sessions table. In the sessions table, input an id of 1 and a user_id of 0.

# Front End
After your front end file is set up according to the README instructions, you can open site by typing in the command ng serve --open into the front end terminal.

# Using the Website
The website will bring you to the home page to start with. Because there are no blogs yet, this home directory will be blank. All users can view this home directory whether logged in or logged out.

In the bottom righthand corner, there is a Login button. You can click this in order to be redirected to the login page. If this is your first time opening the app, since you do not have any data in your tables yet, you can create a new user by hitting the green link titled 'here' at the bottom of this page.

At the user login, type in your credentials. You'll need a username, email address, and password containing 8 characters, including at least one letter, one number, and one random character.
After creating a new user, navigate back to the login page and use the user name and password that were just created.

This will take you to the user home page. Again, this will be empty since the user has not created any blogs yet.

User Home This page will display the username of the currently logged in user, their user profile image and a list of all blogs posted on the site by this user. Clicking on one of the blog titles will navigate the user to the Blog Page associated with that blog. Clicking on the user's profile image will display a form that will allow them to provide a link to an image they would like to set as their profile image. Clicking the 'X' on the form will cancel this operation. Clicking submit will use the link provided to reset their profile image. Each blog also has a delete button, which will permanently remove that blog from the site, and an edit button, which will allow them to edit the content, title, image, tags and recipe associated with that particular blog.

Blog Page The Blog Page will display the contents of a specific blog, including the body, recipe and tags associated with that blog, as well as a single image if one is associated with that blog.

Create Blog This page will allow users to create a Blog Post. A Title and Content are required. Recipe, tags and an image are optional. Upon clicking submit, the blog is added to the database and associated with the currently logged in user, if there is one.

Edit Blog This page has functionality that mirrors the Create Blog page, however the contents of the form are preloaded with the associated blog being edited, and clicking submit will update the existing blog instead of creating a new one.

Search This page allows users to search the entire database for blogs either by Tag or by Title. Checking the checkbox will search by Tag, deselecting it will allow searching by Blog Title

Contact Us This page navigates to a form that allows users, either logged in or not to contact the proprietors of the website with feedback. Clicking submit on the feedback will navigate to the Thank You Page

Thank You Page This page provides a breif communication with the reader, thanking them for contacting the website. Clicking the back button will return the user to the page they were viewing before they clicked on the 'Contact Us' link.

About Us Page Displays a short description of the website and it's proprietors. Clicking the back button will return to whatever page was being viewed before navigating to this one.