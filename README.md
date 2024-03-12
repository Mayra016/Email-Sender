# Email-Sender
Spring boot application to send email notifications.


To send emails with this application you need to send a JSON post petition with the email configurations to /sendEmail

JSON example:

{
    "receiver" : "example@gmail.com",
    "from" : "mailtrap@demomailtrap.com",
    "subject" : "Subject",
    "body" : "Email body"
}


In aim to send emails with your email you will need to configure the environment variables ${usernameMailtrap} and ${password}. And change the from on the JSON. 

Mailtrap free service was used to test the functionalitty of the app.
