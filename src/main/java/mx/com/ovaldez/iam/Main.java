package mx.com.ovaldez.iam;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.rds.auth.GetIamAuthTokenRequest;
import com.amazonaws.services.rds.auth.RdsIamAuthTokenGenerator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String region = "us-est-2";
	    String hostname = "mydatabase.c08oynukl3ie.us-east-2.rds.amazonaws.com";
	    String port = "3306";
	    String username = "root";
	
	    System.out.println(generateAuthToken(region, hostname, port, username));
	}

	static String generateAuthToken(String region, String hostName, String port, String username) {

	    RdsIamAuthTokenGenerator generator = RdsIamAuthTokenGenerator.builder()
		    .credentials(new DefaultAWSCredentialsProviderChain())
		    .region(region)
		    .build();

	    String authToken = generator.getAuthToken(
		    GetIamAuthTokenRequest.builder()
		    .hostname(hostName)
		    .port(Integer.parseInt(port))
		    .userName(username)
		    .build());
	    
	    return authToken;
    }
}
