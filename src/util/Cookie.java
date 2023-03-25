package util;

import com.developerstack.Medex.db.Database;
import com.developerstack.Medex.dto.User;

public class Cookie {
    public static User selectedUser= Database.userTable.get(1);
}
