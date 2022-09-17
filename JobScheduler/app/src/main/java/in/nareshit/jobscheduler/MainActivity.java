package in.nareshit.jobscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    JobScheduler scheduler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
    }

    public void scheduleJob(View view) {
        JobInfo.Builder builder = new JobInfo.Builder(14,
                new ComponentName(getPackageName(),MyJobService.class.getName()));
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);

        JobInfo jobInfo = builder.build();

        scheduler.schedule(jobInfo);
    }
}

/*
* JobService
* JobInfo
* JobScheduler
* */