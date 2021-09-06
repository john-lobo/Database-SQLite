package com.johnlennonlobo.databasesqlite

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try{
            //TODO -> Criar Banco de dados
            val bancoDados = openOrCreateDatabase("app", MODE_PRIVATE,null)

            with(bancoDados) {

                //TODO -> Criar tabela
                execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))")

                //TODO -> apagar tabela
                //execSQL("DROP TABLE pessoas")

                //TODO -> Inserir dados
//                execSQL("INSERT INTO pessoas (nome,idade) VALUES('João', 8)")
//                 execSQL("INSERT INTO pessoas (nome,idade) VALUES('Benjamim', 0)")
//                 execSQL("INSERT INTO pessoas (nome,idade) VALUES('Suzanne', 26)")
//                 execSQL("INSERT INTO pessoas (nome,idade) VALUES('John', 24)")

                //TODO -> Atualizar item na tabela
                //execSQL("UPDATE pessoas SET idade = 1 WHERE nome = 'Benjamim' " )
                //execSQL("UPDATE pessoas SET nome = 'John Lennon' WHERE nome = 'John' " )

                //TODO -> Atualizar item na tabela pelo ID
                //execSQL("UPDATE pessoas SET nome = 'John Lennon' WHERE id = 4 " )

                //TODO -> Deletar item na tabela
                //execSQL("DELETE FROM pessoas WHERE id = 4" )

                //TODO -> Deleta tabela inteira
                //execSQL("DELETE FROM pessoas" )
                
            }

            //TODO -> filtros

            val consulta =
                "SELECT * FROM pessoas "

//            val consulta =
//                "SELECT id, nome, idade " +
//                "FROM pessoas "

//            val consulta =
//                 "SELECT nome, idade " +
//                 "FROM pessoas " +
//                 "WHERE nome = 'John' "

//            val consulta =
//                "SELECT nome, idade " +
//                "FROM pessoas " +
//                "WHERE idade > 0 "

//            val consulta =
//                "SELECT nome, idade " +
//                        "FROM pessoas " +
//                        "WHERE idade > 0 AND nome = 'Suzanne' "

//            val consulta =
//                "SELECT nome, idade " +
//                        "FROM pessoas " +
//                        "WHERE idade = 0 OR nome = 'John' "
//            val consulta =
//                "SELECT nome, idade " +
//                        "FROM pessoas " +
//                        "WHERE idade IN(0,26) "

//            val consulta =
//                "SELECT nome, idade " +
//                        "FROM pessoas " +
//                        "WHERE idade BETWEEN 20 AND 30 "


//            var filtro = "jo"
//            val consulta =
//                "SELECT nome, idade " +
//                        "FROM pessoas " +
//                        "WHERE nome LIKE '%$filtro%' "

            //TODO -> Odernação por numero
//            val consulta =
//                "SELECT nome, idade " +
//                        "FROM pessoas " +
//                        "ORDER BY idade DESC "

//            val consulta =
//                "SELECT nome, idade " +
//                        "FROM pessoas " +
//                        "ORDER BY nome ASC "

//            val consulta =
//                "SELECT nome, idade " +
//                        "FROM pessoas " +
//                        "ORDER BY nome ASC LIMIT 2"


            val cursor = bancoDados.rawQuery(consulta,null)

            //TODO -> Indices da tabela
            val indiceNome = cursor.getColumnIndex("nome")
            val indiceIdade = cursor.getColumnIndex("idade")
            val indiceID = cursor.getColumnIndex("id")

            // TODO -> mover cursor para primeiro item
            cursor.moveToFirst()

            //TODO -> percorrendo colunas
            while (cursor != null){

                //TODO -> recuperar indices
                val nome = cursor.getString(indiceNome)
                val idade = cursor.getString(indiceIdade)
                val id = cursor.getString(indiceID)

            Log.i("RESULTADO id" , "$id -> nome - $nome / idade - $idade"  )

                //TODO -> mover cursor para proximo item
                cursor.moveToNext()
            }

        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}