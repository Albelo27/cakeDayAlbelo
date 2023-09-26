package cs301.birthdaycake;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener{

    private CakeView cakeView;
    private CakeModel cakeModel;
    private Button blowOut;
    private Switch candle;
    private SeekBar numCandleSeek;

    public CakeController(CakeView view, Button blowOutButton, Switch candleSwitch, SeekBar candleBar) {
        cakeView = view;
        cakeModel = cakeView.getModel();
        blowOut = blowOutButton;
        candle = candleSwitch;
        numCandleSeek = candleBar;
        blowOut.setOnClickListener(this);
        candle.setOnCheckedChangeListener(this);
        numCandleSeek.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.blowOutButton) {
            if (cakeModel.candleLit) {
                blowOut.setText("ReLight");
            } else {
                blowOut.setText("Blow Out");
            }
            cakeModel.candleLit = !cakeModel.candleLit;
            cakeView.invalidate();
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            cakeModel.hasCanlde = compoundButton.isChecked();
            cakeView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        cakeModel.numCandle = seekBar.getProgress();
        String test = Integer.toString(seekBar.getProgress());
        Log.d("seekbar", test);
        cakeView.invalidate();
    }

    //unused implemented methods
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
}