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

    <ldapRegistry baseDN="dc=purplecompute,dc=com" bindDN="cn=admin,dc=purplecompute,dc=com" bindPassword="{xor}Dz4sLChvLTs=" host="<ldap-server ip>" id="ldap" ignoreCase="true" ldapType="Custom" port="31252" realm="<ldap-server ip>:31252" searchTimeout="8m">
     
        <contextPool enabled="true" initialSize="1" maxSize="0" preferredSize="3" timeout="0s" waitTime="3000ms"/>
        
        <ldapCache>
            <attributesCache enabled="true" size="4000" sizeLimit="2000" timeout="1200s"/>
            <searchResultsCache enabled="true" resultsSizeLimit="1000" size="2000" timeout="600s"/>
        </ldapCache>
    
    </ldapRegistry>
