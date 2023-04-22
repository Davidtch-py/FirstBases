package model;
import view.Iomanager;
import java.util.Random;

import javafx.concurrent.Worker;


public class Student {
    
    int ITER=10;
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String booleanAtSpanish(boolean b) {
        String re = "";
        if (b) re="Verdadero";
        else re="Falso";
        return re ;
    }


    //Area de matematicas

//N1 Parametro es multiplo de n
public boolean multiple(int n, int m) {
    return n % m == 0;
}

//N2 Tabla de multiplicar
public String tabla(int n, int ini, int fin) {
    String tabla = "";
    for (int i = ini; i <= fin ; i++) tabla += n + " x " + i + " = " + (n*i) + "\n";
    return tabla;
}

//N3 Define si el numero es primo
public boolean isPrime(int n) {
    boolean isPrime = true;
    int na=n-1;
    while (na > 1 && isPrime==true) {
        if (n % na == 0) isPrime = false;
        na--;
    }
    if (n <=1) isPrime = false;
    return isPrime;
}

//N4 Cuenta la cantidad de cifras de un numero
public int countlength(int n) {
    int count = 0;
    while (n > 0) {
        n /= 10;
        count++;
    }
    return count;
}

//N5 Hace la sucesion de fibonacci
public String fibonacci1(){
    String fibo = "";
    int a = 0, b = 1, c = 0;
    for (int i = 0; i < 10; i++) {
        fibo += c + " ";
        a = b;
        b = c;
        c = a + b;
    }
    return fibo;
}

//N6 Hace la potencia de un numero contando con exponentes negativos
public double powerinn(float n, int m) {
    double power = 1;
    if (m > 0) {
        for (int i = 0; i < m; i++) power *= n;
    } else if (m < 0) {
        for (int i = 0; i < -m; i++) power /= n;
    }
    return power;
}

//N7 Hace el factorial de un numero
    public long factorial(int n) {
        long fact = 1;
        for (long i = 2; i <= n; i++) fact *= i;
        return fact;
    }

//N8 angulos a radianes
public double toRadians(double n) {
    return n * Math.PI  / 180;
}

//N8 Hace la serie de taylor
    public double serieTaylor(float x) {
        int iter=ITER;
        return this.serieTaylor(x,iter);  
    }
    public double serieTaylor(float x, int n) {
        double serie = 0;
        x = (float) toRadians(x);
        for (int i = 0; i < n; i++) serie += (powerinn(-1, i)*powerinn(x, 2*i+1))/factorial(2*i+1);
        return serie;
    }

//N9 Pasar un numero a una base hexadecimal
public String toHex(int n) {
    String hex = "";
    while (n > 0) {
        int r = n % 16;
        if (r < 10) hex = r + hex;  
        if (r >= 10) hex = (char)(r + 55) + hex;
        n /= 16;
    }
    return hex;
} 

//N10 Hace un numero random entre n y m
public int random(int n, int m){
    return (int)(Math.random()*(m-n+1)+n);
}
public int random2(int n, int m){
    Random random = new Random();
    return random.nextInt(m - n + 1) + n;
}

//N11 Juego de adivinar un numero
public void game(){
    Iomanager io = new Iomanager();
    int n = this.random(1, 100);
    int m = 0;
    int i = 0;
    while (n != m && i<10) {
        m = io.readInt("Ingrese un numero: ");
        if (n > m) io.showMessage("El numero es mayor");
        if (n < m) io.showMessage("El numero es menor");
        i++;
    }
    if (n==m)io.showMessage("Felicidades, adivinaste el numero en " + i + " intentos");
    if (n!=m)io.showMessage("Haz perdido");
}   

//Area de lenguaje


//N12 Pasa una palabra a mayusculas
public String toUpper(String word) {
    String upper = "";
    for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == 'ñ' || (word.charAt(i) >= 'a' && word.charAt(i) <= 'z')) upper += (char)(word.charAt(i) - 32);
        else upper += word.charAt(i);
    }
    return upper;
}



//N13 Pasar un string a numero sin usar Integer.parseInt
public int toInt(String word) {
    int num = 0;
    for (int i = 0; i < word.length(); i++) num =num*10 + (word.charAt(i) - '0');
    return num;
}

