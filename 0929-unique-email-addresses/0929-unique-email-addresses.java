import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        
        for (String email : emails) {
            // Split the email into local and domain parts
            int atIndex = email.indexOf('@');
            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex); // Keeps the '@' with the domain
            
            // Rule 1: Everything after a '+' is ignored
            int plusIndex = local.indexOf('+');
            if (plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }
            
            // Rule 2: Periods '.' are completely ignored/removed
            local = local.replace(".", "");
            
            // Combine them back together and add to the set
            uniqueEmails.add(local + domain);
        }
        
        // The size of the set represents the number of unique addresses
        return uniqueEmails.size();
    }
}