### Overview

This is an Web module for Shopping Service which redirects the REST requests to the Microservices Layer. This redirection layer layer is introduced to solve the CORS problem. 


<br><br>
<b>Build WAR using Maven</b>

1. Ensure maven is installed
2. On command prompt, navigate to ShoppingWebBFFService project
3. Run "mvn clean package" command
4. ShoppingWebBFFService-0.1.war is created under ShoppingWebBFFService/target directory
5. Use this war file for deploying the Web module for Shopping Service on app server

<br>
<b>Security Configuration in server.xml</b>
The backend services are secured with basic authentication. Hence the redirection REST service layer also needs to be secured. Add the following Basic Registry in server.xml file

    <basicRegistry id="basic" realm="BasicRealm"> 
        <!-- <user name="yourUserName" password="" />  -->
        <group name="SecureShopper">
        	<member name="rbarcia"/>
        	<member name="kbrown"/>
        </group>
        <user name="rbarcia" password="{xor}PTNvKDk2LDc="/> <!-- Refer parent documentation for passwords for these users -->
        <user name="kbrown" password="{xor}PTNvKDk2LDc="/> <!-- Refer parent documentation for passwords for these users -->
    </basicRegistry>
