package jp.ac.jec.jz.jz250127.ex0302;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btCalc = findViewById(R.id.btCalc);
        CalcListener listener = new CalcListener();
        btCalc.setOnClickListener(listener);
    }

    private class CalcListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText etValue1 = findViewById(R.id.etValue1);
            EditText etValue2 = findViewById(R.id.etValue2);
            Spinner spOperator = findViewById(R.id.spOperator);
            TextView tvResult = findViewById(R.id.tvResult);

            int id = view.getId();

            if (id == R.id.btCalc) {
               String value1 = etValue1.getText().toString();
                String value2 = etValue2.getText().toString();
                String operator = spOperator.getSelectedItem().toString();
                String expression;

                if (value1.equals("") || value2.equals("")) {
                    expression = "計算エラー";
                } else {
                    int num1 = Integer.parseInt(value1);
                    int num2 = Integer.parseInt(value2);
                    int ret = 0;
                    boolean isError = false;

                    switch (operator) {
                        case "+":
                            ret = num1 + num2;
                            break;
                        case "-":
                            ret = num1 - num2;
                            break;
                        case "*":
                            ret = num1 * num2;
                            break;
                        case "/":
                            if (num2 == 0) {
                                isError = true;
                            } else {
                                ret = num1 / num2;
                            }
                            break;
                    }

                    if (isError) {
                        expression = "計算エラー";
                    } else {
                        expression = value1 + operator + value2 + "=" + ret;
                    }
                }

                tvResult.setText(expression);
            }
        }
    }
}
