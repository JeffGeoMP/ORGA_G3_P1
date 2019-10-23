/**
 *
 * @author JeffGeo
 */
public class Tipo {
    public static int CoordenadaX = 1;
    public static int CoordenadaY = 2;
    public static int Numero = 3;
    public static int Simbolo = 4;
    public static int Coordenadas = 5;
    
    private String lex;
    private int Fila;
    private int Columna;
    private int gTipo;

    public String getLex() {
        return lex;
    }

    public void setLex(String lex) {
        this.lex = lex;
    }

    public int getFila() {
        return Fila;
    }

    public void setFila(int Fila) {
        this.Fila = Fila;
    }

    public int getColumna() {
        return Columna;
    }

    public void setColumna(int Columna) {
        this.Columna = Columna;
    }

    public int getgTipo() {
        return gTipo;
    }

    public void setgTipo(int gTipo) {
        this.gTipo = gTipo;
    }
    
    public Tipo(int num, String Lexema, int f, int c){
        lex = Lexema;
        gTipo = num;
        Fila = f;
        Columna = c;
    }
    
    public String Es(int a)
        {
            switch (a)
            {
                case 1:
                    return "Coordenada X: ";
                 
                case 2: 
                    return "Coordenada Y: ";
                                    
                case 4:
                    if (lex.equals(":"))
                    {
                        return "Dos Puntos";
                    }
                    else if (lex.equals(";"))
                    {
                        return "Punto y Coma";
                    }
                    else if(lex.equals("[")){
                        return "Corchete Abierto";
                    }
                    else if(lex.equals("]")){
                        return "Corchete Cerrado";
                    }
                    else if(lex.equals("{")){
                        return "Llave Abierta";
                    }
                    else if(lex.equals("}")){
                        return "Llave Cerrada";
                    }
                    else if(lex.equals(",")){
                        return "Coma";
                    }
                    else if(lex.equals(">")){
                        return "Mayor que";
                    }
                    else if(lex.equals("<")){
                        return "Menor que";
                    }
                    else if(lex.equalsIgnoreCase("v")){
                        return "Simbolo Reservado V";
                    }
                    else if(lex.equals("^")){
                        return "SuperIndice";
                    }
                                        
                case 3:
                    return "Numero";
                
                case 5:
                    return "Coordenadas";

                default:
                    return "XXX";
            }
        }
        public String ToString()
        {
            return lex + "      " + Es(gTipo) + "Fila:    " + Fila + "Columna:   " + Columna;
        }
}

    class Error
    {
        public String Ex;
        public int Fil; 
        public int Col; 

    public String getEx() {
        return Ex;
    }

    public void setEx(String Ex) {
        this.Ex = Ex;
    }

    public int getFil() {
        return Fil;
    }

    public void setFil(int Fil) {
        this.Fil = Fil;
    }

    public int getCol() {
        return Col;
    }

    public void setCol(int Col) {
        this.Col = Col;
    }

    public Error(String error, int f, int c)
    {
    Ex = error;
    Fil = f;
    Col = c;
    }

    public String ToString()
    {
    return Ex + "  [" + Fil + "]" + "[" + Col + "]" + " Error Léxico, Token No Reconocido";
    }
}