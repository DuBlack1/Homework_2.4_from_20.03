public class Main {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        System.out.println(registrationForm("fjfksE_4fjfksE_4", "mfmdmdа", "mfmdmdа"));
    }

    public static boolean registrationForm(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        boolean checkLogin;
        boolean checkPassword;
        try {
            checkLogin = loginVerification(login);
            checkPassword = passwordVerification(password);
            checkLengthLogin(login);
            checkEqualityPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return checkLogin && checkPassword;
    }

    public static boolean loginVerification(String login) {
        if (login.matches("\\w+")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean passwordVerification(String password){
        if (password.length()<=20 && password.matches("\\w+")) {return true;}
        else {return false;}
    }

    public static boolean checkLengthLogin(String login) throws WrongLoginException {
        if (login.length()>20) {
            throw new WrongLoginException("Логин больше 20 символов");
        }else{return true;}
    }

    public static boolean checkEqualityPassword (String password, String confirmPassword) throws WrongPasswordException {
        if (password != confirmPassword){
            throw new WrongPasswordException("Пароль не совпадает");
        }else {return true;}
    }
}