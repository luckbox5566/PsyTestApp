package t.p.c.psylist;

import androidx.appcompat.app.AppCompatActivity;
import test.psy.com.psyctest.R;

import android.os.Bundle;

public class PsyListActivity extends AppCompatActivity implements LefttFragment.OnListSeclectd {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psy_list);
    }

    //接受从左边fragment传输过来的数据，并且转给右边的fragment
    @Override
    public void onListSeclected(int postion) {
        RightFragment rightFragment= (RightFragment) getSupportFragmentManager().findFragmentById(R.id.psy_left_fragment);
        rightFragment.updateRihgtList(postion);
    }
}
