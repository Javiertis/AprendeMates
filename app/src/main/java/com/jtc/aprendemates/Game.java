package com.jtc.aprendemates;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.io.Serializable;
import java.util.Random;

public class Game extends AppCompatActivity implements Serializable {
    static final int[] IMAGENES_NUM = {
            R.drawable.ic_num1,
            R.drawable.ic_num2,
            R.drawable.ic_num3,
            R.drawable.ic_num4,
            R.drawable.ic_num5,
            R.drawable.ic_num6,
            R.drawable.ic_num7,
            R.drawable.ic_num8,
            R.drawable.ic_num9
    };
    static final int[] IMAGENES_VIDA = {
            R.drawable.ic_life1,
            R.drawable.ic_life2,
            R.drawable.ic_life3
    };
    static final String[] OPERACIONES = {
            "+",
            "-",
            "x"
    };
    Bundle bundle;
    Player player;
    ImageView imgNum1, imgNum2, imgVidas;
    Button btComprobar;
    TextView txtOperacion, txtScore, txtNum1, txtNum2;
    EditText edTxtNum;
    ValueAnimator failAnimation;
    int expectedResult, n1, n2;
    String op;
    Drawable oldBackground, oldForeground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        bundle = getIntent().getExtras();
        player = new Player(bundle.getString("name"), bundle.getString("level"), bundle.getInt("life", 3), bundle.getInt("score", 0));


        imgNum1 = findViewById(R.id.imgNum1);
        imgNum2 = findViewById(R.id.imgNum2);
        imgVidas = findViewById(R.id.imgVidas);

        btComprobar = findViewById(R.id.btComprobar);

        txtOperacion = findViewById(R.id.txtOperacion);
        txtScore = findViewById(R.id.txtScore);
        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        edTxtNum = findViewById(R.id.edTxtNum);
        oldBackground = edTxtNum.getBackground();
        oldForeground = edTxtNum.getForeground();
        fillOperation(player.getActualLevel());
        txtScore.setText(Integer.toString(player.getScore()));
        setLifeImg();
        btComprobar.setOnClickListener(v -> checkOperation());
        failAnimation = (ValueAnimator) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.error);
        failAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator updatedAnimation) {
                edTxtNum.setBackgroundColor((Integer) updatedAnimation.getAnimatedValue());
            }
        });
        failAnimation.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationEnd(Animator animation) {
                edTxtNum.setForeground(oldForeground);
                edTxtNum.setBackground(oldBackground);
            }

            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        savedInstanceState.putSerializable("player", player);
        savedInstanceState.putInt("n1", n1);
        savedInstanceState.putInt("n2", n2);
        savedInstanceState.putString("op", op);
        super.onSaveInstanceState(savedInstanceState);
    }


    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        player = (Player) savedInstanceState.getSerializable("player");
        n1 = savedInstanceState.getInt("n1");
        n2 = savedInstanceState.getInt("n2");
        op = savedInstanceState.getString("op");
        txtScore.setText(Integer.toString(player.getScore()));
        setLifeImg();
        fillOperation();
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        if (player.getLife() <= 0) {
            this.startActivity(new Intent(this, MainActivity.class));
            this.finishAffinity();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        setLifeImg();
        super.onPause();
    }

    void fillOperation(Level n) {
        Random r = new Random();
        op = OPERACIONES[r.nextInt(n.levelValue() + 1)];
        n1 = r.nextInt(IMAGENES_NUM.length);
        n2 = op.equals("-") ? r.nextInt(n1 + 1) : r.nextInt(IMAGENES_NUM.length);
        imgNum1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), IMAGENES_NUM[n1]));
        imgNum2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), IMAGENES_NUM[n2]));
        expectedResult = operacion(op, n1 + 1, n2 + 1);
    }

    void fillOperation() {
        imgNum1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), IMAGENES_NUM[n1]));
        imgNum2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), IMAGENES_NUM[n2]));
        expectedResult = operacion(op, n1 + 1, n2 + 1);
    }

    void setLifeImg() {
        if (player.getLife() >= 1) {
            imgVidas.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), IMAGENES_VIDA[player.getLife() - 1]));
        } else {
            imgVidas.setImageAlpha(0);
            imgNum1.setImageAlpha(0);
            imgNum2.setImageAlpha(0);
            txtOperacion.setText("");
            txtNum1.setText("");
            txtNum2.setText("");
        }
    }

    int operacion(String op, int x, int y) {
        txtNum1.setText(Integer.toString(x));
        txtNum2.setText(Integer.toString(y));
        if (op.equals("+")) {
            txtOperacion.setText("+");
            return x + y;
        } else if (op.equals("-")) {
            txtOperacion.setText("-");
            return x - y;
        } else {
            txtOperacion.setText("x");
            return x * y;
        }
    }

    void checkOperation() {
        String resultStr = edTxtNum.getText().toString();
        if (!resultStr.equals("")) {
            if (Integer.parseInt(resultStr) == expectedResult) {
                player.scoreUp();
                txtScore.setText(Integer.toString(player.getScore()));
            } else if (player.getLife() >= 1) {
                player.lifeDown();
                failAnimation.start();
                setLifeImg();
            }
            if (player.getLife() <= 0) {
                startActivityPerdido();
            }
            fillOperation(player.getActualLevel());
        }
        if ((player.getScore() == 100 && player.getInitLevel().compareTo(Level.MEDIUM) <= 0) || (player.getScore() == 300 && player.getInitLevel() == Level.EASY)) {
            summonToast();
            player.bonusUp();
            player.levelUp();
        }
        edTxtNum.setText("");
    }

    public void startActivityPerdido() {
        setLifeImg();
        bundle.clear();
        bundle.putSerializable("player", player);
        Intent intent = new Intent(this, Lost.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    public void summonToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

    }
}