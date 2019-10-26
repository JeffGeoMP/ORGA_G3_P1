/**
 *
 * @author JeffGeo
 */
import java.util.ArrayList;


public class Analizador {

    public ArrayList<Object> Coordenadas;
    public ArrayList<Object> Errores;
    public ArrayList<Object> Simbolos;
    
    public String lexema;
    public int fila;
    public int columna;
    public int indice;
    public int estado;
    
    
    public Analizador(){
        Coordenadas = new ArrayList();
        Errores = new ArrayList();
        Simbolos = new ArrayList();
        
        lexema = "";
        fila = 0;
        columna = 0;
        indice = 0;
        estado = 0;
        
    }
   
     //---------------Verificar Si es Letra----------------// Conjunto -> {L}
    private Boolean EsLetra(int codigo)
    {
        if ((codigo >= 65 && codigo <= 90) || (codigo >= 97 && codigo <= 122) ||
            (codigo >= 160 && codigo <= 165) || codigo == 130 || codigo == 181 ||
            codigo == 144 || codigo == 214 || codigo == 224 || codigo == 233)
        {
            return true;
        }
        return false;
    }

    //---------------Verificar Si es Digito----------------// Condjunto -> {D}
    private Boolean EsNumero(int codigo)
    {
        if (codigo >= 48 && codigo <= 57)
        {
            return true;
        }
        return false;
    }

    //---------------Verificar Si es Simbolo ----------------//  Conjunto S -> {:,;,[,],{,],>,v,^,<,','}
    private Boolean EsSimbolo(int codigo)
    {
        if (codigo == 58 |   codigo == 91 | codigo == 93 | 
            codigo == 123 | codigo == 125 |
            codigo == 44)
       {
            return true;
        }
            return false;
    }
  
       // ----------------- Verifica Si es Comilla --------------// "
    private Boolean EsComillas(int codigo)
    {
            if (codigo == 34)
            {
                return true;
            }
            return false;
        }

    public  void Analizar(String Cadena){
        //Auxiliar.clear();
        Coordenadas.clear();
        Errores.clear();
        fila = 1;
        columna = 1;

        String txt = Cadena + "\n";
        String Limpio = "";

        for(int i=0; i<txt.length();i++){
            char letra = txt.charAt(i);
            switch(letra){
                case '\r':
                case '\t':
               // case '\n':
                case '\b':
                case '\f':
                    break;

                default:Limpio = Limpio + letra;
            }
        }
        
        for(indice = 0; indice<Limpio.length();indice++){
            char letra = Limpio.charAt(indice);
            int codigo = letra;
            
            switch(estado){
                case 0:
                   if(EsComillas(codigo)){
                       estado = 1;
                       lexema = lexema + letra;
                   }
                   else if(EsNumero(codigo)){
                       estado = 3;
                       lexema = lexema +letra;
                   }
                   else if(EsSimbolo(codigo)){
                       estado = 4;
                       lexema = lexema + letra;
                   }
                    else if(letra == ' ' || letra == '\n'){
                        estado = 0;
                        columna++;
                        if(letra =='\n'){
                            fila++;
                            columna=1;
                        }
                    }
                    else{
                        Errores.add(new Error(""+letra,fila,columna));
                        columna++;
                        estado = 0;
                        lexema = "";
                    }
                    break;
                    
                case 1:
                    if(EsLetra(codigo)){
                        estado = 1;
                        lexema = lexema + letra;
                        columna++;
                    }
                    else if(EsComillas(codigo)){
                        estado = 2;
                        lexema = lexema + letra;
                        columna++;
                    }
                    else{
                        Errores.add(new Error(""+letra,fila,columna));
                        columna++;
                        estado = 0;            
                    }
                    break;
                    
                case 2:
                    lexema = lexema.toLowerCase();
                    if(lexema.contains("coordenadas")){
                        Coordenadas.add(new Tipo(Tipo.Coordenadas,lexema,fila,columna));
                        estado = 0;
                        lexema = "";
                        indice--;
                        columna++;
                    }
                    else if(lexema.contains("x")){
                        Coordenadas.add(new Tipo(Tipo.CoordenadaX,lexema,fila,columna));
                        estado = 0;
                        lexema = "";
                        indice--;
                        columna++;
                    }
                    else if(lexema.contains("y")){
                        Coordenadas.add(new Tipo(Tipo.CoordenadaY,lexema,fila,columna));
                        estado = 0;
                        lexema = "";
                        indice--;
                        columna++;
                    }
                    else{
                        Errores.add(new Error(lexema,fila,columna));
                        columna++;
                        lexema = "";
                        estado = 0;
                    }
                    break;
                    
                case 3:
                    if(EsNumero(codigo)){
                        estado = 3;
                        lexema = lexema + letra;
                        columna++;
                    }
                    else{
                        Coordenadas.add(new Tipo(Tipo.Numero, lexema, fila,columna));
                        estado = 0;
                        lexema = "";
                        indice--;
                        columna++;
                    }
                    break;
                    
                case 4:
                   Simbolos.add(new Tipo(Tipo.Simbolo,lexema,fila,columna));
                   estado = 0;
                   lexema = "";
                   indice--;
                   columna++;
                   break;
            }
        }
    }
    
