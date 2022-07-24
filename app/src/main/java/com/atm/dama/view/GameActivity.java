package com.atm.dama.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.atm.dama.R;
import com.atm.dama.model.Board;
import com.atm.dama.model.Move;
import com.atm.dama.model.Piece;
import com.atm.dama.model.Player;

import java.util.HashMap;
import java.util.Map;

public class GameActivity extends AppCompatActivity {
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText newName;
    private int avatarSelected;
    private boolean lf;
    private ImageView avatar;
    private ImageView player=null;
    private Button save;
    HashMap<Integer,String> posicao = new HashMap<Integer,String>();
    String startPosition=null;
    String endPosition=null;
    boolean turn;
    Board b = new Board();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().hide();

        this.Preencher();

    }
    public void avatarSelect(View v){

        ImageView avatar1 = findViewById(R.id.photo1);
        ImageView avatar2 = findViewById(R.id.photo2);
        ImageView avatar3 = findViewById(R.id.photo3);
        ImageView avatar4 = findViewById(R.id.photo4);
        ImageView avatar5 = findViewById(R.id.photo5);
        ImageView avatar6 = findViewById(R.id.photo6);
       if (R.id.photo1 == v.getId()){
           avatarSelected=1;
           player=findViewById(R.id.imagePlayer);
           if (lf){
               createPlayer(true);

           }else{
               createPlayer(false);
           }

        }else if (R.id.photo2 == v.getId()) {
           avatarSelected = 2;
           player = findViewById(R.id.imagePlayer);
           if (lf) {
               createPlayer(true);

           } else {
               createPlayer(false);
           }
       }
        /*else if (avatar2.getId()==v.getId()){
            player.setImageResource(R.drawable.profile2);
        }else if (avatar3.getId()==v.getId()){
            player.setImageResource(R.drawable.profile3);
        }else if(avatar4.getId()==v.getId()){
            player.setImageResource(R.drawable.profile4);
        }else if(avatar5.getId()==v.getId()){
            player.setImageResource(R.drawable.profile5);
        }else{
            player.setImageResource(R.drawable.profile6);
        }*/
    }
    public void createPlayer(boolean leftPlayer){
        lf=leftPlayer;
        dialogBuilder = new AlertDialog.Builder(this);
        final  View popup = getLayoutInflater().inflate(R.layout.players, null);
        newName = popup.findViewById(R.id.NomeJogador);
        save = popup.findViewById(R.id.btnSend);
        dialogBuilder.setView(popup);
        dialog = dialogBuilder.create();
        dialog.show();
        if (leftPlayer){
            //int id = (int) R.id.imagePlayer;
            //ImageView pl = findViewById(id);

                /*AlertDialog.Builder x = new AlertDialog.Builder(this);
                x.setMessage(Integer.toString(avatarSelected));
                x.show();*/
                if (avatarSelected==1){
                    //pl.setImageResource(R.drawable.p1);
                    //player=null;
                }else if (avatarSelected==2){
                    //player.setImageResource(R.drawable.profile2);
                    //player=null;
                }

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView name = findViewById(R.id.j1);
                    Player.setNomePlayer1(newName.getText().toString());
                    name.setText(Player.getNomePlayer1());
                    dialog.dismiss();

                }
            });
        }else{
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView name = findViewById(R.id.j2);
                    Player.setNomePlayer2(newName.getText().toString());
                    name.setText(Player.getNomePlayer2());
                    dialog.dismiss();
                }
            });
        }
    }
    public void changeAvatar(View v){
        dialogBuilder = new AlertDialog.Builder(this);
        final  View popup = getLayoutInflater().inflate(R.layout.avatar, null);
        dialogBuilder.setView(popup);
        dialog = dialogBuilder.create();
        dialog.show();

    }
    public void limparCor(){
        int k = (int) R.id.btn00;
        for (int i = 0; i < b.getBoardElements().length; i++) {
            for (int j = 0; j < b.getBoardElements()[0].length; j++) {
                if ((i + j) % 2 == 0 && i < 8 ){
                    ImageView g = findViewById(k);
                    g.setBackgroundResource(R.drawable.qua2);

                }
                k++;
            }
        }
    }
    public void move(View v){
        //limparCor();
        int pos = v.getId();
        int k = (int) v.getId();

        //int i = (int) v.getId();
        //ImageView g = findViewById(i);
        //layout.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.ready)
        //g.setBackgroundResource(R.drawable.quadrado);
        if (posicao.containsKey(pos)){
            if (startPosition==null){
                startPosition = posicao.get(pos);
                if (b.getBoardElements()[Integer.parseInt(startPosition.substring(0,1))][Integer.parseInt(startPosition.substring(2,3))] != null){
                    ImageView g = findViewById(k);
                    g.setBackgroundResource(R.drawable.quadrado);
                    int x = Integer.parseInt(startPosition.substring(0,1));
                    int y = Integer.parseInt(startPosition.substring(2,3));
                    b.canGo(x,y);
                    if(b.getBoardElements()[x][y].topo){
                        if (b.bottonleft){
                            String xy = Integer.toString(x+1)+","+Integer.toString(y-1);
                            for (Map.Entry<Integer, String> entry : posicao.entrySet()) {
                                if (entry.getValue().equals(xy)) {
                                    int p = (int) entry.getKey();
                                    ImageView c = findViewById(p);
                                    c.setBackgroundResource(R.drawable.rigthquadrado);
                                }
                            }

                        }
                        if (b.bottonrigth){
                            String xy = Integer.toString(x+1)+","+Integer.toString(y+1);
                            for (Map.Entry<Integer, String> entry : posicao.entrySet()) {
                                if (entry.getValue().equals(xy)) {
                                    int p = (int) entry.getKey();
                                    ImageView c = findViewById(p);
                                    c.setBackgroundResource(R.drawable.rigthquadrado);
                                }
                            }

                        }
                    }
                    if(b.getBoardElements()[x][y].topo==false){
                        if (b.topleft){
                            String xy = Integer.toString(x-1)+","+Integer.toString(y-1);
                            for (Map.Entry<Integer, String> entry : posicao.entrySet()) {
                                if (entry.getValue().equals(xy)) {
                                    int p = (int) entry.getKey();
                                    ImageView c = findViewById(p);
                                    c.setBackgroundResource(R.drawable.rigthquadrado);
                                }
                            }

                        }
                        if (b.toprigth){
                            String xy = Integer.toString(x-1)+","+Integer.toString(y+1);
                            for (Map.Entry<Integer, String> entry : posicao.entrySet()) {
                                if (entry.getValue().equals(xy)) {
                                    int p = (int) entry.getKey();
                                    ImageView c = findViewById(p);
                                    c.setBackgroundResource(R.drawable.rigthquadrado);
                                }
                            }

                        }
                    }


                }


            }else{
                endPosition= posicao.get(pos);
                if (startPosition != endPosition ){
                    Move m = new Move(startPosition,endPosition);
                    b.move(m);
                    Preencher();
                    startPosition=null;
                }
            }
        }
    }
    public void LimparTabela(){
        //limparCor();
        int id = (int) R.id.btn00;
        for (int i = 0; i < b.getBoardElements().length; i++) {
            for (int j = 0; j < b.getBoardElements()[0].length; j++){
                ImageView bu = findViewById(id);
                bu.setImageDrawable(null);
                id++;
            }
        }
    }
    public void Preencher(){
        limparCor();
        b.dama();
        if (b.winner()!=null){
            AlertDialog.Builder x = new AlertDialog.Builder(this);
            x.setMessage(b.winner());
            x.show();
        }
        int id = (int) R.id.btn00;
        //ImageView bu = (ImageView) findViewById(id) ;
        //AlertDialog.Builder x = new AlertDialog.Builder(this);
        //x.setMessage(Integer.toString(bu.getId()));
        //x.show();
       // bu.setImageResource(id);
        this.LimparTabela();
        if (Piece.topoTurn){
            TextView t = findViewById(R.id.j1);
            t.setText(Player.getNomePlayer1() + ": Sua Vez");
            TextView a = findViewById(R.id.j2);
            a.setText(Player.getNomePlayer2());

        }else {
            TextView t = findViewById(R.id.j2);
            t.setText(" Sua Vez: "+Player.getNomePlayer2());
            TextView a = findViewById(R.id.j1);
            a.setText(Player.getNomePlayer1());
        }
        for (int i = 0; i < b.getBoardElements().length; i++) {
            for (int j = 0; j < b.getBoardElements()[0].length; j++) {
                if((i + j) % 2 == 0 && i < 8 ){
                    posicao.put(id,Integer.toString(i)+","+Integer.toString(j));
                 }

                if (b.getBoardElements()[i][j] != null && b.getBoardElements()[i][j].topo){
                    if ( b.getBoardElements()[i][j].isDama()){
                        ImageView bu = findViewById(id);
                        bu.setImageResource(R.drawable.damap1);
                    }else{
                        ImageView bu = findViewById(id);
                        bu.setImageResource(R.drawable.p1);
                    }


                }else if (b.getBoardElements()[i][j] != null && b.getBoardElements()[i][j].topo != true){
                    if ( b.getBoardElements()[i][j].isDama()){
                        ImageView bu = findViewById(id);
                        bu.setImageResource(R.drawable.damap2);
                    }else{
                        ImageView bu = findViewById(id);
                        bu.setImageResource(R.drawable.p2);
                    }

                }
                id++;
            }
        }
        //b.dama();

    }
    public void Players(View v){
        int id = v.getId();


        ImageView b = findViewById(R.id.imageJ1);
        if (id==b.getId()){
            createPlayer(true);
        }else{
            createPlayer(false);
        }
    }
}