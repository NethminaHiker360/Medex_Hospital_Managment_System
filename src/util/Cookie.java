package util;

import com.developerstack.Medex.db.Database;
import com.developerstack.Medex.dto.UserDto;

public class Cookie {
    public static UserDto selectedUser= Database.userTable.get(1);
}
