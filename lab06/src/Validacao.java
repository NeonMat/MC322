public class Validacao{    
    public  static boolean validarCPF(String cpf) {
        String newCpf;
        newCpf = cpf.replaceAll("^[A-z]","");
        if (newCpf.length() != 11){
            return false; 
        }
        else if (AllCharactersSame.allCharactersSame(cpf)){
            return false;
        }
        
        
        int soma = 0;
        for(int i =0; i < 9; i++){
            soma += Character.getNumericValue(newCpf.charAt(i)) * (10 - i);
        }
        int resto = soma % 11;
        int primeiro_dig = 0;
        if (resto > 1){
            primeiro_dig = 11 - resto;
        }
        if (primeiro_dig != Character.getNumericValue(newCpf.charAt(9))){
            return false;
        }
        
        int soma2 = 0;
        for(int i =0; i < 10; i++){
            soma2 += Character.getNumericValue(newCpf.charAt(i)) * (11-i);
        }
        int resto2 = soma2 % 11;
        int segundo_dig = 0;
        if (resto2 > 1){
            segundo_dig = 11 - resto2;
        }
        if (segundo_dig != Character.getNumericValue(newCpf.charAt(10))){
            return false;
        }
        
        return true;


    }
    public static boolean validarCNPJ(String cnpj){
        String newCnpj = cnpj.replaceAll("^[A-z]",""); // Para nome: [^A-Z, ^a-z, ^\b]
        if (newCnpj.length() != 14){
            return false; 
        }
        else{
            if (AllCharactersSame.allCharactersSame(newCnpj)){
                return false;}
            }
            
        //Cálculo do primeiro dígito
        int soma = 0;
        for(int i =0; i < 4; i++){
            soma += Character.getNumericValue(newCnpj.charAt(i)) * (5 - i);
        }
        for(int i =4; i < 12; i++){
            soma += Character.getNumericValue(newCnpj.charAt(i)) * (13 - i);
        }
        double resto = soma % 11;
        int res = 11 - (int)resto;
        int primeiro_dig = 0;
        if (res >= 2){
            primeiro_dig = 11 - (int)resto;
        }
        if (primeiro_dig != Character.getNumericValue( newCnpj.charAt(12) ) ){
            return false;
        }
        //Cálculo do segundo dígito
        int soma2 = 0;
        for(int i =0; i < 5; i++){
            soma2 += Character.getNumericValue(newCnpj.charAt(i)) * (6 - i);
        }
        for(int i =5; i < 13; i++){
            soma2 += Character.getNumericValue(newCnpj.charAt(i)) * (14 - i);
        }
        int resto2 = soma2 % 11;
        int segundo_dig = 0;
        if (resto2 >= 2){
            segundo_dig = 11 - resto2;
        }
        if (segundo_dig != Character.getNumericValue(newCnpj.charAt(13))){
            return false;
        }
        return true;
    }

}

