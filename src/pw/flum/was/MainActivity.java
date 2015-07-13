package pw.flum.was;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class MainActivity extends Activity {
	private Twitter twitter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button main_wol = (Button)this.findViewById(R.id.main_wol);
		Button main_sleep = (Button)this.findViewById(R.id.main_sleep);
		Button sub_wol = (Button)this.findViewById(R.id.sub_wol);
		Button sub_sleep = (Button)this.findViewById(R.id.sub_sleep);
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true)
	            .setOAuthConsumerKey("")
	            .setOAuthConsumerSecret("")
	            .setOAuthAccessToken("")
	            .setOAuthAccessTokenSecret("");
	    TwitterFactory tf = new TwitterFactory(cb.build());
	    twitter = tf.getInstance();
		
		main_wol.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	try {
					twitter.updateStatus("@flum_ main_wol");
				} catch (TwitterException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
            	
            }
        });
		
		main_sleep.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	try {
					twitter.updateStatus("@flum_ main_sleep");
				} catch (TwitterException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
            }
        });
		
		sub_wol.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	try {
					twitter.updateStatus("@flum_ sub_wol");
				} catch (TwitterException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
            }
        });
		
		sub_sleep.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	try {
					twitter.updateStatus("@flum_ sub_sleep");
				} catch (TwitterException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
