package connect.nissan.com.calendarpoc;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<HashMap<String,Object>> list=new ArrayList<>();

    String[] calendarProjection =
            new String[] {
        
        
        

                    CalendarContract.Calendars._ID,
                    CalendarContract.Calendars.ACCOUNT_NAME,
                    CalendarContract.Calendars.ACCOUNT_TYPE,
                    CalendarContract.Calendars.NAME,
                    CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,
                    CalendarContract.Calendars.CALENDAR_COLOR,
                    CalendarContract.Calendars.CALENDAR_ACCESS_LEVEL,
                    CalendarContract.Calendars.OWNER_ACCOUNT,
                    CalendarContract.Calendars.SYNC_EVENTS,
                    CalendarContract.Calendars.CALENDAR_TIME_ZONE,
                    CalendarContract.Calendars.ALLOWED_REMINDERS
            };

    List<String> tempList = new ArrayList<String>(Arrays.asList(calendarProjection));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tempList.add(CalendarContract.Calendars.ALLOWED_AVAILABILITY);
        tempList.add(CalendarContract.Calendars.ALLOWED_ATTENDEE_TYPES);

        ContentResolver contentResolver = getContentResolver();
        final Cursor cursor = contentResolver.query(CalendarContract.Calendars.CONTENT_URI,
                tempList.toArray(new String[tempList.size()]), null, null, null);


        if (cursor.moveToFirst()) {
            int columnsQty = cursor.getColumnCount();
            while (cursor.moveToNext()) {
                HashMap<String,Object> calendarEvent=new HashMap<>();
calendarEvent.put(CalendarContract.Calendars._ID,cursor.getInt(0));
                calendarEvent.put(CalendarContract.Calendars.ACCOUNT_NAME,cursor.getString(1));

calendarEvent.put(CalendarContract.Calendars.ACCOUNT_TYPE,cursor.getString(2));
                calendarEvent.put(CalendarContract.Calendars.NAME,cursor.getString(3));
                calendarEvent.put(CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,cursor.getString(4));
                calendarEvent.put(CalendarContract.Calendars.CALENDAR_COLOR,cursor.getString(5));
                calendarEvent.put(CalendarContract.Calendars.CALENDAR_ACCESS_LEVEL,cursor.getString(6));
                calendarEvent.put(CalendarContract.Calendars.OWNER_ACCOUNT,cursor.getString(7));
                calendarEvent.put(CalendarContract.Calendars.SYNC_EVENTS,cursor.getString(8));
                calendarEvent.put(CalendarContract.Calendars.CALENDAR_TIME_ZONE,cursor.getString(9));
                calendarEvent.put(CalendarContract.Calendars.ALLOWED_REMINDERS,cursor.getString(10));
                list.add(calendarEvent);
            }
        }
        System.out.println(list);
    }

}
