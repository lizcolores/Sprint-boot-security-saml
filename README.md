You need to start with a configuration of the okta service, for that we should follow the following steps.

1. Create a free Okta Developer Edition organization https://developer.okta.com/signup/

2. Click Admin / Add Applications.

3. Click Create New App.

4. Select SAML 2.0, and then click Create. 

5. In the App name field, enter a name, and click Next. 

6. Enter the following SAML Settings:

*  Single Sign-On URL: http://localhost:8080/saml/SSO

*  Use this for Recipient URL and Destination URL: YES

*  Audience URI: http://localhost:8080/saml/metadata


7. Select the following two options:

- I’m an Okta customer adding an internal app

- This is an internal app that we have created


8. Add people, you will have to go to the developer console > Users > People >  Add person

9. Return to Classic UI in the application, navigate to Assignments > Assign to People.

10. Navigate to Sign On and copy the following values to your /src/main/resources/application.properties



11. Generate a keystore. Put as keystore password: secret and alias password: spring

keytool -genkey -alias <SERVICE_PROVIDER_ALIAS> -keyalg RSA -keystore<KEYSTORE_FILENAME> 

12. Run your Spring Boot application
13. Navigate to your application’s home page at http://localhost:8443

14. For database authentication, log in using dbuser@dbauth.com / test1234
