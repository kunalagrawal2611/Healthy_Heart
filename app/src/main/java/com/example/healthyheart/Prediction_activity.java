package com.example.healthyheart;

import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Prediction_activity extends AppCompatActivity {

    Button pred_btn;
    TextView result;
    Interpreter interpreter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_prediction);

        pred_btn = (Button) findViewById(R.id.predict_btn);
        result = (TextView) findViewById(R.id.result_check);

        try {
            interpreter = new Interpreter(loadModelFile(),null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        pred_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("About to start");
                float f =  doInference("4");
                System.out.println("About to print");
                result.setText("Result - "+f);

            }
        });
    }

    private MappedByteBuffer loadModelFile() throws IOException
    {
        System.out.println("Accessing the file");
        AssetFileDescriptor assetFileDescriptor = this.getAssets().openFd("heart_linear.tflite");
        FileInputStream fileInputStream = new FileInputStream(assetFileDescriptor.getFileDescriptor());
        FileChannel fileChannel = fileInputStream.getChannel();

        long startOffset = assetFileDescriptor.getStartOffset();
        long len = assetFileDescriptor.getLength();

        System.out.println("Length"+len);

        return fileChannel.map(FileChannel.MapMode.READ_ONLY,startOffset,len);
    }

    public float doInference(String val)
    {
        float[] input = new float[1];
        input[0] = Float.parseFloat(val);
        float[][] output = new float[1][1];
        output[0][0] = 7;
        //float input = 1;
        //float output = 2;
        interpreter.run(input,output);
        return  output[0][0];
    }
}