    public String[] Validaciones(){
        String[] Error =  new String[2];
        Error[0] = "0";
        Error[1] = "Ninguno";
        
        Tipo g = (Tipo)Coordenadas.get(0);
        
        if(g.getgTipo() == Tipo.Coordenadas){
            Coordenadas.remove(0);
            Error[0] = "0";
            Error[1] = "Ninguno";
        }else{
            Error[0] = "1";
            Error[1] = "Error No. 1 No Existe Palabra \"Coordenadas\"";
            return Error;
        }
         
        if(Errores.isEmpty()){
            Error[0] = "0";
            Error[1] = "Ninguno";    
        }else{
            Error[0] = "1";
            Error[1] = "Error No. 2 Existen Errores Porfavor Revise...";
            return Error;
        }
        int count_x = 0;
        int count_y = 0;
        int coor = 0;
        for(int i =0; i<Coordenadas.size();i++){
            g = (Tipo)Coordenadas.get(i);
            if(g.getgTipo()==Tipo.CoordenadaX){
                count_x++;
            }
            if(g.getgTipo()==Tipo.CoordenadaY){
                count_y++;
            }
            if(g.getgTipo()==Tipo.Numero){
                coor++;
            }
        }
        
        if(count_x == count_y){
            Error[0] = "0";
            Error[1] = "Ninguno";    
        }else{
            Error[0] = "1";
            Error[1] = "Error No. 3 El Numero de X y Y es Incongruente Porfavor Revise...";
            return Error;
        }
        
        if((count_x+count_y)==coor){
            Error[0] = "0";
            Error[1] = "Ninguno";    
        }else{
            Error[0] = "1";
            Error[1] = "Error No. 4 Hay Mas Valores Que Coordenadas X y Y";
            return Error;
        }
        
        return Error;
    }

    public  String Imprimir(){
        String txt= "";
        Tipo g;
        Error er;
        for(int i=0; i<Coordenadas.size();i++){
            g = (Tipo)Coordenadas.get(i);
            txt = txt + g.ToString() +"\n";
        }
//      
//        for(int i=0; i<Errores.size();i++){
//            er = (Error)Errores.get(i);
//            txt = txt + er.ToString() + "\n";
//        }
//        
//        for(int i=0; i<Simbolos.size();i++){
//            g = (Tipo)Simbolos.get(i);
//            txt = txt + g.ToString() + "\n";
//        }
        return txt;
    }
    
    public ArrayList<Object> getCoordenadas() {
        return Coordenadas;
    }
}
