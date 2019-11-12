package social.manager;

import java.io.File;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramGetUserFollowersRequest;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.InstagramUploadPhotoRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramGetUserFollowersResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramLoginResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// Login to instagram
    	Instagram4j instagram = Instagram4j.builder().username("user").password("senha").build();
    	instagram.setup();
    	try {
			InstagramLoginResult user = instagram.login();
			InstagramSearchUsernameResult userResult = instagram.sendRequest(new InstagramSearchUsernameRequest("solefy.me"));
			System.out.println("ID for @solefy.me is " + userResult.getUser().getPk());
			System.out.println("Number of followers: " + userResult.getUser().getFollower_count());
			instagram.sendRequest(new InstagramUploadPhotoRequest(
			        new File("image.jpg"),
			        "Posted with Instagram4j, how cool is that?"));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
        System.out.println( "Hello World!" );
    }
}
