public class SecurePassword
{
    // instance variable
    private String password;

    // constructor
    public SecurePassword(String password)
    {
        this.password = password;
    }

    public void setPassword(String newPassword)
    {
        password = newPassword;
    }

    /* Returns true if password:
       - Is at least 8 characters long
       - Contains at least one uppercase letter
       - Contains at least one lowercase letter
       - Contains at least one numeric digit
       - Contains at least one of these "special symbols":  ! @ # $ % ^ & * ?
       Must satisfy ALL FIVE categories for password to be "secure"
       Return false if any of the above security requirements are not fulfilled.
    */
    public boolean isSecure()
    {
        if (isLongEnough() && containsUppercase() && containsLowercase() && containsDigit() && containsSpecialSymbol())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /* Returns a String that contains information about the security status of the
       current password.

       If isSecure() is true, this method returns "Password is secure"
       If isSecure() is false, this methods should return a single String that informs the
       user of which security requirements are not currently being met.

       For example, the password 3WrT6tH does not meet length or special symbol
       requirements, so this method should return the following String (using a line
       break \n):

       "The password must be at least 8 characters
        The password must contain a special symbol: ! @ # $ % ^ & * ?"
    */
    public String status()
    {
        String status = "";
        if (isSecure())
        {
            return "Password is secure";
        }
        if (!isLongEnough())
        {
            status += "The password much contain at least 8 characters\n";
        }
        if (!containsUppercase())
        {
            status += "The password must contain an uppercase letter\n";
        }
        if (!containsLowercase())
        {
            status += "The password must contain a lowercase letter\n";
        }
        if (!containsDigit())
        {
            status += "The password must contain a digit\n";
        }
        if (!containsSpecialSymbol())
        {
            status += "The password must contain a special character\n";
        }
        return status;
    }


    // PRIVATE HELPER METHODS (marked "private" rather than "public")

    /* Returns true if the password’s length meets the minimum requirement of 8 characters
       and false otherwise.
     */
    private boolean isLongEnough()
    {
        return (password.length() >= 8);
    }

    /* Returns true if the password has at least one uppercase letter and false otherwise.
     */
    private boolean containsUppercase()
    {
        /* this one is completed for you as a hint for how to do the others! */
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return checkString(upperCaseLetters);
    }

    /* Returns true if the password has at least one lowercase letter and false otherwise.
     */
    private boolean containsLowercase()
    {
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        return checkString(lowerCaseLetters);
    }

    /* Returns true if the password has at least one digit and false otherwise.
     */
    private boolean containsDigit()
    {
        String digits = "123456789";
        return checkString(digits);
    }

    /* Returns true if the password has at least one of these special symbols:
       ! @ # $ % ^ & * ?    and false otherwise.
     */
    private boolean containsSpecialSymbol()
    {
        String specialSymbols = "!@#$%^&*?";
        return checkString(specialSymbols);
    }

    /* Checks a given character string to see if password contains at least one
       character from that string.

       For example, if characterString is "ABCDEFGH", and password == "jbHFmfA"
       this method will find two occurrences (F and A) and return true, since two
       is at least one
     */
    private boolean checkString(String characterString)
    {
        for (int i = 0; i < characterString.length(); i++)
        {
            if (password.contains(String.valueOf(characterString.charAt(i))))
            {
                return true;
            }
        }
        return false;
    }
}