//N14 Decir cuantas veces se repite una letra
public int repeatLetter2(String msg, char letter){
    int rst=0;
    for (int i = 0; i< msg.length(); i++) {
        if (msg.charAt(i) == letter || msg.charAt(i)== (letter -32)) rst++;
    } return rst;
}

//N15 Sin espacios
public String withoutSpaces(String msg){
    return msg.replaceAll(" ", "");
}
public String withoutSpaces2(String msg){
    String rst="";
    for (int i = 0; i< msg.length(); i++) {
        if (msg.charAt(i) != ' ') rst+=msg.charAt(i);
    } return rst;
}

//N16 Cuenta la cantidad de vocales de una palabra
public int countvowels(String word) {
    
    int count = 0;
    word = word.toUpperCase();
    for (int i = 0; i < word.length(); i++) if (word.charAt(i) == 'A' || word.charAt(i) == 'E' || word.charAt(i) == 'I' || word.charAt(i) == 'O' || word.charAt(i) == 'U') count++;
    return count;
} 

//palindromo
public boolean isPalindrome(String word) {
    boolean isPalindrome = true;
    word = withoutSpaces2(word.toUpperCase()); 
    for (int i = 0; i < word.length()/2; i++) if (word.charAt(i) != word.charAt(word.length()-1-i ) && isPalindrome == false) isPalindrome = false;
    return isPalindrome;
}
public boolean isPalindrome2(String word) {
    boolean isPalindrome = true;
    word = word.toUpperCase();
    int i = 0, j = word.length()-1;
    while (i < j && isPalindrome == true) {
     
    }
    return isPalindrome;
}
public boolean isPalindrome3(String word) {
    boolean isPalindrome = true;
    word = word.toUpperCase();
    int i = 0, j = word.length()-1;
    while (i < j && isPalindrome == true) {
        if (word.charAt(i) == ' ') i++;
        else if (word.charAt(j) == ' ') j--;
        else if (word.charAt(i) != word.charAt(j)) isPalindrome = false;
        else {
            i++;
            j--;
        }
    }
    return isPalindrome;
}

//entra cadena y la devuelve al reves
public String reverse(String word) {
      String reverse = "";
    for (int i = word.length()-1; i >= 0; i--) reverse += word.charAt(i);
    return reverse;
}

//cuenta la cantidad de caracteres
public String countCaracteres(String word){
    String caracters = "";
    for (int i = 0; i < word.length(); i++) {
        if (!caracters.contains(word.charAt(i)+":")) caracters+= word.charAt(i)+":" + repeatLetter(word, word.charAt(i))+ "\n";
    }
    return caracters;
}

// cuantas silabas tiene una palabra
public int countSilabas(String word){
    int count = 0;
    word = word.toUpperCase();
    for (int i = 0; i < word.length(); i++) if (word.charAt(i) == 'A' || word.charAt(i) == 'E' || word.charAt(i) == 'I' || word.charAt(i) == 'O' || word.charAt(i) == 'U') count++;
    return count;
}

//hacer el 17


// contar el numero de caracteres
public String countCaracteres2(String word){
    String caracters = "";
    String cantidad = "";
    for (int i = 0; i < word.length(); i++) {
        cantidad = word.charAt(i)+":" + repeatLetter(word, word.charAt(i))+ "\n";
        if (!caracters.contains(cantidad)) caracters+= cantidad;
    }
    return caracters;
}

//cambiar una letra de un string

