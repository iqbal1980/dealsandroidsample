package it.flashr;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public abstract class MyListActivity extends ListActivity
{
   /**
	* Inflate Menu from XML
	*/
	public boolean onCreateOptionsMenu(Menu menu) {
	    super.onCreateOptionsMenu(menu);
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu, menu);
	    return true;
	}

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
	   switch (item.getItemId())
       {
       case R.id.menu_0:
           ////Calls another activity, by name, without passing data
		   Intent iExp = new Intent(this, SettingsActivity.class);
		   startActivity(iExp);Toast.makeText(MyListActivity.this, "Bookmark is Selected", Toast.LENGTH_SHORT).show();
           return true;
       }
		return true;
   }    
}