public String changeLetter(String word, char letter, char newLetter){
    String newWord = "";
    for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == letter) newWord += newLetter;
        else newWord += word.charAt(i);
    }
    return newWord;
}

    //binario a decimal
    public int toDecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            decimal += (binary.charAt(i) - '0') * Math.pow(2, binary.length() - i - 1);
        }
        return decimal;
    }
    
    public String toBinary(int n) {
        String binary = "";
        while (n > 0) {
            binary = (n % 2) + binary;
            n /= 2;
        }
        return binary;
    }

    //duplicar todos char en string
    public String duplicateChar(String s) {
        String re = "";
        for (int i = 0; i < s.length(); i++) {
            re+=s.charAt(i);
            re+=s.charAt(i);
        }
        return re;
    }

    public String repeatLetter(String s, char c) {
        String re = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==c) {
                re+=c;
            }
            re+=s.charAt(i);
        }
        return re;
    }
    public String toHex(int n,int g) {
        String hex = "";
        while (n > 0) {
            int r = n % g;
            if (r < 10) hex = r + hex;  
            if (r >= 10) hex = (char)(r + 55) + hex;
            n /= g;
        }
        return hex;
    } 

    public String fibonacci(){
        String fibo = "";
        int a = 0, b = 1, c = 0;
        for (int i = 0; i < 20; i++) {
            fibo += c + " ";
            a=b;
            b=c;
            c= a+b;
        }
        return fibo;
    }

    public double factorial(Float n){
        long factorial = 1;
        for (int i = 2; i<=n ; i++){
            factorial *= i;
        }
        return factorial;
    }


    public String insetCat(String msg, int num, String c) {
        String output = "";
        for (int i = 0; i < num; i++) {
            output += msg.charAt(i);
        }
        output += c;
        for (int i = num + 1; i < msg.length(); i++) {
            output += msg.charAt(i);
        }
        return output;
    }

    public String toBase(int number, int base) {
		String response = "";
		char hexadecimal[] = { 'A', 'B', 'C', 'D', 'E', 'F' };
		int module;
		while (number > 0) {
			module = number % base;
			if (module >= 10) {
				response = hexadecimal[module - 10] + response;
			} else {
				response = module + response;
			}
			number = number / base;
		}
		return response;
	}



    private int timesCharacterRepited(String word, char character){
        int timesRepited = 0;
        for(int i = 0; i<word.length(); i++){
            if(word.charAt(i) == character) timesRepited++;
        }
        return timesRepited;
    }

    private String deleteCharacters(String word, char character){
        String wordUpdated = "";
        for(int i =0; i<word.length(); i++){
            if(word.charAt(i)!=character) wordUpdated += word.charAt(i);
        }
        return wordUpdated;
    }


    public String countCharacters(String word){
        int repCounter;
        String repetitionsMenu = "";
        while(word.length() > 0){
            repCounter = timesCharacterRepited(word, word.charAt(0));
            repetitionsMenu += word.charAt(0);
            repetitionsMenu += repCounter + "\n";
            word = deleteCharacters(word, word.charAt(0));  
        }
        return repetitionsMenu;
    }

    //Contador de palabras

    
// public String repeatedLetters(String word) {
//     int counter = 0;
//     String appearLetter = "";
//     for (int i = 0; i < word.length(); i++) {
//     counter = this.timesCharacterRepited(word, word.charAt(i));
//     if (findLetter(appearLetter, word.charAt(i))) {
//     counter = 0;
//     } else {
//     appearLetter += "" + word.charAt(i) + counter + "\n";
//     counter = 0;
//     }
//     }
//     return appearLetter;
//     }
    


    

//numero magico

public boolean magicNumber(int num){
    boolean isAMagic = false;
    String numberString = num + "";
    double numberPruve = powerinn((float) toInt(numberString.charAt(0)+"") , 3) + powerinn(toInt(numberString.charAt(1)+""), 3) + powerinn(toInt(numberString.charAt(2)+""), 3);
    if (num == numberPruve) isAMagic = true;
    return isAMagic;
}



//hacer el metodo de parseDouble que admita numeros negativos y decimales
    public double toDouble(String word){
        double number = 0;
        int decimal = 0;
        boolean isNegative = false;
        if (word.charAt(0) == '-') {
            isNegative = true;
            word = word.substring(1);
        }
        if (word.charAt(0) == '+') {
            word = word.substring(1);
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                decimal = i;
            }
        }
        if (decimal == 0) {
            for (int i = 0; i < word.length(); i++) {
                number += toInt(word.charAt(i)+"") * powerinn(10, word.length() - i - 1);
            }
        } else {
            for (int i = 0; i < decimal; i++) {
                number += toInt(word.charAt(i)+"") * powerinn(10, decimal - i - 1);
            }
            for (int i = decimal + 1; i < word.length(); i++) {
                number += toInt(word.charAt(i)+"") * powerinn(10, decimal - i);
            }
        }
        if (isNegative) number *= -1;
        return number;
    }
    

}
